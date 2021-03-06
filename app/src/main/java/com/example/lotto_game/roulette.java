package com.example.lotto_game;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;

import org.w3c.dom.UserDataHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class roulette extends AppCompatActivity {
    private LuckyWheel luckyWheel;
    List<WheelItem> wheelItems;
    String point;
    TextView textView;

    private UserDatabaseHelper userDataBaseHelper;
    public static final String TABLE_NAME = "user";
    SQLiteDatabase database;

    Button look,delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette);

        userDataBaseHelper = UserDatabaseHelper.getInstance(this);
        database = userDataBaseHelper.getWritableDatabase();

        textView = findViewById(R.id.textView);
        look=findViewById(R.id.look);
        look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectData(TABLE_NAME);
            }
        });
        delete=findViewById(R.id.delete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String money = textView.getText().toString();
                deleteData(money);
            }
        });

        luckyWheel = findViewById(R.id.luck_wheel);

        generateWheelItems();

        luckyWheel.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {
                WheelItem wheelItem = wheelItems.get(Integer.parseInt(point)-1);

                String money = wheelItem.text;

                Toast.makeText(roulette.this,money,Toast.LENGTH_SHORT).show();



            }
        });
        Button start = findViewById(R.id.spin_btn);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Random random = new Random();
                point = String.valueOf(random.nextInt(45)+1);
                luckyWheel.rotateWheelTo(Integer.parseInt(point));

                WheelItem wheelItem = wheelItems.get(Integer.parseInt(point)-1);

                String money = wheelItem.text;

                insertData(money);

            }
        });


    }
    private void selectData(String tableName){

        if (database !=null){
            String sql = " SELECT money FROM " + tableName;
            Cursor cursor = database.rawQuery(sql,null);

            for(int i=0;i<cursor.getCount();i++){
                cursor.moveToNext();
                String money = cursor.getString(0);
                println("[ "+i+ "] Number : "+money);
            }
            cursor.close();
        }
    }
    private void insertData(String money){
        if (database!=null){
            String sql = "INSERT INTO user(money) VALUES(?) ";
            Object[] params={money};
            database.execSQL(sql,params);
        }
    }
    private void deleteData(String money){
        if (database!=null){
            String sql="DELETE FROM user WHERE money=? ";
            Object[] params={money};
            database.execSQL(sql,params);
            database.execSQL("delete from "+TABLE_NAME);
        }
    }

    private void println(String data){
        textView.append(data+"\n");
    }
    @Override
    protected void onDestroy(){
        userDataBaseHelper.close();
        super.onDestroy();
    }

    private void generateWheelItems() {
        wheelItems = new ArrayList<>();
        Drawable d =getResources().getDrawable(R.drawable.back,null);
        Bitmap bitmap = drawableToBitmap(d);

        wheelItems.add(new WheelItem(Color.parseColor("#FF0000"),bitmap,"1"));
        wheelItems.add(new WheelItem(Color.parseColor("#FF8000"),bitmap,"2"));
        wheelItems.add(new WheelItem(Color.parseColor("#FFFF00"),bitmap,"3"));
        wheelItems.add(new WheelItem(Color.parseColor("#008000"),bitmap,"4"));
        wheelItems.add(new WheelItem(Color.parseColor("#7B68EE"),bitmap,"5"));
        wheelItems.add(new WheelItem(Color.parseColor("#FFC0CB"),bitmap,"6"));
        wheelItems.add(new WheelItem(Color.parseColor("#FFFACD"),bitmap,"7"));
        wheelItems.add(new WheelItem(Color.parseColor("#BC8F8F"),bitmap,"8"));
        wheelItems.add(new WheelItem(Color.parseColor("#B0C4DE"),bitmap,"9"));
        wheelItems.add(new WheelItem(Color.parseColor("#F0FFFF"),bitmap,"10"));
        wheelItems.add(new WheelItem(Color.parseColor("#FF0000"),bitmap,"11"));
        wheelItems.add(new WheelItem(Color.parseColor("#FF8000"),bitmap,"12"));
        wheelItems.add(new WheelItem(Color.parseColor("#FFFF00"),bitmap,"13"));
        wheelItems.add(new WheelItem(Color.parseColor("#008000"),bitmap,"14"));
        wheelItems.add(new WheelItem(Color.parseColor("#7B68EE"),bitmap,"15"));
        wheelItems.add(new WheelItem(Color.parseColor("#FFC0CB"),bitmap,"16"));
        wheelItems.add(new WheelItem(Color.parseColor("#FFFACD"),bitmap,"17"));
        wheelItems.add(new WheelItem(Color.parseColor("#BC8F8F"),bitmap,"18"));
        wheelItems.add(new WheelItem(Color.parseColor("#B0C4DE"),bitmap,"19"));
        wheelItems.add(new WheelItem(Color.parseColor("#F0FFFF"),bitmap,"20"));
        wheelItems.add(new WheelItem(Color.parseColor("#FF0000"),bitmap,"21"));
        wheelItems.add(new WheelItem(Color.parseColor("#FF8000"),bitmap,"22"));
        wheelItems.add(new WheelItem(Color.parseColor("#FFFF00"),bitmap,"23"));
        wheelItems.add(new WheelItem(Color.parseColor("#008000"),bitmap,"24"));
        wheelItems.add(new WheelItem(Color.parseColor("#7B68EE"),bitmap,"25"));
        wheelItems.add(new WheelItem(Color.parseColor("#FFC0CB"),bitmap,"26"));
        wheelItems.add(new WheelItem(Color.parseColor("#FFFACD"),bitmap,"27"));
        wheelItems.add(new WheelItem(Color.parseColor("#BC8F8F"),bitmap,"28"));
        wheelItems.add(new WheelItem(Color.parseColor("#B0C4DE"),bitmap,"29"));
        wheelItems.add(new WheelItem(Color.parseColor("#F0FFFF"),bitmap,"30"));
        wheelItems.add(new WheelItem(Color.parseColor("#FF0000"),bitmap,"31"));
        wheelItems.add(new WheelItem(Color.parseColor("#FF8000"),bitmap,"32"));
        wheelItems.add(new WheelItem(Color.parseColor("#FFFF00"),bitmap,"33"));
        wheelItems.add(new WheelItem(Color.parseColor("#008000"),bitmap,"34"));
        wheelItems.add(new WheelItem(Color.parseColor("#7B68EE"),bitmap,"35"));
        wheelItems.add(new WheelItem(Color.parseColor("#FFC0CB"),bitmap,"36"));
        wheelItems.add(new WheelItem(Color.parseColor("#FFFACD"),bitmap,"37"));
        wheelItems.add(new WheelItem(Color.parseColor("#BC8F8F"),bitmap,"38"));
        wheelItems.add(new WheelItem(Color.parseColor("#B0C4DE"),bitmap,"39"));
        wheelItems.add(new WheelItem(Color.parseColor("#F0FFFF"),bitmap,"40"));
        wheelItems.add(new WheelItem(Color.parseColor("#FF0000"),bitmap,"41"));
        wheelItems.add(new WheelItem(Color.parseColor("#FF8000"),bitmap,"42"));
        wheelItems.add(new WheelItem(Color.parseColor("#FFFF00"),bitmap,"43"));
        wheelItems.add(new WheelItem(Color.parseColor("#008000"),bitmap,"44"));
        wheelItems.add(new WheelItem(Color.parseColor("#7B68EE"),bitmap,"45"));

        luckyWheel.addWheelItems(wheelItems);
    }
    public static Bitmap drawableToBitmap(Drawable drawable){
        if(drawable instanceof BitmapDrawable){
            return ((BitmapDrawable)drawable).getBitmap();
        }
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0,0,canvas.getWidth(),canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }
}
