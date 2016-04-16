package com.example.xiaolong.exercises.exercise_03_inter_activity_data_exchange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.xiaolong.exercises.R;

public class Exercise_03_FontSelectionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_03__font_selection);
    }

    public void on_small(View view) {
        set_and_finish(12);
    }

    public void on_medium(View view) {
        set_and_finish(24);
    }

    public void on_large(View view) {
        set_and_finish(32);
    }

    private void set_and_finish(int fontsize) {
        Intent return_intent = new Intent();
        return_intent.putExtra("font", fontsize);
        setResult(Activity.RESULT_OK, return_intent);
        finish();
    }
}
