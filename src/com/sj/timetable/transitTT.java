package com.sj.timetable;

import java.util.List;

import com.sj.jsondemo.Application;
import com.sj.jsondemo.GlobalClass;
import com.sj.jsondemo.MainActivity;
import com.sj.jsondemo.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class transitTT extends Activity implements TimetableVariableListener{

	private ProgressDialog dialog;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.transit);        
        initView();  
	}
	
	private void initView() {
        
    	// show progress dialog
         dialog = ProgressDialog.show(this, "", "Loading...");
        
        final GlobalClass g = (GlobalClass) getApplicationContext();
	    String addr=g.server_addr;
        String url = addr+"/batch_info.php?prn="+g.getPrn();
        
        TimetableVariableDataFetch task = new TimetableVariableDataFetch(this);
        task.execute(url);
    }
	
	@Override
	public void onFetchComplete(List<TimetableVariables> data) {
		// TODO Auto-generated method stub
		
		final GlobalClass g=(GlobalClass) getApplicationContext();
		
        // create new adapter
        TimetableVariables app= data.get(0);
        
        if(app!=null)
        {
        	
        	//g.setBid(app.getBid());
        	g.setDid(app.getDid());
        	//g.setPid(app.getPid());
        	g.setBatch(app.getBname());
        	g.setProgram(app.getPname());
        	g.setDname(app.getDname());
        	
        }
        
        if(dialog != null)  dialog.dismiss();
        Intent i=new Intent(getApplicationContext(), Timetable_main_index.class);
        startActivity(i);
		
	}

	@Override
	public void onFetchFailure(String msg) {
		
		if(dialog != null)  dialog.dismiss();
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        Intent i=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
		
	}

}
