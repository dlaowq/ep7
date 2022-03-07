package com.yjh.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivitybook extends AppCompatActivity {

    ImageButton btnSidemenu;

    String strNickname, strMbti;
    private View drawerView;
    private DrawerLayout drawerLayout;
    ImageView btnClose;
    TextView tvNickname, tvMbti;


    ImageView imgbntmoras, imgbntselseil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainbook);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setDrawerListener(drawerListener);

        drawerView = (View) findViewById(R.id.drawer);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
//        btnClose = (ImageView) findViewById(R.id.btnClose);
//        btnClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawerLayout.closeDrawers();
//            }
//        });




        imgbntmoras = (ImageView) findViewById(R.id.imgbntmoras);
        btnSidemenu = (ImageButton) findViewById(R.id.btnSidemenu);
//        imgbntselseil = (ImageButton) findViewById(R.id.imgbntselseil);

        imgbntmoras.setOnClickListener(mClickListener);
//        imgbntselseil.setOnClickListener(mClickListener);
        btnSidemenu.setOnClickListener(mClickListener);



    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {


            switch (v.getId()) {
                case R.id.btnSidemenu:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.imgbntmoras:
                    Intent da1 = new Intent(MainActivitybook.this, MainActivitymoras.class);
                    startActivity(da1);
                    finish();
                    break;
//                case R.id.imgbntselseil:
//                    Intent da2 = new Intent(MainActivitybook.this, MainActivityseleil.class);
//                    startActivity(da2);
//                    finish();
//                    break;
            }
        }
    };

    DrawerLayout.DrawerListener drawerListener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
//            if (strNickname == null) {
//                tvNickname.setText("닉네임");
//            } else {
//                tvNickname.setText(strNickname);
//            }
//            if (strMbti == null) {
//                tvMbti.setText("ENFP");
//            } else {
//                tvMbti.setText(strMbti);
//            }
        }
        @Override
        public void onDrawerClosed(@NonNull View drawerView) {
        }
        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
}