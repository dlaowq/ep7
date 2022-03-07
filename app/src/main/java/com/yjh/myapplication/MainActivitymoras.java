package com.yjh.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivitymoras extends AppCompatActivity {
    //implements View.OnClickListener
    SQLiteDatabase db;
    MySQLiteOpenHelper helper;

    Button potbnt1, potbnt2, potbnt3, ability, aking, textbtn;

    EditText textName;

    ImageButton imgbntbb, imageBtn2, imageBtn1;
    ImageView skillbnt1, skillbnt2, skillbnt3;
    LinearLayout frame1, frame2, frame3;
    SeekBar SeekBar, SeekBar2;
    CheckBox checkBox;
    RatingBar ratingBar;
    ImageView mainimg;
    TextView skilltextView1, skilltextView2, level, hoshi, levelmax, textViewtitle, tvSelectResult;
    TextView add, hp, spd, dfn, cltc, cltcadd, guqrhd, wjrwnd, wjdgkd;
    //       공격력,체력,속도,방어력,치명확률,치명피해,협공확률,적중,저항



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.morasactivity);

        helper = new MySQLiteOpenHelper(
                MainActivitymoras.this, // 현재 화면의 context
                "ap7.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호

        mainimg = (ImageView) findViewById(R.id.mainimg);
        mainimg.setOnClickListener(mClickListener);

        textViewtitle = (TextView) findViewById(R.id.textViewtitle);
        tvSelectResult = (TextView) findViewById(R.id.tvSelectAll);



        //프레임 레이아웃
        potbnt1 = (Button) findViewById(R.id.potbnt1);
        potbnt2 = (Button) findViewById(R.id.potbnt2);
        potbnt3 = (Button) findViewById(R.id.potbnt3);
        potbnt1.setOnClickListener(mClickListener);
        potbnt2.setOnClickListener(mClickListener);
        potbnt3.setOnClickListener(mClickListener);
        frame1 = (LinearLayout) findViewById(R.id.frame1);
        frame2 = (LinearLayout) findViewById(R.id.frame2);
        frame3 = (LinearLayout) findViewById(R.id.frame3);

        // 능력치 창
        ability = (Button) findViewById(R.id.ability);
        ability.setOnClickListener(mClickListener);

        textbtn = (Button) findViewById(R.id.textbtn);
        textbtn.setOnClickListener(mClickListener);

        // 스킬버튼
        skillbnt1 = (ImageView) findViewById(R.id.skillbnt1);
        skillbnt1.setOnClickListener(mClickListener);
        skillbnt2 = (ImageView) findViewById(R.id.skillbnt2);
        skillbnt2.setOnClickListener(mClickListener);
        skillbnt3 = (ImageView) findViewById(R.id.skillbnt3);
        skillbnt3.setOnClickListener(mClickListener);
        // 각성 버튼
        aking = (Button) findViewById(R.id.aking);
        aking.setOnClickListener(mClickListener);



//        checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(checkBox.isChecked()){
//
//                    lbut = true;
//                    if(lbut = true){
//                        Toast.makeText(MainActivitymoras.this, "되는거냐?",  Toast.LENGTH_SHORT).show();
//                        upst();
//                    }
//                }else{
//                    lbut = false;
//                }
//            }
//
//            public void upst(){
//                String hoshi1 = hoshi.getText().toString();
//                if(lbut = true || hoshi1.equals("1")){
//
//                }
//            }
//        });


//        SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//
//
//            @Override
//            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
//            }
//            @Override
//            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
//            }
//            @Override
//            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
//
//                level.setText(String.format("%d", seekBar.getProgress()));
//                levelst();
//
//            }
//        });


        //별 갯수별 능력치 변화
//        SeekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//
//            @Override
//            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
//            }
//
//            @Override
//            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
//            }
//            @Override
//            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
//                hoshi.setText(String.valueOf(seekBar.getProgress()));
//                //클자를 숫자로 변경
//                String level1 = level.getText().toString();
//                int numInt = Integer.parseInt(level1);
//
//            }
//        });


    }


