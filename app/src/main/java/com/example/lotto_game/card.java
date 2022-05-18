package com.example.lotto_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class card extends AppCompatActivity implements View.OnClickListener {

    private ImageButton[] buttons = new ImageButton[45];

    private ArrayList<Integer> imageList;
    private ArrayList<MemoryCard> cards;


    private Collections collections;
    private Button resetBtn;

    int preCardPosition =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);


        init();

        resetBtn = findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init();
            }
        });

    }

    public void init(){

        imageList = new ArrayList<>();

        imageList.add(R.drawable.one);
        imageList.add(R.drawable.two);
        imageList.add(R.drawable.three);
        imageList.add(R.drawable.four);
        imageList.add(R.drawable.five);
        imageList.add(R.drawable.six);
        imageList.add(R.drawable.seven);
        imageList.add(R.drawable.eight);
        imageList.add(R.drawable.nine);
        imageList.add(R.drawable.ten);
        imageList.add(R.drawable.eleven);
        imageList.add(R.drawable.twelve);
        imageList.add(R.drawable.thirteen);
        imageList.add(R.drawable.fourteen);
        imageList.add(R.drawable.fifteen);
        imageList.add(R.drawable.sixteen);
        imageList.add(R.drawable.seventeen);
        imageList.add(R.drawable.eighteen);
        imageList.add(R.drawable.nineteen);
        imageList.add(R.drawable.twenty);
        imageList.add(R.drawable.two_one);
        imageList.add(R.drawable.two_two);
        imageList.add(R.drawable.two_three);
        imageList.add(R.drawable.two_four);
        imageList.add(R.drawable.two_five);
        imageList.add(R.drawable.two_six);
        imageList.add(R.drawable.two_seven);
        imageList.add(R.drawable.two_eight);
        imageList.add(R.drawable.two_nine);
        imageList.add(R.drawable.thirty);
        imageList.add(R.drawable.thirty_one);
        imageList.add(R.drawable.thirty_two);
        imageList.add(R.drawable.thirty_three);
        imageList.add(R.drawable.thirty_four);
        imageList.add(R.drawable.thirty_five);
        imageList.add(R.drawable.thirty_six);
        imageList.add(R.drawable.thirty_seven);
        imageList.add(R.drawable.thirty_eight);
        imageList.add(R.drawable.thirty_nine);
        imageList.add(R.drawable.fourty);
        imageList.add(R.drawable.fourty_one);
        imageList.add(R.drawable.fourty_two);
        imageList.add(R.drawable.fourty_three);
        imageList.add(R.drawable.fourty_four);
        imageList.add(R.drawable.fourty_five);



        collections.shuffle(imageList);
        cards = new ArrayList<>();

        for(int i=0;i<buttons.length;i++){
            String buttonID = "imageBtn"+i;
            int resourceID=getResources().getIdentifier(buttonID,"id",getPackageName());
            buttons[i]=findViewById(resourceID);

            buttons[i].setOnClickListener(this);

            cards.add(new MemoryCard(imageList.get(i),false));
            buttons[i].setImageResource(R.drawable.back);
            buttons[i].setAlpha(1.0f);
        }
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        
        int position = 0;

        if(id==R.id.imageBtn0){
            position=0;

        }else if(id==R.id.imageBtn1){
            position=1;

        }else if(id==R.id.imageBtn2){
            position=2;

        }else if(id==R.id.imageBtn3) {
            position = 3;
        }else if(id==R.id.imageBtn4){
            position=4;

        }else if(id==R.id.imageBtn5){
            position=5;

        }else if(id==R.id.imageBtn6){
            position=6;

        }else if(id==R.id.imageBtn7){
            position=7;

        }else if(id==R.id.imageBtn8){
            position=8;

        }else if(id==R.id.imageBtn9){
            position=9;

        }else if(id==R.id.imageBtn10){
            position=10;

        }else if(id==R.id.imageBtn11){
            position=11;

        }else if(id==R.id.imageBtn12){
            position=12;

        }else if(id==R.id.imageBtn13){
            position=13;

        }else if(id==R.id.imageBtn14){
            position=14;

        }else if(id==R.id.imageBtn15){
            position=15;

        }else if(id==R.id.imageBtn16){
            position=16;

        }else if(id==R.id.imageBtn17){
            position=17;

        }else if(id==R.id.imageBtn18){
            position=18;

        }else if(id==R.id.imageBtn19){
            position=19;

        }else if(id==R.id.imageBtn20){
            position=20;

        }else if(id==R.id.imageBtn21){
            position=21;

        }else if(id==R.id.imageBtn22){
            position=22;


        }else if(id==R.id.imageBtn23){
            position=23;

        }else if(id==R.id.imageBtn24){
            position=24;

        }else if(id==R.id.imageBtn25){
            position=25;

        }else if(id==R.id.imageBtn26){
            position=26;

        }else if(id==R.id.imageBtn27){
            position=27;

        }else if(id==R.id.imageBtn28){
            position=28;

        }else if(id==R.id.imageBtn29){
            position=29;

        }else if(id==R.id.imageBtn30){
            position=30;

        }else if(id==R.id.imageBtn31){
            position=31;

        }else if(id==R.id.imageBtn32){
            position=32;

        }else if(id==R.id.imageBtn33){
            position=33;

        }else if(id==R.id.imageBtn34){
            position=34;

        }else if(id==R.id.imageBtn35){
            position=35;

        }else if(id==R.id.imageBtn36){
            position=36;

        }else if(id==R.id.imageBtn37){
            position=37;

        }else if(id==R.id.imageBtn38){
            position=38;

        }else if(id==R.id.imageBtn39){
            position=39;

        }else if(id==R.id.imageBtn40){
            position=40;

        }else if(id==R.id.imageBtn41){
            position=41;

        }else if(id==R.id.imageBtn42){
            position=42;

        }else if(id==R.id.imageBtn43){
            position=43;

        }else if(id==R.id.imageBtn44){
            position=44;

        }

        updateModel(position);
        updateView(position);

    }
    private void updateModel(int position){
        MemoryCard card = cards.get(position);

        if(card.isFaceUp()){
            Toast.makeText(this,"이미 뒤집혔음",Toast.LENGTH_SHORT).show();
            return;
        }


        cards.get(position).setFaceUp(!card.isFaceUp());

    }

    private void updateView(int position){
        MemoryCard card = cards.get(position);

        if(card.isFaceUp()){
            buttons[position].setImageResource(card.getImageId());
        }else{
            buttons[position].setImageResource(R.drawable.back);
        }
    }
    private void restoreCard(){
        for(int i=0;i<cards.size();i++){
            if(cards.size()>=6){
                buttons[i].setImageResource(R.drawable.back);
                cards.get(i).setFaceUp(false);
            }
        }
    }











}