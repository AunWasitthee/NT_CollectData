package com.example.aunnie_iw.nt_collectdata.step;

/**
 * Created by Aunnie-IW on 13/7/2560.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.text.Editable;
import android.util.Log;
import android.widget.EditText;

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
    public static DataStepFragment4 newInstance() {
        return new DataStepFragment4();
    }

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
        return checkValue() ? null : new VerificationError("Click more times!");
    }
    private boolean checkValue(){
        return true;
    }
    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {
    }

    @OnTextChanged(value = {R.id.E_Hight,R.id.E_Weight},callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void CalculateBodyMass(Editable s){
        if (!E_Hight.getText().toString().equals("")&&!E_Weight.getText().toString().equals("")) {
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
