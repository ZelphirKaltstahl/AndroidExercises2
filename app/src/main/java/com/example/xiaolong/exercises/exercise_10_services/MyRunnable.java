package com.example.xiaolong.exercises.exercise_10_services;

import android.util.Log;

/**
 * Created by xiaolong on 1/28/16.
 */
public class MyRunnable implements Runnable {

    private static final String LOG_TAG = "MyRunnable";

    private int delay;
    private int id;
    private MyService parent;

    public MyRunnable(int delay, int id, MyService parent) {
        this.delay = delay;
        this.id = id;
        this.parent = parent;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parent.signal_finished(id);
        //Log.d(MyRunnable.LOG_TAG, "Thread #" + id + " finished.");

    }
}
