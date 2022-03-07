package com.yjh.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class awakeningsub extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.awakeningsub);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);




    }



    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {

            }

        }
        public boolean onToucffhEvent(MotionEvent event) {
            if(event.getAction()== MotionEvent.ACTION_OUTSIDE){
                return false;
            }
            return true;
        }
        public void onBackPressed() {
            return;
        }
    };
}
