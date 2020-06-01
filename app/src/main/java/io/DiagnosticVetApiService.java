package io;

import java.util.ArrayList;

import models.ByCountry;
import models.Country;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface DiagnosticVetApiService {

    @GET("countries")
    Call<ArrayList<Country>> getCountry1();

    //@GET("country/{país}/status/confirmed?from=2020-05-29T00:00:00Z&to=2020-05-29T23:59:59Z")
    //Call<ArrayList<ByCountry>> getCountry2("país");

    @GET("country/{pais}/status/confirmed")
    Call<ArrayList<ByCountry>> getCountry2(@Path("pais") String pais, @Query("from") String yesterday, @Query("to") String today);

}
