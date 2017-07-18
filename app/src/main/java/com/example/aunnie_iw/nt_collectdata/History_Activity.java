package com.example.aunnie_iw.nt_collectdata;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Aunnie-IW on 7/7/2560.
 */

public class History_Activity extends AppCompatActivity {
    protected Button BBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        BBack = (Button) findViewById(R.id.BBack);

        WhenClickBBack();

    }

    private void WhenClickBBack() {
        BBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History_Activity.this,Menu_Activity.class);
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
}
