package adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import cr.ac.ucr.laboratorio2_android.ByCountryActivity;
import cr.ac.ucr.laboratorio2_android.CountryListActivity;
import cr.ac.ucr.laboratorio2_android.R;
import models.Country;


public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CountryViewHolder> {

    private List<Country> countryList;
    private Context context;

    public CountryListAdapter(List<Country> countryList, Context context) {
        this.countryList = countryList;
        this.context = context;
    }


    @NonNull
    @Override
    public CountryListAdapter.CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.country_list_item, parent, false);
        CountryListAdapter.CountryViewHolder viewHolder = new CountryListAdapter.CountryViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryListAdapter.CountryViewHolder holder, int position) {

        final Country country = countryList.get(position);
        holder.id.setText(country.getCountry());

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Toast.makeText(context, "El país seleccionado es: "+country.getCountry(), Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(context.getApplicationContext(), ByCountryActivity.class);
                intent.setAction(country.getCountry());
                context.startActivity(intent);

            }
        });
    }

    /*
     Me permite conocer el tamaño de la lista en tiempo real
     */
    @Override
    public int getItemCount() {
        return countryList.size();
    }


    //View holder para lograr llenar el contenido de cada item
    public static class CountryViewHolder extends RecyclerView.ViewHolder {

        public TextView id;

        public ConstraintLayout itemLayout;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.id = (TextView) itemView.findViewById(R.id.tv_id);
            this.itemLayout = (ConstraintLayout) itemView.findViewById(R.id.cl_students_list_item);
        }
    }






}

