package com.example.aunnie_iw.nt_collectdata.model;

import android.provider.BaseColumns;

/**
 * Created by Aunnie-IW on 18/7/2560.
 */

public class Shoe_Brands {
    //Database
    public static final String DATABASE_NAME = "shoe_brands.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE = "shoe_brands";

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String SHOE_BRANDS = "shoe_brands";
    }

    private int id;
    private String shoe_brands;

    //Default Constructor
    public Shoe_Brands() {

    }
    //Constructor
    public Shoe_Brands(int id, String shoe_brands) {

        this.id = id;
        this.shoe_brands = shoe_brands;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShoeBrands() {
        return shoe_brands;
    }

    public void setShoeBrands(String shoe_brands) {
        this.shoe_brands = shoe_brands;
    }
}