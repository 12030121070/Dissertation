package com.sj.timetable;

import java.text.NumberFormat;
import java.util.List;

import com.sj.jsondemo.R;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ApplicationAdapter extends ArrayAdapter<ClassInfo>{
    private List<ClassInfo> items;
    View v;
    public ApplicationAdapter(Context context, List<ClassInfo> items) {
        super(context, R.layout.activity_home, items);
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
            v = li.inflate(R.layout.activity_home,null);  
            //v.getLayoutParams().width=LayoutParams.WRAP_CONTENT;
           }
        
        ClassInfo app = items.get(position);
        
        if(app != null) {
            
            TextView username = (TextView)v.findViewById(R.id.username);
            TextView u_prn = (TextView)v.findViewById(R.id.u_prn);
         // TableLayout ratingCntr = (TableLayout)v.findViewById(R.id.table1);
            TextView name = (TextView)v.findViewById(R.id.name);
            
            
            /*
                        
            if(username != null) username.setText(app.getDname());
            
            if(name != null) {
                //NumberFormat nf = NumberFormat.getNumberInstance();
                //name.setText(nf.format(app.getTotalDl())+"Rs.");
            	name.setText("Welcome "+app.getDname());
            }
            
            if(u_prn != null) {
            	
                String PRN=String.valueOf(app.getBid());
                u_prn.setText(PRN);
            }
            
          /*  if(ratingCntr != null && ratingCntr.getChildCount() == 0) {        
             
                 //* max rating: 5
                
                for(int i=1; i<=5; i++) {
                    ImageView iv = new ImageView(getContext());
                    
                    if(i <= app.getRating()) {
                        iv.setImageDrawable(getContext().getResources().getDrawable(R.drawable.start_checked));
                    }
                    else {                
                        iv.setImageDrawable(getContext().getResources().getDrawable(R.drawable.start_unchecked));
                    }
                    
                    ratingCntr.addView(iv);
                }
            }*/
        }
        
        return v;
    }
}
