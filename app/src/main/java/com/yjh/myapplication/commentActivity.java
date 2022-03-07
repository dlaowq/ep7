package com.yjh.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class commentActivity extends AppCompatActivity {

    SQLiteDatabase db;
    MySQLiteOpenHelper helper;

    Button btn1, btn2;
    TextView intenttitle;
    EditText editTextid, editTextpw, editTexttitle, editTextTextcon;
    RatingBar ratingBar;
    String TAG ="저장";

    String title, id, pw, name, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment);

        helper = new MySQLiteOpenHelper(
                commentActivity.this, // 현재 화면의 context
                "ap7.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호

        btn1 = (Button) findViewById(R.id.btn1);//취소
        btn2 = (Button) findViewById(R.id.btn2);//저장

        intenttitle = (TextView) findViewById(R.id.intenttitle);

        editTextid = (EditText) findViewById(R.id.editTextid);
        editTextpw = (EditText) findViewById(R.id.editTextpw);
        editTexttitle = (EditText) findViewById(R.id.editTexttitle);
        editTextTextcon = (EditText) findViewById(R.id.editTextTextcon);

        Intent intent = getIntent();
        String awd = intent.getStringExtra("title");
        intenttitle.setText(awd);

        btn1.setOnClickListener(mClickListener);
        btn2.setOnClickListener(mClickListener);

    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn1:
                    Intent da = new Intent(commentActivity.this, MainActivitymoras.class);
                    startActivity(da);
                    finish();
                    break;
                case R.id.btn2:

                    if(intenttitle.getText().toString().equals("")){
                        Toast.makeText(commentActivity.this, "ㅁㅁㅁ",  Toast.LENGTH_SHORT).show();
                        break;
                    }if(editTextid.getText().toString().equals("")){
                        Toast.makeText(commentActivity.this, "아이디 입력",  Toast.LENGTH_SHORT).show();
                        break;
                    }if(editTextpw.getText().toString().equals("")){
                        Toast.makeText(commentActivity.this, "번호 입력",  Toast.LENGTH_SHORT).show();
                        break;
                    }if(editTexttitle.getText().toString().equals("")){
                        Toast.makeText(commentActivity.this, "제목입력",  Toast.LENGTH_SHORT).show();
                        break;
                    }if(editTextTextcon.getText().toString().equals("")){
                        Toast.makeText(commentActivity.this, "내용입력",  Toast.LENGTH_SHORT).show();
                        break;
                    }

                    title = intenttitle.getText().toString();
                    id = editTextid.getText().toString();
                    pw = editTextpw.getText().toString();
                    name = editTexttitle.getText().toString();
                    text = editTextTextcon.getText().toString();

                    dbinsert(title, id, pw, name, text);
                    Intent da1 = new Intent(commentActivity.this, MainActivitymoras.class);
                    startActivity(da1);
                    finish();
                    break;


            }
        }
    };
    void dbinsert(String title, String id, String pw, String name, String text){

        db = helper.getWritableDatabase(); // db 객체를 얻어온다. 쓰기 가능
        ContentValues values = new ContentValues();
// db.insert의 매개변수인 values가 ContentValues 변수이므로 그에 맞춤
// 데이터의 삽입은 put을 이용한다.

        values.put("title", title);
        values.put("id", id);
        values.put("pw", pw);
        values.put("name", name);
        values.put("text", text);


        db.insert("ap7", null, values); // 테이블/널컬럼핵/데이터(널컬럼핵=디폴트)
// tip : 마우스를 db.insert에 올려보면 매개변수가 어떤 것이 와야 하는지 알 수 있다.

        db.close();
        Toast.makeText(getApplicationContext(), id+"의 정보가 삽입되었습니다.", Toast.LENGTH_LONG).show();

        Log.d(TAG, title+"/"+id+"/"+pw+"/"+name+"/"+text+" 의 정보로 디비저장완료.");

    }
}