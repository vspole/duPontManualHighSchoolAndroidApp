package com.polepalli.vishal.manual;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

import com.polepalli.vishal.manual.R;



/**
 * Created by visha on 12/15/2016.
 */
public class Contact extends Fragment{

    View myView;
    WebView myWebView;
    ImageButton mobutton, gobutton,aobutton,atobutton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.contact, container, false);

       /* myWebView = (WebView) myView.findViewById(R.id.webview);
        WebSettings webSettings= myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        myWebView.loadUrl("http://www.dupontmanual.com/contact.htm");*/
        mobutton = (ImageButton)myView.findViewById(R.id.imageButton3);
        mobutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:5024858241"));
                startActivity(phoneIntent);
            }
        });
        gobutton = (ImageButton) myView.findViewById(R.id.imageButton6);
        gobutton.setOnClickListener(new View.OnClickListener(){
            public void onClick (View V)
            {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:5024858503"));
                startActivity(phoneIntent);
            }
        });
        aobutton = (ImageButton) myView.findViewById(R.id.imageButton5);
        aobutton.setOnClickListener(new View.OnClickListener(){
            public void onClick (View V)
            {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:5024858241"));
                startActivity(phoneIntent);
            }
        });
        atobutton = (ImageButton) myView.findViewById(R.id.imageButton7);
        atobutton.setOnClickListener(new View.OnClickListener(){
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
