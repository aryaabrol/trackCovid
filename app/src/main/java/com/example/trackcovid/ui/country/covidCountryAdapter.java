package com.example.trackcovid.ui.country;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trackcovid.R;

import java.util.ArrayList;

public class covidCountryAdapter extends RecyclerView.Adapter<covidCountryAdapter.ViewHolder> {

    ArrayList<covidCountry> covidCountries;
    public covidCountryAdapter(ArrayList<covidCountry> covidCountries){
        this.covidCountries=covidCountries;
    }
    @NonNull
    @Override
    public covidCountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_covid,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull covidCountryAdapter.ViewHolder holder, int position) {
        covidCountry covidCountry=covidCountries.get(position);
        holder.cases.setText(covidCountry.getCases());
        holder.country.setText(covidCountry.getCountry());

    }

    @Override
    public int getItemCount() {
        return covidCountries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView cases,country;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            country=itemView.findViewById(R.id.textView);
            cases=itemView.findViewById(R.id.textView2);
        }
    }
}
