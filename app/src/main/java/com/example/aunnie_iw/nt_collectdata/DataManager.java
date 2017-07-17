package com.example.aunnie_iw.nt_collectdata;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Aunnie-IW on 13/7/2560.
 */

public interface DataManager  {
    void saveData(String data);

    String getImg();

    String getIDcard();
    String getTitleNameThai();
    void saveTitleNameThai(String TitleNameThai);

    String getfirstNameThai();
    String getlastNameThai();
    String getbirthday();
    String gettell();
    String gethometell();
    String getemail();


    String gethouseNumber();
    String getBuilding();
    String getroom();
    String getfloor();
    String getmoo();
    String getsoi();
    String getroad();
    String gettambon();
    String getamphur();
    String getprovince();
    String getpostcode();

    void saveTitleContact(String TitleContact);
    void saveRelationship(String Relationship);
    String getTitleContact();
}

