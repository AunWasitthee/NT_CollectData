package com.example.aunnie_iw.nt_collectdata.model;

import android.provider.BaseColumns;

/**
 * Created by Aunnie-IW on 19/7/2560.
 */

public class Order {
    //Database
    public static final String DATABASE_NAME = "order.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE = "order";

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String SHOE_TYPE = "shoe_type";
        public static final String SHOE_SIZE = "shoe_size";
        public static final String SHOE_NOTE = "note";
        public static final String MATERIAL_ID = "material_id";
        public static final String SHOE_BRAND_ID = "shoe_brand_id";
        public static final String USER_ID = "user_id";
        public static final String PATIENT_ID = "patient_id";
    }

    private String id;
    private String shoe_type;
    private String shoe_size;
    private String note;
    private String material_id;
    private String shoe_brand_id;
    private String user_id;
    private String patient_id;

    //Default Constructor
    public  Order() {

    }
    //Constructor
    public  Order(String id, String shoe_type, String shoe_size,String note,String material_id,String shoe_brand_id,String user_id,String patient_id) {

        this.id = id;
        this.shoe_type = shoe_type;
        this.shoe_size = shoe_size;
        this.note = note;
        this.material_id = material_id;
        this.shoe_brand_id = shoe_brand_id;
        this.user_id = user_id;
        this.patient_id = patient_id;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShoe_type() {
        return shoe_type;
    }

    public void setShoe_type(String shoe_type) {
        this.shoe_type = shoe_type;
    }

    public String getShoe_size() {
        return shoe_size;
    }

    public void setShoe_size(String shoe_size) {
        this.shoe_size = shoe_size;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    public String getShoe_brand_id() {
        return shoe_brand_id;
    }

    public void setShoe_brand_id(String shoe_brand_id) {
        this.shoe_brand_id = shoe_brand_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String id) {
        this.patient_id = patient_id;
    }

}
