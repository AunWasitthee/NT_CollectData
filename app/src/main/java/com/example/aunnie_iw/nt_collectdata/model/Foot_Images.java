package com.example.aunnie_iw.nt_collectdata.model;

import android.provider.BaseColumns;

/**
 * Created by Aunnie-IW on 19/7/2560.
 */

public class Foot_Images {
        //Database
        public static final String DATABASE_NAME = "foot_images.db";
        public static final int DATABASE_VERSION = 1;
        public static final String TABLE = "foot_images";

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String PATHFILE = "pathfile";
        public static final String PATIENT_ID = "patient_id";
    }

    private String id;
    private String pathfile;
    private String patient_id;

    //Default Constructor
    public Foot_Images() {

    }
    //Constructor
    public Foot_Images(String id, String pathfile, String patient_id) {

        this.id = id;
        this.pathfile = pathfile;
        this.patient_id = patient_id;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPathfile() {
        return pathfile;
    }

    public void setPathfile(String pathfile) {
        this.pathfile = pathfile;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

}