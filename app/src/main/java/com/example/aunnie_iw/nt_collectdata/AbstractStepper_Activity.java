package com.example.aunnie_iw.nt_collectdata;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import com.example.aunnie_iw.nt_collectdata.adapter.FragmentStepAdapter;

import butterknife.Bind;

import butterknife.ButterKnife;

/**
 * Created by Aunnie-IW on 11/7/2560.
 */

public abstract class AbstractStepper_Activity extends AppCompatActivity implements StepperLayout.StepperListener,
        OnNavigationBarListener {

    private static final String CURRENT_STEP_POSITION_KEY = "position";

    @Bind(R.id.stepperLayout)
    protected StepperLayout mStepperLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Stepper sample");

        setContentView(getLayoutResId());

        ButterKnife.bind(this);
        int startingStepPosition = savedInstanceState != null ? savedInstanceState.getInt(CURRENT_STEP_POSITION_KEY) : 0;
        mStepperLayout.setAdapter(new FragmentStepAdapter(getSupportFragmentManager(), this), startingStepPosition);

        mStepperLayout.setListener(this);
    }

    @LayoutRes
    protected abstract int getLayoutResId();

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(CURRENT_STEP_POSITION_KEY, mStepperLayout.getCurrentStepPosition());
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
    public void onCompleted(View completeButton) {
        Toast.makeText(this, "onCompleted!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(VerificationError verificationError) {
        Toast.makeText(this, "onError! -> " + verificationError.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStepSelected(int newStepPosition) {
        Toast.makeText(this, "onStepSelected! -> " + newStepPosition, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReturn() {
        finish();
    }

    @Override
    public void onChangeEndButtonsEnabled(boolean enabled) {
        mStepperLayout.setNextButtonVerificationFailed(!enabled);
        mStepperLayout.setCompleteButtonVerificationFailed(!enabled);
    }
}