package com.example.aunnie_iw.nt_collectdata.step;

/**
 * Created by Aunnie-IW on 13/7/2560.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aunnie_iw.nt_collectdata.DataManager;
import com.example.aunnie_iw.nt_collectdata.R;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import butterknife.Bind;

public class DataStepFragment3 extends ButterKnifeFragment implements BlockingStep {
    String a;
    public static DataStepFragment3 newInstance() {
        return new DataStepFragment3();
    }

    private DataManager dataManager;

    private int TitleContactPosition = 0;
    private int RelationshipPosition = 0;

    @Bind(R.id.S_TitleContact) Spinner S_TitleContact;
    @Bind(R.id.S_Relationship) Spinner S_Relationship;
    @Bind(R.id.E_FirstNameContact) EditText E_FirstNameContact;
    @Bind(R.id.E_LastNameContact) EditText E_LastNameContact;
    @Bind(R.id.E_TellContact) EditText E_TellContact;
    @Bind(R.id.E_HomeTellContact) EditText E_HomeTellContact;
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

        if (TextUtils.isEmpty(E_FirstNameContact.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_LastNameContact.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_TellContact.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(E_HomeTellContact.getText().toString()))
            return false;
        else
            return true;
    }
    @Override
    public void onSelected() {
        setSpinner();
        setPositionSpinner();

    }

    @Override
    public void onError(@NonNull VerificationError error) {
        Toast.makeText(getActivity(), "onError! -> " + error.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    @UiThread
    public void onNextClicked(final StepperLayout.OnNextClickedCallback callback) {
        TitleContactPosition = S_TitleContact.getSelectedItemPosition();
        RelationshipPosition = S_Relationship.getSelectedItemPosition();
        dataManager.saveTitleContact(S_TitleContact.getSelectedItem().toString());
        dataManager.saveRelationship(S_Relationship.getSelectedItem().toString());
        Log.d("onNextClicked: ", dataManager.getTitleContact());
//
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
        return R.layout.fragment_step3;
    }


    public void setSpinner(){

        String[] TitleName = getResources().getStringArray(R.array.TitleName);
        ArrayAdapter<String> adapterTitleName = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, TitleName);
        S_TitleContact.setAdapter(adapterTitleName);


        String[] Relationship = getResources().getStringArray(R.array.Relationship);
        ArrayAdapter<String> adapterRelatonship = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, Relationship);
        S_Relationship.setAdapter(adapterRelatonship);



    }


    public void setPositionSpinner(){
        S_TitleContact.setSelection(TitleContactPosition);
        S_Relationship.setSelection(RelationshipPosition);
    }


}
