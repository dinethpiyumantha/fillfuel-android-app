package edu.sliitead.fillfuelapp.services;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.logging.Logger;

import edu.sliitead.fillfuelapp.models.Fuel;
import edu.sliitead.fillfuelapp.utils.Constants;

public class FuelExternalAPICalls {


    public static void getFuels (ArrayList arrayList) {

        String url = Constants.BASE_URL+"/api/fuel";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray(null);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String id = jsonObject.getString("_id");
                                String name = jsonObject.getString("name");
                                String createdAt = jsonObject.getString("createdAt");
                                String updatedAt = jsonObject.getString("updatedAt");

                                arrayList.add(new Fuel(id, name, createdAt, updatedAt));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
    }
}
