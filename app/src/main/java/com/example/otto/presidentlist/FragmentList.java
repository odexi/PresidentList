package com.example.otto.presidentlist;


import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by Otto on 24.8.2017.
 */

public class FragmentList extends ListFragment{

    private OnFragmentInteractionListener fragmentListener;

    private ArrayList<President> presidents;

    public FragmentList(){
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        presidents = new ArrayList<>();

        presidents.add(new President("Ståhlberg, Kaarlo Juho", "1919-1925", "Eka pressa"));
        presidents.add(new President("Relander, Lauri Kristian", "1925-1931", "Toka pressa"));
        presidents.add(new President("Svinhufvud, Pehr Evind", "1931-1937", "Kolmas pressa"));
        presidents.add(new President("Kallio, Kyösti", "1937-1940", "Neljäs pressa"));
        presidents.add(new President("Ryti, Risto Heikki", "1940-1944", "Viides pressa"));
        presidents.add(new President("Mannerheim, Carl Gustav Emil", "1944-1946", "Kuudes pressa"));
        presidents.add(new President("Paasikivi, Juho Kusti", "1946-1956", "Seitsemäs pressa"));
        presidents.add(new President("Kekkonen, Urho Kaleva", "1956-1982", "Kahdeksas pressa"));
        presidents.add(new President("Koivisto, Mauno Henrik", "1982-1994", "Yhdeksäs pressa"));
        presidents.add(new President("Ahtisaari, Martti Oiva Kalevi", "1994-2000", "Kymmenes pressa"));
        presidents.add(new President("Halonen, Tarja Kaarina", "2000-2012", "Yhdestoista pressa"));
        presidents.add(new President("Niinistö, Sauli Väinämö", "2012-", "Kahdestoista pressa"));

        return view;
    }

    public void onListItemClick(ListView l, View v, int position, long id){

        Bundle bundle = new Bundle();
        bundle.putString("pres", presidents.get(position).toString());
        bundle.putString("des", presidents.get(position).getDescription());

        FragmentView frag = new FragmentView();
        FragmentView desc = new FragmentView();
        frag.setArguments(bundle);
        desc.setArguments(bundle);
        fragmentListener.changeFragment(2, frag, desc);
    }


    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<President> adapter = new ArrayAdapter<President>(getActivity(), android.R.layout.simple_list_item_1, presidents);
        setListAdapter(adapter);
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
