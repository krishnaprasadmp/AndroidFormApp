package com.krishnaprasad.assignment2;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by krishnaprasad on 12/02/17.
 */

public class MySpinnerFragment extends ListFragment implements AdapterView.OnItemClickListener {
    String selection,tag="value";
    ArrayList<String> mState = new ArrayList<>();

    public interface StateListner {
        void stateValue(String value);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        StateActivity sl = (StateActivity) getActivity();
        mState  = sl.stateList;
        View view = inflater.inflate(R.layout.spinner_fragment, container, false);
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Spinner spin = null;
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,mState);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        //Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
        selection = parent.getItemAtPosition(position).toString();
        stateSendValue();
    }
    public void stateSendValue() {
        StateListner listner = (StateListner) getActivity();
        listner.stateValue(selection);
    }
}
