package com.example.aunnie_iw.nt_collectdata;

/**
 * Created by Aunnie-IW on 13/7/2560.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.aunnie_iw.nt_collectdata.step.AddressDataObject;
import com.example.aunnie_iw.nt_collectdata.step.DataObject;
import com.stepstone.stepper.StepperLayout;
import com .example.aunnie_iw.nt_collectdata.adapter.DataStepsFragmentStepAdapter;
import com.stepstone.stepper.VerificationError;

        import butterknife.Bind;
        import butterknife.ButterKnife;

public class StepAddData_Activity extends AppCompatActivity implements DataManager {

    private static final String CURRENT_STEP_POSITION_KEY = "position";

    private static final String DATA = "data";

    @Bind(R.id.stepperLayout)
    StepperLayout mStepperLayout;

    private String mData;
private DataObject dataObject;
    private AddressDataObject addressDataObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Stepper sample");

        setContentView(R.layout.activity_styled_tabs);
        ButterKnife.bind(this);
        int startingStepPosition = savedInstanceState != null ? savedInstanceState.getInt(CURRENT_STEP_POSITION_KEY) : 0;
        mData = savedInstanceState != null ? savedInstanceState.getString(DATA) : null;
        mStepperLayout.setAdapter(new DataStepsFragmentStepAdapter(getSupportFragmentManager(), this), startingStepPosition);
        Intent intent = getIntent();
        dataObject = (DataObject) intent.getExtras().getSerializable("DataObject");
        addressDataObject = (AddressDataObject) intent.getExtras().getSerializable("AddrssDataObject");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(CURRENT_STEP_POSITION_KEY, mStepperLayout.getCurrentStepPosition());
        outState.putString(DATA, mData);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        final int currentStepPosition = mStepperLayout.getCurrentStepPosition();
        if (currentStepPosition > 0) {
            mStepperLayout.onBackClicked();
        } else {
            finish();
        }
    }

    @Override
    public void saveData(String data) {
        mData = data;
    }

    public String getData() {
        return dataObject.IDcard();
    }

    @Override
    public String getData2() {
        return dataObject.getFirstNameThai();
    }
}
