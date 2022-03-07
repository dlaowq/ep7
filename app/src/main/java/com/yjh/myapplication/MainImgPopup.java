package com.yjh.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainImgPopup extends AppCompatActivity {


    ImageView mainimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainimg);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);

        mainimg = (ImageView) findViewById(R.id.mainimg);

        mainimg.setOnClickListener(mClickListener);


        Intent getData = getIntent();
        String img = getData.getStringExtra("img");

        if(img.equals("moras")){
            mainimg.setImageResource(R.drawable.moras);
        }

    }

//    public void skillView(TextView skillname){
//        if(skillname.getText().toString().equals("가르기")){
//            soulb.setText("소울 1 획득");
//            imageskill.setImageResource(R.drawable.morasskillbtn1);
//        }else if(skillname.getText().toString().equals("지휘의\n일격")){
//            skillname.setText("지휘의일격");
//            soulb.setText("소울 2 획득");
//            imageskill.setImageResource(R.drawable.morasskillbtn2);
//        }else if(skillname.getText().toString().equals("정화의\n불길")){
//            skillname.setText("정화의불길");
//            soulb.setText("소울 2 획득");
//            imageskill.setImageResource(R.drawable.morasskillbtn3);
//        }
//    }

    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.mainimg:
                    finish();
                    break;
            }
//            Intent intent = new Intent();
//            intent.putExtra("result", "Close Popup");
//            setResult(RESULT_OK, intent);
//
//            finish();
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
