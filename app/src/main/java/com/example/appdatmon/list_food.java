package com.example.appdatmon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class list_food extends AppCompatActivity {

    ListView list;
    ArrayList<food_obj> objs = new ArrayList<>();
    MainActivity adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);
        objs.add(new food_obj(R.drawable.xao, 20, "xao", false));
        objs.add(new food_obj(R.drawable.nau, 200, "nau", false));
        objs.add(new food_obj(R.drawable.luoc, 2000, "luoc", false));
        objs.add(new food_obj(R.drawable.hap, 20000, "hap", false));
        objs.add(new food_obj(R.drawable.chien, 20000, "chien", false));
        adapter = new MainActivity(this, objs);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        Button checkout = findViewById(R.id.btn_checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalPrice = 0;
                for (int i = 0; i < objs.size(); i++) {
                    if (objs.get(i).checked) {
                        totalPrice += objs.get(i).price;
                    }

                }

                Intent it = new Intent(list_food.this, food_2.class);
                it.putExtra("price", totalPrice);
                startActivity(it);
            }
        });
    }
}
