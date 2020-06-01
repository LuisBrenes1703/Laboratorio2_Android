package cr.ac.ucr.laboratorio2_android;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import adapters.CountryListAdapter;

import io.CountryApiAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import models.Country;

public class CountryListActivity extends AppCompatActivity implements Callback<ArrayList<Country>> {
    private RecyclerView country_list_recycler;
    private List<Country> countryList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        country_list_recycler = findViewById(R.id.country_list_recycler);

        Call<ArrayList<Country>> call = CountryApiAdapter.getApiService().getCountry1();


        call.enqueue(this);
        //call2.enqueue(this);

    }

    @Override
    public void onResponse(Call<ArrayList<Country>> call, Response<ArrayList<Country>> response) {

        if(response.isSuccessful()){

            countryList = response.body();

            CountryListAdapter adapter = new CountryListAdapter(countryList, this);
            country_list_recycler.setLayoutManager(new LinearLayoutManager(this));
            country_list_recycler.setAdapter(adapter);

        }

    }

    @Override
    public void onFailure(Call<ArrayList<Country>> call, Throwable t) {

    }





}




