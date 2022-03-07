package com.yjh.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivitypopup extends AppCompatActivity {


    String skill;
    Button bnt1;
    ImageButton imgbtna;
    TextView skillname, skillcontents, soulburn, skillattac, j1, j2, j3, cooltime;
    //       이름         스킬 내용    소울번 능력    소울번 스택
    TextView skillability1, skillability2, skillability3, skillability4,
            skillability5, skillability6, skillability7, skillability8;
    ImageView imageskill, goods1, goods2, goods3;

    String popup= "", soul= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupactivity);

        imgbtna = (ImageButton) findViewById(R.id.imgbtna);
        imgbtna.setOnClickListener(mClickListener);


        skillname = (TextView) findViewById(R.id.skillname);
        skillcontents = (TextView) findViewById(R.id.skillcontents);
        skillcontents.setOnClickListener(mClickListener);

        skillattac = (TextView) findViewById(R.id.skillattac);
        j1 = (TextView) findViewById(R.id.j1);
        j2 = (TextView) findViewById(R.id.j2);
        j3 = (TextView) findViewById(R.id.j3);
        cooltime = (TextView) findViewById(R.id.cooltime);
        soulburn = (TextView) findViewById(R.id.soulburn);
        // 스킬강화별 능력치
        skillability1 = (TextView) findViewById(R.id.skillability1);
        skillability2 = (TextView) findViewById(R.id.skillability2);
        skillability3 = (TextView) findViewById(R.id.skillability3);
        skillability4 = (TextView) findViewById(R.id.skillability4);
        skillability5 = (TextView) findViewById(R.id.skillability5);
        skillability6 = (TextView) findViewById(R.id.skillability6);
        skillability7 = (TextView) findViewById(R.id.skillability7);
        skillability8 = (TextView) findViewById(R.id.skillability8);


        Intent getData = getIntent();
        skill = getData.getStringExtra("skill");

        if(skill.equals("모라스1")){
            morasskill1();
            contents();
            background();
        }else if(skill.equals("모라스2")){
            morasskill2();
            contents();
            background();
            soul();
            Popup();
        }else if(skill.equals("모라스3")){
            morasskill3();
            contents();
            background();
            Popup();
        }






    }
    // 스킬 gif 변경 메소드
    public void morasskill1() {
        ImageView banner2 = (ImageView) findViewById(R.id.gifskill);
        Glide.with(this).load(R.drawable.seleilskill1).into(banner2);
    }
    public void morasskill2() {
        ImageView banner2 = (ImageView) findViewById(R.id.gifskill);
        Glide.with(this).load(R.drawable.seleilskill2).into(banner2);
    }
    public void morasskill3() {
        ImageView banner2 = (ImageView) findViewById(R.id.gifskill);
        Glide.with(this).load(R.drawable.morasskill).into(banner2);
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
                case R.id.imgbtna:
                    finish();
                    break;
//                case R.id.skillcontents:
//                    if(popup.equals("pincers")){
//
//                    }
//                    break;
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

    public void contents(){
        popup= ""; soul= "";
        if(skill.equals("모라스1")){
            skillname.setText("가르기");
            skillcontents.setText("검을 휘둘러 적을 공격하여 75% 확률로 강화 효과를 1개 해제합니다." +
                    "자신의 최대 생명력에 비례해 피해량이 증가합니다.");
            skillattac.setText("소울 1 획득");
            j1.setText("2700개");
            j2.setText("12개");
            j3.setText("98,000원");
            skillability1.setText("피해량 5% 증가");
            skillability2.setText("피해량 5% 증가");
            skillability3.setText("피해량 5% 증가");
            skillability4.setText("피해량 5% 증가");
            skillability5.setText("피해량 10% 증가");
        }else if(skill.equals("모라스2")){
            popup = "pincers";
            soul = "moras";
            skillname.setText("지휘의 일격");
            skillcontents.setText("");
            final SpannableStringBuilder sp = new SpannableStringBuilder("적에게 연속으로 공격한 후, 가장 공격력이 높은 아군에게 협공 을 발생시킵니다.");
            sp.setSpan(new ForegroundColorSpan(Color.RED), 32, 35, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            skillcontents.append(sp);
            j1.setText("2700개");
            j2.setText("12개");
            j3.setText("98,000원");
            cooltime.setText("쿨타임: 3턴");
            skillattac.setText("소울 2 획득");
            skillability1.setText("피해량 5% 증가");
            skillability2.setText("피해량 5% 증가");
            skillability3.setText("피해량 5% 증가");
            skillability4.setText("피해량 5% 증가");
            skillability5.setText("피해량 10% 증가");
            soulburn.setText("소울번 효과");
            soulburn.setBackground(getDrawable(R.drawable.box_mainwhite));
        }else if(skill.equals("모라스3")){
            popup = "def";
            skillname.setText("정화의 불길");
            skillcontents.setText("");
            final SpannableStringBuilder sp = new SpannableStringBuilder("적 전체에 검기를 날려 강하게 공격한 후, 피해량에 비례해 생명력을 회복하고 방어력 증가를 2턴간 발생시킵니다. 자신의 최대 생명력에 비례해 피해량이 증가합니다.");
            sp.setSpan(new ForegroundColorSpan(Color.RED), 43, 49, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            skillcontents.append(sp);
            j1.setText("2700개");
            j2.setText("12개");
            j3.setText("98,000원");
            cooltime.setText("쿨타임: 4턴");
            skillattac.setText("소울 2 획득");
            skillability1.setText("피해량 5% 증가");
            skillability2.setText("피해량 5% 증가");
            skillability3.setText("피해량 5% 증가");
            skillability4.setText("피해량 5% 증가");
            skillability5.setText("피해량 10% 증가");
        }

    }
    // 추가 능력
    public void Popup(){
        skillcontents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivitypopup.this);
                if(popup.equals("def")){
                    String strHtml =
                            "<b>방어력 증가</b>";
                    Spanned oHtml;
                    String strHtml2 =
                            "<b><big><font color='#007bfd'>방어력이 60% 증가합니다.</font></big></b>";
                    Spanned oHtml2;
                    if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N) {
                        oHtml = Html.fromHtml(strHtml);
                        oHtml2 = Html.fromHtml(strHtml2);
                    }else
                    {
                        oHtml = Html.fromHtml(strHtml, Html.FROM_HTML_MODE_LEGACY);
                        oHtml2 = Html.fromHtml(strHtml, Html.FROM_HTML_MODE_LEGACY);
                    }
                    ad.setIcon(R.drawable.stic_def_up);
                    ad.setTitle(oHtml);
                    ad.setMessage(oHtml2);
                    ad.show();
                }
                else if(popup.equals("pincers")){
                    String strHtml =
                            "<b>협공</b>";
                    Spanned oHtml;
                    String strHtml2 =
                            "<b><big><font color='#bd7f41'>다른 아군이 기본 스킬로 공격 시 자신이 행동 가능한 상태라면 동일한 대상을 기본 스킬로 공격합니다. 반격 시에는 발생하지 않습니다.</font></big></b>";
                    Spanned oHtml2;
                    if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N) {
                        oHtml = Html.fromHtml(strHtml);
                        oHtml2 = Html.fromHtml(strHtml2);
                    }
                    else
                    {
                        oHtml = Html.fromHtml(strHtml, Html.FROM_HTML_MODE_LEGACY);
                        oHtml2 = Html.fromHtml(strHtml, Html.FROM_HTML_MODE_LEGACY);
                    }
                    ad.setTitle(oHtml);
                    ad.setMessage(oHtml2);
                    ad.show();
                }

            }
        });
    }
    // 소울번
    public void soul(){
        if(soulburn.getText().toString().equals("소울번 효과")){
            soulburn.setBackground(getDrawable(R.drawable.skillability));
        }
        soulburn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivitypopup.this);
                if(soul.equals("moras")){
                    String strHtml =
                            "<b><font color='#007bfd'>소울번 효과</font></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><font color='#007bfd'>소울 10 소모</font></b>";
                    Spanned oHtml;
                    String strHtml2 =
                            "<b><big>해당 스킬 쿨타임이 2턴 감소합니다.</big></b>";
                    Spanned oHtml2;
                    if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N) {
                        oHtml = Html.fromHtml(strHtml);
                        oHtml2 = Html.fromHtml(strHtml2);
                    }
                    else
                    {
                        oHtml = Html.fromHtml(strHtml, Html.FROM_HTML_MODE_LEGACY);
                        oHtml2 = Html.fromHtml(strHtml, Html.FROM_HTML_MODE_LEGACY);
                    }
                    ad.setIcon(R.drawable.cm_icon_star_s);
                    ad.setTitle(oHtml);
                    ad.setMessage(oHtml2);
                    ad.show();
                }

            }
        });
    }
    public void background(){
        if(skillability1.getText().toString().equals("")){
            skillability1.setBackground(getDrawable(R.drawable.box_mainwhite));
        }if(skillability2.getText().toString().equals("")){
            skillability2.setBackground(getDrawable(R.drawable.box_mainwhite));
        }if(skillability3.getText().toString().equals("")){
            skillability3.setBackground(getDrawable(R.drawable.box_mainwhite));
        }if(skillability4.getText().toString().equals("")){
            skillability4.setBackground(getDrawable(R.drawable.box_mainwhite));
        }if(skillability5.getText().toString().equals("")){
            skillability5.setBackground(getDrawable(R.drawable.box_mainwhite));
        }if(skillability6.getText().toString().equals("")){
            skillability6.setBackground(getDrawable(R.drawable.box_mainwhite));
        }if(skillability7.getText().toString().equals("")){
            skillability7.setBackground(getDrawable(R.drawable.box_mainwhite));
        }if(skillability8.getText().toString().equals("")){
            skillability8.setBackground(getDrawable(R.drawable.box_mainwhite));
        }
    }

}
