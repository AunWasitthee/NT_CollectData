package com.example.aunnie_iw.nt_collectdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Aunnie-IW on 7/7/2560.
 */

public class Menu_Activity extends AppCompatActivity {
    protected Button BAdd,BHistory,BLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BAdd = (Button) findViewById(R.id.BAdd);
        BHistory = (Button) findViewById(R.id.BHistory);
        BLogout = (Button) findViewById(R.id.BLogout);

        WhenClickBAdd();
        WhenClickBHistory();
        WhenClickBLogout();

    }




    private void WhenClickBAdd() {
        BAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_Activity.this,AddUpdateUser_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void WhenClickBHistory() {
        BHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_Activity.this,History_Activity.class);
                startActivity(intent);
            }
        });

    }

    private void WhenClickBLogout() {
        BLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_Activity.this,Login_Activity.class);
                startActivity(intent);
            }
        });

    }
}
