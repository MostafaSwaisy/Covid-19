package com.example.cov19.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.cov19.R;

import org.json.JSONException;
import org.json.JSONObject;


public class StatsFragment extends Fragment {

    RequestQueue mQueue;
    TextView number , date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_stats, container, false);

        mQueue = Volley.newRequestQueue(getActivity());
        date = view.findViewById(R.id.date);
        number = view.findViewById(R.id.number);
        jsonPares();

        return view;
    }
    private void jsonPares() {
        String url = "https://corona-virus-stats.herokuapp.com/api/v1/cases/general-stats";
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject jsonObject = response.getJSONObject("data");


                    number.setText(jsonObject.getString("total_cases"));
                    date.setText(jsonObject.getString("last_update"));
                    Log.d("Json", jsonObject.getString("recovery_cases"));
                    Log.d("Json", jsonObject.getString("death_cases"));
                    Log.d("Json", jsonObject.getString("currently_infected"));
                    Log.d("Json", jsonObject.getString("cases_with_outcome"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Json", error.getMessage());
                Log.d("Json", "GG");
            }
        });
        mQueue.add(request);

    }
}
