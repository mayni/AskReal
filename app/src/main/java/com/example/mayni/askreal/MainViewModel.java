package com.example.mayni.askreal;

import android.arch.lifecycle.ViewModel;
import android.graphics.drawable.Drawable;

public class MainViewModel extends ViewModel{
    private String name;
    private String id;
    private String id_name;
    private String address;
    private String tel;
    private String tel_name;
    private Boolean button_EN,button_TH;


    public MainViewModel() {

        this.name = "คุณนิวัฒน์  สารภี";
        this.id = "1-2345-678910-88-8";
        this.id_name= "หมายเลขบัตรประชาชน :";
        this.address= "จังหวัดเชียงใหม่ ประเทศไทย 50200";
        this.tel= "+66 81 2265894";
        this.tel_name= "เบอร์โทรติดต่อ :";
        this.button_EN=true;
        this.button_TH=false;


    }
    public void setString(String string[]) {
        this.name = string[0];
        this.id = string[1];
        this.id_name= string[2];
        this.address= string[3];
        this.tel= string[4];
        this.tel_name= string[5];


    }

    public String getId() {
        return id;
    }

    public String getId_name() {
        return id_name;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public String getTel_name() {
        return tel_name;
    }
    public String getName() {
        return name;
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
