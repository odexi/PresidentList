package com.example.otto.presidentlist;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Otto on 24.8.2017.
 */

public class FragmentView extends Fragment {

    private OnFragmentInteractionListener fragmentListener;
    String hirvi;
    String hirvas;
    public FragmentView(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_view, container, false);

        Button btn = (Button) view.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                fragmentListener.changeFragment(1, null, null);
            }
        });


        Bundle info = getArguments();

            hirvi = info.getString("pres");
            hirvas = info.getString("des");
            Log.d("aa", hirvi);

        TextView tv = (TextView)view.findViewById(R.id.presidentti);
        tv.setText(hirvi + "" + hirvas);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            fragmentListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + "");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentListener = null;
    }

}
