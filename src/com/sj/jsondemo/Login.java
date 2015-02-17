/**
 * 
 */
package com.sj.jsondemo;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
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
public class Login extends Activity implements FetchDataListener{
	
	private ProgressDialog dialog;
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
		// When Login button is clicked, we validate inputs
		
		String username = PRN.getText().toString();
		String password = PSWD.getText().toString();
		
		String regex = "[0-9]+";
		if(username.equals("") || username.matches(regex)==false)
		{
			Toast.makeText(getApplicationContext(), "INVALID", Toast.LENGTH_LONG).show();
		}
		else
		{		long prn = Long.parseLong(username);
				long psw = Long.parseLong(password);

			if(prn>=10000000000d && prn<100000000000d)
			{
				if(prn==psw){
					
					//dialog = ProgressDialog.show(getApplicationContext(), "", "Loading...");
					String url = "http://172.20.10.7:8888/login.php?prn="+String.valueOf(prn);
					//FetchDataTask task = new FetchDataTask(getActivity().getContext(),getApplicationContext());
			        //task.execute(url);
					
					
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					globalVariable.setPrn(prn);
					int bid=(int) (prn/1000000000);
					globalVariable.setBid(bid);
					int pid=(int) ((prn%100000)/1000);
					globalVariable.setPid(pid);
					
					Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
					intent2.putExtra("PRN", prn);
					startActivity(intent2);
				}
			}
			
		}
		
		
	}
};
Register.setOnClickListener(listener1);
	Login.setOnClickListener(listener2);

}

	@Override
	public void onFetchComplete(List<Application> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFetchFailure(String msg) {
		// TODO Auto-generated method stub
		
	}
}

