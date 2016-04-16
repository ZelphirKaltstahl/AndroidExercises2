package com.example.xiaolong.exercises.exercise_03_inter_activity_data_exchange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.xiaolong.exercises.R;

public class Exercise_03_TestActivity extends Activity {

    private static final String LOG_TAG = "Exercise03TestActivity";
    private String string_to_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_03__test);
        if (getIntent().hasExtra("string")) {
            string_to_test = getIntent().getStringExtra("string");
        } else {
            Log.d(Exercise_03_TestActivity.LOG_TAG, "intent did not contain key \"string\"");
        }
    }

    public void on_isnumber(View view) {
        boolean result = false;

        try {
            Double.parseDouble(string_to_test);
            result = true;
        } catch (NumberFormatException ex) {
            // do nothing
        }

        Intent return_intent = new Intent();
        return_intent.putExtra("isnumber", result);
        setResult(Activity.RESULT_OK, return_intent);
        finish();
    }

    public void on_isempty(View view) {
        boolean result = false;
        if(string_to_test != null && string_to_test.isEmpty()) {
            result = true;
        }

        Intent return_intent = new Intent();
        return_intent.putExtra("isempty", result);
        setResult(Activity.RESULT_OK, return_intent);
        finish();
    }



}
