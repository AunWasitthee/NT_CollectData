package com.example.aunnie_iw.nt_collectdata;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Login_Activity extends AppCompatActivity {

    protected Button BSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        BSignin = (Button) findViewById(R.id.BSignin);
        if(haveNetworkConnection()) {
            new FeedAsyncTask().execute("http://203.150.245.33:8001/api/underlying_disease");
            new FeedAsyncTask().execute("http://203.150.245.33:8001/api/foot_disorder");
            new FeedAsyncTask().execute("http://203.150.245.33:8001/api/material");
            new FeedAsyncTask().execute("http://203.150.245.33:8001/api/shoebrand");
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

    public class FeedAsyncTask extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            // called before doInBasckground
            Log.i("FeedAsyncTask","onPreExeccute");

        }
        @Override
        protected String doInBackground(String... strings) {
            // called in custom/background thread
            Log.i("FeedAsyncTask","doInBackground: " + strings[0]);
            final String _url = strings[0];
            try{
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(_url).build();

                Response response = client.newCall(request).execute();
                String s = response.body().string();
                Log.i("FeedAsyncTask",s);
                return "" + s;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            // called after doInBackground
            Log.i("FeedAsyncTask","onPostExecute");
        }
    }
}
