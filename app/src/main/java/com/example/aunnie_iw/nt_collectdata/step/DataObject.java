package com.example.aunnie_iw.nt_collectdata.step;

import java.io.Serializable;

/**
 * Created by Aunnie-IW on 12/7/2560.
 */

public class DataObject implements Serializable {

    private String img;
    private String IDcard;
    private String TitleNameThai;
    private String firstNameThai;
    private String lastNameThai;
    private String birthday;
    private String tell;
    private String hometell;
    private String email;



    public DataObject() {
    }



    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIDcard() {
        return this.IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public String getTitleNameThai() {
        return this.TitleNameThai;
    }

    public void setTitleNameThai(String TitleNameThai) {
        this.TitleNameThai = TitleNameThai;
    }

    public String getFirstNameThai() {
        return this.firstNameThai;
    }

    public void setFirstNameThai(String firstNameThai) {
        this.firstNameThai = firstNameThai;
    }

    public String getLastNameThai() {
        return this.lastNameThai;
    }

    public void setLastNameThai(String lastNameThai) {
        this.lastNameThai = lastNameThai;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }



    public String getTell() {
        return this.tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getHometell() {
        return this.hometell;
    }

    public void setHometell(String hometell) {
        this.hometell = hometell;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
