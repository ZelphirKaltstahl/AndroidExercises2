package com.example.xiaolong.exercises.exercise_03_inter_activity_data_exchange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.example.xiaolong.exercises.R;

public class Exercise_03_AlignmentSelectionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_03__alignment_selection);
    }

    public void on_left(View view) {
        set_and_finish(Gravity.START);
    }
    public void on_center(View view) {
        set_and_finish(Gravity.CENTER);
    }
    public void on_right(View view) {
        set_and_finish(Gravity.END);
    }

    private void set_and_finish(int alignment) {
        Intent return_intent = new Intent();
        return_intent.putExtra("alignment", alignment);
        setResult(Activity.RESULT_OK, return_intent);
        finish();
    }
}
