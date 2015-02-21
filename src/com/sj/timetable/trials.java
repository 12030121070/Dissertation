package com.sj.timetable;

import java.util.ArrayList;
import java.util.List;

import com.sj.jsondemo.GlobalClass;
import com.sj.jsondemo.MainActivity;
import com.sj.jsondemo.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class trials extends Fragment implements OnItemSelectedListener{
	
	//ArrayList<String> spinnerArray = new ArrayList<String>();
	String start[]={"Select Program"};
	String start2[]={"Batch"};
	String start3[]={"Select Div"};
	String[] Programs={" "};
	String[] Batch={" "};
	String[] Div={" "};
	int count=0;
	
	View rootView;
	private ProgressDialog dialog;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.trial, container, false);
        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner1);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, start); 
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(this);
        
        Spinner spinner2 = (Spinner) rootView.findViewById(R.id.spinner2);
        ArrayAdapter<String> spinner2ArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, start2); 
        spinner2ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(spinner2ArrayAdapter);
        spinner2.setEnabled(false); 
        
        Spinner spinner3 = (Spinner) rootView.findViewById(R.id.spinner3);
        ArrayAdapter<String> spinner3ArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, start3); 
        spinner3ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(spinner3ArrayAdapter);
        spinner3.setEnabled(false); 
        
        return rootView;
	}
	

	@Override
	public void onItemSelected(AdapterView<?> parent,    View view,    int pos,    long id) {
		// TODO Auto-generated method stub
		
		
		switch(parent.getId()){
        case R.id.spinner1:
        	if(pos==0 && count==0)
        	{
        		initView(1);
        		count++;
        	}
        	else if(pos==0)
        	{
        		Spinner spinner2 = (Spinner) rootView.findViewById(R.id.spinner2);
        		spinner2.setEnabled(false);
        		Spinner spinner3 = (Spinner) rootView.findViewById(R.id.spinner3);
        		spinner3.setEnabled(false);
        	}
        	else
        	{
        		//Toast.makeText(getActivity(), pos, Toast.LENGTH_LONG).show();
        		initView(2);
        	}
              break;
        case R.id.spinner2 :
        	if(pos==0)
        	{
        		Spinner spinner3 = (Spinner) rootView.findViewById(R.id.spinner3);
        		spinner3.setEnabled(false);
        	}
        	else
        	{
        		//Toast.makeText(getActivity(), pos, Toast.LENGTH_LONG).show();
        		initView(3);
        	}
              //Your Another Action Here.
        break;
        case R.id.spinner3 :
        	Button back=(Button) rootView.findViewById(R.id.back);
    		Button go=(Button) rootView.findViewById(R.id.go);
    		go.setVisibility(View.VISIBLE);
        	if(pos!=0)
        	{
        		if(go !=null)
                {
                	OnClickListener l=new OnClickListener(){

                		@Override
                		public void onClick(View v2) {
                			
        				// TODO Auto-generated method stub
        				Intent intent=new Intent(getActivity(), Timetable.class);
        				intent.putExtra("did", 212);
        				intent.putExtra("bid", 12);
        	            startActivity(intent);
                		}
                };
                go.setOnClickListener(l);
                }
        	}
        	else
        	{
        		go.setVisibility(View.INVISIBLE);
        	}
       
		}
		//Toast.makeText(getActivity(), "Works", Toast.LENGTH_LONG).show();
		
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "Doesnt Work", Toast.LENGTH_LONG).show();
		
	}
	
	private void initView(int c) {
        
		if(c==1){
		
    	// show progress dialog
         dialog = ProgressDialog.show(getActivity(), "", "Loading...");
        
        final GlobalClass g = (GlobalClass) getActivity().getApplicationContext();
	    String addr=g.server_addr;
        String url = addr+"/program.php";
        
        ProgramsDataTask task = new ProgramsDataTask(this);
        task.execute(url);
		}
		else if(c==2)
		{
			dialog = ProgressDialog.show(getActivity(), "", "Loading...");
			Spinner spinner2 = (Spinner) rootView.findViewById(R.id.spinner2);
			spinner2.setEnabled(true);
			
			final GlobalClass g = (GlobalClass) getActivity().getApplicationContext();
		    String addr=g.server_addr;
	        String url = addr+"/batch.php";
	        
	        BatchDataTask task = new BatchDataTask(this);
	        task.execute(url);
		}
		else if(c==3)
		{
			dialog = ProgressDialog.show(getActivity(), "", "Loading...");
			Spinner spinner3 = (Spinner) rootView.findViewById(R.id.spinner3);
			spinner3.setEnabled(true);
			
			final GlobalClass g = (GlobalClass) getActivity().getApplicationContext();
		    String addr=g.server_addr;
	        String url = addr+"/div.php";
	        
	        DivDataTask task = new DivDataTask(this);
	        task.execute(url);
		}
    }
	
	public void onFetchComplete(List<?> data,int spin_num) {
		// TODO Auto-generated method stub
		
		final GlobalClass g=(GlobalClass) getActivity().getApplicationContext();
		
		if(spin_num==1)
		{			
			if(data!=null)
	        {
			
			Programs=new String[data.size()+1];
			Programs[0]="Select Program";
			for(int i=0;i<data.size();i++)
			{
				ProgramNames app= (ProgramNames) data.get(i);
				Programs[i+1]=app.getPname();
			}
			Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner1);
	        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, Programs); 
	        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spinner.setAdapter(spinnerArrayAdapter);
	        spinner.setOnItemSelectedListener(this);
	        count=1;
	        }
		}
		else if(spin_num==2){
			
			if(data!=null)
	        {
			
			Batch=new String[data.size()+1];
			Batch[0]="Select Batch";
			for(int i=0;i<data.size();i++)
			{
				BatchNames app= (BatchNames) data.get(i);
				Batch[i+1]=app.getBname();
			}
			Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner2);
	        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, Batch); 
	        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spinner.setAdapter(spinnerArrayAdapter);
	        spinner.setOnItemSelectedListener(this);
	        count=2;
	        }
		}
		else if(spin_num==3)
		{
			if(data!=null)
	        {
			
			Div=new String[data.size()+1];
			Div[0]="Select Division";
			for(int i=0;i<data.size();i++)
			{
				DivisionNames app= (DivisionNames) data.get(i);
				Div[i+1]=app.getDname();
			}
			Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner3);
	        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, Div); 
	        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spinner.setAdapter(spinnerArrayAdapter);
	        spinner.setOnItemSelectedListener(this);
	        count=2;
	        }
			
		}
		if(dialog != null)  dialog.dismiss();
		
	}
	
	public void onFetchFailure(String msg) {
		
		if(dialog != null)  dialog.dismiss();
		Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        //Intent i=new Intent(getActivity(), MainActivity.class);
        //startActivity(i);
		
	}

}
