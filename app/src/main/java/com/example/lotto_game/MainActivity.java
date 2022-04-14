package com.example.lotto_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button go_game = findViewById(R.id.go_game);
        Button lucky_num = findViewById(R.id.lucky_num);
        Button ran_num = findViewById(R.id.ran_num);

        go_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),game_select.class);
                startActivity(intent);
            }
        });

        lucky_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),lucky_num.class);
                startActivity(intent);
            }
        });

        ran_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),random.class);
                startActivity(intent);
            }
        });

    }
}