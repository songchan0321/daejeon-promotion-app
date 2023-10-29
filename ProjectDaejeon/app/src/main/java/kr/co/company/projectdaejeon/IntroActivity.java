package kr.co.company.projectdaejeon;
/*클래스를 포함시키는 import*/
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
/*대전 소개 페이지*/
public class IntroActivity extends AppCompatActivity {
    @Override
    /*생성 시 제일 먼저 실행*/
    protected void onCreate(Bundle savedInstanceState) {
        /*부모 클래스 지정*/
        super.onCreate(savedInstanceState);
        /*setContentView로 intro 액티비티 지정*/
        setContentView(R.layout.intro);
    }
}