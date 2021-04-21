package com.sies.cyber;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Topic_Linux_Essentials extends AppCompatActivity {
    RecyclerView mRecyclerView;
    ArrayList<DataModelInner> dataHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linux_essentials_topic);
        mRecyclerView = findViewById(R.id.recView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataHolder = new ArrayList<>();


        TextView t = findViewById(R.id.topic_title);
        String topic = t.getText().toString();
        ImageButton back = findViewById(R.id.backButton);
        back.setOnClickListener(v -> startActivity(new Intent(Topic_Linux_Essentials.this, MainActivity.class)));

        DataModelInner ob1 = new DataModelInner("What is Linux?","Description1",topic);
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