package com.example.xiaolong.exercises.exercise_10_services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyService extends Service {

    private static final String LOG_TAG = "MyService";
    public static final String PROGRESS_UPDATE_ACTION_STRING = "com.example.xiaolong.SERVICE_STATUS_UPDATE";
    private ArrayList<Integer> delays;

    private ExecutorService task_executor;

    private double total_progress = 0.0;

    @Override
    public void onCreate() {
        super.onCreate();
        task_executor = Executors.newFixedThreadPool(2);
    }

    /**
     * Could be called multiple times!
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        total_progress = 0.0;
        Log.d(MyService.LOG_TAG, "onStartCommand");
        this.delays = intent.getIntegerArrayListExtra("delays");
//        task_executor = Executors.newFixedThreadPool(2);
        some_task();
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * This is where the logic happens!
     */
    public void some_task() {
        Log.d(MyService.LOG_TAG, "some_task");
        for (int i = 0; i < delays.size(); i++) {
            MyRunnable my_runnable = new MyRunnable(delays.get(i), i, this);
            task_executor.execute(my_runnable);
        }
//        task_executor.shutdown();
//        try {
//            task_executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS); // blocking
//            Log.d(MyService.LOG_TAG, "All tasks completed.");
//
//        } catch (InterruptedException e) {
//            Log.d(MyService.LOG_TAG, "Interrupted while awaiting termination of ExecutorService");
//        }
    }

    @Override
    public void onDestroy() {
        task_executor.shutdown();
        try {
            task_executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Log.d(MyService.LOG_TAG, "Interrupted while awaiting termination of ExecutorService");
        }
    }

    public void signal_finished(int id) {
        total_progress += (100.0 / delays.size()) % 101;
        announce_progress();
    }

    private void announce_progress() {
        //this method sends broadcast messages
        Intent intent = new Intent(MyService.PROGRESS_UPDATE_ACTION_STRING);
        intent.putExtra("total_progress", total_progress);
        sendBroadcast(intent);
    }
}
