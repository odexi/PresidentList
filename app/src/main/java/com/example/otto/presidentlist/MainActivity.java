package com.example.otto.presidentlist;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;




public class MainActivity extends Activity implements OnFragmentInteractionListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            FragmentList firstFragment = new FragmentList();

            firstFragment.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();

        }
    }
    public void changeFragment(int id, Fragment f, Fragment g){
        if (id == 1) {
            FragmentList fragmentList = new FragmentList();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragmentList);
            ft.commit();
        }
        else if (id == 2) {
            FragmentView fragmentView;
            if(null == f) {
                fragmentView = new FragmentView();
                Log.d("bb", "is that ever called? And at startup????");
            }else
                fragmentView = (FragmentView) f;
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragmentView).addToBackStack(null);

            ft.commit();
        }
    }


}


