package com.sj.groups;

import java.text.NumberFormat;
import java.util.List;

import com.sj.jsondemo.R;
import com.sj.timetable.Timetable;

import android.content.Context;
import android.content.Intent;
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

public class ApplicationAdapter extends ArrayAdapter<Application>{
    private List<Application> items;
    View v;
    public ApplicationAdapter(Context context, List<Application> items) {
        super(context, R.layout.groups_name_main, items);
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
            v = li.inflate(R.layout.groups_list,null);  
            //v.getLayoutParams().width=LayoutParams.WRAP_CONTENT;
           }
        
        Application app = items.get(position);
        
        if(app != null) {
            TextView gName = (TextView)v.findViewById(R.id.GroupName);
            
            OnClickListener listn=new OnClickListener(){

        		@Override
        		public void onClick(View v) {
        			Toast.makeText(getContext(), "Hello", Toast.LENGTH_LONG).show();
				// TODO Auto-generated method stub
				//Intent intent=new Intent(v.getContext(), Timetable.class);
	            //startActivity(intent);
        		}
            };
            gName.setOnClickListener(listn);
            
         // TableLayout ratingCntr = (TableLayout)v.findViewById(R.id.table1);
         // TextView dlText = (TextView)v.findViewById(R.id.username);
            
            
            /*
            if(gName !=null)
            {
            	OnClickListener l=new OnClickListener(){

            		@Override
            		public void onClick(View v) {
            			Toast.makeText(getContext(), "Hello", Toast.LENGTH_LONG).show();
    				// TODO Auto-generated method stub
    				//Intent intent=new Intent(v.getContext(), Timetable.class);
    	            //startActivity(intent);
            		}
            };
            timetable.setOnClickListener(l);
            }
            
            /*
            Button b=(Button)v.findViewById(R.id.button1);
            b.setOnClickListener(new OnClickListener(){
            	public void onClick(View v1){
            		TextView ttex=(TextView)v.findViewById(R.id.titleTxt);
            		TextView tpxt=(TextView)v.findViewById(R.id.dlTxt);
            		Toast.makeText(v.getContext(), "Selected"+ttex.getText()+"  "+tpxt.getText(), Toast.LENGTH_LONG).show();
            	}
            });
            
            
            if(icon != null) {
                Resources res = getContext().getResources();
                String sIcon = "com.sj.jsondemo:drawable/" + app.getIcon();
                icon.setImageDrawable(res.getDrawable(res.getIdentifier(sIcon, null, null)));
            }*/
            
            if(gName != null)
            {
            	gName.setText(app.getGroupName());
            
            /*
            if(dlText != null) {
                NumberFormat nf = NumberFormat.getNumberInstance();
                dlText.setText((app.getUsername()));      
            */      
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
