package com.sj.timetable;


import com.sj.groups.Annc_Trial;
import com.sj.jsondemo.GlobalClass;
import com.sj.jsondemo.MainActivity;
import com.sj.jsondemo.R;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Timetable_main_index extends FragmentActivity{
	
	Bundle savedInstanceStates;
	private String menucat="home";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable_main_index);
        savedInstanceStates=savedInstanceState;
        
        final GlobalClass g=(GlobalClass) getApplicationContext();
        
        TextView prog=(TextView) findViewById(R.id.pName);
        prog.setText(prog.getText()+" "+g.getProgram());
        
        TextView batch=(TextView) findViewById(R.id.bName);
        String b=g.getBatch();
        b=b.substring(0, 5);
        batch.setText(batch.getText()+" "+b);
        TextView div=(TextView) findViewById(R.id.Div);
        String d=g.getBatch();
        d=d.substring(d.length()-1);
        div.setText(div.getText()+" "+d);
        
        
        final Button change=(Button) findViewById(R.id.all_button);
        final Button weekly=(Button) findViewById(R.id.sw_button);
        change.setVisibility(1);
        OnClickListener l = new OnClickListener()
        {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				change.setVisibility(View.GONE);
				weekly.setVisibility(View.GONE);
				if (findViewById(R.id.decider_container) != null) {
		    		/*if (this.savedInstanceStates != null) {
		                return;
		            }*/
		    		
		    		trials firstFragment = new trials();
		    		getSupportFragmentManager().beginTransaction().replace(R.id.decider_container,firstFragment).commit();
		    	}
			}

        };
        change.setOnClickListener(l);
        
        
	
	
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
    	//initView(menucat);
    	return(super.onOptionsItemSelected(mitem));
    }

	

}
