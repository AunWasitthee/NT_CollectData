package com.example.aunnie_iw.nt_collectdata;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.ExecutionException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Login_Activity extends AppCompatActivity {
    String[] underlying_disease;
    protected Button BSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        BSignin = (Button) findViewById(R.id.BSignin);
        if(haveNetworkConnection()) {

            try {
                underlying_disease = new FeedAsyncTask().execute("http://203.150.245.33:8001/api/underlying_disease","underlying_disease").get();

                String[] foot_disorder = new FeedAsyncTask().execute("http://203.150.245.33:8001/api/foot_disorder","foot_disorder").get();
                String[] material = new FeedAsyncTask().execute("http://203.150.245.33:8001/api/material","material").get();
                String[] shoebrand = new FeedAsyncTask().execute("http://203.150.245.33:8001/api/shoebrand","shoebrand").get();



//                for(String s : underlying_disease)
//                    System.out.println(s);
//                for(String s : foot_disorder)
//                    System.out.println(s);
//                for(String s : material)
//                    System.out.println(s);
//                for(String s : shoebrand)
//                    System.out.println(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            writeToFile(underlying_disease,"underlying_disease");
        }
        WhenClickBSignin();

    }

    private void WhenClickBSignin() {
        BSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Activity.this,Menu_Activity.class);
                startActivity(intent);
            }
        });
    }
    public void writeToFile(String[] data, String name)
    {
        // Get the directory for the user's public pictures directory.
        String path = Environment.getExternalStorageDirectory() + File.separator  + "Database";
        // Create the folder.
        File folder = new File(path);

        // Make sure the path directory exists.
        if(!folder.exists())
        {
            // Make it, if it doesn't exit
            folder.mkdirs();
        }

        final File file = new File(path, name+".txt");

        // Save your stream, don't forget to flush() it before closing it.

        try
        {
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            for(String s : data){
                myOutWriter.append(s+"\n");
            }
            myOutWriter.close();
            fOut.flush();
            fOut.close();
        }
        catch (IOException e)
        {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public boolean haveNetworkConnection(){
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = cm.getAllNetworkInfo();
        for (NetworkInfo networkInfo : networkInfos){
            if (networkInfo.getTypeName().equalsIgnoreCase("WIFI")){
                if (networkInfo.isConnected()){
                    haveConnectedWifi = true;
                    Log.d("haveWifi", String.valueOf(networkInfo.isConnected()));
                }
            }
            if (networkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                if (networkInfo.isConnected()) {
                    haveConnectedMobile = true;
                    Log.d("haveMobile", String.valueOf(networkInfo.isConnected()));
                }
            }
        }
        return haveConnectedWifi||haveConnectedMobile;
    }

    public class FeedAsyncTask extends AsyncTask<String , Void, String[]>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            // called before doInBasckground
            Log.i("FeedAsyncTask","onPreExeccute");

        }
        @Override
        protected String[] doInBackground(String... strings) {
            // called in custom/background thread
            Log.i("FeedAsyncTask","doInBackground: " + strings[0]);
            final String _url = strings[0];
            try{
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(_url).build();

                Response response = client.newCall(request).execute();
                JSONObject s = null;
                JSONArray arr = null;
                try {
                    s = new JSONObject(response.body().string());
                    arr = s.getJSONArray("data");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.i("FeedAsyncTask",s.toString());
                String[] result = new String[arr.length()];
                    for(int i = 0; i < arr.length(); i++){
                        try {
                            if (strings[1].equals("underlying_disease")||strings[1].equals("foot_disorder"))
                                result[i] = arr.getJSONObject(i).getString("title");
                            else if (strings[1].equals("material"))
                                result[i] = arr.getJSONObject(i).getString("material_name");
                            else if (strings[1].equals("shoebrand"))
                                result[i] = arr.getJSONObject(i).getString("brand_name");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String[] s){
            super.onPostExecute(s);
            // called after doInBackground
            Log.i("FeedAsyncTask","onPostExecute");
        }
    }
}
