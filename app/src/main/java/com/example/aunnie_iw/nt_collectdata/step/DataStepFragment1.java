package com.example.aunnie_iw.nt_collectdata.step;

/**
 * Created by Aunnie-IW on 13/7/2560.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
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

import butterknife.Bind;

public class DataStepFragment1 extends ButterKnifeFragment implements BlockingStep {

    public static DataStepFragment1 newInstance() {
        return new DataStepFragment1();
    }

    private DataManager dataManager;
    @Bind(R.id.tv_IdCard)
    TextView tv_IdCard;
    @Bind(R.id.E_FirstName)
    EditText E_FirstName;
    @Bind(R.id.S_TitleName)
    Spinner S_TitleName;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DataManager) {
            dataManager = (DataManager) context;
        } else {
            throw new IllegalStateException("Activity must implement DataManager interface!");
        }
       // setSpinnerTitleName(context);
    }

//    private void setSpinnerTitleName(Context context) {
//        /*------------------- Spinner Sex--------------------------------------------------------------------------------------------------*/
//        String[] TitleName = getResources().getStringArray(R.array.TitleName);
////        if(people.getProfileData() !=null && people.getProfileData().getSex()!=null){
////            Sex[Sex.length-1] = people.getProfileData().getSex();
////        }
//        //S_TitleName = (Spinner) findViewById(R.id.Sex);
//        final ArrayAdapter<String> adapterSex = new ArrayAdapter<String>(, android.R.layout.simple_dropdown_item_1line, S_TitleName){
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                Log.d(getItem(getCount()), "getView: ");
//                View v = super.getView(position, convertView, parent);
//                if (position == getCount()) {
//                    ((TextView) v.findViewById(android.R.id.text1)).setText(getItem(getCount()));
//                    ((TextView) v.findViewById(android.R.id.text1)).setTextSize(14);
//                    //((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
//                }
//                return v;
//            }
//
//            @Override
//            public int getCount() {
//                return super.getCount() - 1; // you dont display last item. It is used as hint.
//            }
//        };
//        S_TitleName.setAdapter(adapterSex);
//        S_TitleName.setSelection(adapterSex.getCount());
//        S_TitleName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View v, int i, long l)
//            {
//                TextView myText = (TextView) v;
//                Toast.makeText(Profile.this, "You Selected "+myText.getText(), Toast.LENGTH_SHORT).show();
//                ((TextView) adapterView.getChildAt(0)).setTextSize(14);
////                if(i==adapterSex.getCount()&&(people.getProfileData()==null||people.getProfileData().getSex()==null)){
////                    ((TextView) adapterView.getChildAt(0)).setTextColor(Color.RED);
////                }
////                else{
////                    ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLUE);
////                }
//
//            } // end onItemSelected method
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView)
//            {
//
//            } // end onNothingSelected method
//        });
//    }

    @Override
    public VerificationError verifyStep() {
        return checkValue() ? null : new VerificationError("Click more times!");
    }
    private boolean checkValue(){
        return true;
    }
    @Override
    public void onSelected() {
        tv_IdCard.setText(dataManager.getData());
        E_FirstName.setText(dataManager.getData2());


    }

    @Override
    public void onError(@NonNull VerificationError error) {
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
        return R.layout.fragment_step1;
    }
}
