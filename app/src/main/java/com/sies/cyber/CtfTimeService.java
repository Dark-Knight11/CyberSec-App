package com.sies.cyber;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CtfTimeService {

    @GET("events/")
    Call<List<CtfsInfo>> getCtf(
            @Query("limit") int limit,
            @Query("start") long startdate,
            @Query("finish") long finishDate
    );
}
