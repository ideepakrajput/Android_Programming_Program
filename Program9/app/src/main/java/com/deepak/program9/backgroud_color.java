package com.deepak.program9;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class backgroud_color extends Fragment {

    Button changebackground,changefragment,reset;
    TextView heading;
    public backgroud_color(){super();}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.background_color,container,false);

        heading = getActivity().findViewById(R.id.heading);
        changebackground = view.findViewById(R.id.changebackgroundcolor);
        changefragment = view.findViewById(R.id.changeFragment);
        reset = view.findViewById(R.id.reset);

        changebackground.setOnClickListener(view1 -> {
            Random random = new Random();
            int color = Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256));
            heading.setBackgroundColor(color);
        });

        changefragment.setOnClickListener(view1 -> {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.frameChanger,new fore_color_text());
            fragmentTransaction.commit();
        });
        return view;
    }

}