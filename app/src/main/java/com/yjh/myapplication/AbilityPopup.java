package com.yjh.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AbilityPopup extends AppCompatActivity {

    Button btnma1, btnma2, btnp1, btnp2;
    CheckBox checkBox;
    SeekBar seekBar1, seekBar2;
    RatingBar ratingBar;
    ImageButton imgbtna;
    TextView level, swd, maxlevel;

    TextView add, hp, spd, dfn, cltc, cltcadd, guqrhd, wjrwnd, wjdgkd;
    //       공격력,체력,속도,방어력,치명확률,치명피해,협공확률,적중,저항

    boolean lbut = false;
    int level_sub = 3;
    int numInt;
    int doed = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abilitypopup);



        // 능력치
        add = (TextView)findViewById(R.id.add);
        hp = (TextView)findViewById(R.id.hp);
        spd = (TextView)findViewById(R.id.spd);
        dfn = (TextView)findViewById(R.id.dfn);
        cltc = (TextView)findViewById(R.id.cltc);
        cltcadd = (TextView)findViewById(R.id.cltcadd);
        guqrhd = (TextView)findViewById(R.id.guqrhd);
        wjrwnd = (TextView)findViewById(R.id.wjrwnd);
        wjdgkd = (TextView)findViewById(R.id.wjdgkd);



        imgbtna = (ImageButton) findViewById(R.id.imgbtna);
        imgbtna.setOnClickListener(mClickListener);

        level = (TextView) findViewById(R.id.level);
        maxlevel = (TextView) findViewById(R.id.maxlevel);
        swd = (TextView) findViewById(R.id.swd);

        // 기본색 변경
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2) .setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);

        Intent getData = getIntent();
        String moras = getData.getStringExtra("moras");

        if(moras.equals("moras")){
            asdfasdf();
            MorasStats(numInt);
        }

        // 별 각성 체크버튼
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkBox.isChecked()){

                    lbut = true;
                    if(lbut = true){
                        doed = 1;
                        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
                        stars.getDrawable(2) .setColorFilter(Color.MAGENTA, PorterDuff.Mode.SRC_ATOP);
                        MorasStats(numInt);
                    }
                }else{
                    doed = 0;
                    lbut = false;
                    LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
                    stars.getDrawable(2) .setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                }
                asdfasdf();
                MorasStats(numInt);
            }
        });

        //별 능력치
        SeekBar seekBar1 = findViewById(R.id.seekBar1);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                swd.setText(String.format("%d", seekBar.getProgress()));
                asdfasdf();
                if(swd.getText().toString().equals("0")){
                    ratingBar.setRating(Float.parseFloat(String.format("3", seekBar.getProgress())));
                    level_sub = 3;
                    maxlevel.setText("/30");
                    if(numInt >= 31){
                        level.setText("30");
                    }
                }else if(swd.getText().toString().equals("1")){
                    ratingBar.setRating(Float.parseFloat(String.format("3", seekBar.getProgress())));
                    level_sub = 3;
                    maxlevel.setText("/30");
                    if(numInt >= 31){
                        level.setText("30");
                    }
                }else if(swd.getText().toString().equals("2")){
                    ratingBar.setRating(Float.parseFloat(String.format("3", seekBar.getProgress())));
                    level_sub = 3;
                    maxlevel.setText("/30");
                    if(numInt >= 31){
                        level.setText("30");
                    }
                }else if(swd.getText().toString().equals("3")){
                    ratingBar.setRating(Float.parseFloat(String.format("4", seekBar.getProgress())));
                    level_sub = 4;
                    maxlevel.setText("/40");
                    if(numInt >= 41){
                        level.setText("40");
                    }
                }else if(swd.getText().toString().equals("4")){
                    ratingBar.setRating(Float.parseFloat(String.format("5", seekBar.getProgress())));
                    level_sub = 5;
                    maxlevel.setText("/50");
                    if(numInt >= 51){
                        level.setText("50");
                    }
                }else if(swd.getText().toString().equals("5")){
                    ratingBar.setRating(Float.parseFloat(String.format("6", seekBar.getProgress())));
                    level_sub = 6;
                    maxlevel.setText("/60");
                }
                MorasStats(numInt);
            }
        });

        //레벨별 능력치
        SeekBar seekBar2 = findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                level.setText(String.format("%d", seekBar.getProgress()));
                asdfasdf();


                if(numInt == 0){
                    level.setText("1");
                }
                if(level_sub == 3){
                    if(numInt <= 30){
                        maxlevel.setText("/30");
                    }
                    if(numInt >= 31){
                        level.setText("30");
                    }
                }
                if(level_sub == 4){
                    if(numInt > 30){
                        maxlevel.setText("/40");
                    }
                    if(numInt >= 41){
                        level.setText("40");
                    }
                }
                if(level_sub == 5){
                    if(numInt > 40){
                        maxlevel.setText("/50");
                    }
                    if(numInt >= 51){
                        level.setText("50");
                    }
                }
                if(level_sub == 6){
                    if(numInt > 50){
                        maxlevel.setText("/60");
                    }
                }
                MorasStats(numInt);
            }
        });

    }



    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imgbtna:
                    finish();
                    break;
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
    public void asdfasdf(){
        numInt = Integer.parseInt(level.getText().toString());
        return;
    }


    void MorasStats(int numInt){
//        add, hp, dfn, wjdgkd
        if(doed == 1){
            if(level_sub == 3){
                if(numInt == 0){
                    add.setText("113");
                    hp.setText("450");
                    dfn.setText("70");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 1){
                    add.setText("113");
                    hp.setText("450");
                    dfn.setText("70");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 2){
                    add.setText("121");
                    hp.setText("518");
                    dfn.setText("77");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 3){
                    add.setText("129");
                    hp.setText("586");
                    dfn.setText("85");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 4){
                    add.setText("137");
                    hp.setText("653");
                    dfn.setText("93");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 5){
                    add.setText("144");
                    hp.setText("721");
                    dfn.setText("100");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 6){
                    add.setText("152");
                    hp.setText("789");
                    dfn.setText("109");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 7){
                    add.setText("160");
                    hp.setText("857");
                    dfn.setText("116");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 8){
                    add.setText("167");
                    hp.setText("925");
                    dfn.setText("124");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 9){
                    add.setText("175");
                    hp.setText("993");
                    dfn.setText("132");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 10){
                    add.setText("183");
                    hp.setText("1061");
                    dfn.setText("140");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 11){
                    add.setText("190");
                    hp.setText("1128");
                    dfn.setText("148");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 12){
                    add.setText("198");
                    hp.setText("1196");
                    dfn.setText("155");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 13){
                    add.setText("206");
                    hp.setText("1264");
                    dfn.setText("163");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 14){
                    add.setText("214");
                    hp.setText("1332");
                    dfn.setText("170");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 15){
                    add.setText("221");
                    hp.setText("1400");
                    dfn.setText("179");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 16){
                    add.setText("229");
                    hp.setText("1468");
                    dfn.setText("187");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 17){
                    add.setText("237");
                    hp.setText("1536");
                    dfn.setText("194");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 18){
                    add.setText("244");
                    hp.setText("1603");
                    dfn.setText("202");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 19){
                    add.setText("252");
                    hp.setText("1671");
                    dfn.setText("210");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 20){
                    add.setText("260");
                    hp.setText("1739");
                    dfn.setText("218");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 21){
                    add.setText("268");
                    hp.setText("1807");
                    dfn.setText("226");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 22){
                    add.setText("275");
                    hp.setText("1875");
                    dfn.setText("233");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 23){
                    add.setText("283");
                    hp.setText("1943");
                    dfn.setText("242");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 24){
                    add.setText("291");
                    hp.setText("2011");
                    dfn.setText("249");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 25){
                    add.setText("298");
                    hp.setText("2078");
                    dfn.setText("257");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 26){
                    add.setText("306");
                    hp.setText("2146");
                    dfn.setText("265");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 27){
                    add.setText("314");
                    hp.setText("2214");
                    dfn.setText("272");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 28){
                    add.setText("321");
                    hp.setText("2282");
                    dfn.setText("381");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 29){
                    add.setText("329");
                    hp.setText("2350");
                    dfn.setText("288");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 30){
                    add.setText("337");
                    hp.setText("2418");
                    dfn.setText("296");
                    wjdgkd.setText("0.0%");
                }else if(numInt >= 31){
                    add.setText("337");
                    hp.setText("2418");
                    dfn.setText("296");
                    wjdgkd.setText("0.0%");
                }
            }
            else if(level_sub == 4){
                if(numInt == 0) {
                    add.setText("147");
                    hp.setText("548");
                    dfn.setText("74");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 1){
                    add.setText("147");
                    hp.setText("548");
                    dfn.setText("74");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 2){
                    add.setText("155");
                    hp.setText("620");
                    dfn.setText("82");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 3){
                    add.setText("163");
                    hp.setText("692");
                    dfn.setText("90");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 4){
                    add.setText("172");
                    hp.setText("765");
                    dfn.setText("99");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 5){
                    add.setText("180");
                    hp.setText("837");
                    dfn.setText("108");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 6){
                    add.setText("188");
                    hp.setText("909");
                    dfn.setText("116");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 7){
                    add.setText("196");
                    hp.setText("982");
                    dfn.setText("124");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 8){
                    add.setText("204");
                    hp.setText("1054");
                    dfn.setText("132");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 9){
                    add.setText("213");
                    hp.setText("1126");
                    dfn.setText("141");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 10){
                    add.setText("221");
                    hp.setText("1198");
                    dfn.setText("149");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 11){
                    add.setText("229");
                    hp.setText("1271");
                    dfn.setText("157");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 12){
                    add.setText("237");
                    hp.setText("1343");
                    dfn.setText("165");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 13){
                    add.setText("245");
                    hp.setText("1415");
                    dfn.setText("174");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 14){
                    add.setText("254");
                    hp.setText("1487");
                    dfn.setText("182");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 15){
                    add.setText("262");
                    hp.setText("1559");
                    dfn.setText("190");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 16){
                    add.setText("270");
                    hp.setText("1631");
                    dfn.setText("199");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 17){
                    add.setText("278");
                    hp.setText("1705");
                    dfn.setText("208");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 18){
                    add.setText("286");
                    hp.setText("1777");
                    dfn.setText("216");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 19){
                    add.setText("295");
                    hp.setText("1849");
                    dfn.setText("224");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 20){
                    add.setText("303");
                    hp.setText("1921");
                    dfn.setText("232");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 21){
                    add.setText("311");
                    hp.setText("1993");
                    dfn.setText("241");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 22){
                    add.setText("319");
                    hp.setText("2065");
                    dfn.setText("249");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 23){
                    add.setText("328");
                    hp.setText("2137");
                    dfn.setText("257");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 24){
                    add.setText("336");
                    hp.setText("2210");
                    dfn.setText("265");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 25){
                    add.setText("344");
                    hp.setText("2282");
                    dfn.setText("273");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 26){
                    add.setText("352");
                    hp.setText("2355");
                    dfn.setText("282");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 27){
                    add.setText("360");
                    hp.setText("2427");
                    dfn.setText("290");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 28){
                    add.setText("369");
                    hp.setText("2499");
                    dfn.setText("299");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 29){
                    add.setText("377");
                    hp.setText("2571");
                    dfn.setText("307");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 30){
                    add.setText("385");
                    hp.setText("2644");
                    dfn.setText("316");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 31){
                    add.setText("393");
                    hp.setText("2716");
                    dfn.setText("324");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 32){
                    add.setText("401");
                    hp.setText("2788");
                    dfn.setText("332");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 33){
                    add.setText("410");
                    hp.setText("2860");
                    dfn.setText("340");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 34){
                    add.setText("418");
                    hp.setText("2932");
                    dfn.setText("349");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 35){
                    add.setText("426");
                    hp.setText("3004");
                    dfn.setText("357");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 36){
                    add.setText("434");
                    hp.setText("3077");
                    dfn.setText("365");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 37){
                    add.setText("442");
                    hp.setText("3150");
                    dfn.setText("373");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 38){
                    add.setText("451");
                    hp.setText("3222");
                    dfn.setText("382");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 39){
                    add.setText("459");
                    hp.setText("3294");
                    dfn.setText("390");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 40){
                    add.setText("467");
                    hp.setText("3366");
                    dfn.setText("399");
                    wjdgkd.setText("12.0%");
                }else if(numInt >= 41){
                    add.setText("467");
                    hp.setText("3366");
                    dfn.setText("399");
                    wjdgkd.setText("12.0%");
                }
            }
            else if(level_sub == 5){
                if(numInt == 0){
                    add.setText("180");
                    hp.setText("663");
                    dfn.setText("79");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 1){
                    add.setText("180");
                    hp.setText("663");
                    dfn.setText("79");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 2){
                    add.setText("189");
                    hp.setText("745");
                    dfn.setText("87");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 3){
                    add.setText("198");
                    hp.setText("826");
                    dfn.setText("96");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 4){
                    add.setText("207");
                    hp.setText("907");
                    dfn.setText("105");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 5){
                    add.setText("215");
                    hp.setText("988");
                    dfn.setText("114");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 6){
                    add.setText("224");
                    hp.setText("1070");
                    dfn.setText("123");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 7){
                    add.setText("233");
                    hp.setText("1150");
                    dfn.setText("131");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 8){
                    add.setText("241");
                    hp.setText("1231");
                    dfn.setText("141");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 9){
                    add.setText("250");
                    hp.setText("1313");
                    dfn.setText("149");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 10){
                    add.setText("259");
                    hp.setText("1394");
                    dfn.setText("158");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 11){
                    add.setText("268");
                    hp.setText("1475");
                    dfn.setText("167");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 12){
                    add.setText("276");
                    hp.setText("1556");
                    dfn.setText("176");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 13){
                    add.setText("285");
                    hp.setText("1638");
                    dfn.setText("185");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 14){
                    add.setText("294");
                    hp.setText("1718");
                    dfn.setText("193");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 15){
                    add.setText("302");
                    hp.setText("1800");
                    dfn.setText("202");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 16){
                    add.setText("311");
                    hp.setText("1881");
                    dfn.setText("211");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 17){
                    add.setText("320");
                    hp.setText("1961");
                    dfn.setText("220");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 18){
                    add.setText("329");
                    hp.setText("2043");
                    dfn.setText("229");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 19){
                    add.setText("337");
                    hp.setText("2124");
                    dfn.setText("237");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 20){
                    add.setText("346");
                    hp.setText("2206");
                    dfn.setText("247");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 21){
                    add.setText("355");
                    hp.setText("2286");
                    dfn.setText("255");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 22){
                    add.setText("363");
                    hp.setText("2368");
                    dfn.setText("264");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 23){
                    add.setText("372");
                    hp.setText("2449");
                    dfn.setText("272");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 24){
                    add.setText("381");
                    hp.setText("2530");
                    dfn.setText("282");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 25){
                    add.setText("390");
                    hp.setText("2611");
                    dfn.setText("291");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 26){
                    add.setText("398");
                    hp.setText("2692");
                    dfn.setText("299");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 27){
                    add.setText("407");
                    hp.setText("2773");
                    dfn.setText("309");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 28){
                    add.setText("416");
                    hp.setText("2854");
                    dfn.setText("317");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 29){
                    add.setText("424");
                    hp.setText("2936");
                    dfn.setText("326");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 30){
                    add.setText("433");
                    hp.setText("3017");
                    dfn.setText("335");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 31){
                    add.setText("442");
                    hp.setText("3098");
                    dfn.setText("344");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 32){
                    add.setText("450");
                    hp.setText("3179");
                    dfn.setText("353");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 33){
                    add.setText("459");
                    hp.setText("3261");
                    dfn.setText("361");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 34){
                    add.setText("468");
                    hp.setText("3341");
                    dfn.setText("370");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 35){
                    add.setText("477");
                    hp.setText("3422");
                    dfn.setText("379");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 36){
                    add.setText("485");
                    hp.setText("3504");
                    dfn.setText("388");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 37){
                    add.setText("494");
                    hp.setText("3584");
                    dfn.setText("397");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 38){
                    add.setText("503");
                    hp.setText("3666");
                    dfn.setText("405");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 39){
                    add.setText("511");
                    hp.setText("3747");
                    dfn.setText("415");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 40){
                    add.setText("520");
                    hp.setText("3829");
                    dfn.setText("423");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 41){
                    add.setText("529");
                    hp.setText("3909");
                    dfn.setText("432");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 42){
                    add.setText("538");
                    hp.setText("3991");
                    dfn.setText("432");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 43){
                    add.setText("546");
                    hp.setText("4072");
                    dfn.setText("450");
                    wjdgkd.setText("12.0%");
                }else if(numInt == 44){
                    add.setText("555");
                    hp.setText("4152");
                    dfn.setText("459");
                    wjdgkd.setText("12.0%");
                }
            }
            else if(level_sub == 6){

            }
        }
        if(doed == 0){
            if(level_sub == 3){
                if(numInt == 0){
                    add.setText("53");
                    hp.setText("263");
                    dfn.setText("68");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 1){
                    add.setText("53");
                    hp.setText("263");
                    dfn.setText("68");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 2){
                    add.setText("61");
                    hp.setText("329");
                    dfn.setText("75");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 3){
                    add.setText("69");
                    hp.setText("395");
                    dfn.setText("83");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 4){
                    add.setText("77");
                    hp.setText("460");
                    dfn.setText("91");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 5){
                    add.setText("84");
                    hp.setText("526");
                    dfn.setText("98");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 6){
                    add.setText("92");
                    hp.setText("592");
                    dfn.setText("106");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 7){
                    add.setText("100");
                    hp.setText("658");
                    dfn.setText("113");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 8){
                    add.setText("107");
                    hp.setText("724");
                    dfn.setText("121");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 9){
                    add.setText("115");
                    hp.setText("790");
                    dfn.setText("129");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 10){
                    add.setText("123");
                    hp.setText("856");
                    dfn.setText("136");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 11){
                    add.setText("130");
                    hp.setText("921");
                    dfn.setText("144");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 12){
                    add.setText("138");
                    hp.setText("987");
                    dfn.setText("151");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 13){
                    add.setText("146");
                    hp.setText("1053");
                    dfn.setText("159");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 13){
                    add.setText("146");
                    hp.setText("1053");
                    dfn.setText("159");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 14){
                    add.setText("154");
                    hp.setText("1119");
                    dfn.setText("166");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 15){
                    add.setText("161");
                    hp.setText("1185");
                    dfn.setText("174");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 16){
                    add.setText("169");
                    hp.setText("1251");
                    dfn.setText("182");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 17){
                    add.setText("177");
                    hp.setText("1317");
                    dfn.setText("189");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 18){
                    add.setText("184");
                    hp.setText("1382");
                    dfn.setText("197");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 19){
                    add.setText("192");
                    hp.setText("1448");
                    dfn.setText("204");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 20){
                    add.setText("200");
                    hp.setText("1514");
                    dfn.setText("212");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 21){
                    add.setText("208");
                    hp.setText("1580");
                    dfn.setText("220");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 22){
                    add.setText("215");
                    hp.setText("1646");
                    dfn.setText("227");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 23){
                    add.setText("223");
                    hp.setText("1712");
                    dfn.setText("235");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 24){
                    add.setText("231");
                    hp.setText("1778");
                    dfn.setText("242");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 25){
                    add.setText("238");
                    hp.setText("1843");
                    dfn.setText("250");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 26){
                    add.setText("246");
                    hp.setText("1909");
                    dfn.setText("258");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 27){
                    add.setText("254");
                    hp.setText("1975");
                    dfn.setText("265");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 28){
                    add.setText("261");
                    hp.setText("2041");
                    dfn.setText("273");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 29){
                    add.setText("269");
                    hp.setText("2107");
                    dfn.setText("280");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 30){
                    add.setText("277");
                    hp.setText("2173");
                    dfn.setText("288");
                    wjdgkd.setText("0.0%");
                }else if(numInt >= 31){
                    add.setText("277");
                    hp.setText("2173");
                    dfn.setText("288");
                    wjdgkd.setText("0.0%");
                }
            }
            else if(level_sub == 4){
                if(numInt == 0) {
                    add.setText("57");
                    hp.setText("280");
                    dfn.setText("72");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 1) {
                    add.setText("57");
                    hp.setText("280");
                    dfn.setText("72");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 2) {
                    add.setText("65");
                    hp.setText("350");
                    dfn.setText("80");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 3) {
                    add.setText("73");
                    hp.setText("420");
                    dfn.setText("88");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 4) {
                    add.setText("82");
                    hp.setText("491");
                    dfn.setText("97");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 5) {
                    add.setText("90");
                    hp.setText("561");
                    dfn.setText("105");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 6) {
                    add.setText("98");
                    hp.setText("631");
                    dfn.setText("113");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 7) {
                    add.setText("106");
                    hp.setText("701");
                    dfn.setText("121");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 8) {
                    add.setText("114");
                    hp.setText("771");
                    dfn.setText("129");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 9) {
                    add.setText("123");
                    hp.setText("841");
                    dfn.setText("137");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 10) {
                    add.setText("131");
                    hp.setText("911");
                    dfn.setText("145");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 11) {
                    add.setText("139");
                    hp.setText("982");
                    dfn.setText("153");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 12) {
                    add.setText("147");
                    hp.setText("1052");
                    dfn.setText("161");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 13) {
                    add.setText("155");
                    hp.setText("1122");
                    dfn.setText("169");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 14) {
                    add.setText("164");
                    hp.setText("1192");
                    dfn.setText("177");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 15) {
                    add.setText("172");
                    hp.setText("1262");
                    dfn.setText("185");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 16){
                    add.setText("180");
                    hp.setText("1332");
                    dfn.setText("194");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 17){
                    add.setText("188");
                    hp.setText("1403");
                    dfn.setText("202");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 18){
                    add.setText("196");
                    hp.setText("1473");
                    dfn.setText("210");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 19){
                    add.setText("205");
                    hp.setText("1543");
                    dfn.setText("218");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 20){
                    add.setText("213");
                    hp.setText("1613");
                    dfn.setText("226");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 21){
                    add.setText("221");
                    hp.setText("1683");
                    dfn.setText("234");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 22){
                    add.setText("229");
                    hp.setText("1753");
                    dfn.setText("242");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 23){
                    add.setText("238");
                    hp.setText("1823");
                    dfn.setText("250");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 24){
                    add.setText("246");
                    hp.setText("1894");
                    dfn.setText("258");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 25){
                    add.setText("254");
                    hp.setText("1964");
                    dfn.setText("266");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 26){
                    add.setText("262");
                    hp.setText("2034");
                    dfn.setText("274");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 27){
                    add.setText("270");
                    hp.setText("2104");
                    dfn.setText("282");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 28){
                    add.setText("279");
                    hp.setText("2174");
                    dfn.setText("291");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 29){
                    add.setText("287");
                    hp.setText("2244");
                    dfn.setText("299");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 30){
                    add.setText("295");
                    hp.setText("2315");
                    dfn.setText("307");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 31){
                    add.setText("303");
                    hp.setText("2385");
                    dfn.setText("315");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 32){
                    add.setText("311");
                    hp.setText("2455");
                    dfn.setText("323");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 33){
                    add.setText("320");
                    hp.setText("2525");
                    dfn.setText("331");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 34){
                    add.setText("328");
                    hp.setText("2595");
                    dfn.setText("339");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 35){
                    add.setText("336");
                    hp.setText("2665");
                    dfn.setText("347");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 36){
                    add.setText("344");
                    hp.setText("2735");
                    dfn.setText("355");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 37){
                    add.setText("352");
                    hp.setText("2806");
                    dfn.setText("363");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 38){
                    add.setText("361");
                    hp.setText("2876");
                    dfn.setText("371");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 39){
                    add.setText("369");
                    hp.setText("2946");
                    dfn.setText("279");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 40){
                    add.setText("377");
                    hp.setText("3016");
                    dfn.setText("388");
                    wjdgkd.setText("0.0%");
                }else if(numInt >= 41){
                    add.setText("377");
                    hp.setText("3016");
                    dfn.setText("388");
                    wjdgkd.setText("0.0%");
                }
            }
            else if(level_sub == 5){
                if(numInt == 0){
                    add.setText("60");
                    hp.setText("297");
                    dfn.setText("77");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 1){
                    add.setText("60");
                    hp.setText("297");
                    dfn.setText("77");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 2){
                    add.setText("69");
                    hp.setText("372");
                    dfn.setText("85");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 3){
                    add.setText("78");
                    hp.setText("446");
                    dfn.setText("94");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 4){
                    add.setText("87");
                    hp.setText("521");
                    dfn.setText("102");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 5){
                    add.setText("95");
                    hp.setText("595");
                    dfn.setText("111");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 6){
                    add.setText("104");
                    hp.setText("670");
                    dfn.setText("120");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 7){
                    add.setText("113");
                    hp.setText("744");
                    dfn.setText("128");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 8){
                    add.setText("121");
                    hp.setText("818");
                    dfn.setText("137");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 9){
                    add.setText("130");
                    hp.setText("893");
                    dfn.setText("145");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 10){
                    add.setText("139");
                    hp.setText("967");
                    dfn.setText("154");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 11){
                    add.setText("148");
                    hp.setText("1042");
                    dfn.setText("163");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 12){
                    add.setText("156");
                    hp.setText("1116");
                    dfn.setText("171");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 13){
                    add.setText("165");
                    hp.setText("1191");
                    dfn.setText("180");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 14){
                    add.setText("174");
                    hp.setText("1265");
                    dfn.setText("188");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 15){
                    add.setText("182");
                    hp.setText("1340");
                    dfn.setText("197");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 16){
                    add.setText("191");
                    hp.setText("1414");
                    dfn.setText("205");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 17){
                    add.setText("200");
                    hp.setText("1488");
                    dfn.setText("214");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 18){
                    add.setText("209");
                    hp.setText("1563");
                    dfn.setText("223");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 19){
                    add.setText("217");
                    hp.setText("1637");
                    dfn.setText("231");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 20){
                    add.setText("226");
                    hp.setText("1712");
                    dfn.setText("240");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 21){
                    add.setText("235");
                    hp.setText("1786");
                    dfn.setText("248");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 22){
                    add.setText("243");
                    hp.setText("1861");
                    dfn.setText("257");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 23){
                    add.setText("252");
                    hp.setText("1935");
                    dfn.setText("265");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 24){
                    add.setText("261");
                    hp.setText("2010");
                    dfn.setText("274");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 25){
                    add.setText("270");
                    hp.setText("2084");
                    dfn.setText("283");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 26){
                    add.setText("278");
                    hp.setText("2158");
                    dfn.setText("291");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 27){
                    add.setText("287");
                    hp.setText("2233");
                    dfn.setText("300");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 28){
                    add.setText("296");
                    hp.setText("2307");
                    dfn.setText("308");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 29){
                    add.setText("304");
                    hp.setText("2382");
                    dfn.setText("317");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 30){
                    add.setText("313");
                    hp.setText("2456");
                    dfn.setText("326");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 31){
                    add.setText("322");
                    hp.setText("2531");
                    dfn.setText("334");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 32){
                    add.setText("330");
                    hp.setText("2605");
                    dfn.setText("343");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 33){
                    add.setText("339");
                    hp.setText("2680");
                    dfn.setText("351");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 34){
                    add.setText("348");
                    hp.setText("2754");
                    dfn.setText("360");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 35){
                    add.setText("357");
                    hp.setText("2828");
                    dfn.setText("368");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 36){
                    add.setText("365");
                    hp.setText("2903");
                    dfn.setText("377");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 37){
                    add.setText("374");
                    hp.setText("2977");
                    dfn.setText("386");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 38){
                    add.setText("383");
                    hp.setText("3052");
                    dfn.setText("394");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 39){
                    add.setText("391");
                    hp.setText("3126");
                    dfn.setText("403");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 40){
                    add.setText("400");
                    hp.setText("3201");
                    dfn.setText("411");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 41){
                    add.setText("409");
                    hp.setText("3275");
                    dfn.setText("420");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 42){
                    add.setText("418");
                    hp.setText("3350");
                    dfn.setText("429");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 43){
                    add.setText("426");
                    hp.setText("3424");
                    dfn.setText("437");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 44){
                    add.setText("435");
                    hp.setText("3498");
                    dfn.setText("446");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 45){
                    add.setText("444");
                    hp.setText("3573");
                    dfn.setText("454");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 46){
                    add.setText("452");
                    hp.setText("3647");
                    dfn.setText("463");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 47){
                    add.setText("461");
                    hp.setText("3722");
                    dfn.setText("471");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 48){
                    add.setText("470");
                    hp.setText("3796");
                    dfn.setText("480");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 49){
                    add.setText("479");
                    hp.setText("3871");
                    dfn.setText("489");
                    wjdgkd.setText("0.0%");
                }else if(numInt == 50){
                    add.setText("487");
                    hp.setText("3945");
                    dfn.setText("497");
                    wjdgkd.setText("0.0%");
                }else if(numInt >= 51){
                    add.setText("487");
                    hp.setText("3945");
                    dfn.setText("497");
                    wjdgkd.setText("0.0%");
                }
            }
            else if(level_sub == 6){

            }
        }
    }



}
