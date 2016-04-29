package com.example.bigbrass;

import android.view.Window;
import android.view.WindowManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.bigbrass.chunky.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //set content view AFTER ABOVE sequence (to avoid crash)
        setContentView(R.layout.activity_main);

    }
}