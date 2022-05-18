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
        
        int position=0;

        if(id==R.id.imageBtn0){
            position=0;
            Toast.makeText(this,"0",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn1){
            position=1;
            Toast.makeText(this,"1",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn2){
            position=2;
            Toast.makeText(this,"2",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn3){
            position=3;
            Toast.makeText(this,"3",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn4){
            position=4;
            Toast.makeText(this,"4",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn5){
            position=5;
            Toast.makeText(this,"5",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn6){
            position=6;
            Toast.makeText(this,"6",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn7){
            position=7;
            Toast.makeText(this,"7",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn8){
            position=8;
            Toast.makeText(this,"8",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn9){
            position=9;
            Toast.makeText(this,"9",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn10){
            position=10;
            Toast.makeText(this,"10",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn11){
            position=11;
            Toast.makeText(this,"11",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn12){
            position=12;
            Toast.makeText(this,"12",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn13){
            position=13;
            Toast.makeText(this,"13",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn14){
            position=14;
            Toast.makeText(this,"14",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn15){
            position=15;
            Toast.makeText(this,"15",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn16){
            position=16;
            Toast.makeText(this,"16",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn17){
            position=17;
            Toast.makeText(this,"17",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn18){
            position=18;
            Toast.makeText(this,"18",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn19){
            position=19;
            Toast.makeText(this,"19",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn20){
            position=20;
            Toast.makeText(this,"20",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn21){
            position=21;
            Toast.makeText(this,"21",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn22){
            position=22;
            Toast.makeText(this,"22",Toast.LENGTH_SHORT).show();

        }else if(id==R.id.imageBtn23){
            position=23;
            Toast.makeText(this,"23",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn24){
            position=24;
            Toast.makeText(this,"24",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn25){
            position=25;
            Toast.makeText(this,"25",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn26){
            position=26;
            Toast.makeText(this,"26",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn27){
            position=27;
            Toast.makeText(this,"27",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn28){
            position=28;
            Toast.makeText(this,"28",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn29){
            position=29;
            Toast.makeText(this,"29",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn30){
            position=30;
            Toast.makeText(this,"30",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn31){
            position=31;
            Toast.makeText(this,"31",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn32){
            position=32;
            Toast.makeText(this,"32",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn33){
            position=33;
            Toast.makeText(this,"33",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn34){
            position=34;
            Toast.makeText(this,"34",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn35){
            position=35;
            Toast.makeText(this,"35",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn36){
            position=36;
            Toast.makeText(this,"36",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn37){
            position=37;
            Toast.makeText(this,"37",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn38){
            position=38;
            Toast.makeText(this,"38",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn39){
            position=39;
            Toast.makeText(this,"39",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn40){
            position=40;
            Toast.makeText(this,"40",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn41){
            position=41;
            Toast.makeText(this,"41",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn42){
            position=42;
            Toast.makeText(this,"42",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn43){
            position=43;
            Toast.makeText(this,"43",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.imageBtn44){
            position=44;
            Toast.makeText(this,"44",Toast.LENGTH_SHORT).show();
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