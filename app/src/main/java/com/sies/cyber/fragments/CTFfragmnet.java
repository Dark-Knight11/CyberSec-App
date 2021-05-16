package com.sies.cyber.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

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
 * Use the {@link CTFfragmnet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CTFfragmnet extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView ctfName, startDate, endDate;
    private List<CtfsInfo> res;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public CTFfragmnet() {
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
    public static CTFfragmnet newInstance(String param1, String param2) {
        CTFfragmnet fragment = new CTFfragmnet();
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
        ctfName = RootView.findViewById(R.id.ctf);
        startDate = RootView.findViewById(R.id.start);
        endDate = RootView.findViewById(R.id.end);

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
                Toast.makeText(getContext(), Integer.toString(res.size()),Toast.LENGTH_SHORT).show(); // prints total no of Ctf's

                // making title a hyperlink
                SpannableString str = new SpannableString(res.get(0).getTitle());
                ClickableSpan span1 = new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        String url = res.get(0).getCtftime_url(); // link to ctf
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                };
                str.setSpan(span1 ,0, str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ctfName.setText(str);
                ctfName.setMovementMethod(LinkMovementMethod.getInstance());

                startDate.setText(res.get(0).getStart()); // start Date
                endDate.setText(res.get(0).getFinish()); // End Date
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