package com.polepalli.vishal.manual;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;



/**
 * Created by visha on 12/15/2016.
 */
public class Athletics extends Fragment{

    View myView;
    WebView myWebView;
    Button teams, calendar,call;
    public FragmentManager fragmentManager = getFragmentManager();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.athletics, container, false);
       /* myWebView = (WebView) myView.findViewById(R.id.webview);
        WebSettings webSettings= myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        myWebView.loadUrl("http://www.dupontmanual.com/contact.htm");*/
        teams = (Button)myView.findViewById(R.id.teams);
        teams.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent =  new Intent(Athletics.this.getActivity(), Teams.class);
                startActivity(intent);
            }
        });
        calendar = (Button) myView.findViewById(R.id.calendar);
        calendar.setOnClickListener(new View.OnClickListener(){
            public void onClick (View V)
            {
                Intent intent =  new Intent(Athletics.this.getActivity(), Calendar.class);
                startActivity(intent);
            }
        });
        call = (Button) myView.findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener(){
            public void onClick (View V)
            {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:5024858489"));
                startActivity(phoneIntent);
            }
        });

        return myView;
    }


}
