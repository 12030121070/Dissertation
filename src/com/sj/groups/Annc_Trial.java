package com.sj.groups;

import java.util.List;

import com.sj.groups.annc.AnncAdapter;
import com.sj.groups.annc.Announcements;
import com.sj.groups.annc.FetchAnncDataListener;
import com.sj.groups.annc.FetchAnncDataTask;
import com.sj.jsondemo.GlobalClass;
import com.sj.jsondemo.R;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Annc_Trial extends ListFragment implements FetchAnncDataListener{
	
	private ProgressDialog dialog;
    private String menucat="home";
    
	@Override
	   public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
		
			   //ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, numbers_text);  
			   //setListAdapter(adapter);
			   initView(menucat);
			   return super.onCreateView(inflater, container, savedInstanceState);
	          //Inflate the layout for this fragment
	          
	  }
	
	
	@Override  
	  public void onListItemClick(ListView l, View v, int position, long id) {  
	   //new CustomToast(getActivity(), numbers_digits[(int) id]);
		Toast.makeText(getActivity(), "Haha", Toast.LENGTH_SHORT).show();
	  }

	private void initView(String mc) {
        
    	// show progress dialog
        //dialog = ProgressDialog.show(this, "", "Loading...");
        
		//GlobalClass 
    	final GlobalClass g = (GlobalClass) getActivity().getApplicationContext();
    	String addr=g.server_addr;
    	//String prn=String.valueOf(g.getPrn());
    	String g_id="3";
    	String url = addr+"/group_annc.php?gid="+g_id;
        FetchAnncDataTask task = new FetchAnncDataTask(this,getActivity());
        task.execute(url);
    }

	@Override
	public void onFetchComplete(List<Announcements> data) {
		// TODO Auto-generated method stub
		
		// create new adapter
        AnncAdapter adapter = new AnncAdapter(getActivity(), data);
        // set the adapter to list
        setListAdapter(adapter);
		
	}


	@Override
	public void onFetchFailure(String msg) {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show(); 
	} 
	
}
