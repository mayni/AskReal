package com.example.mayni.askreal;

import android.arch.lifecycle.ViewModel;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Dimension;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;

public class MainViewModel2 extends ViewModel {
    private String fullName;
    private String nickname;
    private String contact;
    private Drawable background;
    private Drawable bgCard;
    private Drawable bgBtn;


    public MainViewModel2(Iterable<DataSnapshot> me, Drawable background,Drawable bgBtn,Drawable bgCard){
        this.background = background;
        this.bgBtn = bgBtn;
        this.bgCard = bgCard;
        String email=null ,tel = null;
        for (DataSnapshot child: me) {
            switch (child.getKey()){
                case "email":
                    email = child.getValue().toString();
                    break;
                case "name" :
                    this.fullName = child.getValue().toString();
                    break;
                case "nickname" :
                    this.nickname = child.getValue().toString();
                    break;
                case "tel" :
                    tel = child.getValue().toString();
                    break;
            }
            Log.i("MyTag",child.getKey()+ child.getValue().toString());
        }
        this.contact = tel + "\n"+ email;
//        this.background = bg;
//        this.bgBtn = bgBtn;
//        this.bgCard = bgCard;


    }


//    public void setText(String fullName, String contact) {
//        this.fullName = fullName;
//        this.contact = contact;
//
//    }

    public void setDrawable(Drawable background,Drawable bgBtn,Drawable bgCard){
        this.background = background;
        this.bgBtn = bgBtn;
        this.bgCard = bgCard;
    }


    public void setFullName(String string) {
        this.fullName = string;
    }

    public String getFullName() {
        return fullName;
    }

    public String getContact(){
        return contact;
    }

    public Drawable getBackground() {
        return background;
    }

    public Drawable getBgCard() {
        return bgCard;
    }

    public Drawable getBgBtn() {
        return bgBtn;
    }
}
