package com.sj.jsondemo;

import java.text.NumberFormat;
import java.util.List;

import com.sj.groups.Groups;
import com.sj.timetable.Timetable;
import com.sj.timetable.transitTT;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements FetchDataListener{
    
		
	private ProgressDialog dialog;
    private String menucat="starters_VEG";
    private Button timetable;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.activity_home);        
        
        
        initView(menucat);   
        
        
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
    	
        	case R.id.TimeTable: menucat="TimeTable"; 
				 				 Intent intent3 = new Intent(getApplicationContext(), transitTT.class);
				 				 startActivity(intent3);
				 				 break;

        	case R.id.MyGroups: menucat="MyGroups";
								Intent intent4 = new Intent(getApplicationContext(), Groups.class);
								startActivity(intent4);
								break;
        	
        	case R.id.E_NoticeBoard: menucat="E-Notice Board";break;
        	
        	case R.id.News: menucat="News";break;
        	
        	case R.id.Settings: menucat="Settings";break;
        	
        	
        	    		
        	}
        	initView(menucat);
        	return(super.onOptionsItemSelected(mitem));
        }

    private void initView(String mc) {
        // show progress dialog
        dialog = ProgressDialog.show(this, "", "Loading...");
        
        //final GlobalClass globalVariable=(GlobalClass) getApplicationContext();
        final GlobalClass g = (GlobalClass) getApplicationContext();
    	String addr=g.server_addr;
    	String prn=String.valueOf(g.getPrn());
        String url = addr+"/login.php?prn="+prn;
        
        //+String.valueOf(globalVariable.getPrn());
        
        FetchDataTask task = new FetchDataTask(this,this.getApplicationContext());
        task.execute(url);
    }
    
    @Override
    public void onFetchComplete(List<Application> data) {
    	//LayoutInflater li = LayoutInflater.from(getApplicationContext());
        //View v = li.inflate(R.layout.activity_home,null);
        // dismiss the progress dialog
    	
        final GlobalClass globalVariable=(GlobalClass) getApplicationContext();
        
        if(dialog != null)  dialog.dismiss();
        // create new adapter
        Application app= data.get(0);
        
        if(app != null) {
        	Toast.makeText(getApplicationContext(), app.getName(),Toast.LENGTH_LONG).show();
        	
        	Button timetable=(Button)  findViewById(R.id.btn1);
            TextView titleText = (TextView) findViewById(R.id.name);
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
        }
    }

    @Override
    public void onFetchFailure(String msg) {
        // dismiss the progress dialog
        if(dialog != null)  dialog.dismiss();
        // show failure message
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();        
    }
}
