package com.example.xiaolong.exercises.exercise_03_inter_activity_data_exchange;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.xiaolong.exercises.R;

public class Exercise_03_ColorSelectionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_03__color_selection);
    }

    public void on_red(View view) {
        set_and_finish(Color.RED);
    }

    public void on_green(View view) {
        set_and_finish(Color.GREEN);
    }

    public void on_blue(View view) {
        set_and_finish(Color.BLUE);
    }

    private void set_and_finish(int color) {
        Intent return_intent = new Intent();
        return_intent.putExtra("color", color);
        setResult(Activity.RESULT_OK, return_intent);
        finish();
    }
}
