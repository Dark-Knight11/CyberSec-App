package com.sies.cyber;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.sies.cyber.fragments.CTFfragment;
import com.sies.cyber.fragments.HomeFragment;
import com.sies.cyber.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View settings = findViewById(R.id.page_2);
        View home = findViewById(R.id.page_1);
        View ctf = findViewById(R.id.page_3);

        // Begin the transaction
        FragmentManager ft = getSupportFragmentManager();
        // FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.beginTransaction().add(R.id.fl_wrapper, new HomeFragment(), "Home").commit();
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added
        settings.setOnClickListener(v -> ft.beginTransaction().replace(R.id.fl_wrapper, new SettingsFragment(), "Settings").commit());
        home.setOnClickListener(v -> ft.beginTransaction().replace(R.id.fl_wrapper, new HomeFragment(), "Home").commit());
        ctf.setOnClickListener(v -> ft.beginTransaction().replace(R.id.fl_wrapper, new CTFfragment(), "Ctf").commit());

    }
}