package com.example.aunnie_iw.nt_collectdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Aunnie-IW on 11/7/2560.
 */

public class AddUpdateUser_Activity extends AppCompatActivity {
    protected Button BOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_update_user);

        BOk = (Button) findViewById(R.id.BOk);

        WhenClickBOk();

    }

    private void WhenClickBOk() {
        BOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddUpdateUser_Activity.this,StepAdd_Activity.class);
                startActivity(intent);
            }
        });
    }
}
