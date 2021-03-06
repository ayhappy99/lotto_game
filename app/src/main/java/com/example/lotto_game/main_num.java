package com.example.lotto_game;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import in.myinnos.androidscratchcard.ScratchCard;

public class main_num extends AppCompatActivity {


    private ScratchCard mScratchCard;

    static TextView[] num = new TextView[6];

    Random rand = new Random();

    String resultNum = "";
    int[] Number = new int[6];
    long seed;
    RelativeLayout cardView;
    RelativeLayout main;
    TextView title;
    ScratchCard scratchcard;
    int startFlag = 0;

    private NumberAdapter mAdapter;

    int count;          //남은 횟수 카운트
    SharedPreferences preferences;      //변수 저장용
    TextView countText;         //횟수 표기 textview
    TextView block;

    static Context mContext;

    static TextView[] titleText = new TextView[6];     //db 어댑터뷰 용
    SQLiteDatabase db;
    SharedPreferences.Editor editor;

    public static Activity activity;
    static int adloadFlag = 0;      //로드면 1 아니면 0

    int scratchORnot = 0;         //긁혔으면 1 아니면 0


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_num);

        activity = this;

// TODO: Add adView to your view hierarchy.


        mContext = this;

        cardView = findViewById(R.id.scratchView);
        main = (RelativeLayout) findViewById(R.id.main);

        mScratchCard = (ScratchCard) findViewById(R.id.scratchCard);

        title = (TextView) findViewById(R.id.title);
        num[0] = (TextView) findViewById(R.id.firstNum);
        num[1] = (TextView) findViewById(R.id.secondNum);
        num[2] = (TextView) findViewById(R.id.thirdNum);
        num[3] = (TextView) findViewById(R.id.fourthNum);
        num[4] = (TextView) findViewById(R.id.fifthNum);
        num[5] = (TextView) findViewById(R.id.sixthNum);

        seed = System.currentTimeMillis();
        rand = new Random(seed);
        rand.setSeed(System.currentTimeMillis());


        ListView listView = (ListView) findViewById(R.id.number_list);
        NumberDbHelper dbHelper = NumberDbHelper.getInstance(this);         //랜덤변수들 db
        Cursor cursor = dbHelper.getReadableDatabase()
                .query(NumberRecord.NumberEntry.TABLE_NAME, null, null,
                        null, null, null, NumberRecord.NumberEntry._ID + " DESC");

        mAdapter = new NumberAdapter(this, cursor);
        listView.setAdapter(mAdapter);

        preferences = getSharedPreferences("MY_NICKNAME", Context.MODE_PRIVATE);

        String buff = preferences.getString("count", "");
        String blank = "";


        if (buff.equals(blank)) {
            editor = preferences.edit();
            editor.putString("count", 6 + "");
            editor.commit();
            count = 6;
        } else {
            count = Integer.parseInt(buff);
        }

        countText = (TextView) findViewById(R.id.count);
        countText.setText("남은 횟수: " + count);
        //count = Integer.parseInt(preferences.getString("count", ""));

        block = (TextView) findViewById(R.id.scratchBlock);
        if (count == 0) {
            //makeScratch();
            block.setVisibility(View.VISIBLE);

        } else {
            block.setVisibility(View.INVISIBLE);
            getNumber();        //스크레치 생성 및 새로운 번호 생성
        }

    }


    private Cursor getNumberCursor() {
        NumberDbHelper dbHelper = NumberDbHelper.getInstance(this);
        return dbHelper.getReadableDatabase().query(NumberRecord.NumberEntry.TABLE_NAME, null,
                null, null, null, null, NumberRecord.NumberEntry._ID + " DESC");
    }

    private static class NumberAdapter extends CursorAdapter {
        public NumberAdapter(Context context, Cursor c) {
            super(context, c, false);
        }

        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(R.layout.number_layout, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {


            titleText[0] = (TextView) view.findViewById(R.id.firstNum);
            titleText[1] = (TextView) view.findViewById(R.id.secondNum);
            titleText[2] = (TextView) view.findViewById(R.id.thirdNum);
            titleText[3] = (TextView) view.findViewById(R.id.fourthNum);
            titleText[4] = (TextView) view.findViewById(R.id.fifthNum);
            titleText[5] = (TextView) view.findViewById(R.id.sixthNum);

            String[] tview = new String[6];
            tview[0] = cursor.getString(cursor.getColumnIndexOrThrow(NumberRecord.NumberEntry.FIRST_NUMBER));
            tview[1] = cursor.getString(cursor.getColumnIndexOrThrow(NumberRecord.NumberEntry.SECOND_NUMBER));
            tview[2] = cursor.getString(cursor.getColumnIndexOrThrow(NumberRecord.NumberEntry.THIRD_NUMBER));
            tview[3] = cursor.getString(cursor.getColumnIndexOrThrow(NumberRecord.NumberEntry.FOURTH_NUMBER));
            tview[4] = cursor.getString(cursor.getColumnIndexOrThrow(NumberRecord.NumberEntry.FIFTH_NUMBER));
            tview[5] = cursor.getString(cursor.getColumnIndexOrThrow(NumberRecord.NumberEntry.SIXTH_NUMBER));

            int[] tviewInt = new int[6];
            tviewInt[0] = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(NumberRecord.NumberEntry.FIRST_NUMBER)));
            tviewInt[1] = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(NumberRecord.NumberEntry.SECOND_NUMBER)));
            tviewInt[2] = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(NumberRecord.NumberEntry.THIRD_NUMBER)));
            tviewInt[3] = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(NumberRecord.NumberEntry.FOURTH_NUMBER)));
            tviewInt[4] = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(NumberRecord.NumberEntry.FIFTH_NUMBER)));
            tviewInt[5] = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(NumberRecord.NumberEntry.SIXTH_NUMBER)));

            for (int i = 0; i < 6; i++) {
                int[] colorG = new int[2];
                System.out.println("tviewInt 값은 = " + tviewInt);

                if (tviewInt[i] < 11) {
                    colorG[0] = mContext.getResources().getColor(R.color.Yellow);
                    colorG[1] = mContext.getResources().getColor(R.color.Yellow2);

                } else if (10 < tviewInt[i] && tviewInt[i] < 21) {
                    colorG[0] = mContext.getResources().getColor(R.color.Blue);
                    colorG[1] = mContext.getResources().getColor(R.color.Blue2);
                    // bgShape.setColor(getResources().getColor(R.color.Blue));
                } else if (20 < tviewInt[i] && tviewInt[i] < 31) {
                    colorG[0] = mContext.getResources().getColor(R.color.Red);
                    colorG[1] = mContext.getResources().getColor(R.color.Red2);
                    //bgShape.setColor(getResources().getColor(R.color.Red));
                } else if (30 < tviewInt[i] && tviewInt[i] < 41) {
                    colorG[0] = mContext.getResources().getColor(R.color.Gray);
                    colorG[1] = mContext.getResources().getColor(R.color.Gray2);
                    //bgShape.setColor(getResources().getColor(R.color.Gray));
                } else {
                    colorG[0] = mContext.getResources().getColor(R.color.Green);
                    colorG[1] = mContext.getResources().getColor(R.color.Green2);
                    //
                    // bgShape.setColor(getResources().getColor(R.color.Green));
                }
                GradientDrawable ad = new GradientDrawable(
                        GradientDrawable.Orientation.TL_BR, colorG);
                ad.setShape(GradientDrawable.OVAL);
                titleText[i].setBackground(ad);
                //resultNum += Number[i] + " ";
                titleText[i].setText(tview[i]);
            }

            String timeStamp = cursor.getString(cursor.getColumnIndexOrThrow(NumberRecord.NumberEntry.TIME_STAMP));
            TextView cnt = (TextView) view.findViewById(R.id.count);
            cnt.setText(timeStamp);

        }


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        preferences = getSharedPreferences("MY_NICKNAME", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("count", count + "");
        editor.commit();

    }


    public void getNumber() {

        count--;
        countText.setText("남은 횟수: " + count);
        editor = preferences.edit();
        editor.putString("count", count + "");
        editor.commit();





        resultNum = "";
        for (int i = 0; i < 6; i++) {
            Number[i] = rand.nextInt(46);     //0<= n <46

            if (Number[i] == 0) {
                i--;
            } else {
                for (int j = 0; j < i; j++) {
                    if (Number[i] == Number[j]) {
                        i--;
                        break;
                    }
                }
            }

        }


        Arrays.sort(Number);
        for (int i = 0; i < 6; i++) {
            //GradientDrawable bgShape = (GradientDrawable) num[i].getBackground();
            int[] colorG = new int[2];


            if (Number[i] < 11) {
                colorG[0] = getResources().getColor(R.color.Yellow);
                colorG[1] = getResources().getColor(R.color.Yellow2);

            } else if (10 < Number[i] && Number[i] < 21) {
                colorG[0] = getResources().getColor(R.color.Blue);
                colorG[1] = getResources().getColor(R.color.Blue2);
                // bgShape.setColor(getResources().getColor(R.color.Blue));
            } else if (20 < Number[i] && Number[i] < 31) {
                colorG[0] = getResources().getColor(R.color.Red);
                colorG[1] = getResources().getColor(R.color.Red2);
                //bgShape.setColor(getResources().getColor(R.color.Red));
            } else if (30 < Number[i] && Number[i] < 41) {
                colorG[0] = getResources().getColor(R.color.Gray);
                colorG[1] = getResources().getColor(R.color.Gray2);
                //bgShape.setColor(getResources().getColor(R.color.Gray));
            } else {
                colorG[0] = getResources().getColor(R.color.Green);
                colorG[1] = getResources().getColor(R.color.Green2);
                //
                // bgShape.setColor(getResources().getColor(R.color.Green));
            }
            GradientDrawable gd = new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR, colorG);
            gd.setShape(GradientDrawable.OVAL);
            num[i].setBackground(gd);
            String buff = Number[i] + "";
            num[i].setText(buff);
            resultNum += Number[i] + " ";

        }


        makeScratch();          //스크래치 생성


        storeNumber();


    }

    public void makeScratch() {
        scratchORnot = 0;

        scratchcard = new ScratchCard(this);
        final int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 330, getResources().getDisplayMetrics());
        final int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
                (width, height);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        layoutParams.addRule(RelativeLayout.BELOW, title.getId());
        scratchcard.setLayoutParams(layoutParams);
        // scratchcard.setLayoutParams(new RelativeLayout.LayoutParams(330, 100));

        //scratchcard.setImageResource(R.drawable.red_dot_icon);
        cardView.addView(scratchcard);

        scratchcard.setOnScratchListener(new ScratchCard.OnScratchListener() {
            @Override
            public void onScratch(ScratchCard scratchCard, float visiblePercent) {

                if (visiblePercent > 0.3) {
                    scratchcard.setVisibility(View.GONE);
                    scratchORnot = 1;
                    Toast.makeText(main_num.this, "행운번호는\n" + resultNum + "입니다.", Toast.LENGTH_SHORT).show();
                    // if (startFlag != 0)
                    renewList();
                }
            }
        });


    }


    public void storeNumber() {
        String one = num[0].getText().toString();
        String two = num[1].getText().toString();
        String three = num[2].getText().toString();
        String four = num[3].getText().toString();
        String five = num[4].getText().toString();
        String six = num[5].getText().toString();
        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd\nHH:mm:ss");
        String time = sdfNow.format(new Date(System.currentTimeMillis()));
        String like = "13";

        ContentValues contentValues = new ContentValues();
        contentValues.put(NumberRecord.NumberEntry.TIME_STAMP, time);
        contentValues.put(NumberRecord.NumberEntry.FIRST_NUMBER, one);
        contentValues.put(NumberRecord.NumberEntry.SECOND_NUMBER, two);
        contentValues.put(NumberRecord.NumberEntry.THIRD_NUMBER, three);
        contentValues.put(NumberRecord.NumberEntry.FOURTH_NUMBER, four);
        contentValues.put(NumberRecord.NumberEntry.FIFTH_NUMBER, five);
        contentValues.put(NumberRecord.NumberEntry.SIXTH_NUMBER, six);
        contentValues.put(NumberRecord.NumberEntry.LIKE_NUMBER, like);

        SQLiteDatabase db = NumberDbHelper.getInstance(this).getWritableDatabase();
        long newRowId = db.insert(NumberRecord.NumberEntry.TABLE_NAME, null, contentValues);
        if (newRowId == -1) {
            Toast.makeText(this, "정보에 문제가 있습니다.", Toast.LENGTH_SHORT).show();
        } else {
            if (startFlag != 0) {
                Toast.makeText(this, "번호가 저장되었습니다.", Toast.LENGTH_SHORT).show();
                //setResult(RESULT_OK);

            } else {
                startFlag++;
            }
        }

    }


    public void getNum(View view) {          //숫자생성


        if (scratchcard.getVisibility() == view.VISIBLE) {
            //scratchcard.setVisibility(View.GONE);
            Toast.makeText(this, "아직 스크래치가 다 긁히지 않았습니다.\n회색 부분을 문질러 없애주세요.", Toast.LENGTH_SHORT).show();
        }else {
            //renewList();

            if (count <= 0) {
                //Toast.make();
                block.setVisibility(View.VISIBLE);
            } else {
                block.setVisibility(View.INVISIBLE);
                getNumber();
            }
        }
    }

    public void renewList() {            //하단 리스트 갱신
        mAdapter.swapCursor(getNumberCursor());

    }


}
