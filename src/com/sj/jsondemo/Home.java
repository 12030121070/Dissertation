package com.sj.jsondemo;

import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

public class Home extends Activity{
	
//private ProgressDialog dialog;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.activity_home);        
        
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        int prn=globalVariable.getBid();
        String p=String.valueOf(prn);
        Toast.makeText(getApplicationContext(), p, Toast.LENGTH_LONG).show();
        
    }

}
