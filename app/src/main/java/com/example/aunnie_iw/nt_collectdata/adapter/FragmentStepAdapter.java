package com.example.aunnie_iw.nt_collectdata.adapter;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.example.aunnie_iw.nt_collectdata.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

import com.example.aunnie_iw.nt_collectdata.step.StepFragmentSample;

/**
 * Created by Aunnie-IW on 11/7/2560.
 */

public class FragmentStepAdapter extends AbstractFragmentStepAdapter {

    public FragmentStepAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
        super(fm, context);
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        return new StepViewModel.Builder(context)
                .setTitle("555")
                .create();
    }

    @Override
    public Step createStep(int position) {
        switch (position) {
            case 0:
                return StepFragmentSample.newInstance(R.layout.fragment_step1);
            case 1:
                return StepFragmentSample.newInstance(R.layout.fragment_step1);
            case 2:
                return StepFragmentSample.newInstance(R.layout.fragment_step1);
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}