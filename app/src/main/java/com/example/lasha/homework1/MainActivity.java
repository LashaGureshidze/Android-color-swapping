package com.example.lasha.homework1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity {
    private LinearLayout mainLayout;
    private BackGroundAnimator backGroundAnimator;
    private int buttonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (LinearLayout) findViewById(R.id.main_layout);
        backGroundAnimator = new BackGroundAnimator(mainLayout);

        if (savedInstanceState != null) {
            buttonId = savedInstanceState.getInt("buttonId");
            changeBackground(buttonId);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("buttonId", buttonId);
    }

    public void onButtonClick(View v) {
        backGroundAnimator.cancelAnimator();
        buttonId = v.getId();
        changeBackground(buttonId);
    }

    private void changeBackground(int buttonId) {
        switch (buttonId) {
            case R.id.white_button :
                mainLayout.setBackgroundColor(Color.WHITE);
                break;
            case R.id.red_button :
                mainLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.grey1_button :
                mainLayout.setBackgroundColor(Color.GRAY);
                break;
            case R.id.green_button :
                mainLayout.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue_button :
                mainLayout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.police_button :
                backGroundAnimator.startAnimator(40);
                break;
        }
    }

}
