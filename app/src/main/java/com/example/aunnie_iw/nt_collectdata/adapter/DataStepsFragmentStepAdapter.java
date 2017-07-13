package com.example.aunnie_iw.nt_collectdata.adapter;

/**
 * Created by Aunnie-IW on 13/7/2560.
 */

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.example.aunnie_iw.nt_collectdata.R;

import com.example.aunnie_iw.nt_collectdata.step.DataStepFragment1;
import com.example.aunnie_iw.nt_collectdata.step.DataStepFragment2;
import com.example.aunnie_iw.nt_collectdata.step.DataStepFragment3;
import com.example.aunnie_iw.nt_collectdata.step.DataStepFragment4;
import com.example.aunnie_iw.nt_collectdata.step.DataStepFragment5;
import com.example.aunnie_iw.nt_collectdata.step.DataStepFragment6;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

public class DataStepsFragmentStepAdapter extends AbstractFragmentStepAdapter {

    public DataStepsFragmentStepAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
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
                return DataStepFragment1.newInstance();
            case 1:
                return DataStepFragment2.newInstance();
            case 2:
                return DataStepFragment3.newInstance();
            case 3:
                return DataStepFragment4.newInstance();
            case 4:
                return DataStepFragment5.newInstance();
            case 5:
                return DataStepFragment6.newInstance();
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
    }

    @Override
    public int getCount() {
        return 6;
    }
}
