package com.krishnaprasad.assignment2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PersonActivity extends AppCompatActivity {

    private static final int INTENT_VALUE_REQUEST = 10;
    Button mDateSet,mCountrySet,mSave;
    EditText mFirstName,mLastName,mAge,mEmail,mPhone,mDateEdit,mCountryText,mStateExit;
    boolean flag1,flag = true;
    String dateValue,countryValue,stateValue;
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        mFirstName = (EditText) findViewById(R.id.fnameText);
        mLastName = (EditText)  findViewById(R.id.lnameText);
        mAge = (EditText) findViewById(R.id.AgeText);
        mEmail = (EditText) findViewById(R.id.EmailText);
        mPhone = (EditText) findViewById(R.id.PhoneText);
        mDateEdit = (EditText) findViewById(R.id.BirthText);
        mDateEdit.setFocusable(false);
        mDateSet = (Button) findViewById(R.id.dateSet);
        mDateSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dateIntent = new Intent(PersonActivity.this,DateActivity.class);
                startActivityForResult(dateIntent,INTENT_VALUE_REQUEST);
            }
        });
        mCountryText = (EditText) findViewById(R.id.CountryText);
        mCountryText.setFocusable(false);
        mStateExit = (EditText) findViewById(R.id.stateText);
        mStateExit.setFocusable(false);
        mCountrySet = (Button) findViewById(R.id.CountrySet);
        mCountrySet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent countryIntent = new Intent (PersonActivity.this,CountryActivity.class);
                startActivityForResult(countryIntent,INTENT_VALUE_REQUEST);
            }
        });
        mSave = (Button) findViewById(R.id.buttonDone);
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("firstname",mFirstName.getText().toString());
                    editor.putString("lastname",mLastName.getText().toString());
                    editor.putString("age",mAge.getText().toString());
                    editor.putString("email",mEmail.getText().toString());
                    editor.putString("phone",mPhone.getText().toString());
                    editor.putString("birth",mDateEdit.getText().toString());
                    editor.putString("country",mCountryText.getText().toString());
                    editor.putString("state",mStateExit.getText().toString());
                    editor.apply();
                   Toast.makeText(getApplicationContext(),"DATA SAVED!",Toast.LENGTH_SHORT).show();
            }
        });
        SharedPreferences sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        displayData();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        if (requestCode != INTENT_VALUE_REQUEST) {
            return;
        }
        switch(resultCode) {
            case RESULT_OK:
                dateValue = data.getStringExtra("data");

                flag = false;
                if(!flag) {
                    mDateEdit.setFocusable(true);
                    mDateEdit.setText(dateValue);
                }
                break;
            case RESULT_FIRST_USER:
                countryValue = data.getStringExtra("country");
                stateValue   =  data.getStringExtra("state");
                flag1 = false;
                if(!flag1) {
                    mCountryText.setFocusable(true);
                    mStateExit.setFocusable(true);
                    mCountryText.setText(countryValue);
                    mStateExit.setText(stateValue);
                }
            case RESULT_CANCELED:
                break;
        }
    }

    public void displayData() {
        SharedPreferences sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String name = sharedPref.getString("firstname","");
        mFirstName.setText(name);
        mLastName.setText(sharedPref.getString("lastname",""));
        mAge.setText(sharedPref.getString("age",""));
        mEmail.setText(sharedPref.getString("email",""));
        mPhone.setText(sharedPref.getString("phone",""));
        mDateEdit.setText(sharedPref.getString("birth",""));
        mCountryText.setText(sharedPref.getString("country",""));
        mStateExit.setText(sharedPref.getString("state",""));
    }

    }




