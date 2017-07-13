package com.example.aunnie_iw.nt_collectdata.step;

import java.io.Serializable;

/**
 * Created by Aunnie-IW on 12/7/2560.
 */

public class AddressDataObject implements Serializable {
    private String houseNumber;
    private String moo;
    private String soi;
    private String road;
    private String tambon;
    private String amphur;
    private String province;
    private String postcode;



    public AddressDataObject() {
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getMoo() {
        return this.moo;
    }

    public void setMoo(String moo) {
        this.moo = moo;
    }

    public String getSoi() {
        return this.soi;
    }

    public void setSoi(String soi) {
        this.soi = soi;
    }

    public String getRoad() {
        return this.road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getTambon() {
        return this.tambon;
    }

    public void setTambon(String tambon) {
        this.tambon = tambon;
    }

    public String getAmphur() {
        return this.amphur;
    }

    public void setAmphur(String amphur) {
        this.amphur = amphur;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


}