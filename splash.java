//splash screen 
//1 screen to get open.
package com.example.lostphoneapp;

import com.example.settext.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash extends Activity {

private static int SPLASH_TIME_OUT = 3000;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main3);


new Handler().postDelayed(new Runnable() {
@Override
public void run() {
	//go to the next screen i.e. main activity
Intent i = new Intent(splash.this, MainActivity.class);
startActivity(i);
finish();
}
}, SPLASH_TIME_OUT);
}
}
