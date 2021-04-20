package com.sies.cyber;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sies.cyber.fragments.DataModel;
import com.sies.cyber.fragments.myAdapter;

import java.util.ArrayList;

import static android.widget.GridLayout.VERTICAL;

public class Topic_1 extends AppCompatActivity {
    RecyclerView mRecyclerView;
    ArrayList<DataModelInner> dataHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_1);
        mRecyclerView = findViewById(R.id.recView1);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataHolder = new ArrayList<>();


        DataModelInner ob1 = new DataModelInner("Heading1","Description1");
        dataHolder.add(ob1);

        DataModelInner ob2 = new DataModelInner("Heading2","Description2");
        dataHolder.add(ob2);

        DataModelInner ob3 = new DataModelInner("Heading3","Description3");
        dataHolder.add(ob3);

        DataModelInner ob4 = new DataModelInner("Heading4","Description4");
        dataHolder.add(ob4);

        DataModelInner ob5 = new DataModelInner("Heading5","Description5");
        dataHolder.add(ob5);




        mRecyclerView.setAdapter(new myAdapterInner(dataHolder));
    }
}