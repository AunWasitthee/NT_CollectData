package com.example.aunnie_iw.nt_collectdata.step;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.aunnie_iw.nt_collectdata.OnNavigationBarListener;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

/**
 * Created by Aunnie-IW on 12/7/2560.
 */

public class StepFragment3 extends ButterKnifeFragment implements Step {

    private static final String CLICKS_KEY = "clicks";

    private static final int TAP_THRESHOLD = 2;

    private static final String LAYOUT_RESOURCE_ID_ARG_KEY = "messageResourceId";

    private int i = 0;

//    @Bind(R.id.E_Moo)
//    TextView E_Moo;

    @Nullable
    private OnNavigationBarListener onNavigationBarListener;

    public static StepFragment3 newInstance(@LayoutRes int layoutResId) {
        Bundle args = new Bundle();
        args.putInt(LAYOUT_RESOURCE_ID_ARG_KEY, layoutResId);
        StepFragment3 fragment = new StepFragment3();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNavigationBarListener) {
            onNavigationBarListener = (OnNavigationBarListener) context;
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            i = savedInstanceState.getInt(CLICKS_KEY);
        }

        updateNavigationBar();

//        button.setText(Html.fromHtml("Taps: <b>" + i + "</b>"));
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                button.setText(Html.fromHtml("Taps: <b>" + (++i) + "</b>"));
//                updateNavigationBar();
//            }
//        });
    }

    @Override
    protected int getLayoutResId() {
        return getArguments().getInt(LAYOUT_RESOURCE_ID_ARG_KEY);
    }

    @Override
    public VerificationError verifyStep() {


        return isAboveThreshold() ? null : new VerificationError("Click " + (TAP_THRESHOLD - i) + " more times!");
        //return null;//return null;
    }

    private boolean isAboveThreshold() {
//        if(!TextUtils.isEmpty(E_Moo.getText().toString()))
//            return true;
//        else
//            return false;
        return true;
    }

    @Override
    public void onSelected() {
        updateNavigationBar();
    }

    @Override
    public void onError(@NonNull VerificationError error) {
//        button.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.shake_error));
    }

    private void updateNavigationBar() {
        if (onNavigationBarListener != null) {
            onNavigationBarListener.onChangeEndButtonsEnabled(isAboveThreshold());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(CLICKS_KEY, i);
        super.onSaveInstanceState(outState);
    }

}