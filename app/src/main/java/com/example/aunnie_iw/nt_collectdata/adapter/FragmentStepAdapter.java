package com.example.aunnie_iw.nt_collectdata.adapter;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.example.aunnie_iw.nt_collectdata.R;
import com.example.aunnie_iw.nt_collectdata.step.StepFragment1;
import com.example.aunnie_iw.nt_collectdata.step.StepFragment2;
import com.example.aunnie_iw.nt_collectdata.step.StepFragment3;
import com.example.aunnie_iw.nt_collectdata.step.StepFragment4;
import com.example.aunnie_iw.nt_collectdata.step.StepFragment5;
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
        CharSequence[] itemTopic = {"ข้อมูลทั่วไป","ที่อยู่","ผู้ติดต่อ","โรค","ความผิดปกติ","วัสดุ"};
        return new StepViewModel.Builder(context)
                .setTitle(itemTopic[position])
                .create();
    }

    @Override
    public Step createStep(int position) {
        switch (position) {
            case 0:
                return StepFragment1.newInstance(R.layout.fragment_step1);
            case 1:
                return StepFragment2.newInstance(R.layout.fragment_step2);
            case 2:
                return StepFragment3.newInstance(R.layout.fragment_step3);
            case 3:
                return StepFragment4.newInstance(R.layout.fragment_step4);
            case 4:
                return StepFragment5.newInstance(R.layout.fragment_step5);
            case 5:
                return StepFragmentSample.newInstance(R.layout.fragment_step6);
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
    }

    @Override
    public int getCount() {
        return 6;
    }
}