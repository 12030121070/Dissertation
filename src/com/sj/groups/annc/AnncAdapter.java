package com.sj.groups.annc;

import java.util.List;

import com.sj.jsondemo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class AnncAdapter extends ArrayAdapter<Announcements>{
	
	private List<Announcements> items;
    View v;
    public AnncAdapter(Context context, List<Announcements> items) {
        super(context, R.layout.announcements, items);
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        v = convertView;
        
        if(v == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            v = li.inflate(R.layout.groups_announcements,null);  
            //v.getLayoutParams().width=LayoutParams.WRAP_CONTENT;
           }
        
        Announcements app = items.get(position);
        
        if(app != null) {
            TextView hName = (TextView)v.findViewById(R.id.AnncHeading);
            
            OnClickListener listn=new OnClickListener(){

        		@Override
        		public void onClick(View v) {
        			Toast.makeText(getContext(), "Hello", Toast.LENGTH_LONG).show();
				// TODO Auto-generated method stub
				//Intent intent=new Intent(v.getContext(), Timetable.class);
	            //startActivity(intent);
        		}
            };
            hName.setOnClickListener(listn);
            
            if(hName != null)
            {
            	hName.setText(app.getHeading());
            }   
        }
        
        return v;
    }
}
