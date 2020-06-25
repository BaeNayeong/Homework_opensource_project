/* **********************************************
 * 프로그램명 : MainActivity.java
 * 작성자 : 2015023025 배나영
 * 작성일 : 2020.04.10
 *프로그램 설명 : 안드로이드 프로젝트를 실행했을 때
 * 제일 처음으로 보이는 화면의 이벤트 처리해주는 자바 코드
 ************************************************/

package com.example.homework1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText text;
    String url;
    RadioGroup radioBtn;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        radioBtn=(RadioGroup) findViewById(R.id.radioGroup);
        image=(ImageView)findViewById(R.id.imageView);
    }

    // EditText에 입력한 값 보여주기
    public void showText(View v){
        text=(EditText)findViewById(R.id.text);
        url=(String) text.getText().toString();
        Toast.makeText(getApplicationContext(), url, Toast.LENGTH_LONG).show();
    }

    // 인터넷 창 띄우기
    public void showUrl(View v){
        text=(EditText)findViewById(R.id.text);
        url=(String) text.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void onRadioButtonClicked(View view){

        switch(view.getId()){

            case R.id.radioPie:
                image.setImageResource(R.drawable.pie);
                break;

            case R.id.radioOreo:
                image.setImageResource(R.drawable.oreo);
                break;
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
