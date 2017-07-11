package com.example.aunnie_iw.nt_collectdata;

import android.os.Bundle;

/**
 * Created by Aunnie-IW on 11/7/2560.
 */

public class StepAdd_Activity extends AbstractStepper_Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStepperLayout.setShowErrorStateEnabled(true);
        mStepperLayout.setShowErrorStateOnBackEnabled(true);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_default_tabs;
    }
}
