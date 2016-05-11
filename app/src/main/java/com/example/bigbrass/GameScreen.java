package com.example.bigbrass;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import java.util.Random;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;


import com.example.bigbrass.chunky.R;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_screen);




        //Sensor stuff:
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        mAccel = 0.00f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;
    }

    public void Guess(View view)
    {
        final Random d2 = new Random();
        final Random d6 = new Random();
        final Random d20 = new Random();
        int d2Roll = d2.nextInt(2) + 1;
        int d6Roll = d6.nextInt(6) + 1;
        int d20Roll = d20.nextInt(8) + 1;

        TextView notif = (TextView) findViewById(R.id.notif);
        if (d2Roll == 1) {
            notif.setText("WRONG! \n You drink " + d6Roll + "!\n\n");
        } else {
            notif.setText("CORRECT! \n Dealer drinks " + d6Roll + "!\n\n");
        }
        Button heads = (Button) findViewById(R.id.heads);
        Button tails = (Button) findViewById(R.id.tails);
        heads.setVisibility(View.INVISIBLE);
        tails.setVisibility(View.INVISIBLE);
        if (d20Roll == 1) {notif.append("You rolled a 1:\n Dirty Categories");}
        if (d20Roll == 2) {notif.append("You rolled a 2:\n Nose-Goes, Drink 4!");}
        if (d20Roll == 3) {notif.append("You rolled a 3:\n Waterfall, sounds good");}
        if (d20Roll == 4) {notif.append("You rolled a 4:\n Call or text a friend and tell them to drink. No excuses, play like a champion!");}
        if (d20Roll == 5) {notif.append("You rolled a 5:\n Explosive Revelation! ");}
        if (d20Roll == 6) {notif.append("You rolled a 6:\n Clothes, article of, non-dealer)");}
        if (d20Roll == 7) {
            notif.append("You rolled a 7:\n Apostrophes\n(May God have mercy on your soul)\n");
            ImageView apost = (ImageView) findViewById(R.id.apostrophes);
            if (apost.getTag().toString().equals("off")) {
                apost.setImageResource(R.drawable.rapost);
                apost.setTag("on");
            } else {
                apost.setImageResource(R.drawable.gapost);
                apost.setTag("off");
            }
        }
        if (d20Roll == 8) {notif.append("You rolled an 8:\n Names, No present");
            ImageView names = (ImageView) findViewById(R.id.names);
            if (names.getTag().toString().equals("off")){
                names.setImageResource(R.drawable.rnames);
                names.setTag("on");
            } else {
                names.setImageResource(R.drawable.gnames);
                names.setTag("off");
            }
        }

    }

    /* put this into your activity class */
    private SensorManager mSensorManager;
    private float mAccel; // acceleration apart from gravity
    private float mAccelCurrent; // current acceleration including gravity
    private float mAccelLast; // last acceleration including gravity

    private final SensorEventListener mSensorListener = new SensorEventListener() {

        public void onSensorChanged(SensorEvent se) {
            float x = se.values[0];
            float y = se.values[1];
            float z = se.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta; // perform low-cut filter
            float t = 1;

            if (mAccel > 15) {
                Button heads = (Button) findViewById(R.id.heads);
                Button tails = (Button) findViewById(R.id.tails);
                heads.setVisibility(View.VISIBLE);
                tails.setVisibility(View.VISIBLE);
                TextView notif = (TextView) findViewById(R.id.notif);
                notif.setText("");




            }


        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mSensorListener);
        super.onPause();

    }
}
