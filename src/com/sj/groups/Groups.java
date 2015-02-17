package com.sj.groups;

import java.util.List;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.sj.jsondemo.MainActivity;
import com.sj.jsondemo.R;

public class Groups extends ListActivity implements FetchDataListener {

	private ProgressDialog dialog;
    private String menucat="home";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    
        setContentView(R.layout.groups_main);        
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
        dialog = ProgressDialog.show(this, "", "Loading...");
        
        String url = "http://10.10.25.185:8888/GroupName.php";
        FetchDataTask task = new FetchDataTask(this,this.getApplicationContext());
        task.execute(url);
    }
    
    
   // @Override
    public void onFetchComplete(List<Application> data) {
        // dismiss the progress dialog
        if(dialog != null)  dialog.dismiss();
        // create new adapter
        ApplicationAdapter adapter = new ApplicationAdapter(this, data);
        // set the adapter to list
        setListAdapter(adapter);        
    }

    @Override
    public void onFetchFailure(String msg) {
        // dismiss the progress dialog
        if(dialog != null)  dialog.dismiss();
        // show failure message
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();        
    }
}