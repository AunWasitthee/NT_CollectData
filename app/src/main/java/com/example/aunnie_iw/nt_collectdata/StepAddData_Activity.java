package com.example.aunnie_iw.nt_collectdata;

/**
 * Created by Aunnie-IW on 13/7/2560.
 */


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.aunnie_iw.nt_collectdata.step.AddressDataObject;
import com.example.aunnie_iw.nt_collectdata.step.DataObject;
import com.stepstone.stepper.StepperLayout;
import com .example.aunnie_iw.nt_collectdata.adapter.DataStepsFragmentStepAdapter;

import butterknife.Bind;
        import butterknife.ButterKnife;

public class StepAddData_Activity extends AppCompatActivity implements DataManager {

    private static final String CURRENT_STEP_POSITION_KEY = "position";

    private static final String DATA = "data";

    @Bind(R.id.stepperLayout)
    StepperLayout mStepperLayout;

    private String mData;
    private String relationship;
    private String titleContact;
    private DataObject dataObject;
    private AddressDataObject addressDataObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("เก็บข้อมูล");

        setContentView(R.layout.activity_styled_tabs);
        ButterKnife.bind(this);
        int startingStepPosition = savedInstanceState != null ? savedInstanceState.getInt(CURRENT_STEP_POSITION_KEY) : 0;
        mData = savedInstanceState != null ? savedInstanceState.getString(DATA) : null;
        mStepperLayout.setAdapter(new DataStepsFragmentStepAdapter(getSupportFragmentManager(), this), startingStepPosition);
        Intent intent = getIntent();
        dataObject = (DataObject) intent.getExtras().getSerializable("DataObject");
        addressDataObject = (AddressDataObject) intent.getExtras().getSerializable("AddrssDataObject");

        mStepperLayout.setShowErrorStateEnabled(true);
        mStepperLayout.setShowErrorStateOnBackEnabled(true);
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
    public void saveTitleContact(String TitleContact){ titleContact = TitleContact;}
    public void saveRelationship(String Relationship){ relationship = Relationship;}

    @Override
    public String getTitleContact() {
        return titleContact;
    }

    @Override
    public String getImg() {
        return dataObject.getImg();
    }

    public String getIDcard() {
        return dataObject.getIDcard();
    }

    @Override
    public String getTitleNameThai() {
        return dataObject.getTitleNameThai();
    }

    @Override
    public void saveTitleNameThai(String TitleNameThai) {
        dataObject.setTitleNameThai(TitleNameThai);
    }

    @Override
    public String getfirstNameThai() {
        return dataObject.getFirstNameThai();
    }

    @Override
    public String getlastNameThai() {
        return dataObject.getLastNameThai();
    }

    @Override
    public String getbirthday() {
        return dataObject.getBirthday();
    }

    @Override
    public String gettell() {
        return dataObject.getTell();
    }

    @Override
    public String gethometell() {
        return dataObject.getHometell();
    }

    @Override
    public String getemail() {
        return dataObject.getEmail();
    }

    @Override
    public String gethouseNumber() {
        return addressDataObject.getHouseNumber();
    }

    @Override
    public String getBuilding() {
        return null;
    }

    @Override
    public String getroom() {
        return null;
    }

    @Override
    public String getfloor() {
        return null;
    }

    @Override
    public String getmoo() {
        return addressDataObject.getMoo();
    }

    @Override
    public String getsoi() {
        return null;
    }

    @Override
    public String getroad() {
        return null;
    }

    @Override
    public String gettambon() {
        return addressDataObject.getTambon();
    }

    @Override
    public String getamphur() {
        return addressDataObject.getAmphur();
    }

    @Override
    public String getprovince() {
        return addressDataObject.getProvince();
    }

    @Override
    public String getpostcode() {
        return addressDataObject.getPostcode();
    }
}
