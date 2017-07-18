package com.example.aunnie_iw.nt_collectdata.model;

import android.provider.BaseColumns;

/**
 * Created by Aunnie-IW on 18/7/2560.
 */

public class Foot_Disorder{
    //Database
    public static final String DATABASE_NAME = "foot_disorder.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE = "foot_disorder";

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String TITLE = "title";
    }

    private int id;
    private String title;

    //Default Constructor
    public Foot_Disorder() {

    }
    //Constructor
    public Foot_Disorder(int id, String title) {

        this.id = id;
        this.title = title;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}