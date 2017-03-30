package com.krishnaprasad.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CountryActivity extends AppCompatActivity implements MyListFragment.CountryListner {


    private static final int INTENT_REQUEST = 10;
    boolean flag = true;
    String tag = "value", k,g,stateValue;
    ArrayList<String> countryList = new ArrayList<String>();
    EditText mStateVal;
    Button mCountryDone,mCountryClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        g ="Country";
        try {

            InputStream countriesFile = getAssets().open(g);
            BufferedReader in = new BufferedReader(new InputStreamReader(countriesFile));
            String m = "";
            while ((m=in.readLine()) != null) {
                countryList.add(m);
            }
        } catch (IOException e) {
            Log.e("rew", "read Error", e);
        }
        mStateVal = (EditText) findViewById(R.id.editText);
        mStateVal.setFocusable(false);
        mCountryDone = (Button) findViewById(R.id.countrybutton2);
        mCountryDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendCountryData();
            }
        });
        mCountryClear = (Button) findViewById(R.id.countrybutton1);
        mCountryClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }



    public void countryValue(String value) {
        k = value;
        Intent intent = new Intent(CountryActivity.this,StateActivity.class);
        intent.putExtra("state",k);
        startActivityForResult(intent,INTENT_REQUEST);
    }

  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != INTENT_REQUEST) {
            return; }
        switch (resultCode) {
            case RESULT_OK:
                flag = false;
                stateValue = data.getStringExtra("st");
                if (!flag) {
                    mStateVal.setFocusable(true);
                    mStateVal.setText(stateValue);
                }
                break;
            case RESULT_CANCELED:
                break;
        }
    }

    private void sendCountryData() {
        Intent passValue = getIntent();
        passValue.putExtra("country",k);
        passValue.putExtra("state",stateValue);
        setResult(RESULT_FIRST_USER,passValue);
        finish();

    }

}