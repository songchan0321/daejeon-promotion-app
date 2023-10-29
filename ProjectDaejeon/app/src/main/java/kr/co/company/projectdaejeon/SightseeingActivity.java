package kr.co.company.projectdaejeon;
/*클래스 포함시키는 import*/
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
/*관광지 리스트 뷰 화면*/
public class SightseeingActivity extends AppCompatActivity {
    /*리스트 뷰 생성*/
    ListView list2;
    /*관광지 이름*/
    String[] places = {
            "한밭 수목원",
            "대전 오월드",
            "회덕 동춘당",
            "으능정이 스카이로드",
            "우암사적공원"
    };
    /*관광지 사진 참조*/
    Integer[] pics = {
            R.drawable.place1,
            R.drawable.place2,
            R.drawable.place3,
            R.drawable.place4,
            R.drawable.place5,
    };
    /*관광지 주소*/
    String[] locations = {
            "관광지 주소 : 대전광역시 서구 둔산대로117번길 169",
            "관광지 주소 : 대전광역시 중구 사정공원로 70",
            "관광지 주소 : 대전광역시 대덕구 송촌동 192",
            "관광지 주소 : 대전광역시 중구 중앙로 164",
            "관광지 주소 : 대전광역시 동구 가양동 65"
    };
    /*관광지 안내 전화번호*/
    String[] tells = {
            "관광안내 전화번호 : 042-270-8452",
            "관광안내 전화번호 : 042-580-4820",
            "관광안내 전화번호 : 번호 없음",
            "관광안내 전화번호 : 042-330-3925",
            "관광안내 전화번호 : 042-270-8691"
    };

    @Override
    /*생성 시 제일 먼저 실행*/
    protected void onCreate(Bundle savedInstanceState) {
        /*부모 클래스 지정*/
        super.onCreate(savedInstanceState);
        /*setContentView로 sightseeing 액티비티 지정*/
        setContentView(R.layout.sightseeing);
        /*커스텀 어댑터 객체 food와 겹치지 않게 2로 지정*/
        SightseeingActivity.CustomList2 adapter = new SightseeingActivity.CustomList2(SightseeingActivity.this);
        /*findViewById로 리스트 뷰 불러옴*/
        list2=(ListView)findViewById(R.id.list2);
        /*어댑터 설정*/
        list2.setAdapter(adapter);
        /*클릭 동작 설정*/
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            /*터치했을 때 해당하는 관광지 이름 토스트 메시지 출력*/
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getBaseContext(), places[+position],
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
    public class CustomList2  extends ArrayAdapter<String> {
        private final Activity context;
        /*생성자*/
        public CustomList2(SightseeingActivity context) {
            /*부모 클래스 생성자호출 부분*/
            super(context, R.layout.sightseeing_in, places);
            this.context = context;
        }
        @Override
        /*어댑터*/
        public View getView(int position, View view, ViewGroup parent) {
            /*inflater를 사용해 레이아웃 View 객체 생성*/
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.sightseeing_in, null, true);
            /*관광지 사진, 정보 등 리소스 참조*/
            ImageView imageView = (ImageView) rowView.findViewById(R.id.pic);
            TextView place = (TextView) rowView.findViewById(R.id.place);
            TextView location = (TextView) rowView.findViewById(R.id.location);
            TextView tell = (TextView) rowView.findViewById(R.id.tell);
            /*포지션으로 데이터 삽입*/
            place.setText(places[position]);
            imageView.setImageResource(pics[position]);
            location.setText(locations[position]);
            tell.setText(tells[position]);
            /*반환*/
            return rowView;
        }
    }
}