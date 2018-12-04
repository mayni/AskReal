package com.example.mayni.askreal;

import android.arch.lifecycle.ViewModel;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Dimension;

public class MainViewModel2 extends ViewModel {
    private String fullName;
    private String contact;
    private Drawable background;
    private Drawable bgCard;
    private Drawable bgBtn;


    public MainViewModel2(){
        this.fullName = "Full name";
        this.contact = "Tel and email";
        this.background = null;
        this.bgCard = null;
        this.bgBtn = null;
    }


    public void setText(String fullName, String contact) {
        this.fullName = fullName;
        this.contact = contact;

    }

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
