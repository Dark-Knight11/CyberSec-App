package com.sies.cyber;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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
                ob3 = new DataModelInner("How do IP addresses work",number);
                ob4 = new DataModelInner("Types of IP addresses",number);
                ob5 = new DataModelInner("How to look up IP addresses",number);
                ob6 = new DataModelInner("IP address security threats", number);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                dataHolder.add(ob6);
                break;
            case 1:
                t.setText("Cloud Security");
                ob1 = new DataModelInner("What is Cloud?",number);
                ob2 = new DataModelInner("What is Cloud Security?",number);
                ob3 = new DataModelInner("How does it Work?",number);
                ob4 = new DataModelInner("Cloud security risks",number);
                ob5 = new DataModelInner("Types of Attacks",number);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                break;
            case 2:
                t.setText("Data Security");
                ob1 = new DataModelInner("What is Data Security?",number);
                ob2 = new DataModelInner("Why Data Security?",number);
                ob3 = new DataModelInner("Types of threats",number);
                ob4 = new DataModelInner("Solutions",number);
                ob5 = new DataModelInner("Regulations",number);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                break;
            case 3:
                t.setText("Linux Essentials");
                ob1 = new DataModelInner("What is Linux?",number);
                ob2 = new DataModelInner("Why Linux?",number);
                ob3 = new DataModelInner("Virtual Machines",number);
                ob4 = new DataModelInner("WSL",number);
                ob5 = new DataModelInner("Docker",number);
                ob6 = new DataModelInner("Basic Linux Commands", number);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                dataHolder.add(ob6);
                break;
            case 4:
                t.setText("Web App Pen-Testing");
                ob1 = new DataModelInner("Basics of Web",number);
                ob2 = new DataModelInner("Vulnerabilities",number);
                ob3 = new DataModelInner("OWASP Top 10",number);
                ob4 = new DataModelInner("Bug Bounty Hunting",number);
                ob5 = new DataModelInner("Pentesting",number);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                break;
            case 5:
                t.setText("Application Security");
                ob1 = new DataModelInner("Basics of App dev",number);
                ob2 = new DataModelInner("Vulnerabilities",number);
                ob3 = new DataModelInner("OWASP",number);
                ob4 = new DataModelInner("Pentesting",number);
                ob5 = new DataModelInner("RVDP",number);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + number);
        }
        mRecyclerView.setAdapter(new myAdapterInner(dataHolder));
    }
}