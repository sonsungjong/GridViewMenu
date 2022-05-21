package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // AppCompatActivity 클래스를 복사 -> 붙여넣기
    TextView textview;
    Button main_intent_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 상태바 없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // 수정
        textview = findViewById(R.id.text1);
        main_intent_btn = findViewById(R.id.main_intent_btn);

        main_intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                intent.putExtra("id", "thstjdwhd");
                startActivity(intent);
                // finish();
            }
        });
        textview.setText("반갑습니다.");
    }


    protected void onDestroy() {
        textview.setText("바이~");
        super.onDestroy();
    }
}

