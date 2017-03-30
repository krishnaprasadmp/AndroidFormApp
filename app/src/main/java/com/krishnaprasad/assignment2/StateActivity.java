package com.krishnaprasad.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by krishnaprasad on 12/02/17.
 */

public class StateActivity extends AppCompatActivity implements MySpinnerFragment.StateListner {

    ArrayList<String> stateList = new ArrayList<String>();
    String val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);
        Bundle stateData = getIntent().getExtras();
        String name = stateData.getString("state");

        try {

            InputStream countriesFile = getAssets().open(name);
            BufferedReader in = new BufferedReader(new InputStreamReader(countriesFile));
            String m = "";
            while ((m=in.readLine()) != null) {
                stateList.add(m);
            }
        } catch (IOException e) {
            Log.e("rew", "read Error", e);
        }
    }

    @Override
    public void stateValue(String value) {
        val = value;
        Intent pass = getIntent();
        pass.putExtra("st",val);
        setResult(RESULT_OK,pass);
        finish();
    }
}

