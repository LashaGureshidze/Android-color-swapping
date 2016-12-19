package com.example.lasha.homework1;

import android.graphics.Color;
import android.os.Handler;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * Created by lasha on 3/9/2015.
 */
public class BackGroundAnimator {
    private View view;
    private int[] colorSet;

    private Timer timer;
    private final Handler handler;

    /**
     * Initialize BackGroundColorAnimator
     * @param view this view will change background color
     */
    public BackGroundAnimator(View view) {
        this.view = view;
        this.colorSet = new int[]{Color.RED, Color.GREEN, Color.BLUE};  //default colorSet
        this.handler = new Handler();
    }

    /**
     * Initialize BackGroundColorAnimator
     * @param view this view will change background color
     * @param colorSet colorSet which will be background of view
     */
    public BackGroundAnimator(View view, int[] colorSet) {
        this.view = view;
        this.colorSet = colorSet;
        this.handler = new Handler();
    }

    /**
     * cancel background color animations.
     */
    public void cancelAnimator() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    /**
     * start background color animation
     * @param milliSeconds schedule time in milliseconds
     */
    public void startAnimator(int milliSeconds) {
        cancelAnimator();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 0, milliSeconds);
    }



    private final Runnable runnable = new Runnable() {
        int color = 0;
        @Override
        public void run() {
            view.setBackgroundColor(colorSet[color]);
            color = (color + 1) % colorSet.length;
        }
    };



}
