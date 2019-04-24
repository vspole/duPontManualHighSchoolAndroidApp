package com.polepalli.vishal.manual;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by visha on 5/2/2017.
 */

public class RedOrWhite extends Fragment {

    View myView;
    String showURL = "https://74.134.92.229/PhpProject2/ShowRoW.php";
    RequestQueue requestQueue;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.redorwhite, container, false);
        textView = (TextView) myView.findViewById(R.id.RedOrWhite);
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                showURL,new Response.Listener<JSONObject>()
                    {
                        @Override
                        public void onResponse(JSONObject response)
                        {
                            try {
                                JSONArray days = response.getJSONArray("row");
                                for (int i = 0; i<days.length(); i++)
                                {
                                    JSONObject day = days.getJSONObject(i);
                                    String date = day.getString("Date");
                                    String row = day.getString("RoW");

                                    textView.append(date + " " + row);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener()
                        {
                            public void onErrorResponse(VolleyError error)
                            {

                            }
                        });


        return myView;
    }
}


