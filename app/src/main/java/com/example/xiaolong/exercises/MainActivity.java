package com.example.xiaolong.exercises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.xiaolong.exercises.exercise_03_inter_activity_data_exchange.Exercise_03_MainActivity;
import com.example.xiaolong.exercises.exercise_04_implicit_intents.Exercise_04_MainActivity;
import com.example.xiaolong.exercises.exercise_05_landscape_and_portrait_layout.Exercise_05_MainActivity;
import com.example.xiaolong.exercises.exercise_06_listview.Exercise_06_MainActivity;
import com.example.xiaolong.exercises.exercise_07_many_intents.Exercise_07_MainActivity;
import com.example.xiaolong.exercises.exercise_10_services.Exercise_10_MainActivity;

public class MainActivity extends Activity {

    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open_debugging_activity(View view) {
        Intent open_debugging_activity_intent = new Intent(this, Activity_01_Debugging.class);
        startActivity(open_debugging_activity_intent);

    }

    public void open_event_handling_activity(View view) {
        Intent open_event_handling_activity_intent = new Intent(this, Activity_02_EventHandling.class);
        startActivity(open_event_handling_activity_intent);

    }

    public void open_simple_calculator_activity(View view) {
        Intent open_simple_calculator_activity_intent = new Intent(this, Activity_03_Simple_Calculator.class);
        startActivity(open_simple_calculator_activity_intent);
    }

    public void open_contextual_action_mode_activity(View view) {
        Intent open_contextual_action_mode_activity_intent = new Intent(this, Activity_04_Contextual_Action_Mode.class);
        startActivity(open_contextual_action_mode_activity_intent);
    }

    public void open_context_menu_activity(View view) {
        Intent open_context_menu_activity_intent = new Intent(this, Activity_05_Context_Menu.class);
        startActivity(open_context_menu_activity_intent);
    }

    public void open_exercise_03_activity(View view) {
        Intent open_exercise_03_activity_intent = new Intent(this, Exercise_03_MainActivity.class);
        startActivity(open_exercise_03_activity_intent);
    }

    public void open_exercise_04_activity(View view) {
        Intent open_exercise_04_activity_intent = new Intent(this, Exercise_04_MainActivity.class);
        startActivity(open_exercise_04_activity_intent);
    }

    public void open_exercise_05_activity(View view) {
        Intent open_exercise_05_activity_intent = new Intent(this, Exercise_05_MainActivity.class);
        startActivity(open_exercise_05_activity_intent);
    }

    public void open_exercise_06_activity(View view) {
        Intent open_exercise_06_activity_intent = new Intent(this, Exercise_06_MainActivity.class);
        startActivity(open_exercise_06_activity_intent);
    }

    public void open_exercise_07_activity(View view) {
        Intent open_exercise_07_activity_intent = new Intent(this, Exercise_07_MainActivity.class);
        startActivity(open_exercise_07_activity_intent);
    }

    public void open_exercise_10_activity(View view) {
        Intent open_exercise_10_activity_intent = new Intent(this, Exercise_10_MainActivity.class);
        startActivity(open_exercise_10_activity_intent);
    }
}
