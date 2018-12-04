package com.example.mayni.askreal;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.mayni.askreal.databinding.ActivityMainBindingImpl;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private View effectOnContainer1;
    private ImageButton image;
    private MainViewModel viewModel;


    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    ActivityMainBindingImpl binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("user");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                viewModel = new MainViewModel(dataSnapshot.child("mark").getChildren());
                binding.setViewmodel(viewModel);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println(error.toException());

            }
        });


    }

    public void process(View view){
//        String  Data_th [] = new String[]{"คุณนิวัฒน์  สารภี", "1-2345-678910-88-8", "หมายเลขบัตรประชาชน :", "จังหวัดเชียงใหม่ ประเทศไทย 50200", "+66 81 2265894", "เบอร์โทรติดต่อ :"};
//        String  Data_en [] = new String[]{"MR. Niwat Sarapee", "1-2345-678910-88-8", "Identity Number Card :", "ChiangMai Thailand 50200", "+66 81 2265894", "Telephone :"};

        if(view.getId() == R.id.btn_en ){
            ChangeData("EN");
            viewModel.setButton_EN(false);
            viewModel.setButton_TH(true);

        }else if(view.getId() == R.id.btn_th){
            ChangeData("TH");
            viewModel.setButton_EN(true);
            viewModel.setButton_TH(false);
        }
        binding.btnEn.setClickable(viewModel.getButton_EN());
        binding.btnEn.setEnabled(viewModel.getButton_EN());
        binding.btnTh.setClickable(viewModel.getButton_TH());
        binding.btnTh.setEnabled(viewModel.getButton_TH());
    }

    public void ChangeData(String lang) {
        if(lang == "TH"){
            binding.tvName.setText(viewModel.getName_th());
            binding.tvTelName.setText(viewModel.getTel_name_th());
            binding.tvTel.setText(viewModel.getTel());
            binding.tvAddress.setText(viewModel.getAddress_th());
            binding.idname.setText(viewModel.getId_name_th());
            binding.tvId.setText(viewModel.getId());

        }else{
            binding.tvName.setText(viewModel.getName_en());
            binding.tvTelName.setText(viewModel.getTel_name_en());
            binding.tvTel.setText(viewModel.getTel());
            binding.tvAddress.setText(viewModel.getAddress_en());
            binding.idname.setText(viewModel.getId_name_en());
            binding.tvId.setText(viewModel.getId());

        }

    }

    public void imageClick(View view) {
        Animation anim = new RotateAnimation(0,360,view.getWidth()/2,view.getHeight()/2);


        anim.setDuration(500);
        view.startAnimation(anim);
        System.out.println("[Click]"+ view.getId());
    }
}
