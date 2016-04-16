package com.example.xiaolong.exercises;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Activity_01_Debugging extends Activity {

    public static final String LOG_TAG = "Activity 01 Logging";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_01__logging);
    }

    public void log(View view) {
        Log.d(Activity_01_Debugging.LOG_TAG, "Debugging using Log.d!");
    }

    public void toast(View view) {
        Toast.makeText(this, "Debugging using Toast", Toast.LENGTH_SHORT).show();
    }
}
