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
public class StudentID extends Fragment{

    View myView;
    WebView myWebView;
    Button front,back;
    FragmentManager fragmentManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.studentid, container, false);
        fragmentManager = getFragmentManager();

        front = (Button)myView.findViewById(R.id.front);
        front.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent =  new Intent(StudentID.this.getActivity(), frontId.class);
                startActivity(intent);
            }
        });

        back = (Button) myView.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick (View V)
            {
                Intent intent =  new Intent(StudentID.this.getActivity(), backID.class);
                startActivity(intent);
            }
        });

        return myView;
    }


}
