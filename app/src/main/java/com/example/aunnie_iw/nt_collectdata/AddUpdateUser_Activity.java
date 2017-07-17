package com.example.aunnie_iw.nt_collectdata;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import nectec_stp.code.com.ntcardreader.*;

import com.example.aunnie_iw.nt_collectdata.step.AddressDataObject;
import com.example.aunnie_iw.nt_collectdata.step.DataObject;
import com.feitian.readerdk.Tool.DK;

/**
 * Created by Aunnie-IW on 11/7/2560.
 */

public class AddUpdateUser_Activity extends AppCompatActivity implements View.OnClickListener {
    private static final String ACTION_USB_PERMISSION = "com.android.example.USB_PERMISSION";  /*สร้างตัวแปรใช้ประกาศการขออนุญาตใช้USB*/
    private UsbDevice mDevice ;
    protected UsbManager mUsbManager;
    protected PendingIntent mPermissionIntent;  //pending = รอ
    protected NT_reader mCard ;
    /*-----------------------------แสดงผล----------------------------------------*/
    //protected TextView Cid,NameTH,Address,CreateCard,NameEng,Datebirthday,ExpireCard,DateToday,Stmsg;
    protected Button mOpen;
    private String deviceName;
    /*-------------------------------------------------------------4 */
    protected ImageView Img ;
    protected DataObject dataObject;
    protected AddressDataObject addressDataObject;
    protected Button BOk;
    protected EditText E_Search;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_update_user);

        BOk = (Button) findViewById(R.id.BOk);
        dataObject = new DataObject();
        addressDataObject = new AddressDataObject();
        E_Search = (EditText) findViewById(R.id.E_Search);

        WhenClickBOk();

        /*------------------------------------------------------------------------------------------------------   1*/
        mUsbManager = (UsbManager) getSystemService(Context.USB_SERVICE);/*เช็ค เปิดค่า USB*/
        mPermissionIntent = PendingIntent.getBroadcast(this, 0, new Intent(ACTION_USB_PERMISSION), 0);
        IntentFilter filter = new IntentFilter();
        filter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED);
        filter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED);
        /*-----------------------------*/
        registerReceiver(mUsbReceiver, filter);
        mOpen = (Button) findViewById(R.id.BOpen);
        mOpen.setOnClickListener(this);
        mOpen.setEnabled(false);
