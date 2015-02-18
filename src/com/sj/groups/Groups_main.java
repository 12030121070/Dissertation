package com.sj.groups;

import java.text.NumberFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


import com.sj.groups.annc.Announcements;
import com.sj.groups.annc.FetchAnncDataListener;
import com.sj.groups.annc.FetchAnncDataTask;
import com.sj.jsondemo.GlobalClass;
import com.sj.jsondemo.MainActivity;
import com.sj.jsondemo.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.*;

public class Groups_main extends FragmentActivity implements FetchAnncDataListener{
	
	private ProgressDialog dialog;
    private String menucat="home";
	public int currentimageindex=0;
	Timer timer;
	TimerTask task;
	ImageView slidingimage;
	Bundle savedInstanceState;
	
	private int[] IMAGE_IDS = {
			R.drawable.splash0, R.drawable.splash1, R.drawable.splash2,
			R.drawable.splash3
		};
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.individual_group_main);
     
        this.savedInstanceState=savedInstanceState;
        
        initView(menucat);
        final Handler mHandler = new Handler();

        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {
            public void run() {
            	
            	AnimateandSlideShow();
            	
            }
        };
		
        int delay = 1000; // delay for 1 sec.

        int period = 8000; // repeat every 4 sec.

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

        public void run() {

        	 mHandler.post(mUpdateResults);

        }

        }, delay, period);
        
    }
	
	private void AnimateandSlideShow() {
    	
    	
    	slidingimage = (ImageView)findViewById(R.id.ImageView3_Left);
   		slidingimage.setImageResource(IMAGE_IDS[currentimageindex%IMAGE_IDS.length]);
   		
   		currentimageindex++;
    	
   		Animation rotateimage = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
    	slidingimage.startAnimation(rotateimage);
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
    
    	//GlobalClass 
    	final GlobalClass g = (GlobalClass) getApplicationContext();
    	String addr=g.server_addr;
    	//String prn=String.valueOf(g.getPrn());
    	String g_id="3";
    	String url = addr+"/group_annc.php?gid="+g_id;
    
    //+String.valueOf(globalVariable.getPrn());
    
    FetchAnncDataTask task = new FetchAnncDataTask(this,this.getApplicationContext());
    task.execute(url);
}

@Override
public void onFetchComplete(List<Announcements> data) {
	//LayoutInflater li = LayoutInflater.from(getApplicationContext());
    //View v = li.inflate(R.layout.activity_home,null);
    // dismiss the progress dialog
	
    
    if(dialog != null)  dialog.dismiss();
    // create new adapter
    Announcements app= data.get(0);
    
    if(app != null) {
    	
    	Toast.makeText(getApplicationContext(), String.valueOf(app.getGroupId()),Toast.LENGTH_LONG).show();
    	
    	//LinearLayout ntc=(LinearLayout) findViewById(R.id.stuff);
    	//TextView headingText = (TextView) findViewById(R.id.heading);
    	//if(headingText!=null)
    	//{
    		//String h=app.getHeading();
    		//headingText.setText(h);
    		
    		/*
    		TextView headingNext = new TextView(this);
    		headingNext.setText("Hi");
    		
    		LinearLayout ll=new LinearLayout(this);
    		ll.setOrientation(LinearLayout.VERTICAL);
    		ll.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
    		ll.addView(headingNext);
    		*/
    		
    		
    	//}
    	
    	if (findViewById(R.id.fragment_container) != null) {
    		if (savedInstanceState != null) {
                return;
            }
    		
    		Annc_Trial firstFragment = new Annc_Trial();
    		getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,firstFragment).commit();
    	}
    	/*
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
     * 
     * 
     */
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


