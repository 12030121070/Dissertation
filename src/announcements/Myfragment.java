package announcements;

import com.sj.jsondemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class Myfragment extends Fragment {

    LinearLayout linearLayout; 
    View rootView;
    @Override
       public void onActivityCreated(Bundle savedInstanceState) {
       super.onActivityCreated(savedInstanceState);
          linearLayout = (LinearLayout) rootView.findViewById(R.id.linearlayout);
       }
    @Override
       public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                    Bundle savedInstanceState) {
       rootView = inflater.inflate(R.layout.fragments, container, false);

        return rootView;
        } 
    public void addPlaces()
     {

        Button button = new Button(getActivity()); // needs activity context
        button.setText("button name");
        linearLayout.addView(button);
     }
}