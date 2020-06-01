
package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import cr.ac.ucr.laboratorio2_android.R;
import models.ByCountry;


public class ByCountryListAdapter extends RecyclerView.Adapter<ByCountryListAdapter.CountryViewHolder> {

    private List<ByCountry> countryList;
    private Context context;


    public ByCountryListAdapter(List<ByCountry> countryList, Context context) {

        this.countryList = countryList;
        this.context = context;

    }


    @NonNull
    @Override
    public ByCountryListAdapter.CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.by_country_list_item, parent, false);
        ByCountryListAdapter.CountryViewHolder viewHolder = new ByCountryListAdapter.CountryViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ByCountryListAdapter.CountryViewHolder holder, int position) {

        final ByCountry country = countryList.get(position);
        holder.idCountry.setText("Country: "+country.getCountry());
        holder.idCountryCode.setText("Country Code: "+country.getCountryCode());
        holder.idProvince.setText("Province: "+country.getProvince());
        holder.idCity.setText("City: "+country.getCity());
        holder.idCityCode.setText("City Code: "+country.getCityCode());
        holder.idLat.setText("Lat: "+country.getLat());
        holder.idLon.setText("Lon: "+country.getLon());
        holder.idCases.setText("Cases: "+country.getCases());
        holder.idStatus.setText("Status: "+country.getStatus());
        holder.idDate.setText("Date: "+country.getDate());

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

        //public TextView id;
        public TextView idCountry;
        public TextView idCountryCode;
        public TextView idProvince;
        public TextView idCity;
        public TextView idCityCode;
        public TextView idLat;
        public TextView idLon;
        public TextView idCases;
        public TextView idStatus;
        public TextView idDate;

        public ConstraintLayout itemLayout;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
           //this.id = (TextView) itemView.findViewById(R.id.tv_id2);
            this.idCountry = (TextView) itemView.findViewById(R.id.tv_id2);
            this.idCountryCode = (TextView) itemView.findViewById(R.id.tv_id3);
            this.idProvince = (TextView) itemView.findViewById(R.id.tv_id4);
            this.idCity = (TextView) itemView.findViewById(R.id.tv_id5);
            this.idCityCode = (TextView) itemView.findViewById(R.id.tv_id6);
            this.idLat = (TextView) itemView.findViewById(R.id.tv_id7);
            this.idLon = (TextView) itemView.findViewById(R.id.tv_id8);
            this.idCases = (TextView) itemView.findViewById(R.id.tv_id9);
            this.idStatus = (TextView) itemView.findViewById(R.id.tv_id10);
            this.idDate = (TextView) itemView.findViewById(R.id.tv_id11);
            this.itemLayout = (ConstraintLayout) itemView.findViewById(R.id.by_country_item);
        }
    }
}

