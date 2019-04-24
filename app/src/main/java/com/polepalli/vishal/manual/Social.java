package com.polepalli.vishal.manual;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
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
public class Social extends Fragment{

    View myView;
    WebView myWebView;
    Button MHST, MAT,CT,MF,jcps;
    FragmentManager fragmentManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.socialmedia, container, false);
        fragmentManager = getFragmentManager();

        MHST = (Button)myView.findViewById(R.id.MHST);
        MHST.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent =  new Intent(Social.this.getActivity(), Manualtwitter.class);
                startActivity(intent);
            }
        });

        MAT = (Button) myView.findViewById(R.id.MAT);
        MAT.setOnClickListener(new View.OnClickListener(){
            public void onClick (View V)
            {
                Intent intent =  new Intent(Social.this.getActivity(), ManualAT.class);
                startActivity(intent);
            }
        });

        CT = (Button) myView.findViewById(R.id.CT);
        CT.setOnClickListener(new View.OnClickListener(){
            public void onClick (View V)
            {
                Intent intent =  new Intent(Social.this.getActivity(), ManualGT.class);
                startActivity(intent);

            }
        });

        MF = (Button) myView.findViewById(R.id.MF);
        MF.setOnClickListener(new View.OnClickListener(){
            public void onClick (View V)
            {
                Intent intent =  new Intent(Social.this.getActivity(), ManualFacebook.class);
                startActivity(intent);
            }
        });
        jcps = (Button) myView.findViewById(R.id.jcps);
        jcps.setOnClickListener(new View.OnClickListener(){
            public void onClick (View V)
            {
                Intent intent =  new Intent(Social.this.getActivity(), JCPSTWITTER.class);
                startActivity(intent);
            }
        });
        return myView;
    }


}
