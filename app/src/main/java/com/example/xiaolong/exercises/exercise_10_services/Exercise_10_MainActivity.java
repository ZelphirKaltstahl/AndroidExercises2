package com.example.xiaolong.exercises.exercise_10_services;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.xiaolong.exercises.R;

import java.util.ArrayList;

public class Exercise_10_MainActivity extends Activity {

    private static final String LOG_TAG ="Exercise10";
    private ProgressBar progress_bar;
    private ArrayList<Integer> delays;
    private MyReceiver my_receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(Exercise_10_MainActivity.LOG_TAG, "creating activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_10__main);

        progress_bar = (ProgressBar) findViewById(R.id.exercise_10_progressbar);

        delays = new ArrayList<>();
        delays.add(1000);
        delays.add(4000);
        delays.add(2000);
        delays.add(5000);

        register_for_broadcast();
    }

    private void register_for_broadcast() {
        Log.d(Exercise_10_MainActivity.LOG_TAG, "registering for broadcasted intents");
        IntentFilter intent_filter = new IntentFilter(MyService.PROGRESS_UPDATE_ACTION_STRING);
        my_receiver = new MyReceiver();
        registerReceiver(my_receiver, intent_filter);
        Log.d(Exercise_10_MainActivity.LOG_TAG, "registered receiver for broadcasted intents");
    }

    public void on_start_service(View view) {
        set_progress(0);
        Log.d(Exercise_10_MainActivity.LOG_TAG, "starting service");
        Intent service_intent = new Intent(this, MyService.class);
        service_intent.putIntegerArrayListExtra("delays", delays);
        startService(service_intent);
        Log.d(Exercise_10_MainActivity.LOG_TAG, "service running");
    }

    @Override
    public void onResume() {
        Log.d(Exercise_10_MainActivity.LOG_TAG, "resuming");
        super.onResume();
    }

    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(Exercise_10_MainActivity.LOG_TAG, "received broadcast");
            //this method receives broadcast messages. Be sure to modify AndroidManifest.xml file in order to enable message receiving
            Double total_progress = intent.getDoubleExtra("total_progress", 0.0);
            Log.d(Exercise_10_MainActivity.LOG_TAG, "updating progress bar");
            set_progress(total_progress.intValue());
            Log.d(Exercise_10_MainActivity.LOG_TAG, "progress bar set to " + total_progress + "%");
        }
    }

    private void set_progress(int progress) {
        progress_bar.setProgress(progress);
    }
}
