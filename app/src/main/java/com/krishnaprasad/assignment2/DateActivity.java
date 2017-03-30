package com.krishnaprasad.assignment2;

import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class DateActivity extends AppCompatActivity {

    DatePicker mPicker;
    Button mDone, mClear;
    String dataChange;
    int month,day,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        mPicker = (DatePicker) findViewById(R.id.datePicker);
        setDefaultDate();
        mDone = (Button) findViewById(R.id.done);
        mDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData();
            }
        });
        mClear = (Button) findViewById(R.id.clear);
        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mPicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                dataChange = (i1+1)+"/" + i2+ "/" +i;
            }
        });

    }

    private void setDefaultDate() {
        month = mPicker.getMonth();
        day = mPicker.getDayOfMonth();
        year = mPicker.getYear();
        dataChange = month+1 + "/" + day + "/" + year;
    }


    private void setData() {
        Intent passValue = getIntent();
        passValue.putExtra("data",dataChange);
        setResult(RESULT_OK,passValue);
        finish();
    }

}
