package com.sj.jsondemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

public class Register extends Activity{
	private ProgressDialog dialog;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.layout_register);
	    dialog = ProgressDialog.show(this, "", "Loading...");  
    }

}
