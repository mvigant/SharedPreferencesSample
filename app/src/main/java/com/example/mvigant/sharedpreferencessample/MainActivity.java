package com.example.mvigant.sharedpreferencessample;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {
    private int currentRate;
    private int maxRate;
    private TextView  currentRateView;
    private TextView  maxRateView;

    public static final String PREFS_NAME = "SharedPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // чтение из файла "SharedPreferences";
        SharedPreferences storeData=getSharedPreferences(PREFS_NAME, 0); // 0 mode private кому доступен файл
        currentRate=storeData.getInt("currentRate",0);// 0- значение по умолчанию
        maxRate=storeData.getInt("maxRate",0);// 0- значение по умолчанию
        //
        currentRateView= ( TextView)findViewById(R.id.currentRateView);
        maxRateView= ( TextView)findViewById(R.id.maxRateView);
        currentRateView.setText(""+currentRate);
        maxRateView.setText(""+maxRate);
        //
       }
    protected void onStop() {
        super.onStop();
        // запись в файл SharedPreferences
        SharedPreferences storeData=getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor  storeDataEditor=storeData.edit();
        storeDataEditor.putInt("currentRate",currentRate);// 0- значение по умолчанию
        storeDataEditor.putInt("maxRate",maxRate);// 0- значение по умолчанию
        storeDataEditor.commit();


    }

    public void addCurrentRate(View view) {
       currentRate++;
        currentRateView.setText(""+currentRate);
        if (maxRate  < currentRate ){
            maxRate=currentRate;
        }
        maxRateView.setText(""+maxRate);

    }
    public void clearCurrentRate(View view) {
        currentRate=0;
        currentRateView.setText(""+currentRate);
        // запись в файл SharedPreferences
        SharedPreferences storeData=getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor  storeDataEditor=storeData.edit();
        storeDataEditor.putInt("currentRate",currentRate);// 0- значение по умолчанию
        storeDataEditor.putInt("maxRate",maxRate);// 0- значение по умолчанию
        storeDataEditor.commit();

    }
    public void clearAllRate(View view) {
        currentRate=0;
        currentRateView.setText(""+currentRate);
        maxRate=0;
        maxRateView.setText(""+maxRate);
        // запись в файл SharedPreferences
        SharedPreferences storeData=getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor  storeDataEditor=storeData.edit();
        storeDataEditor.putInt("currentRate",currentRate);// 0- значение по умолчанию
        storeDataEditor.putInt("maxRate",maxRate);// 0- значение по умолчанию
        storeDataEditor.commit();

    }


  
}
