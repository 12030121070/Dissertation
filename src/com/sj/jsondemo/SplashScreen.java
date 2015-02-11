package com.sj.jsondemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class SplashScreen extends Activity{ 
	public ProgressDialog myDialog; 

@Override
public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash_screen);

    new Handler().postDelayed(new Runnable() {

        public void run() { 
            myDialog = ProgressDialog.show(SplashScreen.this,"", "Loading", true);

            Intent intent=new Intent(SplashScreen.this, Login.class);
            SplashScreen.this.startActivity(intent);
            myDialog.dismiss();
            SplashScreen.this.finish();     
        }

    }, 10000);// 3 Seconds
}

};
