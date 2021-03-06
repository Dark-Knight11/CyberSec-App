package com.sies.cyber;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WAPT_Security extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.astopic);
        Intent intent = getIntent();

        int number = intent.getIntExtra("inTOPIC",0);
        String text = "", topic_table = "";

        ImageButton back = findViewById(R.id.backButton);
        Intent in = new Intent(WAPT_Security.this, Topic_Common.class);
        in.putExtra("TOPIC",4);
        back.setOnClickListener(v -> startActivity(in));

        switch(number){
            case 0:
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus et purus a orci interdum eleifend. Morbi iaculis laoreet turpis, ac suscipit magna molestie id. Maecenas interdum tincidunt nunc, ac vehicula nulla rhoncus eget. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Praesent nulla ante, condimentum ut orci eu, congue iaculis lectus. Sed nec neque rhoncus, tempus sem quis, facilisis urna. Curabitur vel ligula sapien. Sed at volutpat orci, at pretium mi. Integer consectetur malesuada purus, vel consequat est finibus at. Curabitur in venenatis libero, sed suscipit lorem.";
                topic_table = "Basics of Web";
                break;
            case 1:
                text = "Phasellus molestie diam sed facilisis blandit. Nullam posuere sapien id neque laoreet iaculis. Aliquam erat volutpat. Nullam in orci rutrum, iaculis diam hendrerit, posuere odio. Maecenas quis massa nulla. Suspendisse convallis bibendum ligula, a luctus risus. Integer hendrerit, sapien id lobortis congue, sem elit pellentesque erat, ut tincidunt urna velit sit amet elit. Curabitur venenatis nisl purus, luctus dignissim magna ultricies at. Donec aliquam mollis massa, et sagittis augue consequat id. Integer nec tristique risus. Integer in interdum lacus. Duis placerat hendrerit eros, non volutpat purus imperdiet tincidunt. Duis auctor purus eu arcu blandit rutrum. Nam vestibulum convallis magna vel facilisis. Nulla condimentum hendrerit sapien vitae suscipit.";
                topic_table = "Vulnerabilities";
                break;
            case 2:
                text = "Nullam bibendum feugiat enim tincidunt sodales. Aliquam ut quam id est ultrices tincidunt non in sapien. Curabitur lacus ex, bibendum consectetur dolor quis, blandit gravida lorem. Nunc id nisl sit amet lectus sodales mattis quis in nisl. Praesent eget neque dui. Suspendisse nisl sem, bibendum vitae accumsan id, blandit non arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Sed a dui placerat, dapibus mauris nec, sollicitudin lorem. Nulla laoreet dui porta nibh convallis tincidunt. Aliquam erat volutpat. Aenean ac scelerisque tellus. Etiam molestie, ex quis consequat auctor, nunc enim egestas enim, nec bibendum augue mauris auctor lorem. Etiam faucibus molestie lacinia. Duis in risus risus.";
                topic_table = "OWASP Top 10";
                break;
            case 3:
                text = "Duis ultrices malesuada mi, non suscipit dolor aliquet ut. Ut volutpat elit ligula, facilisis pellentesque metus cursus at. Fusce ut ultricies magna. Etiam pharetra urna enim, eu eleifend tortor sollicitudin ut. Maecenas quis fermentum eros. Curabitur rutrum malesuada neque, id ullamcorper urna lobortis ac. Nullam sed interdum purus, at tempor mi. Aenean tempus nulla a arcu lobortis gravida.";
                topic_table = "Bug Bounty Hunting";
                break;
            case 4:
                text = "Phasellus sed venenatis lorem, vel convallis lorem. Suspendisse pretium ante vel bibendum euismod. Nullam venenatis lacus erat, a sollicitudin tortor ultrices sed. Quisque sit amet vulputate mi, id volutpat enim. Mauris vulputate fringilla elit, at pellentesque ligula porta et. Donec a elementum dolor, fringilla sodales nibh. Vestibulum ac diam consequat, consequat est eget, placerat dui.";
                topic_table = "Pentesting";
                break;
        }

        TextView content = findViewById(R.id.topic_content);
        TextView title = findViewById(R.id.topic_title);
        title.setText(topic_table);
        content.setText(text);
    }
}
