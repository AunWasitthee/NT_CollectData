package com.example.aunnie_iw.nt_collectdata.model;

import android.provider.BaseColumns;

/**
 * Created by Aunnie-IW on 19/7/2560.
 */

public class Patients {
    //Database

    public static final String DATABASE_NAME = "patients.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE = "patients";

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String PREFIXNAME = "prefixname";
        public static final String NAME = "name";
        public static final String LASTNAME = "lastname";
        public static final String BIRTHDAR = "birthday";
        public static final String EMAIL = "email";
        public static final String PHONE = "phone";
        public static final String MOBILEPHONE = "mobilephone";
        public static final String HEIGHT = "height";
        public static final String TALL = "tall";
        public static final String BMI = "bmi";
        public static final String PROFILE1 = "profile1";
        public static final String PROFILE2 = "profile2";
        public static final String DATE_OF_ISSUE = "date_of_issue";
        public static final String HOUSE_NUMBER_1 = "house_number_1";
        public static final String BUILDING_1 = "building_1";
        public static final String ROOM_NUMBER_1 = "room_number_1";
        public static final String CLASS_1 = "class_1";
        public static final String VILLAGE_NO_1 = "village_no_1";
        public static final String ALLEY_1 = "alley_1";
        public static final String SUB_DISTRICT_1 = "sub_district_1";
        public static final String DISTRICT_1 = "district_1";
        public static final String PROVINCE_1 = "province_1";
        public static final String ZIP_CODE_1 = "zip_code_1";
        public static final String HOUSE_NUMBER_2 = "house_number_2";
        public static final String BUILDING_2 = "building_2";
        public static final String ROOM_NUMBER_2 = "room_number_2";
        public static final String CLASS_2 = "class_2";
        public static final String VILLAGE_NO_2 = "village_no_2";
        public static final String ALLEY_2 = "alley_2";
        public static final String SUB_DISTRICT_2 = "sub_district_2";
        public static final String DISTRICT_2 = "district_2";
        public static final String PROVINCE_2 = "province_2";
        public static final String ZIP_CODE_2 = "zip_code_2";
        public static final String UNDERLYING_DISEASE_SPECIFY = "underlying_disease_specify";
        public static final String FOOT_DISORDER_SPECIFY = "foot_disorder_specify";
        public static final String EMG_PREFIXNAME = "emg_prefixname";
        public static final String EMG_NAME = "emg_name";
        public static final String EMG_LASTNAME = "emg_lastname";
        public static final String EMG_PHONENUMBER = "emg_phonenumber";
        public static final String EMG_MOBILEPHONE = "emg_mobilephone";
        public static final String EMG_RELATIONSHIP = "emg_relationship";
        public static final String USER_ID = "user_id";


    }

    private String id;
    private String prefixname;
    private String name;
    private String lastname;
    private String birthday;
    private String email;
    private String phone;
    private String mobilephone;
    private double height;
    private double tall;
    private double bmi;
    private String profile1;
    private String profile2;
    private String date_of_issue;
    private String house_number_1;
    private String building_1;
    private String room_number_1;
    private String class_1;
    private Integer village_no_1;
    private String alley_1;
    private String sub_district_1;
    private String district_1;
    private String province_1;
    private Integer zip_code_1;
    private String house_number_2;
    private String building_2;
    private String room_number_2;
    private String class_2;
    private Integer village_no_2;
    private String alley_2;
    private String sub_district_2;
    private String district_2;
    private String province_2;
    private Integer zip_code_2;
    private String underlying_disease_specify;
    private String foot_disorder_specify;
    private String emg_prefixname;
    private String emg_name;
    private String emg_lastname;
    private String emg_phonenumber;
    private String emg_mobilephone;
    private String emg_relationship;
    private Integer user_id;


    //Default Constructor
    public Patients() {

    }

    //Constructor
    public Patients(String id,
            String prefixname,
            String name,
            String lastname,
            String birthday,
            String email,
            String phone,
            String mobilephone,
            double height,
            double tall,
            double bmi,
            String profile1,
            String profile2,
            String date_of_issue,
            String house_number_1,
            String building_1,
            String room_number_1,
            String class_1,
            Integer village_no_1,
            String alley_1,
            String sub_district_1,
            String district_1,
            String province_1,
            Integer zip_code_1,
            String house_number_2,
            String building_2,
            String room_number_2,
            String class_2,
            Integer village_no_2,
            String alley_2,
            String sub_district_2,
            String district_2,
            String province_2,
            Integer zip_code_2,
            String underlying_disease_specify,
            String foot_disorder_specify,
            String emg_prefixname,
            String emg_name,
            String emg_lastname,
            String emg_phonenumber,
            String emg_mobilephone,
            String emg_relationship,
            Integer user_id) {

        this.id = id;
        this.prefixname = prefixname;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.mobilephone = mobilephone;
        this.height = height;
        this.tall = tall;
        this.bmi = bmi;
        this.profile1 = profile1;
        this.profile2 = profile2;
        this.date_of_issue = date_of_issue;
        this.house_number_1 = house_number_1;
        this.building_1 = building_1;
        this.room_number_1 = room_number_1;
        this.class_1 = class_1;
        this.village_no_1 = village_no_1;
        this.alley_1 = alley_1;
        this.sub_district_1 = sub_district_1;
        this.district_1 = district_1;
        this.province_1 = province_1;
        this.zip_code_1 = zip_code_1;
        this.house_number_2 = house_number_2;
        this.building_2 = building_2;
        this.room_number_2 = room_number_2;
        this.class_2 = class_2;
        this.village_no_2 = village_no_2;
        this.alley_2 = alley_2;
        this.sub_district_2 = sub_district_2;
        this.district_2 = district_2;
        this.province_2 = province_2;
        this.zip_code_2 = zip_code_2;
        this.underlying_disease_specify = underlying_disease_specify;
        this.foot_disorder_specify = foot_disorder_specify;
        this.emg_prefixname = emg_prefixname;
        this.emg_name = emg_name;
        this.emg_lastname = emg_lastname;
        this.emg_phonenumber = emg_phonenumber;
        this.emg_mobilephone = emg_mobilephone;
        this.emg_relationship = emg_relationship;
        this.user_id = user_id;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrefixname() {
        return prefixname;
    }

    public void setPrefixname(String prefixname) {
        this.prefixname = prefixname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getTall() {
        return tall;
    }

    public void setTall(double tall) {
        this.tall = tall;
    }
    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
    public String getProfile1() {
        return profile1;
    }

    public void setProfile1(String profile1) {
        this.profile1 = profile1;
    }
    public String getProfile2() {
        return profile2;
    }

    public void setProfile2(String profile2) {
        this.profile2 = profile2;
    }
    public String getDate_of_issue() {
        return date_of_issue;
    }

    public void setDate_of_issue(String date_of_issue) {
        this.date_of_issue = date_of_issue;
    }
    public String getHouse_number_1() {
        return house_number_1;
    }

    public void setHouse_number_1(String house_number_1) {
        this.house_number_1 = house_number_1;
    }
    public String getBuilding_1() {
        return building_1;
    }

    public void setBuilding_1(String building_1) {
        this.building_1 = building_1;
    }
    public String getRoom_number_1() {
        return room_number_1;
    }

    public void setRoom_number_1(String room_number_1) {
        this.room_number_1 = room_number_1;
    }
    public String getClass_1() {
        return class_1;
    }

    public void setClass_1(String class_1) {
        this.class_1 = class_1;
    }
    public Integer getVillage_no_1() {
        return village_no_1;
    }

    public void setVillage_no_1(Integer village_no_1) {
        this.village_no_1 = village_no_1;
    }
    public String getAlley_1() {
        return alley_1;
    }

    public void setAlley_1(String alley_1) {
        this.alley_1 = alley_1;
    }
    public String getSub_district_1() {
        return sub_district_1;
    }

    public void setSub_district_1(String sub_district_1) {
        this.sub_district_1 = sub_district_1;
    }
    public String getDistrict_1() {
        return district_1;
    }

    public void setDistrict_1(String district_1) {
        this.district_1 = district_1;
    }
    public String getProvince_1() {
        return province_1;
    }

    public void setProvince_1(String province_1) {
        this.province_1 = province_1;
    }
    public Integer getZip_code_1() {
        return zip_code_1;
    }

    public void setZip_code_1(Integer zip_code_1) {
        this.zip_code_1 = zip_code_1;
    }
    public String getHouse_number_2() {
        return house_number_2;
    }

    public void setHouse_number_2(String house_number_2) {
        this.house_number_2 = house_number_2;
    }
    public String getBuilding_2() {
        return building_2;
    }

    public void setBuilding_2(String building_2) {
        this.building_2 = building_2;
    }
    public String getRoom_number_2() {
        return room_number_2;
    }

    public void setRoom_number_2(String room_number_2) {
        this.room_number_2 = room_number_2;
    }
    public String getClass_2() {
        return class_2;
    }

    public void setClass_2(String class_2) {
        this.class_2 = class_2;
    }
    public Integer getVillage_no_2() {
        return village_no_2;
    }

    public void setVillage_no_2(Integer village_no_2) {
        this.village_no_2 = village_no_2;
    }
    public String getAlley_2() {
        return alley_2;
    }

    public void setAlley_2(String alley_2) {
        this.alley_2 = alley_2;
    }
    public String getSub_district_2() {
        return sub_district_2;
    }

    public void setSub_district_2(String sub_district_2) {
        this.sub_district_2 = sub_district_2;
    }
    public String getDistrict_2() {
        return district_2;
    }

    public void setDistrict_2(String district_2) {
        this.district_2 = district_2;
    }
    public String getProvince_2() {
        return province_2;
    }

    public void setProvince_2(String province_2) {
        this.province_2 = province_2;
    }
    public Integer getZip_code_2() {
        return zip_code_2;
    }

    public void setZip_code_2(Integer zip_code_2) {
        this.zip_code_2 = zip_code_2;
    }
    public String getUnderlying_disease_specify() {
        return underlying_disease_specify;
    }

    public void setUnderlying_disease_specify(String underlying_disease_specify) {
        this.underlying_disease_specify = underlying_disease_specify;
    }
    public String getFoot_disorder_specify() {
        return foot_disorder_specify;
    }

    public void setFoot_disorder_specify(String foot_disorder_specify) {
        this.foot_disorder_specify= foot_disorder_specify;
    }
    public String getEmg_prefixname() {
        return emg_prefixname;
    }

    public void setEmg_prefixname(String emg_prefixname) {
        this.emg_prefixname = emg_prefixname;
    }
    public String getEmg_name() {
        return emg_name;
    }

    public void setEmg_name(String emg_name) {
        this.emg_name = emg_name;
    }
    public String getEmg_lastname() {
        return emg_lastname;
    }

    public void setEmg_lastname(String emg_lastname) {
        this.emg_lastname = emg_lastname;
    }
    public String getEmg_phonenumber() {
        return emg_phonenumber;
    }

    public void setEmg_phonenumber(String emg_phonenumber) {
        this.emg_phonenumber = emg_phonenumber;
    }
    public String getEmg_mobilephone() {
        return emg_mobilephone;
    }

    public void setEmg_mobilephone(String emg_mobilephone) {
        this.emg_mobilephone = emg_mobilephone;
    }
    public String getEmg_relationship() {
        return emg_relationship;
    }

    public void setEmg_relationship(String emg_relationship) {
        this.emg_relationship = emg_relationship;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}