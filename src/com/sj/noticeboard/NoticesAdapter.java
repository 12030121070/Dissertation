package com.sj.noticeboard;

import java.text.NumberFormat;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.sj.jsondemo.Application;
import com.sj.jsondemo.R;

public class NoticesAdapter extends ArrayAdapter<Notices>{
    private List<Notices> items;
    View v;
    static int mid=1;
    public NoticesAdapter(Context context, List<Notices> items) {
        super(context, R.layout.notice_item, items);
        this.items = items;
    }
    
    @Override
    public int getCount() {
        return items.size();
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
    	v = convertView;
        //static int mid=1;
        if(v == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            v = li.inflate(R.layout.notice_item,null);  
            //v.getLayoutParams().width=LayoutParams.WRAP_CONTENT;
        }
        
        Notices app = items.get(position);
        
        if(app != null) {
            
        	TextView titleText = (TextView)v.findViewById(R.id.NoticeTitle);
        	if(titleText!=null)
        	{  
        		titleText.setText(app.getNtitle());
            }
        	
        	TextView nText = (TextView)v.findViewById(R.id.noticeTxt1);
        	if(nText!=null)
        	{  
        		nText.setText(app.getNpart1());
            }
         
        }
        
        return v;
    }
}