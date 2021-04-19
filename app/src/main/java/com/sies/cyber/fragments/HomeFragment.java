package com.sies.cyber.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sies.cyber.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.widget.GridLayout.VERTICAL;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView mRecyclerView;
    ArrayList<DataModel> dataHolder;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = view.findViewById(R.id.topic_recyclerview);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2,VERTICAL,false));
        dataHolder = new ArrayList<>();


        DataModel ob1 = new DataModel(R.drawable.application_security,"Application Security");
        dataHolder.add(ob1);

        DataModel ob2 = new DataModel(R.drawable.cloud_security,"Cloud Security");
        dataHolder.add(ob2);

        DataModel ob3 = new DataModel(R.drawable.data_security,"Data Security");
        dataHolder.add(ob3);

        DataModel ob4 = new DataModel(R.drawable.linux_security,"Linux Essentials");
        dataHolder.add(ob4);

        DataModel ob5 = new DataModel(R.drawable.wapt_security,"Web App Pen-Testing");
        dataHolder.add(ob5);

        mRecyclerView.setAdapter(new myAdapter(dataHolder));

        return view;
    }
}