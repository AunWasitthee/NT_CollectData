package com.example.aunnie_iw.nt_collectdata.step;

/**
 * Created by Aunnie-IW on 13/7/2560.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aunnie_iw.nt_collectdata.DataManager;
import com.example.aunnie_iw.nt_collectdata.R;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import butterknife.Bind;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

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
        return checkValue() ? null : new VerificationError("กรุณากรอกข้อมูลให้ครบถ้วน");
    }

    private boolean checkValue(){
        //Check Location Id Card
        if (TextUtils.isEmpty(E_CardHouseNumber.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_CardBuilding.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_CardRoom.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_CardFloor.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_CardMoo.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_CardSoi.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_CardTambon.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_CardAmphur.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_CardProvince.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_CardPostCode.getText().toString()))
            return false;
        //Check Location Now
        else if (TextUtils.isEmpty(E_NowHouseNumber.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_NowBuilding.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_NowRoom.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_NowFloor.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_NowMoo.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_NowSoi.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_NowTambon.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_NowAmphur.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_NowProvince.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_NowPostCode.getText().toString()))
            return false;

        else
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

    @OnCheckedChanged(R.id.CB_SameLocation)
    public void checkboxToggled (boolean isChecked) {
        // true = checkbox is checked
        if (isChecked){
            E_NowHouseNumber.setText(E_CardHouseNumber.getText().toString());
            E_NowBuilding.setText(E_CardBuilding.getText().toString());
            E_NowRoom.setText(E_CardRoom.getText().toString());
            E_NowFloor.setText(E_CardFloor.getText().toString());
            E_NowMoo.setText(E_CardMoo.getText().toString());
            E_NowSoi.setText(E_CardSoi.getText().toString());
            E_NowTambon.setText(E_CardTambon.getText().toString());
            E_NowAmphur.setText(E_CardAmphur.getText().toString());
            E_NowProvince.setText(E_CardProvince.getText().toString());
            E_NowPostCode.setText(E_CardPostCode.getText().toString());
        }
        else{
            // false = checkbox is unchecked}
            E_NowHouseNumber.setText(null);
            E_NowBuilding.setText(null);
            E_NowRoom.setText(null);
            E_NowFloor.setText(null);
            E_NowMoo.setText(null);
            E_NowSoi.setText(null);
            E_NowTambon.setText(null);
            E_NowAmphur.setText(null);
            E_NowProvince.setText(null);
            E_NowPostCode.setText(null);
        }


    }

    @Override
    public void onError(@NonNull VerificationError error) {
        Toast.makeText(getActivity(), "onError! -> " + error.getErrorMessage(), Toast.LENGTH_SHORT).show();
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
