package cr.ac.ucr.laboratorio2_android;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import adapters.ByCountryListAdapter;
import io.CountryApiAdapter;
import models.ByCountry;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ByCountryActivity extends AppCompatActivity implements Callback<ArrayList<ByCountry>> {
    private RecyclerView by_country_list_recycler;
    private List<ByCountry> byCountry = new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_by_country);
        by_country_list_recycler = findViewById(R.id.by_country_list_recycler);


        Date date2 = new Date();
        Date fecha = subtractDay(date2);

        String dateA = new SimpleDateFormat("yyyy-MM-dd'T'", Locale.getDefault()).format(fecha);
        String dateH = new SimpleDateFormat("yyyy-MM-dd'T'", Locale.getDefault()).format(fecha);
        dateA+= "00:00:00Z";
        dateH+= "23:59:59Z";

        Call<ArrayList<ByCountry>> call = CountryApiAdapter.getApiService().getCountry2(super.getIntent().getAction(), dateA, dateH);
        call.enqueue(this);

    }



    public static Date subtractDay(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    @Override
    public void onResponse(Call<ArrayList<ByCountry>> call, Response<ArrayList<ByCountry>> response) {
        if(response.isSuccessful()){

            byCountry = response.body();
            ByCountryListAdapter adapter = new ByCountryListAdapter(byCountry, this);
            by_country_list_recycler.setLayoutManager(new LinearLayoutManager(this));
            by_country_list_recycler.setAdapter(adapter);

        }
    }

    @Override
    public void onFailure(Call<ArrayList<ByCountry>> call, Throwable t) {

    }


}


