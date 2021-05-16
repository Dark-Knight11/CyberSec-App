package com.sies.cyber.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.sies.cyber.R;
import com.sies.cyber.Sign_In;

import static com.sies.cyber.Network_Security.SHARED_PREFS;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    public static final String PERSON_NAME = "Person_Name";
    public static final String PERSON_USER_NAME = "User_Name";
    public static final String PERSON_EMAIL = "Person_Email";
    public static final String PERSON_AGE = "Person_Age";
    public static final String PERSON_DESC = "Person_Desc";

    EditText name, age, username, email, description;
    Button logOut,editButton;
    int count=0;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View RootView = inflater.inflate(R.layout.fragment_settings, container, false);
        sharedPref = this.getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        name = RootView.findViewById(R.id.personName);
        age = RootView.findViewById(R.id.personAge);
        username = RootView.findViewById(R.id.personUsername);
        email = RootView.findViewById(R.id.personEmail);
        description = RootView.findViewById(R.id.personDesc);

        name.setText(sharedPref.getString(PERSON_NAME, "Anand"));
        age.setText(sharedPref.getString(PERSON_AGE, "20"));
        username.setText(sharedPref.getString(PERSON_USER_NAME, "anandb235"));
        email.setText(sharedPref.getString(PERSON_EMAIL, "borkaranand19@siesgst.ac.in"));
        description.setText(sharedPref.getString(PERSON_DESC,"--"));

        editButton = RootView.findViewById(R.id.button4);
        editButton.setOnClickListener(this::onClick);

        logOut = RootView.findViewById(R.id.button3);
        logOut.setOnClickListener(this::onClick);
        return RootView;
    }

    private void onClick(View v) {
        if(v==logOut)
        {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(getContext(), "Logged Out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getActivity(), Sign_In.class));
        }
        if(v==editButton)
        {
            editor = sharedPref.edit();
            editor.putString(PERSON_NAME, name.getText().toString());
            editor.apply();
            editor.putString(PERSON_AGE, age.getText().toString());
            editor.apply();
            editor.putString(PERSON_USER_NAME, username.getText().toString());
            editor.apply();
            editor.putString(PERSON_EMAIL, email.getText().toString());
            editor.apply();
            editor.putString(PERSON_DESC, description.getText().toString());
            editor.apply();

            Toast.makeText(this.getActivity(), "Information Saved Successfully", Toast.LENGTH_SHORT).show();
        }

    }
}