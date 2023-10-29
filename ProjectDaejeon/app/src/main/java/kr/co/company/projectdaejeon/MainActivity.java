package kr.co.company.projectdaejeon;
/*클래스 포함시키는 import*/
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/*어플 초기화면*/
public class MainActivity extends AppCompatActivity {

    @Override
    /*생성 시 제일 먼저 실행*/
    protected void onCreate(Bundle savedInstanceState) {
        /*부모 클래스 지정*/
        super.onCreate(savedInstanceState);
        /*setContentView로 액티비티 지정*/
        setContentView(R.layout.activity_main);
    }
    /*button1에 대한 클릭 동작*/
    public void myListener(View target) {
        /*인텐트 선언과 초기화*/
        Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
        /*명시적 인텐트로 대전 소개 페이지 시작*/
        startActivity(intent);
    }
    /*button2에 대한 클릭 동작*/
    public void myListener2(View target) {
        /*인텐트 선언과 초기화*/
        Intent intent = new Intent(getApplicationContext(), SightseeingActivity.class);
        /*명시적 인텐트로 관광지 소개 페이지 시작*/
        startActivity(intent);
    }
    /*button3에 대한 클릭 동작*/
    public void myListener3(View target){
        /*인텐트 선언과 초기화*/
        Intent intent = new Intent(getApplicationContext(), FoodActivity.class);
        /*명시적 인텐트로 맛집 소개 페이지 시작*/
        startActivity(intent);
}}