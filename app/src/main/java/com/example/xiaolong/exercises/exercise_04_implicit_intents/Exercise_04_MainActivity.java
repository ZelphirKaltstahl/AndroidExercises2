package com.example.xiaolong.exercises.exercise_04_implicit_intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.xiaolong.exercises.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exercise_04_MainActivity extends Activity {

    private static final String LOG_TAG = "Exercise04";
    private static final String ACTION_STRING_SHOW_DATETIME = "com.example.xiaolong.SHOW_DATETIME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_04__main);
    }

    public void on_show_datetime(View view) {
        Intent intent = new Intent(Exercise_04_MainActivity.ACTION_STRING_SHOW_DATETIME);
        intent.putExtra("datetime", get_time_now());
        send_intent(intent);
    }

    private String get_time_now() {
        SimpleDateFormat simple_date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simple_date_format.format(new Date());
    }

    private void send_intent(Intent intent) {
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d(
                    Exercise_04_MainActivity.LOG_TAG,
                    "Did not find any activity suitable for handling the implizit intent with action string: \"" + Exercise_04_MainActivity.ACTION_STRING_SHOW_DATETIME + "\""
            );
        }
    }
}
