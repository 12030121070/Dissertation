/**
 * 
 */
package com.sj.jsondemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author Saloni
 *
 */
public class Login extends Activity{
	private Button Login;
	private Button Register;
	private EditText PRN;
	private EditText PSWD;
	@Override
	public void onCreate(Bundle savedInstanceState) {

	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.layout_login);
	    Register = (Button) findViewById(R.id.register);
        Login = (Button) findViewById(R.id.login);
        PRN = (EditText) findViewById(R.id.prn);
        PSWD = (EditText) findViewById(R.id.password);
OnClickListener listener1 = new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
				Intent intent = new Intent(getApplicationContext(), Register.class);
				startActivity(intent);
			
		
	}
};
OnClickListener listener2 = new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String username = PRN.getText().toString();
		String password = PSWD.getText().toString();
		String regex = "[0-9]+";
		if(username.equals("") || username.matches(regex)==false)
		{
			Toast.makeText(getApplicationContext(), "INVALID", Toast.LENGTH_LONG).show();
		}
		else
		{		double prn = Double.parseDouble(username);
				double psw = Double.parseDouble(password);

			if(prn>=10000000000d && prn<100000000000d)
			{
				if(prn==psw){
					Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
					startActivity(intent2);
				}
			}
			
		}
		
		
	}
};
Register.setOnClickListener(listener1);
	Login.setOnClickListener(listener2);

}
}

