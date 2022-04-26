package com.example.lotto_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class game_select extends AppCompatActivity {
    Button card_game;
    Button roulette_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_select);

        card_game = findViewById(R.id.card_game);
        roulette_game = findViewById(R.id.roulette_game);

        card_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(game_select.this,card.class);
                startActivity(intent);

            }
        });

        roulette_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(game_select.this,roulette.class);
                startActivity(intent);
            }
        });
    }
}