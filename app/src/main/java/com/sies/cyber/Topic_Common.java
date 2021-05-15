package com.sies.cyber;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.sies.cyber.Cloud_Security.SCORE_CS1;
import static com.sies.cyber.Network_Security.SCORE_NS1;
import static com.sies.cyber.Network_Security.SCORE_NS2;
import static com.sies.cyber.Network_Security.SHARED_PREFS;

public class Topic_Common extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ArrayList<DataModelInner> dataHolder;
    int image,points;
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


        SharedPreferences sharedPref = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);

        DataModelInner ob1, ob2, ob3, ob4, ob5, ob6;

        switch(number){
            case 0:
                t.setText("Network Security");
                ob1 = new DataModelInner("What is IP?", number,R.drawable.ic_lock_unlock,15);
                points = sharedPref.getInt(SCORE_NS1,0);
                if(points>= 10) image = R.drawable.ic_lock_unlock;
                else image = R.drawable.ic_lock;
                ob2 = new DataModelInner("What are Ports?",number,image, points);
                points = sharedPref.getInt(SCORE_NS2,0);
                if(points>=10) image = R.drawable.ic_lock_unlock;
                else image = R.drawable.ic_lock;
                ob3 = new DataModelInner("How do IP addresses work",number,image,points);
                ob4 = new DataModelInner("Types of IP addresses",number,R.drawable.ic_lock,0);
                ob5 = new DataModelInner("How to look up IP addresses",number,R.drawable.ic_lock,0);
                ob6 = new DataModelInner("IP address security threats", number,R.drawable.ic_lock,0);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                dataHolder.add(ob6);
                break;
            case 1:
                t.setText("Cloud Security");
                ob1 = new DataModelInner("What is Cloud?",number,R.drawable.ic_lock_unlock,10);
                points = sharedPref.getInt(SCORE_CS1,0);
                if(points>= 5) image = R.drawable.ic_lock_unlock;
                else image = R.drawable.ic_lock;
                ob2 = new DataModelInner("What is Cloud Security?",number,image,points);
                ob3 = new DataModelInner("How does it Work?",number,R.drawable.ic_lock,0);
                ob4 = new DataModelInner("Cloud security risks",number,R.drawable.ic_lock,0);
                ob5 = new DataModelInner("Types of Attacks",number,R.drawable.ic_lock,0);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                break;
            case 2:
                t.setText("Data Security");
                ob1 = new DataModelInner("What is Data Security?",number,R.drawable.ic_lock_unlock,0);
                ob2 = new DataModelInner("Why Data Security?",number,R.drawable.ic_lock,0);
                ob3 = new DataModelInner("Types of threats",number,R.drawable.ic_lock,0);
                ob4 = new DataModelInner("Solutions",number,R.drawable.ic_lock,0);
                ob5 = new DataModelInner("Regulations",number,R.drawable.ic_lock,0);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                break;
            case 3:
                t.setText("Linux Essentials");
                ob1 = new DataModelInner("What is Linux?",number,R.drawable.ic_lock_unlock,0);
                ob2 = new DataModelInner("Why Linux?",number,R.drawable.ic_lock,0);
                ob3 = new DataModelInner("Virtual Machines",number,R.drawable.ic_lock,0);
                ob4 = new DataModelInner("WSL",number,R.drawable.ic_lock,0);
                ob5 = new DataModelInner("Docker",number,R.drawable.ic_lock,0);
                ob6 = new DataModelInner("Basic Linux Commands", number,R.drawable.ic_lock,0);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                dataHolder.add(ob6);
                break;
            case 4:
                t.setText("Web App Pen-Testing");
                ob1 = new DataModelInner("Basics of Web",number,R.drawable.ic_lock_unlock,0);
                ob2 = new DataModelInner("Vulnerabilities",number,R.drawable.ic_lock,0);
                ob3 = new DataModelInner("OWASP Top 10",number,R.drawable.ic_lock,0);
                ob4 = new DataModelInner("Bug Bounty Hunting",number,R.drawable.ic_lock,0);
                ob5 = new DataModelInner("Pentesting",number,R.drawable.ic_lock,0);
                dataHolder.add(ob1);
                dataHolder.add(ob2);
                dataHolder.add(ob3);
                dataHolder.add(ob4);
                dataHolder.add(ob5);
                break;
            case 5:
                t.setText("Application Security");
                ob1 = new DataModelInner("Basics of App dev",number,R.drawable.ic_lock_unlock,0);
                ob2 = new DataModelInner("Vulnerabilities",number,R.drawable.ic_lock,0);
                ob3 = new DataModelInner("OWASP",number,R.drawable.ic_lock,0);
                ob4 = new DataModelInner("Pentesting",number,R.drawable.ic_lock,0);
                ob5 = new DataModelInner("RVDP",number,R.drawable.ic_lock,0);
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