package com.example.xiaolong.exercises.exercise_03_inter_activity_data_exchange;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiaolong.exercises.R;

public class Exercise_03_MainActivity extends Activity {

    private static final String LOG_TAG = "Exercise03";

    private static final int COLOR_REQUEST_CODE = 0;
    private static final int ALIGNMENT_REQUEST_CODE = 1;
    private static final int FONT_REQUEST_CODE = 2;
    private static final int TEST_REQUEST_CODE = 3;

    public TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_03__main_);

        textview = (TextView) findViewById(R.id.exercise_03_textview);
    }

    public void on_color(View view) {
        Intent open_color_activity_intent = new Intent(this, Exercise_03_ColorSelectionActivity.class);
        startActivityForResult(open_color_activity_intent, Exercise_03_MainActivity.COLOR_REQUEST_CODE);
    }

    public void on_alignment(View view) {
        Intent open_alignment_activity_intent = new Intent(this, Exercise_03_AlignmentSelectionActivity.class);
        startActivityForResult(open_alignment_activity_intent, Exercise_03_MainActivity.ALIGNMENT_REQUEST_CODE);
    }

    public void on_font(View view) {
        Intent open_font_activity_intent = new Intent(this, Exercise_03_FontSelectionActivity.class);
        startActivityForResult(open_font_activity_intent, Exercise_03_MainActivity.FONT_REQUEST_CODE);
    }

    public void on_test(View view) {
        Intent open_test_activity_intent = new Intent(this, Exercise_03_TestActivity.class);
        open_test_activity_intent.putExtra("string", textview.getText().toString());
        startActivityForResult(open_test_activity_intent, Exercise_03_MainActivity.TEST_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Exercise_03_MainActivity.COLOR_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                int color = data.getIntExtra("color", Color.BLACK);
                set_color(color);
            } else {
                Log.d(Exercise_03_MainActivity.LOG_TAG, "data did not have a color extra.");
            }
        } else if(requestCode == Exercise_03_MainActivity.ALIGNMENT_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                int alignment = data.getIntExtra("alignment", Gravity.CENTER);
                set_alignment(alignment);
            } else {
                Log.d(Exercise_03_MainActivity.LOG_TAG, "data did not have an alignment extra.");
            }
        } else if(requestCode == Exercise_03_MainActivity.FONT_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data.hasExtra("font")) {
                    int fontsize = data.getIntExtra("font", Typeface.NORMAL);
                    Log.d(Exercise_03_MainActivity.LOG_TAG, "Got font size: " + fontsize);
                    set_fontsize(fontsize);
                } else {
                    Log.d(Exercise_03_MainActivity.LOG_TAG, "data did not have a font extra.");
                }
            }
        } else if(requestCode == Exercise_03_MainActivity.TEST_REQUEST_CODE) {
            Boolean test_isnumber;
            Boolean test_isempty;

            if (resultCode == Activity.RESULT_OK) {
                if (data.hasExtra("isnumber")) {
                    test_isnumber = data.getBooleanExtra("isnumber", false);
                    Log.d(Exercise_03_MainActivity.LOG_TAG, "Is it a number? " + test_isnumber);
                    toast_test_result_isnumber(test_isnumber);
                } else if (data.hasExtra("isempty")) {
                    test_isempty = data.getBooleanExtra("isempty", false);
                    Log.d(Exercise_03_MainActivity.LOG_TAG, "Is it empty? " + test_isempty);
                    toast_test_result_isempty(test_isempty);
                } else {
                    Log.d(Exercise_03_MainActivity.LOG_TAG, "data did not have a test extra.");
                }
            }
        }
    }

    private void set_color(int color) {
        textview.setTextColor(color);
    }

    private void set_alignment(int alignment) {
        textview.setGravity(alignment);
    }

    private void set_fontsize(int size) {
        textview.setTextSize(TypedValue.COMPLEX_UNIT_PT, size);
//        textview.setTypeface(textview.getTypeface(), typeface);
    }

    private void toast_test_result_isnumber(boolean isnumber) {
        if (isnumber) {
            Toast.makeText(this, "The text is a number.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "The text is not a number.", Toast.LENGTH_SHORT).show();;
        }
    }

    private void toast_test_result_isempty(boolean isempty) {
        if (isempty) {
            Toast.makeText(this, "The text is empty.", Toast.LENGTH_SHORT).show();;
        } else {
            Toast.makeText(this, "The text is not empty.", Toast.LENGTH_SHORT).show();;
        }

    }
}
