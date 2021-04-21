package com.sies.cyber;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Network_Security extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.astopic);
        Intent intent = getIntent();

        int number = intent.getIntExtra("inTOPIC",0);
        String text = "", topic_table = "";

        ImageButton back = findViewById(R.id.backButton);

        Intent in = new Intent(Network_Security.this, Topic_Common.class);
        in.putExtra("TOPIC",0);
        back.setOnClickListener(v -> startActivity(in));

        switch(number){
            case 0:
                text = "An important relationship on networks is that of the server and the client. A server is a computer that holds content and services such as a website, a media file, or a chat application. A good example of a server is the computer that holds the website for Google’s search page: http://www.google.com. The server holds that page, and sends it out when requested.\n" +
                        "\n" +
                        "A client is a different computer, such as your laptop or cell phone, that requests to view, download, or use the content. The client can connect over a network to exchange information. For instance, when you request Google’s search page with your web browser, your computer is the client.\n" +
                        "\n" +
                        "In order to send and direct data across a network, computers need to be able to identify destinations and origins. This identification is an IP—Internet Protocol—address. An IP address is just a set of four numbers between 1 and 254, separated by dots. An example of an IP address is 173.194.43.7.";
                topic_table = "What is IP?";
                break;
            //Add More Cases
        }

        TextView content = findViewById(R.id.topic_content);
        TextView title = findViewById(R.id.topic_title);
        title.setText(topic_table);
        content.setText(text);
    }
}
