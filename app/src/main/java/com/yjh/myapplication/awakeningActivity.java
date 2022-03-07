package com.yjh.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class awakeningActivity extends AppCompatActivity {


    ImageView titleimage, material1, material2;
    TextView titlename, prev, next;
    LinearLayout frame1, aaaa1, aaaa2;
    //프레임 1
    TextView title, subtitle, abilityname1, abilityname2, abilityname3;
    TextView ability1, ability2, ability3, materialcon1, materialcon2;

    int lv = 1;
    Animation ani = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.awakening);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);


        aaaa1 = (LinearLayout) findViewById(R.id.aaaa1);
        aaaa2 = (LinearLayout) findViewById(R.id.aaaa2);


        ani = AnimationUtils.loadAnimation(awakeningActivity.this, R.anim.awakening);

        prev = (TextView) findViewById(R.id.prev);
        next = (TextView) findViewById(R.id.next);
        titlename = (TextView) findViewById(R.id.titlename);
        prev.setOnClickListener(mClickListener);
        next.setOnClickListener(mClickListener);

        titleimage = (ImageView) findViewById(R.id.titleimage);
        material1 = (ImageView) findViewById(R.id.material1);
        material2 = (ImageView) findViewById(R.id.material2);


        title = (TextView) findViewById(R.id.title);
        subtitle = (TextView) findViewById(R.id.subtitle);
        abilityname1 = (TextView) findViewById(R.id.abilityname1);
        abilityname2 = (TextView) findViewById(R.id.abilityname2);
        abilityname3 = (TextView) findViewById(R.id.abilityname3);
        ability1 = (TextView) findViewById(R.id.ability1);
        ability1.setOnClickListener(mClickListener);
        ability2 = (TextView) findViewById(R.id.ability2);
        ability3 = (TextView) findViewById(R.id.ability3);
        materialcon1 = (TextView) findViewById(R.id.materialcon1);
        materialcon2 = (TextView) findViewById(R.id.materialcon2);

        frame1 = (LinearLayout) findViewById(R.id.frame1);




        Intent getData = getIntent();
        String Data = getData.getStringExtra("Data");

        if(Data.equals("moras")){
            titleimage.setImageResource(R.drawable.moras2);
            titlename.setText("모험자 라스");
            moras();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intentBack = new Intent(awakeningActivity.this, MainActivitymoras.class);
        startActivity(intentBack);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
        finish();
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.next:
                    lv += 1;
                    maxlv();
                    moras();
                    break;
                case R.id.prev:
                    lv -= 1;
                    maxlv();
                    moras();
                    break;


            }
            if(lv == 3){
                switch (v.getId()) {
                    case R.id.ability1:
                        Intent sub = new Intent(awakeningActivity.this, awakeningsub.class);
                        startActivity(sub);
//                        Toast.makeText(awakeningActivity.this, "잠시 나타나는 메시지",  Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }
    };
    public void maxlv(){
        if(lv == 0){
            lv = 1;
        }
        if(lv == 7){
            lv = 6;
        }
    }
    public void moras(){

        if(lv == 1){
            aaaa1.setBackground(getDrawable(R.drawable.box_mainggggg));
        }else{
            aaaa1.setBackground(getDrawable(R.drawable.box_mainwhite));
        }
        if(lv == 6){
            aaaa2.setBackground(getDrawable(R.drawable.box_mainggggg));
        }else{
            aaaa2.setBackground(getDrawable(R.drawable.box_mainwhite));
        }

        if(lv == 1){
            abilityname1.setText("생명력 :");
            abilityname2.setText("공격력 :");
            abilityname3.setText("생명력 :");
            ability1.setText("3%");
            ability2.setText("20");
            ability3.setText("60");
            material1.setImageBitmap(null);
            materialcon1.setText("");
            material2.setImageResource(R.drawable.ma_runefire1);
            materialcon2.setText("5");
        }else if(lv == 2){
            abilityname1.setText("방어력 :");
            abilityname2.setText("공격력 :");
            abilityname3.setText("생명력 :");
            ability1.setText("3%");
            ability2.setText("20");
            ability3.setText("60");
            material1.setImageBitmap(null);
            materialcon1.setText("");
            material2.setImageResource(R.drawable.ma_runefire1);
            materialcon2.setText("9");
        }else if(lv == 3){
            title.setText("능력의 스톤");
            subtitle.setText("영웅의 스킬을 더욱 강력하게 강화합니다.");
            abilityname1.setText("스킬강화1 :");
            abilityname2.setText("공격력 :");
            abilityname3.setText("생명력 :");
            ability1.setText("");
            final SpannableStringBuilder sp = new SpannableStringBuilder("상세보기");
            sp.setSpan(new ForegroundColorSpan(Color.RED), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ability1.append(sp);
            ability2.setText("20");
            ability3.setText("60");
            material1.setImageResource(R.drawable.ma_runefire1);
            materialcon1.setText("12");
            material2.setImageResource(R.drawable.ma_runefire2);
            materialcon2.setText("6");
        }else if(lv == 4){
            abilityname1.setText("효과저항 :");
            abilityname2.setText("공격력 :");
            abilityname3.setText("생명력 :");
            ability1.setText("12%");
            ability2.setText("30");
            ability3.setText("80");
            material2.setImageResource(R.drawable.ma_runefire2);
            materialcon2.setText("15");
        }else if(lv == 5){
            abilityname1.setText("생명력 :");
            abilityname2.setText("공격력 :");
            abilityname3.setText("생명력 :");
            ability1.setText("6%");
            ability2.setText("30");
            ability3.setText("80");
            material1.setImageResource(R.drawable.ma_runefire3);
            materialcon1.setText("4");
            material2.setImageResource(R.drawable.awakeninglibra);
            materialcon2.setText("9");
        }else if(lv == 6){
            abilityname1.setText("방어력 :");
            abilityname2.setText("공격력 :");
            abilityname3.setText("생명력 :");
            ability1.setText("6%");
            ability2.setText("30");
            ability3.setText("80");
            material1.setImageResource(R.drawable.ma_runefire3);
            materialcon1.setText("6");
            material2.setImageResource(R.drawable.legendlibra);
            materialcon2.setText("6");
        }
    }

}