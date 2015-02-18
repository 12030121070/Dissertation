package announcements;

import com.sj.jsondemo.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ListInView extends FragmentActivity {
    Button b;
    Myfragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_in_view);
        FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment = new Myfragment();
        fragmentTransaction.add(R.id.fragment1, fragment);
        fragmentTransaction.commit();
        b = (Button) findViewById(R.id.addfrag);
           b.setOnClickListener(new OnClickListener()
           {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				fragment.addPlaces();
			}

           });  
    }
}
