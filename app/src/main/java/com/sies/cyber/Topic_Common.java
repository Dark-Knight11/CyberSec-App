package com.sies.cyber;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Topic_Common extends AppCompatActivity {
    RecyclerView mRecyclerView;
    ArrayList<DataModelInner> dataHolder;
    ImageView lock;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_topic_layout);

        Intent intent = getIntent();
        int number = intent.getIntExtra("TOPIC",0);

        mRecyclerView = findViewById(R.id.recView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataHolder = new ArrayList<>();

        TextView t = findViewById(R.id.topic_title);
        ImageButton back = findViewById(R.id.backButton);
        back.setOnClickListener(v -> startActivity(new Intent(Topic_Common.this, MainActivity.class)));

        lock = findViewById(R.id.lock);
        //lock.setVisibility(View.INVISIBLE);

        DataModelInner ob1, ob2, ob3, ob4, ob5, ob6, ob7;

        switch(number){
            case 0:
                t.setText("Network Security");
                ob1 = new DataModelInner("What is IP?", number);
                ob2 = new DataModelInner("What are Ports?",number);
                ob3 = new DataModelInner("Heading3",number);
                ob4 = new DataModelInner("Heading4",number);
                ob5 = new DataModelInner("Heading5",number);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                break;
            case 1:
                t.setText("Cloud Security");
                ob1 = new DataModelInner("Heading1",number);
                ob2 = new DataModelInner("Heading2",number);
                ob3 = new DataModelInner("Heading3",number);
                ob4 = new DataModelInner("Heading4",number);
                ob5 = new DataModelInner("Heading5",number);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                break;
            case 2:
                t.setText("Data Security");
                ob1 = new DataModelInner("Heading1",number);
                ob2 = new DataModelInner("Heading2",number);
                ob3 = new DataModelInner("Heading3",number);
                ob4 = new DataModelInner("Heading4",number);
                ob5 = new DataModelInner("Heading5",number);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                break;
            case 3:
                t.setText("Linux Essentials");
                ob1 = new DataModelInner("Heading1",number);
                ob2 = new DataModelInner("Heading2",number);
                ob3 = new DataModelInner("Heading3",number);
                ob4 = new DataModelInner("Heading4",number);
                ob5 = new DataModelInner("Heading5",number);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                break;
            case 4:
                t.setText("Web App Pen-Testing");
                ob1 = new DataModelInner("Heading1",number);
                ob2 = new DataModelInner("Heading2",number);
                ob3 = new DataModelInner("Heading3",number);
                ob4 = new DataModelInner("Heading4",number);
                ob5 = new DataModelInner("Heading5",number);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                break;
            case 5:
                t.setText("Application Security");
                ob1 = new DataModelInner("Heading1",number);
                ob2 = new DataModelInner("Heading2",number);
                ob3 = new DataModelInner("Heading3",number);
                ob4 = new DataModelInner("Heading4",number);
                ob5 = new DataModelInner("Heading5",number);
                ob6 = new DataModelInner("Heading6",number);
                ob7 = new DataModelInner("Heading7",number);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                dataHolder.add(ob6);
                dataHolder.add(ob7);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + number);
        }
        mRecyclerView.setAdapter(new myAdapterInner(dataHolder));
    }
}