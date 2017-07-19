package com.example.aunnie_iw.nt_collectdata.step;

/**
 * Created by Aunnie-IW on 13/7/2560.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aunnie_iw.nt_collectdata.DataManager;
import com.example.aunnie_iw.nt_collectdata.R;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.text.DecimalFormat;

import butterknife.Bind;
import butterknife.OnTextChanged;

public class DataStepFragment4 extends ButterKnifeFragment implements BlockingStep {
    String a;

    String[] array = new String[]{"A","B","C"};

    public static DataStepFragment4 newInstance() {
        return new DataStepFragment4();
    }


    @Bind(R.id.checkboxContainerDisease) ViewGroup checkboxContainerDisease;
    private DataManager dataManager;
    @Bind(R.id.E_Hight) EditText E_Hight;
    @Bind(R.id.E_Weight) EditText E_Weight;
    @Bind(R.id.E_BodyMass) EditText E_BodyMass;

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
        if (TextUtils.isEmpty(E_Hight.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_Weight.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_BodyMass.getText().toString()))
            return false;
        else
            return true;
    }
    @Override
    public void onSelected() {

        for (int i = 0 ; i <array.length ; i++){
            CheckBox checkBox = new CheckBox(getActivity());
            checkBox.setText(array[i]);
            checkboxContainerDisease.addView(checkBox);
        }

    }

    @Override
    public void onError(@NonNull VerificationError error) {
        Toast.makeText(getActivity(), "onError! -> " + error.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    @OnTextChanged(value = {R.id.E_Hight,R.id.E_Weight},callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void CalculateBodyMass(Editable s) {
        if (E_Hight.getText().toString().equals("") || E_Weight.getText().toString().equals("")){
            E_BodyMass.setText(null);
        }
        else{
            double Hight = Double.parseDouble(E_Hight.getText().toString());
            double Weight = Double.parseDouble(E_Weight.getText().toString());

            double BodyMass = Weight / ((Hight / 100) * (Hight / 100));
            Log.d("CalculateBodyMass: ", String.valueOf(BodyMass));
            DecimalFormat newFormat = new DecimalFormat("#.##");
            E_BodyMass.setText(String.valueOf(newFormat.format(BodyMass)));
        }
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
        return R.layout.fragment_step4;
    }
}
