package com.example.bigbrass;

import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.bigbrass.chunky.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void openAbout(View view)
    {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void openGameScreen(View view)
    {
        Intent intent = new Intent(this, GameScreen.class);
        startActivity(intent);
    }


}