//        mExit = (Button) findViewById(R.id.BExit);
//        mExit.setOnClickListener(this);
        /*-----------------------------*/

    }



    private void WhenClickBOk() {
        BOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataObject.setIDcard(E_Search.getText().toString());
                if (dataObject.getIDcard().equals("")) {
                    Toast.makeText(AddUpdateUser_Activity.this, "onError! -> กรุณากรอกเลขบัตรประชาชน", Toast.LENGTH_SHORT).show();
                }
                else {
                    Log.d("onClick: ", E_Search.getText().toString());
                    Intent intent = new Intent(AddUpdateUser_Activity.this, StepAddData_Activity.class);
                    intent.putExtra("DataObject", dataObject);
                    intent.putExtra("AddrssDataObject", addressDataObject);
                    startActivity(intent);
                }
            }
        });
    }

    @SuppressLint("NewApi")
    private final BroadcastReceiver mUsbReceiver = new BroadcastReceiver() {
        @TargetApi(12)
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (UsbManager.ACTION_USB_DEVICE_ATTACHED.equals(action)) {
                UsbDevice deviceInput = (UsbDevice) intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
                if (deviceInput != null) {
                }
                //Stmsg.setText("เพิ่มอุปกรณ์:  " + deviceInput.getDeviceName()+"\n");
                deviceName=deviceInput.getDeviceName();
                mOpen.setEnabled(true);
                /*------------------------------------------------------------------------------------*/
                for (UsbDevice device : mUsbManager.getDeviceList().values()) {
                    if (deviceName.equals(device.getDeviceName())) {
                        if (mCard != null) {
                            mCard.close();
                        }
                        mDevice = device;
                        if (!mUsbManager.hasPermission(mDevice)) {
                            mUsbManager.requestPermission(mDevice, mPermissionIntent);
                        }
                        if (!mUsbManager.hasPermission(mDevice)) {
                            return;
                        }
                        break;
                    }
                }
            } else if (UsbManager.ACTION_USB_DEVICE_DETACHED.equals(action)) {
                UsbDevice deviceExit = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
                //Stmsg.setText("ถอดอุปกรณ์:  " + deviceExit.getDeviceName()+"\n");
                if (null != mCard) {
                }
            }
        }
    };
    /*------------------------------------------------------------------------------------------------------   1*/
    @Override
    public void onClick(View v) {
        if (v == mOpen) {
//             String deviceName = (String) mSpinner.getSelectedItem(); //ทำการเลือกitem ใน spinner
            if (deviceName != null)
//            ------(*)-------------ส่วนของการเช็คชื่อเเละทำการตรวจอุปรณ์เเละทำการ connect---------------
            {
                for (UsbDevice device : mUsbManager.getDeviceList().values()) {
                    // If device name is found
                    if (deviceName.equals(device.getDeviceName())) {
                        if (mCard != null) {
                            mCard.close();
                        }
                        mCard = new NT_reader(mUsbManager, mDevice);
                        break;
                    }
                }
            }
            try {
                mCard.open();
                mOpen.setEnabled(false);
//                Stmsg.setText("เปิดอุปกรณ์สำเร็จ "+"\n");
                mCard.startCardStatusMonitoring(mHandler);
            } catch (Exception e) {
                //Stmsg.setText("ไม่พบอุปกรณ์"+"\n");
            }
        }
//        else if (v == mExit) {
//            new AlertDialog.Builder(AddUpdateUser_Activity.this)
//                    .setTitle("ออกโปรแกรม")
//                    .setMessage("คุณกำลังทำการออกจากโปรแกรม")
//                    .setPositiveButton(" ใช่",
//                            new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog,
//                                                    int which) {
//                                    // TODO Auto-generated method stub
//                                    finish();
//                                }
//                            })
//                    .setNegativeButton("ไม่",
//                            new DialogInterface.OnClickListener() {
//
//                                @Override
//                                public void onClick(DialogInterface dialog,
//                                                    int which) {
//                                    // TODO Auto-generated method stub
//                                    // do nothing
//                                }
//                            }).show();
//        }
    }
    //    -------------------------------------Handler-------------------------------------------------------
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DK.CARD_STATUS:
                    switch (msg.arg1) {
                        case DK.CARD_ABSENT: //ยังไม่มีการใช้อินเทอเฟสของอุปกรณ์
                            try{
                                stat_clear();
                                mCard.PowerOff();
/*--------------------------------------Auto Clear---------------------------------------------------*/

                                //Stmsg.setText("กรุณาเสียบบัตรประชาชน"+"\n");
                            } catch (FtException e) {
                                e.printStackTrace();
                            }
                            break;
                        case DK.CARD_PRESENT:
                            //Stmsg.setText("พบการเสียบบัตรประชาชน"+"\n"); //อินเทอเฟสของอุปกรณ์ถูกใช้งานเเล้ว
                            try {
                                stat_clear();
                                mCard.PowerOff();
                                mCard.PowerOn();
/*------------------------------------Auto read-----------------------------------------------------*/
                                stat_clear();
                                mCard.PowerOff();
                                mCard.PowerOn();
/*------------------------------------Auto read-----------------------------------------------------*/
                                Card card = mCard.read();
                                dataObject.setFirstNameThai(card.getFirstNameThai());
                                dataObject.setLastNameThai(card.getLastNameThai());
                                dataObject.setIDcard(card.getCitizenID());
                                dataObject.setBirthday(card.getBirthday());


                                dataObject.setImg(Helper.BitMapToString(card.getPicture()));
                                addressDataObject.setHouseNumber(card.getAddress().getHouseNumber());
                                addressDataObject.setMoo(card.getAddress().getMoo());
                                addressDataObject.setTambon(card.getAddress().getTambon());
                                addressDataObject.setAmphur(card.getAddress().getAmphur());
                                addressDataObject.setProvince(card.getAddress().getProvince());
                                E_Search.setText(dataObject.getIDcard());
                                Log.d("handleMessage: ", "handleMessage: ");
                                Log.d("handleMessage: ", "handleMessage: ");

//                                Cid.setText(card.getCitizenID()); //รหัสประจำตัวประชาชน
//                                NameTH.setText(card.getTitleThai()+" "+card.getFirstNameThai()+" "+card.getLastNameThai()); //ชื่อภาษาไทย
//                                NameEng.setText(card.getTitleEng()+" "+card.getFirstNameEng()+" "+card.getLastNameEng()); //ชื่อภาษาอังกฤษ
//                                Address.setText(card.getAddress().getHouseNumber()+" "+card.getAddress().getMoo()+" "+card.getAddress().getTambon()+" "+card.getAddress().getAmphur()+" "+card.getAddress().getProvince());  //ที่อยู่
//                                Datebirthday.setText(card.getBirthday()); //วันเดือนปีเกิด
//                                CreateCard.setText(card.getCreateCard()); //วันทำบัตร
//                                ExpireCard.setText(card.getExpireCard()); //วันบัตรหมดอายุ
//                                DateToday.setText(card.getDateThaitoday()); //วันปัจจุบันที่ทำการอ่านบัตร
//                                Img.setImageBitmap(card.getPicture());//รูปภาพประจำตัว
//                                Stmsg.setText("อ่านข้อมูลเรียบร้อย"+"\n");
/*-----------------------------------------------------------------------------------------*/
                            } catch (FtException e) {
                                e.printStackTrace();
                            }
                            break;
                        case DK.CARD_UNKNOWN:
                            //Stmsg.setText("บัตรไม่ถูกต้อง"+"\n");
                            break;
                        case DK.IFD_COMMUNICATION_ERROR:
                            //Stmsg.setText("การส่งข้อมูลผิดพลาด"+"\n");
                            break;
                    }
                default:
                    break;
            }
        }
    };
    private void stat_clear() {
//        Img.setImageDrawable(null);
//        Stmsg.setText("");Cid.setText("");NameTH.setText("");Address.setText("");
//        CreateCard.setText("");NameEng.setText("");Datebirthday.setText("");ExpireCard.setText("");
//        DateToday.setText("");
    }


}
