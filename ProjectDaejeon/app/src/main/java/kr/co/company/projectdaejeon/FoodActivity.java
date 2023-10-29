package kr.co.company.projectdaejeon;
/*클래스 포함시키는 import*/
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
/*맛집 리스트 뷰 화면*/
public class FoodActivity extends AppCompatActivity {
    /*리스트 뷰 생성*/
    ListView list;
    /*가게 이름*/
    String[] names = {
            "강남면옥",
            "스마일 칼국수",
            "광세 족발",
            "개천 식당",
            "삿뽀로",
            "오한순 손수제비"
    };
    /*가게 사진 참조*/
    Integer[] photos = {
            R.drawable.food1,
            R.drawable.food2,
            R.drawable.food3,
            R.drawable.food4,
            R.drawable.food5,
            R.drawable.food6
    };
    /*가게 주소*/
    String[] addresses={
            "대전광역시 서구 둔산1동 1410",
            "대전광역시 중구 대흥동 보문로230번길 82",
            "대전광역시 유성구 전민동 329-18",
            "대전광역시 동구 원동 62-1",
            "대전광역시 서구 만년동 대덕대로 366 센트롤파크2층201 해가든",
            "대전광역시 서구 신갈마로230번길 36"
    };
    /*가게 영업시간*/
    String[] opening={
            "영업시간 : 오전 8시 ~ 오후 10시",
            "영업시간 : 오전 11시 ~ 오후 9시",
            "영업시간 : 오후 5시 ~ 오후 11시",
            "영업시간 : 오전 11시 30분 ~ 오후 8시 30분",
            "영업시간 : 오전 11시 30분 ~ 오후 9시",
            "영업시간 : 오전 11시 ~ 오후 3시, 오후5시 ~ 오후 9시 30분"
    };
    /*가게 전화번호*/
    String[] calls={
            "가게 전화번호 : 042-472-9996",
            "가게 전화번호 : 042-221-1845",
            "가게 전화번호 : 042-863-6142",
            "가게 전화번호 : 042-256-5627",
            "가게 전화번호 : 042-482-7766",
            "가게 전화번호 : 042-301-3484"
    };
    @Override
    /*생성 시 제일 먼저 실행*/
    protected void onCreate(Bundle savedInstanceState) {
        /*부모 클래스 지정*/
        super.onCreate(savedInstanceState);
        /*setContentView로 food 액티비티 지정*/
        setContentView(R.layout.food);
        /*커스텀 어댑터 객체*/
        CustomList adapter = new CustomList(FoodActivity.this);
        /*findViewById로 리스트 뷰 불러옴*/
        list=(ListView)findViewById(R.id.list);
        /*어댑터 설정*/
        list.setAdapter(adapter);
        /*클릭 동작 설정*/
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            /*터치했을 때 해당하는 가게 이름 토스트 메시지 출력*/
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getBaseContext(), names[+position],
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
public class CustomList  extends ArrayAdapter<String> {
    private final Activity context;
    /*생성자*/
    public CustomList(FoodActivity context) {
        /*부모 클래스 생성자호출 부분*/
    super(context, R.layout.food_in, names);
    this.context = context;
    }
    @Override
    /*어댑터*/
    public View getView(int position, View view, ViewGroup parent) {
        /*inflater를 사용해 레이아웃 View 객체 생성*/
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.food_in, null, true);
        /*가게 사진, 정보 등 리소스 참조*/
        ImageView imageView = (ImageView) rowView.findViewById(R.id.photo);
        TextView name = (TextView) rowView.findViewById(R.id.name);
        TextView address = (TextView) rowView.findViewById(R.id.address);
        TextView opening_hours = (TextView) rowView.findViewById(R.id.opening);
        TextView call = (TextView) rowView.findViewById(R.id.call);
        /*포지션으로 데이터 삽입*/
        name.setText(names[position]);
        imageView.setImageResource(photos[position]);
        address.setText(addresses[position]);
        opening_hours.setText(opening[position]);
        call.setText(calls[position]);
        /*반환*/
        return rowView;
    }
}
}
