package com.sies.cyber;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Topic_Cloud_Security extends AppCompatActivity {
    RecyclerView mRecyclerView;
    ArrayList<DataModelInner> dataHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cloud_security_topic);
        mRecyclerView = findViewById(R.id.recView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataHolder = new ArrayList<>();


        TextView t = findViewById(R.id.topic_title);
        String topic = t.getText().toString();

        DataModelInner ob1 = new DataModelInner("Heading1","Description1",topic);
        dataHolder.add(ob1);

        DataModelInner ob2 = new DataModelInner("Heading2","Description2",topic);
        dataHolder.add(ob2);

        DataModelInner ob3 = new DataModelInner("Heading3","Description3",topic);
        dataHolder.add(ob3);

        DataModelInner ob4 = new DataModelInner("Heading4","Description4",topic);
        dataHolder.add(ob4);

        DataModelInner ob5 = new DataModelInner("Heading5","Description5",topic);
        dataHolder.add(ob5);




        mRecyclerView.setAdapter(new myAdapterInner(dataHolder));
    }
}