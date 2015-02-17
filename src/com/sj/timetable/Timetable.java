package com.sj.timetable;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.sj.jsondemo.Application;
import com.sj.jsondemo.GlobalClass;
import com.sj.jsondemo.MainActivity;
import com.sj.jsondemo.R;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Timetable extends Activity implements FetchDataListener{

			
	private ProgressDialog dialog;
	private String menucat="starters_VEG";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.timetables1);        
        initView(menucat);   
        
        String weekDay;
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());

        Calendar calendar = Calendar.getInstance();
        weekDay = dayFormat.format(calendar.getTime());
        
        Toast.makeText(getApplicationContext(), weekDay, Toast.LENGTH_LONG).show();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inft=getMenuInflater();
    inft.inflate(R.menu.main, menu);
    return(super.onCreateOptionsMenu(menu));
    
    
    }
        @Override
        public boolean onOptionsItemSelected(MenuItem mitem){
        	switch(mitem.getItemId()){
      	
        	case R.id.home: menucat="home"; 
        					Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
        					startActivity(intent2);
        					break;
        	        	
        	case R.id.TimeTable: menucat="TimeTable"; break;
        		
        	case R.id.MyGroups: menucat="MyGroups";break;
        	
        	case R.id.E_NoticeBoard: menucat="E-Notice Board";break;
        	
        	case R.id.News: menucat="News";break;
        	
        	case R.id.Settings: menucat="Settings";break;
        	    		
        	}
        	initView(menucat);
        	return(super.onOptionsItemSelected(mitem));
        }

    private void initView(String mc) {
        
    	// show progress dialog
        // dialog = ProgressDialog.show(this, "", "Loading...");
        
        final GlobalClass g = (GlobalClass) getApplicationContext();
	    String addr=g.server_addr;
        String url = addr+"/tt.php";
        
        FetchDataTask task = new FetchDataTask(this);
        task.execute(url);
    }
    
    @Override
    public void onFetchComplete(List<ClassInfo> data) {
        
    	// dismiss the progress dialog
        if(dialog != null)  dialog.dismiss();
        
        int s=data.size();
        for(int a=0;a<s;a++)
        {
        	ClassInfo app= data.get(a);
        	
        	if(app != null)
        	{
            	//Toast.makeText(getApplicationContext(), String.valueOf(app.getSessionid()),Toast.LENGTH_LONG).show();
            	
        		Float f=app.getSessionid();
        		int i=(int) (f*10);
            	String r=String.valueOf(i);
            	
            	int bId = getResources().getIdentifier("a"+r, "id", getPackageName());
            	TextView myText = (TextView) findViewById(bId);
            	String teachr=app.getTeacher();
            	String ini="";
            	for (String initials: teachr.split(" ",2)){
                    ini=ini+(initials.substring(0, 1))+".";
                 }
            	myText.setText(app.getSubjName()+"  "+ini);
            	
            	/*
                TextView titleText = (TextView) findViewById(r);
                TextView prn = (TextView) findViewById(R.id.u_prn);
                //TableLayout ratingCntr = (TableLayout)v.findViewById(R.id.table1);
                TextView dlText = (TextView) findViewById(R.id.username);
                
                
                if(timetable !=null)
                {
                	OnClickListener l=new OnClickListener(){

                		@Override
                		public void onClick(View v2) {
                			
        				// TODO Auto-generated method stub
        				Intent intent=new Intent(getApplicationContext(), Timetable.class);
        	            startActivity(intent);
                		}
                };
                timetable.setOnClickListener(l);
                }
                
                if(prn !=null) prn.setText(String.valueOf(globalVariable.getPrn()));
                
                
                if(titleText != null) titleText.setText(app.getName());
                
                if(dlText != null) {
                    NumberFormat nf = NumberFormat.getNumberInstance();
                    dlText.setText((app.getUsername()));            
                }
            //ApplicationAdapter adapter = new ApplicationAdapter(this, data);
            // set the adapter to list
            //setListAdapter(adapter); 
             */  
            }
        }
        
        // create new adapter
        //ApplicationAdapter adapter = new ApplicationAdapter(this, data);
        // set the adapter to list
        //setListAdapter(adapter);       
    }

    @Override
    public void onFetchFailure(String msg) {
        
        // dismiss the progress dialog
        
        if(dialog != null)  dialog.dismiss();
        // show failure message
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();        
        
    }

}
