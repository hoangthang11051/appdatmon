package com.example.appdatmon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class food_2 extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_layer2);
        Intent intent = getIntent();
        int message = intent.getIntExtra("price", 0);
        if(message == 0){
            TextView textView = findViewById(R.id.tv_total_price);
            textView.setText("Bạn chưa chọn món ăn ");
        }else{
            TextView textView = findViewById(R.id.tv_total_price);
            textView.setText("Bạn cần thanh toán: " + message);
        }
    }
}
