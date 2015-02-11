package com.sj.jsondemo;

import java.text.NumberFormat;
import java.util.List;

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
    View v;
    public ApplicationAdapter(Context context, List<Application> items) {
        super(context, R.layout.app_custom_list, items);
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
            v = li.inflate(R.layout.app_custom_list,null);  
            //v.getLayoutParams().width=LayoutParams.WRAP_CONTENT;
           }
        
        Application app = items.get(position);
        
        if(app != null) {
            ImageView icon = (ImageView)v.findViewById(R.id.appIcon);
            TextView titleText = (TextView)v.findViewById(R.id.titleTxt);
            
         // TableLayout ratingCntr = (TableLayout)v.findViewById(R.id.table1);
            TextView dlText = (TextView)v.findViewById(R.id.dlTxt);
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
            }
            
            if(titleText != null) titleText.setText(app.getTitle());
            
            if(dlText != null) {
                NumberFormat nf = NumberFormat.getNumberInstance();
                dlText.setText(nf.format(app.getTotalDl())+"Rs.");            
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
