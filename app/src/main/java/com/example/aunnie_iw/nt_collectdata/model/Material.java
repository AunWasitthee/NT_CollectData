package com.example.aunnie_iw.nt_collectdata.model;

import android.provider.BaseColumns;

/**
 * Created by Aunnie-IW on 19/7/2560.
 */

public class Material {//Database
    public static final String DATABASE_NAME = "material.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE = "material";

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String PATHFILE = "pathfile";
        public static final String MATERIAL_NAME = "material_name";
    }

    private String id;
    private String pathfile;
    private String material_name;

    //Default Constructor
    public Material() {

    }
    //Constructor
    public Material(String id, String pathfile, String material_name) {

        this.id = id;
        this.pathfile = pathfile;
        this.material_name = material_name;

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

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

}
