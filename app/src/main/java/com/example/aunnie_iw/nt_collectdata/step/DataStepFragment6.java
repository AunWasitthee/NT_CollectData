package com.example.aunnie_iw.nt_collectdata.step;

/**
 * Created by Aunnie-IW on 13/7/2560.
 */

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.aunnie_iw.nt_collectdata.DataManager;
import com.example.aunnie_iw.nt_collectdata.Helper;
import com.example.aunnie_iw.nt_collectdata.R;
import com.example.aunnie_iw.nt_collectdata.RotateImg;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

public class DataStepFragment6 extends ButterKnifeFragment implements BlockingStep {
    String a;
    public static DataStepFragment6 newInstance() {
        return new DataStepFragment6();
    }

    private DataManager dataManager;

    //private Bitmap ImgLocationCard;

    public static final int MY_PERMISSIONS_REQUEST_STORED = 90;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 98;

    public static final int REQUEST_GALLERY = 1;
    public static final int REQUEST_CAMERA = 2;

    private Uri uri;
    private File f;
    private  int positionImage;

    private Bitmap[] ImgLocationCard = new Bitmap[7];
    private static final int REQUEST_PERMISSION_SETTING = 101;
    private boolean sentToSettings = false;
    private SharedPreferences permissionStatus;
    private String[] PathImgLocationCard = new String[7];

    @Bind(R.id.Pic1) ImageView Pic1;
    @Bind(R.id.Pic2) ImageView Pic2;
    @Bind(R.id.Pic3) ImageView Pic3;
    @Bind(R.id.Pic4) ImageView Pic4;
    @Bind(R.id.Pic5) ImageView Pic5;
    @Bind(R.id.Pic6) ImageView Pic6;
    @Bind(R.id.Pic7) ImageView Pic7;
    @Bind(R.id.TakePic1) Button TakePic1;
    @Bind(R.id.TakePic2) Button TakePic2;
    @Bind(R.id.TakePic3) Button TakePic3;
    @Bind(R.id.TakePic4) Button TakePic4;
    @Bind(R.id.TakePic5) Button TakePic5;
    @Bind(R.id.TakePic6) Button TakePic6;
    @Bind(R.id.TakePic7) Button TakePic7;

    public void setPathImage(int position, String s){
        this.PathImgLocationCard[position] = s;
    }

    public String getPathImage(int position){
        return this.PathImgLocationCard[position];
    }
    public void setBitmapPosition(int position, Bitmap b){
        ImgLocationCard[position] = b;
    }

    public Bitmap getBitmapPosition(int position){
        return ImgLocationCard[position];
    }


    public void setImagePosition(int position){
        this.positionImage = position;
    }

