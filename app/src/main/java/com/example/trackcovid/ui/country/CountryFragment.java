package com.example.trackcovid.ui.country;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.trackcovid.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//import static com.example.trackcovid.ui.country.ItemClickSupport.*;

public class CountryFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    ArrayList <covidCountry> covidCountries;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_country, container, false);

        recyclerView=root.findViewById(R.id.navigation_country);
        progressBar=root.findViewById(R.id.progress_circular2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        getData();


        return root;
    }

    private void RecyclerView(){
        covidCountryAdapter covidCountryAdapter=new covidCountryAdapter(covidCountries);
        recyclerView.setAdapter(covidCountryAdapter);


    }



    public void showdetails(covidCountry covidCountry){
        Intent intent=new Intent(getActivity(),CountryDetails.class);
        intent.putExtra("EXTRA COVID", covidCountry);
        startActivity(intent);
    }



    private void getData() {
        RequestQueue queue= Volley.newRequestQueue(getActivity());
        String url="https://corona.lmao.ninja/v2/countries";
        covidCountries=new ArrayList<>();
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                try{
                    JSONArray jsonArray=new JSONArray(response);
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject data=jsonArray.getJSONObject(i);
                        //covidCountries.add(new covidCountry(data.getString("country"),data.getString("cases")));
                        covidCountries.add(new covidCountry(
                                data.getString("country"), data.getString("cases"),
                                data.getString("todayCases"), data.getString("deaths"),
                                data.getString("todayDeaths"), data.getString("recovered"),
                                data.getString("active"), data.getString("critical")
                        ));
                    }
                    RecyclerView();
                }
                catch(JSONException e){
                    e.printStackTrace();

                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);

            }
        });
        queue.add(stringRequest);
    }
}
