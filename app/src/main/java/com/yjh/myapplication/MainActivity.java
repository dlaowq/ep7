package com.yjh.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView mainimg;

    Animation ani = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maina);

        mainimg = (ImageView)findViewById(R.id.mainimg);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent intent = new Intent (getApplicationContext(), MainActivitybook.class);
                startActivity(intent); //인트로 실행 후 바로 MainActivity로 넘어감.
                finish();
            }
        },2000); //4초 후 인트로 실행
    }
}