//    public void skill1() {
//        ImageView banner2 = (ImageView) findViewById(R.id.imgvimorassk);
//        Glide.with(this).load(R.drawable.seleilskill1).into(banner2);
//    }
//
//    public void skill2() {
//        ImageView banner2 = (ImageView) findViewById(R.id.imgvimorassk);
//        Glide.with(this).load(R.drawable.seleilskill2).into(banner2);
//    }
//
//    public void skill3() {
//        ImageView banner2 = (ImageView) findViewById(R.id.imgvimorassk);
//        Glide.with(this).load(R.drawable.morassk).into(banner2);
//    }

    public void view() {
        frame1.setVisibility(View.INVISIBLE);
        frame2.setVisibility(View.INVISIBLE);
        frame3.setVisibility(View.INVISIBLE);
    }


    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        String morasskill = "";
        public void onClick(View v) {


            switch (v.getId()) {
                case R.id.imgbntbb:
                    Intent da1 = new Intent(MainActivitymoras.this, MainActivitybook.class);
                    startActivity(da1);
                    finish();
                    break;

                case R.id.mainimg:
                    String img = "moras";
                    Intent mainimgpop = new Intent(MainActivitymoras.this, MainImgPopup.class);
                    mainimgpop.putExtra("img", img);
                    startActivity(mainimgpop);
                    break;
                case R.id.potbnt1:
                    view();
                    frame1.setVisibility(View.VISIBLE);
                    break;

                case R.id.potbnt2:
                    view();
                    frame2.setVisibility(View.VISIBLE);
                    break;
                case R.id.potbnt3:
                    view();
                    selectAll();
                    frame3.setVisibility(View.VISIBLE);
                    break;
                // 능력치 버튼
                case R.id.ability:
                    String popup = "moras";
                    Intent ability = new Intent(MainActivitymoras.this, AbilityPopup.class);
                    ability.putExtra("moras",popup);
                    startActivity(ability);
                    break;
                // 각성 창 버튼
                case R.id.aking:
                    String awakening = "moras";
                    Intent aking = new Intent(MainActivitymoras.this, awakeningActivity.class);
                    aking.putExtra("Data",awakening);
                    startActivity(aking);
                    finish();
                    break;
                // 스킬버튼
                case R.id.skillbnt1:
                    morasskill = "모라스1";
                    Intent skill1 = new Intent(MainActivitymoras.this, MainActivitypopup.class);
                    skill1.putExtra("skill",morasskill);
                    startActivity(skill1);
                    break;
                case R.id.skillbnt2:
                    morasskill = "모라스2";
                    Intent skill2 = new Intent(MainActivitymoras.this, MainActivitypopup.class);
                    skill2.putExtra("skill",morasskill);
                    startActivity(skill2);
                    break;
                case R.id.skillbnt3:
                    morasskill = "모라스3";
                    Intent skill3 = new Intent(MainActivitymoras.this, MainActivitypopup.class);
                    skill3.putExtra("skill",morasskill);
                    startActivity(skill3);
                    break;

                case R.id.btn5:
                    break;
                case R.id.btn6:
                    String ddd = textName.getText().toString();
                    if (ddd.equals("")) {
                        break;
                    }

                    select(ddd);
                    textName.setText("");
                    break;


                case R.id.textbtn:
                    String title = textViewtitle.getText().toString();
                    Intent comment = new Intent(MainActivitymoras.this, commentActivity.class);
                    comment.putExtra("title",title);
                    startActivity(comment);
                    break;
            }
        }

        public void select(String searchddd) {

            db = helper.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용
            //Cursor c = db.query("member", null, null, null, null, null, null);
            Cursor c = db.rawQuery("SELECT * FROM ap7 where id ='" + searchddd + "'", null);


            String result = "";
            while (c.moveToNext()) {

                int idx = c.getInt(0);
                String title = c.getString(1);
                String id = c.getString(2);
                String pw = c.getString(3);
                String name = c.getString(4);
                String text = c.getString(5);


//                result += "캐릭터: " + title + " / id : " + id + " /  제목:" + name + "\n" + text + "\n\n";
                result += "캐릭터: " + title + " / id : " + id + " /  제목:" + name + "\n\n";


            }
            c.close();
            db.close();

            tvSelectResult.setText(result);


        }

        public void selectAll() {

            db = helper.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT * FROM ap7", null);

            String result = "";
            while (c.moveToNext()) {

                int idx = c.getInt(0);
                String title = c.getString(1);
                String id = c.getString(2);
                String pw = c.getString(3);
                String name = c.getString(4);
                String text = c.getString(5);

//                result += "캐릭터: " + title + " / id : " + id + " /  제목:" + name + "\n" + text + "\n\n";
                result += "캐릭터: " + title + " / id : " + id + " /  제목:" + name + "\n\n";

            }

            c.close();
            db.close();

            tvSelectResult.setText(result);
        }


    };
}
