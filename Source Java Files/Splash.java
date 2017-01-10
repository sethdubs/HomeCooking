package edu.auburn.eng.csse.comp3710;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Seth Williams on 5/2/2016.
 */
public class Splash extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        int secondsDelayed = 3;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Splash.this, HomeCookingActivity.class));
                finish();
            }
        }, secondsDelayed * 1000);
    }
}
