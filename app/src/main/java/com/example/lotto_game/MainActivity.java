package com.example.lotto_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button go_game;
    Button lucky_num;
    Button ran_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go_game = findViewById(R.id.go_game);
        lucky_num = findViewById(R.id.lucky_num);
        ran_num = findViewById(R.id.ran_num);

        go_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,game_select.class);
                startActivity(intent);
            }
        });

        lucky_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,lucky_num.class);
                startActivity(intent);
            }
        });

        ran_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,random.class);
                startActivity(intent);
            }
        });

    }





}
