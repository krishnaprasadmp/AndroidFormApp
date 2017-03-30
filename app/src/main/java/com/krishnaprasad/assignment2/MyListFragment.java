package com.krishnaprasad.assignment2;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by krishnaprasad on 12/02/17.
 */

public class MyListFragment extends ListFragment implements AdapterView.OnItemClickListener {

    String selection,tag="value";
    ArrayList<String> mCountry = new ArrayList<>();

    public interface CountryListner {
        void countryValue(String value);

    }
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CountryActivity ma = (CountryActivity) getActivity();
        mCountry = ma.countryList;
        View view = inflater.inflate(R.layout.list_fragment, container, false);

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,mCountry);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        selection = parent.getItemAtPosition(position).toString();
        countrySendValue();
    }

    public void countrySendValue() {
        CountryListner listner = (CountryListner) getActivity();
        listner.countryValue(selection);

    }
}