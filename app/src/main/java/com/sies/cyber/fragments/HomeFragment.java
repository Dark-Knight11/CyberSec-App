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
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false);
        //mRecyclerView.setLayoutManager(gridLayoutManager);
        //mRecyclerView.setHasFixedSize(true);
        //mRecyclerView.setAdapter(adapter);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2,VERTICAL,false));
        dataHolder = new ArrayList<>();


        DataModel ob1 = new DataModel(R.drawable.ic_baseline_architecture_24,"First Topic");
        dataHolder.add(ob1);

        DataModel ob2 = new DataModel(R.drawable.ic_baseline_beenhere_24,"Second Topic");
        dataHolder.add(ob2);

        DataModel ob3 = new DataModel(R.drawable.ic_baseline_backpack_24,"Third Topic");
        dataHolder.add(ob3);

        DataModel ob4 = new DataModel(R.drawable.ic_baseline_assignment_ind_24,"Fourth Topic");
        dataHolder.add(ob4);

        DataModel ob5 = new DataModel(R.drawable.ic_baseline_architecture_24,"Fifth Topic");
        dataHolder.add(ob5);

        DataModel ob6 = new DataModel(R.drawable.ic_baseline_beenhere_24,"Sixth Topic");
        dataHolder.add(ob6);

        DataModel ob7 = new DataModel(R.drawable.ic_baseline_backpack_24,"Seventh Topic");
        dataHolder.add(ob7);

        DataModel ob8 = new DataModel(R.drawable.ic_baseline_assignment_ind_24,"Eight Topic");
        dataHolder.add(ob8);

        DataModel ob9 = new DataModel(R.drawable.ic_baseline_architecture_24,"Ninth Topic");
        dataHolder.add(ob9);

        DataModel ob10 = new DataModel(R.drawable.ic_baseline_beenhere_24,"Tenth Topic");
        dataHolder.add(ob10);

        DataModel ob11 = new DataModel(R.drawable.ic_baseline_backpack_24,"Eleventh Topic");
        dataHolder.add(ob11);

        DataModel ob12 = new DataModel(R.drawable.ic_baseline_assignment_ind_24,"Twelfth Topic");
        dataHolder.add(ob12);

        mRecyclerView.setAdapter(new myAdapter(dataHolder));

        return view;
    }
}