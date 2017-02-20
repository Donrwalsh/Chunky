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
        int d20Roll = d20.nextInt(20) + 1;

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
            notif.append("You rolled a 7:\n Apostrophes toggles\n(May God have mercy on your soul)\n");
            ImageView apost = (ImageView) findViewById(R.id.apostrophes);
            if (apost.getTag().toString().equals("off")) {
                apost.setImageResource(R.drawable.rapost);
                apost.setTag("on");
            } else {
                apost.setImageResource(R.drawable.gapost);
                apost.setTag("off");
            }
        }
        if (d20Roll == 8) {notif.append("You rolled an 8:\n Names toggles");
            ImageView names = (ImageView) findViewById(R.id.names);
            if (names.getTag().toString().equals("off")){
                names.setImageResource(R.drawable.rnames);
                names.setTag("on");
            } else {
                names.setImageResource(R.drawable.gnames);
                names.setTag("off");
            }
        }
        if (d20Roll == 9) {notif.append("You rolled a 9:\n Cursin's toggles\n");
            notif.append("(Ass, Damn, Shit, Fuck, Bitch, Cactus)");
            ImageView cursin = (ImageView) findViewById(R.id.cursin);
            if (cursin.getTag().toString().equals("off")){
                cursin.setImageResource(R.drawable.rcursin);
                cursin.setTag("on");
            } else {
                cursin.setImageResource(R.drawable.gcursin);
                cursin.setTag("off");
            }
        }
        if (d20Roll == 10) {notif.append("You rolled a 10:\n FaceTouching toggles\n");
            ImageView facetouching = (ImageView) findViewById(R.id.facetouching);
            if (facetouching.getTag().toString().equals("off")){
                facetouching.setImageResource(R.drawable.rfacet);
                facetouching.setTag("on");
            } else {
                facetouching.setImageResource(R.drawable.gcursin);
                facetouching.setTag("off");
            }
        }
        if (d20Roll == 11) {notif.append("You rolled an 11:\n Drink-in-Hand toggles\n");
            ImageView drinkinhand = (ImageView) findViewById(R.id.drinkinhand);
            if (drinkinhand.getTag().toString().equals("off")){
                drinkinhand.setImageResource(R.drawable.rdih);
                drinkinhand.setTag("on");
            } else {
                drinkinhand.setImageResource(R.drawable.gdih);
                drinkinhand.setTag("off");
            }
        }
        if (d20Roll == 12) {notif.append("You rolled an 12:\n Accents toggles\n");
            ImageView accents = (ImageView) findViewById(R.id.accents);
            if (accents.getTag().toString().equals("off")){
                accents.setImageResource(R.drawable.rdih);
                accents.setTag("on");
            } else {
                accents.setImageResource(R.drawable.gdih);
                accents.setTag("off");
            }
        }
        if (d20Roll == 13) {notif.append("You rolled a 13:\n You are now the drink and trash bitch\n");}
        if (d20Roll == 14) {notif.append("You rolled a 14:\n Never-have-I-ever, 3 fingers\n");}
        if (d20Roll == 15) {notif.append("You rolled a 15:\n Social!\n");}
        if (d20Roll == 16) {notif.append("You rolled a 16:\n Rhymes, filthy filthy rhymes\n");}
        if (d20Roll == 17) {notif.append("You rolled a 17:\n Ladies, take a drink!\n");}
        if (d20Roll == 18) {notif.append("You rolled an 18:\n Fellas, take a drink!\n");}
        if (d20Roll == 19) {notif.append("You rolled a 19:\n Make a rule!\n");}
        if (d20Roll == 20) {notif.append("You rolled a 20:\n Chunky Cup. May God have mercy on your soul\n");}



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

    @Override
    public void onBackPressed() {
        // do nothing. We want to force user to stay in this activity and not drop out.
    }

}
