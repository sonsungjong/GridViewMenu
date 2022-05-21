package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    GridView grid_view;
    static TextView menu_total;
    static int total_price = 0;

    // 갯수 동일하게 맞춰주기
    String[] numberWord = {"One","Two","Three","Four","Five","Six","Seven","Eight"};
    int[] numberImage = {R.drawable.one, R.drawable.two, R.drawable.three,R.drawable.four,R.drawable.five,
            R.drawable.six,R.drawable.seven,R.drawable.eight};
    int[] numberPrice = {100, 200, 300, 400, 500, 600, 700, 800};
    int[] numberCount = {0,0,0,0,0,0,0,0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 상태바 없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
        grid_view = findViewById(R.id.grid_view);
        menu_total = findViewById(R.id.menu_total);


        menu_total.setText("총 가격 : "+total_price+"원");

        MenuAdapter adapter = new MenuAdapter(MenuActivity.this, numberWord, numberImage, numberPrice, numberCount);
        grid_view.setAdapter(adapter);

        // 그리드뷰 클릭시
        grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), "You Clicked"+numberWord[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}