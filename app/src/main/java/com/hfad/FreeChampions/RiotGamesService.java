package com.hfad.FreeChampions;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RiotGamesService {
    @GET("lol/platform/v3/champion-rotations")
    Call<FreeChampions> search(@Query("api_key")String apiKey);
}
