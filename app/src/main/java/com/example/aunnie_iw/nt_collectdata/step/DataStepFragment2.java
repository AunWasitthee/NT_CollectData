package com.example.aunnie_iw.nt_collectdata.step;

/**
 * Created by Aunnie-IW on 13/7/2560.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.aunnie_iw.nt_collectdata.DataManager;
import com.example.aunnie_iw.nt_collectdata.R;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import butterknife.Bind;

public class DataStepFragment2 extends ButterKnifeFragment implements BlockingStep {
    String a;
    public static DataStepFragment2 newInstance() {
        return new DataStepFragment2();
    }

    private DataManager dataManager;
    @Bind(R.id.E_CardHouseNumber) EditText E_CardHouseNumber;
    @Bind(R.id.E_CardBuilding) EditText E_CardBuilding;
    @Bind(R.id.E_CardRoom) EditText E_CardRoom;
    @Bind(R.id.E_CardFloor) EditText E_CardFloor;
    @Bind(R.id.E_CardMoo) EditText E_CardMoo;
    @Bind(R.id.E_CardSoi) EditText E_CardSoi;
    @Bind(R.id.E_CardTambon) EditText E_CardTambon;
    @Bind(R.id.E_CardAmphur) EditText E_CardAmphur;
    @Bind(R.id.E_CardProvince) EditText E_CardProvince;
    @Bind(R.id.E_CardPostCode) EditText E_CardPostCode;

    @Bind(R.id.E_NowHouseNumber) EditText E_NowHouseNumber;
    @Bind(R.id.E_NowBuilding) EditText E_NowBuilding;
    @Bind(R.id.E_NowRoom) EditText E_NowRoom;
    @Bind(R.id.E_NowFloor) EditText E_NowFloor;
    @Bind(R.id.E_NowMoo) EditText E_NowMoo;
    @Bind(R.id.E_NowSoi) EditText E_NowSoi;
    @Bind(R.id.E_NowTambon) EditText E_NowTambon;
    @Bind(R.id.E_NowAmphur) EditText E_NowAmphur;
    @Bind(R.id.E_NowProvince) EditText E_NowProvince;
    @Bind(R.id.E_NowPostCode) EditText E_NowPostCode;

    @Bind(R.id.CB_SameLocation) CheckBox CB_SameLocation;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DataManager) {
            dataManager = (DataManager) context;
        } else {
            throw new IllegalStateException("Activity must implement DataManager interface!");
        }
    }

    @Override
    public VerificationError verifyStep() {
        return checkValue() ? null : new VerificationError("Click more times!");
    }
    private boolean checkValue(){
        return true;
    }
    @Override
    public void onSelected() {
        if (dataManager!=null) {
            if (dataManager.gethouseNumber() != null)
                E_CardHouseNumber.setText(dataManager.gethouseNumber());
            if (dataManager.getmoo() != null)
                E_CardMoo.setText(dataManager.getmoo());
            if (dataManager.gettambon() != null)
                E_CardTambon.setText(dataManager.gettambon());
            if (dataManager.getamphur() != null)
                E_CardAmphur.setText(dataManager.getamphur());
            if (dataManager.getprovince() != null)
                E_CardProvince.setText(dataManager.getprovince());

        }
    }

    @Override
    public void onError(@NonNull VerificationError error) {
    }

    @Override
    @UiThread
    public void onNextClicked(final StepperLayout.OnNextClickedCallback callback) {
        callback.goToNextStep();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        callback.complete();
    }

    @Override
    @UiThread
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        callback.goToPrevStep();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_step2;
    }
}
