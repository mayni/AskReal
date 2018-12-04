package com.example.mayni.askreal;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.annotation.Dimension;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mayni.askreal.databinding.ActivityMain3BindingImpl;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Main3Activity extends AppCompatActivity {

    private View.OnClickListener onClickListener;

    private int num = 0,num2=0;
    private MainViewModel2 viewModel, viewModel_1,viewModel_2;

    ActivityMain3BindingImpl binding;

    private String fname,contact,who;
    private Drawable background,bgBtn,bgCard;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        who = "smile";
        bindView();
        initView();
    }

    private void bindView(){

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main3);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("user");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                viewModel_1 = new MainViewModel2(dataSnapshot.child("smile").getChildren(),getResources().getDrawable(R.drawable.bg2)
                        ,getDrawable(R.drawable.button1),getDrawable(R.drawable.card));

                viewModel_2 = new MainViewModel2(dataSnapshot.child("beam").getChildren(),getResources().getDrawable(R.drawable.bg3)
                        ,getDrawable(R.drawable.button2),getDrawable(R.drawable.bg7));

                viewModel = viewModel_1;
                binding.setViewmodels(viewModel);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println(error.toException());

            }
        });

        settingCard(who);
        dataBinding(who);

    }

    private void initView(){
        initOnClickListener();
        binding.btnClick.setOnClickListener(onClickListener);
        binding.cardView.setOnClickListener(onClickListener);
    }

    // You don't have to bind any functions to "android:onClick" in layout XML file.
    private void initOnClickListener(){
        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnClick :

                        if (who  == "smile"){
                            who = "beam";
                            viewModel = viewModel_2;
                            binding.setViewmodels(viewModel);
                        }else {
                            who = "smile";
                            viewModel = viewModel_1;
                            binding.setViewmodels(viewModel);
                        }
                        settingCard(who);
                        dataBinding(who);
                        break;
                    case R.id.cardView:
                        if (who == "smile"){
                            changeName(num,who);
                            num +=1;
                        }else {
                            changeName(num2,who);
                            num2++;
                        }



                }
            }
        };
    }

    @SuppressLint("SetTextI18n")
    private  void changeName(int val,String who){
        if (val%2 != 0) {
                    viewModel.setFullName( who == "smile" ? getString(R.string.nameSmile) : getString(R.string.nameBeam));
        }
        else {

            viewModel.setFullName(who == "smile" ? "SMILE :D" : "I'm BEAMMHEE. :)");
        }
        if (who == "smile"){

            binding.nameMe.setText(viewModel_1.getFullName());
        }else {
            binding.nameBeam.setText(viewModel_2.getFullName());
        }



    }

    private void settingCard(String who){
        switch (who){
            case "smile":
//                fname = getString(R.string.nameSmile);
//                contact = getString(R.string.telMailSmile);
                background = getResources().getDrawable(R.drawable.bg2);
                bgBtn = getDrawable(R.drawable.button1);
                bgCard = getDrawable(R.drawable.card);
                break;
            case "beam":
//                fname = getString(R.string.nameBeam);
//                contact = getString(R.string.beamPhone);
                background = getResources().getDrawable(R.drawable.bg3);
                bgBtn = getDrawable(R.drawable.button2);
                bgCard = getDrawable(R.drawable.bg7);
        }
    }

    private void dataBinding(String who){


        if (who == "smile"){
            binding.nameMe.setVisibility(View.VISIBLE);
            binding.nameBeam.setVisibility(View.INVISIBLE);
            binding.contactSmile.setVisibility(View.VISIBLE);
            binding.contactBeam.setVisibility(View.INVISIBLE);
        }else {
            binding.nameMe.setVisibility(View.INVISIBLE);
            binding.nameBeam.setVisibility(View.VISIBLE);
            binding.contactSmile.setVisibility(View.INVISIBLE);
            binding.contactBeam.setVisibility(View.VISIBLE);
        }


    }



}
