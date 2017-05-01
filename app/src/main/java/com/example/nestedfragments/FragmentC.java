package com.example.nestedfragments;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Shrey on 01/05/2017.
 */

public class FragmentC extends Fragment
{
    TextView tv;
    int sum=0;
    FragmentB fB;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v= inflater.inflate(R.layout.fragment_c, container, false);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        tv=(TextView)getView().findViewById(R.id.tv);

        setBorder();

        fB = (FragmentB)getParentFragment();



    }

    void recall()
    {
        sum = fB.getSum();
        tv.setText(Integer.toString(sum));
    }

    void setBorder()
    {
        LinearLayout linearLayout = (LinearLayout)getView().findViewById(R.id.fragment_c);
        GradientDrawable gd = (GradientDrawable)getView().getBackground();
        gd.setStroke(14, Color.GREEN);
        linearLayout.setBackgroundDrawable(gd);
    }
}
