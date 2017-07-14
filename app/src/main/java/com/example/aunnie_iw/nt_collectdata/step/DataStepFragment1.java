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
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.example.aunnie_iw.nt_collectdata.DataManager;
import com.example.aunnie_iw.nt_collectdata.R;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.OnTextChanged;

public class DataStepFragment1 extends ButterKnifeFragment implements BlockingStep {

    public static DataStepFragment1 newInstance() {
        return new DataStepFragment1();
    }

    private DataManager dataManager;
    private String[] TitleName;
    private int TitleNamePosition = 0;

    private String current = "";
    private String ddmmyyyy = "DDMMYYYY";
    private Calendar cal = Calendar.getInstance();

    @Bind(R.id.tv_IdCard) TextView tv_IdCard;

    @Bind(R.id.S_TitleName) Spinner S_TitleName;

    @Bind(R.id.E_FirstName) EditText E_FirstName;
    @Bind(R.id.E_Lastname) EditText E_Lastname;
    @Bind(R.id.E_Birthday) EditText E_Birthday;
    @Bind(R.id.E_Age) EditText E_Age;
    @Bind(R.id.E_Tell) EditText E_Tell;
    @Bind(R.id.E_HomeTell) EditText E_HomeTell;
    @Bind(R.id.E_Email) EditText E_Email;
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

        if (TextUtils.isEmpty(E_FirstName.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_Lastname.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_Birthday.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_Age.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_Tell.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_HomeTell.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_Email.getText().toString()))
            return false;
        else
            return true;
    }
    @Override
    public void onSelected() {
        setSpinner();
        setPositionSpinner();

        if (dataManager!=null) {
            if (dataManager.getIDcard()!=null)
                tv_IdCard.setText(dataManager.getIDcard());
            if (dataManager.getfirstNameThai()!=null)
                E_FirstName.setText(dataManager.getfirstNameThai());
            if (dataManager.getlastNameThai()!=null)
                E_Lastname.setText(dataManager.getlastNameThai());
            if (dataManager.getbirthday()!=null)
                E_Birthday.setText(dataManager.getbirthday());
        }
    }

    @Override
    public void onError(@NonNull VerificationError error) {
        Toast.makeText(getActivity(), "onError! -> " + error.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    @OnTextChanged(value = R.id.E_Birthday,callback = OnTextChanged.Callback.TEXT_CHANGED)
    public void CalculateAge(CharSequence s) {

    }



    @Override
    @UiThread
    public void onNextClicked(final StepperLayout.OnNextClickedCallback callback) {
        TitleNamePosition = S_TitleName.getSelectedItemPosition();
        dataManager.saveTitleNameThai(S_TitleName.getSelectedItem().toString());
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
        return R.layout.fragment_step1;
    }

    public void setSpinner(){

        TitleName = getResources().getStringArray(R.array.TitleName);
        ArrayAdapter<String> adapterTitleName = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, TitleName);
        S_TitleName.setAdapter(adapterTitleName);
    }


    public void setPositionSpinner(){
        if (dataManager.getTitleNameThai()!=null){
            if (!dataManager.getTitleNameThai().equals("")) {
                S_TitleName.setSelection(Arrays.asList(TitleName).indexOf(dataManager.getTitleNameThai()));
                //S_TitleName.setEnabled(false);
            }
        }
        else
            S_TitleName.setSelection(TitleNamePosition);
    }

}