    public  int getImagePosition(){
        return this.positionImage;
    }
    public void UpdateImageUi(){

    }

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
        permissionStatus = this.getActivity().getSharedPreferences("permissionStatus",MODE_PRIVATE);
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
        return R.layout.fragment_step6;
    }

    @OnClick({R.id.TakePic1,R.id.TakePic2,R.id.TakePic3,R.id.TakePic4,R.id.TakePic5,R.id.TakePic6,R.id.TakePic7})
    public void onClick(Button button) {
        switch (button.getId()){
            case R.id.TakePic1:
                setImagePosition(1);
                selectImage("Pic1");
                Pic1.setImageBitmap(getBitmapPosition(1));
                Toast.makeText(getActivity(), "Pic1 ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.TakePic2:
                setImagePosition(2);
                selectImage("Pic2");
                Pic2.setImageBitmap(getBitmapPosition(2));
                Toast.makeText(getActivity(), "Pic2 ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.TakePic3:
                setImagePosition(2);
                selectImage("Pic3");
                Pic3.setImageBitmap(getBitmapPosition(3));
                Toast.makeText(getActivity(), "Pic3 ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.TakePic4:
                setImagePosition(4);
                selectImage("Pic4");
                Pic4.setImageBitmap(getBitmapPosition(4));
                Toast.makeText(getActivity(), "Pic4 ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.TakePic5:
                setImagePosition(5);
                selectImage("Pic5");
                Pic5.setImageBitmap(getBitmapPosition(5));
                Toast.makeText(getActivity(), "Pic5 ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.TakePic6:
                setImagePosition(6);
                selectImage("Pic6");
                Pic6.setImageBitmap(getBitmapPosition(6));
                Toast.makeText(getActivity(), "Pic6 ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.TakePic7:
                setImagePosition(7);
                selectImage("Pic7");
                Pic7.setImageBitmap(getBitmapPosition(7));
                Toast.makeText(getActivity(), "Pic7 ", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void selectImage(final String NamePic) {

        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo"))

                {/*------------------- Permission --------------------------------------*/


                    if (ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {

                        checkCameraPermission();
                    }
                    else {


                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                        String timeStamp =
//                                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                        String imageFileName = dataManager.getIDcard() + NamePic+ ".jpg";
                        f = new File(Environment.getExternalStorageDirectory()
                                , "DCIM/Camera/" + imageFileName);
                        uri = Uri.fromFile(f);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                        startActivityForResult(intent, 2);
                    }
                }
                else if (options[item].equals("Choose from Gallery"))
                {

                    /*------------------- Permission --------------------------------------*/
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)
                            != PackageManager.PERMISSION_GRANTED) {

                        checkWRITE_EXTERNAL_STORAGEPermission();
                    } else {

//                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                    intent.setType("image/*");
//                    startActivityForResult(Intent.createChooser(intent
//                            , "Select photo from"), 1);
                        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(intent, 1);
                    }
                }

                else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("onActivityResult", "onActivityResult: ");
        if (requestCode == REQUEST_GALLERY && resultCode == RESULT_OK) {
            uri = data.getData();
            String path =Helper.getPath(getActivity(), Uri.parse(data.getData().toString()));
            setPathImage(getImagePosition(), path);
            //PathImgLocationCard[getImagePosition()] = Helper.getPath(getActivity(), Uri.parse(data.getData().toString()));
            //uploadFromFile(PathImgLocationCard);
            //File imageFile = new File(getRealPathFromURI(uri));
            Log.d(uri.toString(), "onActivityResult: ");
            Log.d(uri.getPath(), "onActivityResult: ");
            Log.d(getPathImage(getImagePosition()), "onActivityResult: ");
            try {
                ImgLocationCard[getImagePosition()] = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                ImgLocationCard[getImagePosition()]= RotateImg.Rotate(getPathImage(getImagePosition()),ImgLocationCard[getImagePosition()]);
                Log.d("bitmap", "onActivityResult: ");
                //uploadFromDataInMemory(bitmap);
//                Pic1.setImageBitmap(ImgLocationCard);
            } catch (FileNotFoundException e) {
                Log.d("FileNotFoundException", "onActivityResult: ");
                e.printStackTrace();
            } catch (IOException e) {
                Log.d("IOException", "onA ctivityResult: ");
                e.printStackTrace();
            }
        }
        else if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK){

            getActivity().getContentResolver().notifyChange(uri, null);
            ContentResolver cr = getActivity().getContentResolver();


            try {

                ImgLocationCard[getImagePosition()] = MediaStore.Images.Media.getBitmap(cr, uri);
                ImgLocationCard[getImagePosition()] = RotateImg.Rotate(uri.getPath(),ImgLocationCard[getImagePosition()]);

                setPathImage(getImagePosition(),uri.getPath().toString());
                Log.d("onActivityResult: Path", getPathImage(getImagePosition()));
                //PathImgLocationCard[getImagePosition()] = uri.getPath();
//                Pic1.setImageBitmap(ImgLocationCard);

                Toast.makeText(getActivity().getApplicationContext()
                        , uri.getPath(), Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public boolean checkWRITE_EXTERNAL_STORAGEPermission(){
        if (ContextCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(getActivity(),
                    new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_STORED);

            }else if (permissionStatus.getBoolean(Manifest.permission.WRITE_EXTERNAL_STORAGE,false)) {
                //Previously Permission Request was cancelled with 'Dont Ask Again',
                // Redirect to Settings after showing Information about why you need the permission
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Need STORAGE Permission");
                builder.setMessage("This app needs WRITE_EXTERNAL_STORAGE permission.");
                builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        sentToSettings = true;
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
                        intent.setData(uri);
                        startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
                        Toast.makeText(getActivity().getBaseContext(), "Go to Permissions to Grant Storage", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
            else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_STORED);
            }
            SharedPreferences.Editor editor = permissionStatus.edit();
            editor.putBoolean(Manifest.permission.WRITE_EXTERNAL_STORAGE,true);
            editor.commit();
            return false;

        } else {
            return true;
        }
    }
    public boolean checkCameraPermission(){
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    android.Manifest.permission.CAMERA)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                //Show Information about why you need the permission
                    ActivityCompat.requestPermissions(getActivity(),
                        new String[]{android.Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);



            }else if (permissionStatus.getBoolean(Manifest.permission.CAMERA,false)) {
                //Previously Permission Request was cancelled with 'Dont Ask Again',
                // Redirect to Settings after showing Information about why you need the permission
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Need Camera Permission");
                builder.setMessage("This app needs camera permission.");
                builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        sentToSettings = true;
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
                        intent.setData(uri);
                        startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
                        Toast.makeText(getActivity().getBaseContext(), "Go to Permissions to Grant Storage", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
            else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{android.Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);
            }
            SharedPreferences.Editor editor = permissionStatus.edit();
            editor.putBoolean(Manifest.permission.CAMERA,true);
            editor.commit();
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_STORED: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED) {

//                        if (mGoogleApiClient == null) {
//                            buildGoogleApiClient();
//                        }

                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(getActivity(), "permission denied", Toast.LENGTH_LONG).show();
                }
                //return;
            }

            case MY_PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_GRANTED) {

//                        if (mGoogleApiClient == null) {
//                            buildGoogleApiClient();
//                        }

                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(getActivity(), "permission denied", Toast.LENGTH_LONG).show();
                }
                //return;
            }
            // other 'case' lines to check for other permissions this app might request.
            // You can add here other case statements according to your requirement.
        }
    }
}
