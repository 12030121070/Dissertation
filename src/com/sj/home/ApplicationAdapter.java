package com.sj.home;

import java.text.NumberFormat;
import java.util.List;

import com.sj.jsondemo.GlobalClass;
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

public class ApplicationAdapter extends ArrayAdapter<Application>{
    private List<Application> items;
    Context c;
    View v;
    public ApplicationAdapter(Context context, List<Application> items) {
        super(context, R.layout.activity_home, items);
        this.c=context;
        this.items = items;
    }
    
    @Override
    public int getCount() {
        return items.size();
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        v = convertView;
        

        final GlobalClass globalVariable = (GlobalClass) c.getApplicationContext();
        
        if(v == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            v = li.inflate(R.layout.activity_home,null);  
            //v.getLayoutParams().width=LayoutParams.WRAP_CONTENT;
           }
        
        Application app = items.get(position);
        
        if(app != null) {
            
            TextView username = (TextView)v.findViewById(R.id.username);
            TextView u_prn = (TextView)v.findViewById(R.id.u_prn);
         // TableLayout ratingCntr = (TableLayout)v.findViewById(R.id.table1);
            TextView name = (TextView)v.findViewById(R.id.name);
            
            
            
                        
            if(username != null){
            	username.setText(app.getUsername());
            	globalVariable.setUsername(app.getUsername());
            }
            
            if(name != null) {
                //NumberFormat nf = NumberFormat.getNumberInstance();
                //name.setText(nf.format(app.getTotalDl())+"Rs.");
            	//name.setText("Welcome "+app.getName());
            	globalVariable.setName(app.getName());
            	name.setText("Welcome "+globalVariable.getName());
            }
            
            if(u_prn != null) {
            	
                String PRN=String.valueOf(app.getUid());
                u_prn.setText(PRN);
                globalVariable.setPrn(app.getUid());
            }
            name.setText("Welcome "+globalVariable.getUsername());
            
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
