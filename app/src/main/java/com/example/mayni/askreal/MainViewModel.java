package com.example.mayni.askreal;

import android.arch.lifecycle.ViewModel;
import android.graphics.drawable.Drawable;
import android.util.ArrayMap;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class MainViewModel extends ViewModel{
    private String name_th;
    private String name_en;
    private String name;
    private String id;
    private String id_name_th;
    private String id_name_en;
    private String id_name;
    private String address_th;
    private String address_en;
    private String address;
    private String tel;
    private String tel_name_th;
    private String tel_name_en;
    private String tel_name;
    private Boolean button_EN,button_TH;

    public MainViewModel(Iterable<DataSnapshot> mark){
        for (DataSnapshot child: mark) {
            switch (child.getKey()) {
                case "address_en":
                    this.address_en = child.getValue().toString();
                    break;
                case "address_th":
                    this.address_th = child.getValue().toString();
                    break;
                case "identity_en":
                    this.id_name_en = child.getValue().toString();
                    break;
                case "identity_th":
                    this.id_name_th = child.getValue().toString();
                    break;
                case "name_en":
                    this.name_en = child.getValue().toString();
                    break;
                case "name_th":
                    this.name_th = child.getValue().toString();
                    break;
                case "telephone":
                    this.tel = child.getValue().toString();
                    break;
                case "telephone_en":
                    this.tel_name_en = child.getValue().toString();
                    break;
                case "telephone_th":
                    this.tel_name_th = child.getValue().toString();
                    break;
                case "identity":
                    this.id  = child.getValue().toString();
                    break;

            }
            Log.i("MyTag",child.getKey()+ child.getValue().toString());

        }
        this.name = this.name_th;
        this.address = this.address_th;
        this.tel_name = this.tel_name_th;
        this.id_name = this.id_name_th;

        this.button_TH = false;
        this.button_EN = true;
    }


    public String getAddress_th() {
        return address_th;
    }

    public String getAddress_en() {
        return address_en;
    }

    public String getId() {
        return id;
    }

    public String getId_name_en() {
        return id_name_en;
    }

    public String getId_name_th() {
        return id_name_th;
    }

    public String getName_en() {
        return name_en;
    }

    public String getName_th() {
        return name_th;
    }

    public String getTel() {
        return tel;
    }

    public String getTel_name_en() {
        return tel_name_en;
    }

    public String getTel_name_th() {
        return tel_name_th;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getId_name() {
        return id_name;
    }

    public String getTel_name() {
        return tel_name;
    }

    public Boolean getButton_EN() {
        return button_EN;
    }

    public void setButton_EN(Boolean button_EN) {
        this.button_EN = button_EN;
    }

    public Boolean getButton_TH() {
        return button_TH;
    }

    public void setButton_TH(Boolean button_TH) {
        this.button_TH = button_TH;
    }



}
