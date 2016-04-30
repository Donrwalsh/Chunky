package com.example.bigbrass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import java.util.Random;
import android.view.View;
import android.widget.TextView;


import com.example.bigbrass.chunky.R;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_game_screen);
    }

    public void randomInt(View view)
    {
        final Random d6 = new Random();
        int d6Roll = d6.nextInt(6) + 1;
        TextView random = (TextView)findViewById(R.id.textViewd6);
        random.setText("d6:" + d6Roll);

        final Random d20 = new Random();
        int d20Roll = d20.nextInt(20) + 1;
        TextView random20 = (TextView)findViewById(R.id.textViewd20);
        random20.setText("d20:" + d20Roll);

        final Random d2 = new Random();
        int d2Roll = d2.nextInt(2) + 1;
        TextView random2 = (TextView)findViewById(R.id.textViewcoin);
        random2.setText("d2:" + d2Roll);

    }
}
