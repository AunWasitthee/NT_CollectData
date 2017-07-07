package com.example.aunnie_iw.nt_collectdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_Activity extends AppCompatActivity {

    protected Button BSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        BSignin = (Button) findViewById(R.id.BSignin);

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
}
