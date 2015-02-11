package com.sj.home;

import java.util.List;

import com.sj.jsondemo.R;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Home extends ListActivity implements FetchDataListener{
	
private ProgressDialog dialog;
private String menucat="starters_VEG";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.activity_main);        
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
      	
        	case R.id.hot: menucat="hot"; break;
        	
        	case R.id.sancks: menucat="sancks"; break;
        		
        	case R.id.veg_sandwiches: menucat="veg_sandwiches";break;
        	
        	case R.id.non_veg_sandwiches: menucat="non_veg_sandwiches";break;
        	
        	case R.id.starters_VEG: menucat="starters_VEG";break;
        	
        	case R.id.starters_NON_VEG: menucat="starters_NON_VEG";break;
        	
        	case R.id.VEG_soup: menucat="VEG_soup";break;
        	
        	case R.id.Non_veg_soup: menucat="Non_veg_soup";break;
        	
        	case R.id.Veg_main_course: menucat="Veg_main_course";break;
        	
        	case R.id.Non_veg_main_course: menucat="Non_veg_main_course";break;
        	
        	case R.id.egg_main_course: menucat="egg_main_course";break;
        	
        	case R.id.Non_veg_rice: menucat="Non_veg_rice";break;
        	
        	case R.id.veg_rice: menucat="veg_rice";break;
        	
        	case R.id.veg_chinese: menucat="veg_chinese";break;
        	
        	case R.id.veg_chinese_gravy: menucat="veg_chinese_gravy";break;
        	
        	case R.id.non_veg_chinese: menucat="non_veg_chinese";break;
        	
        	case R.id.non_veg_gravy: menucat="non_veg_gravy";break;
        	
        	case R.id.tandoor: menucat="tandoor";break;
        	
        	case R.id.paratahs: menucat="paratahs";break;
        	
        	case R.id.papad: menucat="papad";break;
        	
        	case R.id.cold_drinks: menucat="cold_drinks";break;
        	
        	case R.id.raita_salads: menucat="raita_salads";break;
        	
        	case R.id.milk_shakes: menucat="milk_shakes";break;
        	    		
        	}
        	initView(menucat);
        	return(super.onOptionsItemSelected(mitem));
        }

    private void initView(String mc) {
        // show progress dialog
        dialog = ProgressDialog.show(this, "", "Loading...");
        
        String url = "http://172.20.10.7:8888/login.php";
        FetchDataTask task = new FetchDataTask(this);
        task.execute(url);
    }
    
    @Override
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
