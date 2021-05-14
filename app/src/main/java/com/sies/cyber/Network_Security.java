package com.sies.cyber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Network_Security extends AppCompatActivity {

    int count = 0, points;
    RelativeLayout questionnaire,question;
    Button evalButton;
    RadioGroup question1;
    TextView curPoints;
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

        questionnaire = findViewById(R.id.questButton);
        questionnaire.setOnClickListener(this::onClick);

        evalButton = findViewById(R.id.evaluate);
        evalButton.setOnClickListener(this::onClick);

        curPoints = findViewById(R.id.current_points);

        switch(number){
            case 0:
                text = "An important relationship on networks is that of the server and the client. A server is a computer that holds content and services such as a website, a media file, or a chat application. A good example of a server is the computer that holds the website for Google’s search page: http://www.google.com. The server holds that page, and sends it out when requested.\n" +
                        "\n" +
                        "A client is a different computer, such as your laptop or cell phone, that requests to view, download, or use the content. The client can connect over a network to exchange information. For instance, when you request Google’s search page with your web browser, your computer is the client.\n" +
                        "\n" +
                        "In order to send and direct data across a network, computers need to be able to identify destinations and origins. This identification is an IP—Internet Protocol—address. An IP address is just a set of four numbers between 1 and 254, separated by dots. An example of an IP address is 173.194.43.7.\n" +
                        "\n" +
                        getString(R.string.hyperlink);
s
                topic_table = "What is IP?";
                break;
            case 1:
                text = "Network ports are provided by the TCP or UDP protocols at the Transport layer. They are used by protocols in the upper layers of the OSI model. Port numbers are used to determine what protocol incoming traffic should be directed to. Ports allow a single host with a single IP address to run network services. Each port number identifies a distinct service, and each host can have 65535 ports per IP address. Port use is regulated by the Internet Corporation for Assigning Names and Numbers (ICANN). By ICANN there are three categories for ports:\n" +
                        "\n" +
                        "From 0 to 1023 – well known ports assigned to common protocols and services\n" +
                        "From 1024 to 49151 – registered ports assigned by ICANN to a specific service\n" +
                        "From 49152 to 65 535 – dynamic (private, high) ports range from 49,152 to 65,535. Can be used by any service on an ad hoc basis. Ports are assigned when a session is established, and released when the session ends.";
                topic_table = "What are Ports?";
                break;
            case 2:
                text = "The use of IP addresses typically happens behind the scenes. The process works like this:\n" +
                        "\n" +
                        "Your device indirectly connects to the internet by connecting at first to a network connected to the internet, which then grants your device access to the internet.\n" +
                        "When you are at home, that network will probably be your Internet Service Provider (ISP). At work, it will be your company network.\n" +
                        "Your IP address is assigned to your device by your ISP.\n" +
                        "Your internet activity goes through the ISP, and they route it back to you, using your IP address. Since they are giving you access to the internet, it is their role to assign an IP address to your device.\n" +
                        "However, your IP address can change. For example, turning your modem or router on or off can change it. Or you can contact your ISP, and they can change it for you.\n" +
                        "When you are out and about – for example, traveling – and you take your device with you, your home IP address does not come with you. This is because you will be using another network (Wi-Fi at a hotel, airport, or coffee shop, etc.) to access the internet and will be using a different (and temporary) IP address, assigned to you by the ISP of the hotel, airport or coffee shop.\n";

                topic_table = "How do IP addresses work";
            //Add More Cases
        }

        TextView content = findViewById(R.id.topic_content);
        TextView title = findViewById(R.id.topic_title);
        title.setText(topic_table);
        content.setText(text);
    }

    private void onClick(View view) {
        if (view == questionnaire)
        {
            question = findViewById(R.id.qAndA);
            if (count%2==0)
                question.setVisibility(View.VISIBLE);
            else
                question.setVisibility(View.GONE);

            count++;
        }
        else if (view == evalButton)
        {
            points = 0;
            question1 = findViewById(R.id.radioGroup);
            if(question1.getCheckedRadioButtonId() == R.id.radioButton1)
            {
                points += 2;
            }

            curPoints.setText(""+points+"/10");
        }

    }
}
