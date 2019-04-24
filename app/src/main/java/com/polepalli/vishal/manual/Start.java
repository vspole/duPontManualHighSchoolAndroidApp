package com.polepalli.vishal.manual;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.polepalli.vishal.manual.R;

import org.w3c.dom.Text;


/**
 * Created by visha on 12/15/2016.
 */
public class Start extends Fragment{

    View myView;
    TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.start, container, false);
        tv = (TextView) myView.findViewById(R.id.textView6);
        Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"fonts/ebrimabd.ttf");
        tv.setTypeface(type);
        tv.setText("duPont Manual \n High School");
        return myView;
    }
}
