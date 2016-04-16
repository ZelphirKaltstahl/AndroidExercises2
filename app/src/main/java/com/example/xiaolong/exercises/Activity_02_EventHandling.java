package com.example.xiaolong.exercises;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity_02_EventHandling extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_02__event_handling);
    }

    public void on_click(View view) {
        Toast.makeText(this, "Event handled!", Toast.LENGTH_SHORT).show();
    }
}
