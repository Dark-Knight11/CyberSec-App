package com.sies.cyber.fragments;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sies.cyber.CTFadapter;
import com.sies.cyber.CtfTimeService;
import com.sies.cyber.CtfsInfo;
import com.sies.cyber.R;

import java.time.Instant;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CTFfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CTFfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView ctfRecyclerView;
    List<CtfsInfo> res;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public CTFfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CTFfragmnet.
     */
    // TODO: Rename and change types and number of parameters
    public static CTFfragment newInstance(String param1, String param2) {
        CTFfragment fragment = new CTFfragment();
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View RootView = inflater.inflate(R.layout.fragment_ctf, container, false);
        ctfRecyclerView = RootView.findViewById(R.id.ctf_recycler_view);

        ctfRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        int limit = 100;
        // start timestamp
        Instant instant = Instant.now();
        long start = instant.getEpochSecond();
        // end time stamp 16th June
        long finish = 1623852139;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ctftime.org/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CtfTimeService ctftimeservice = retrofit.create(CtfTimeService.class);

        ctftimeservice.getCtf(limit, start, finish).enqueue(new Callback<List<CtfsInfo>>() {
            @Override
            public void onResponse(Call<List<CtfsInfo>> call, Response<List<CtfsInfo>> response) {
                res = response.body(); // json response stored in list
                ctfRecyclerView.setAdapter(new CTFadapter(res));
            }

            @Override
            public void onFailure(Call<List<CtfsInfo>> call, Throwable t) {
                Log.i("on Failure",t.getMessage());
            }
        });

        // Inflate the layout for this fragment
        return RootView;
    }
}