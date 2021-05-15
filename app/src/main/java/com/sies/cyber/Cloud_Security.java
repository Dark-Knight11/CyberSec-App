package com.sies.cyber;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.sies.cyber.Network_Security.SHARED_PREFS;

public class Cloud_Security extends AppCompatActivity {
    public static final String SCORE_CS1 = "Cloud_Security_Score_1";
    int count = 0, points, number;
    RelativeLayout questionnaire,question;
    Button evalButton;
    RadioGroup question7,question8;
    TextView curPoints;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    String wrong = "";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.astopic);
        Intent intent = getIntent();

        int number = intent.getIntExtra("inTOPIC",0);
        String text = "", topic_table = "";

        ImageButton back = findViewById(R.id.backButton);
        Intent in = new Intent(Cloud_Security.this, Topic_Common.class);
        in.putExtra("TOPIC",1);
        back.setOnClickListener(v -> startActivity(in));

        questionnaire = findViewById(R.id.questButton);
        questionnaire.setOnClickListener(this::onClick);

        sharedPref = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        curPoints = findViewById(R.id.current_points);

        switch(number){
            case 0:
                text = "Cloud is a service offered on the internet for public consumption either for a fee or free. It comes in different forms (IaaS, PaaS, SaaS), shapes (infrastructure, container based, abstracted) and sizes (public, private or hybrid).";
                topic_table = "What is Cloud?";
                points = sharedPref.getInt(SCORE_CS1,0);
                evalButton = findViewById(R.id.evaluate3);
                evalButton.setOnClickListener(this::onClick);
                break;
            case 1:
                text = "Cloud security is the whole bundle of technology, protocols, and best practices that protect cloud computing environments, applications running in the cloud, and data held in the cloud. Securing cloud services begins with understanding what exactly is being secured, as well as, the system aspects that must be managed.\n" +
                        "\n" +
                        "As an overview, backend development against security vulnerabilities is largely within the hands of cloud service providers. Aside from choosing a security-conscious provider, clients must focus mostly on proper service configuration and safe use habits. Additionally, clients should be sure that any end-user hardware and networks are properly secured.\n";
                topic_table = "What is Cloud Security?";
                break;
            case 2:
                text = "Every cloud security measure works to accomplish one or more of the following:\n" +
                        "\n" +
                        "1. Enable data recovery in case of data loss\n" +
                        "\n" +
                        "2. Protect storage and networks against malicious data theft\n" +
                        "\n" +
                        "3. Deter human error or negligence that causes data leaks\n" +
                        "\n" +
                        "4. Reduce the impact of any data or system compromise\n";
                topic_table = "How does It work?";
                break;
            case 3:
                text = "Duis ultrices malesuada mi, non suscipit dolor aliquet ut. Ut volutpat elit ligula, facilisis pellentesque metus cursus at. Fusce ut ultricies magna. Etiam pharetra urna enim, eu eleifend tortor sollicitudin ut. Maecenas quis fermentum eros. Curabitur rutrum malesuada neque, id ullamcorper urna lobortis ac. Nullam sed interdum purus, at tempor mi. Aenean tempus nulla a arcu lobortis gravida.";
                topic_table = "Cloud Security Risks";
                break;
            case 4:
                text = "Phasellus sed venenatis lorem, vel convallis lorem. Suspendisse pretium ante vel bibendum euismod. Nullam venenatis lacus erat, a sollicitudin tortor ultrices sed. Quisque sit amet vulputate mi, id volutpat enim. Mauris vulputate fringilla elit, at pellentesque ligula porta et. Donec a elementum dolor, fringilla sodales nibh. Vestibulum ac diam consequat, consequat est eget, placerat dui.";
                topic_table = "Types of Attacks";
                break;
        }

        TextView content = findViewById(R.id.topic_content);
        TextView title = findViewById(R.id.topic_title);
        content.setClickable(true);
        content.setMovementMethod(LinkMovementMethod.getInstance());
        title.setText(topic_table);
        content.setText(Html.fromHtml(text));

        curPoints.setText(""+points+"/10");
    }

    private void onClick(View view) {
        if (view == questionnaire)
        {

            switch(number)
            {
                case 0: question = findViewById(R.id.qAndANS3);
                    break;
            }

            if (count%2==0)
                question.setVisibility(View.VISIBLE);
            else
                question.setVisibility(View.GONE);

            count++;
        }
        else if (view == evalButton)
        {
            editor = sharedPref.edit();
            switch(number)
            {
                case 0:
                    points = 0;
                    editor.putInt(SCORE_CS1, points);
                    editor.commit();
                    question7 = findViewById(R.id.radioGroup7);
                    question8 = findViewById(R.id.radioGroup8);

                    if(question7.getCheckedRadioButtonId() == R.id.radioButton25)
                    {
                        points += 5;
                        editor.putInt(SCORE_CS1, points);
                        editor.commit();
                    }
                    else wrong += "1, ";
                    if(question8.getCheckedRadioButtonId() == R.id.radioButton29)
                    {
                        points += 5;
                        editor.putInt(SCORE_CS1, points);
                        editor.commit();
                    }
                    else wrong += "2";

                    editor.putInt(SCORE_CS1, points);
                    editor.commit();
                    curPoints.setText(""+points+"/10");
                    if(wrong.length()==0)
                        Toast.makeText(view.getContext(),"You have got Everything Correct!!",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(view.getContext(),"You have got Q: "+wrong+" Incorrect.",Toast.LENGTH_SHORT).show();

                    if(points>=5)
                        Toast.makeText(view.getContext(),"You scored "+ points + " points and unlocked the next Topic!!",Toast.LENGTH_SHORT).show();
                    wrong = "";
                    break;

            }
        }
    }
}
