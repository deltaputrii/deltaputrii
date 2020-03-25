package com.d3if4201.application;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListHistory extends AppCompatActivity {

    private static final String TAG = "ListHistory";

    DbManager mDatabaseHelper;

    private ListView mListView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new DbManager(this);

        ArrayList<String>theList=new ArrayList<>();
        Cursor x = mDatabaseHelper.selectFromMaps();

        while (x.moveToNext()){
            theList.add(x.getString(1));
            ListAdapter list = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
            mListView.setAdapter(list);

        }
    }
}
