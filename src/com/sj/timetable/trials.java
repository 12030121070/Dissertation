package com.sj.timetable;

import java.util.ArrayList;

import com.sj.jsondemo.R;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class trials extends Activity implements OnItemSelectedListener{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trial);
        
        //ArrayList<String> spinnerArray = new ArrayList<String>();
        String colors[] = {"Red","Blue","White","Yellow","Black", "Green","Purple","Orange","Grey"};
        
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
        (this, android.R.layout.simple_spinner_item, colors); 
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(this);
        		
        	
	}

	@Override
	public void onItemSelected(AdapterView<?> parent,    View view,    int pos,    long id) {
		// TODO Auto-generated method stub
		
		Toast.makeText(getApplicationContext(), "Works", Toast.LENGTH_LONG).show();
		String batch[] = {"12-15","13-16","14-17"};
        
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
        (this, android.R.layout.simple_spinner_item, batch); 
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "Doesnt Work", Toast.LENGTH_LONG).show();
		
	}

}
