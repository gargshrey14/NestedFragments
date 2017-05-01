package com.example.nestedfragments;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by Shrey on 01/05/2017.
 */

public class FragmentA extends Fragment
{
    EditText et1;
    int num1;

    FragmentB fragmentB = new FragmentB();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v= inflater.inflate(R.layout.fragment_a, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        et1=(EditText)getView().findViewById(R.id.et1);
        et1.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                try
                {
                    num1=Integer.parseInt(s.toString());
                }
                catch (Exception e)
                {
                    num1=0;
                }

                FragmentB fB = (FragmentB)getChildFragmentManager().findFragmentByTag("Fragment B");
                FragmentC fC = (FragmentC)fB.getChildFragmentManager().findFragmentByTag("Fragment C");
                fC.recall();
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        setBorder();
        insertNestedFragment();

    }

    int getNum1()
    {
        return num1;
    }

    void setBorder()
    {
        LinearLayout linearLayout = (LinearLayout)getView().findViewById(R.id.fragment_a);
        GradientDrawable gd = (GradientDrawable)getView().getBackground();
        gd.setStroke(14, Color.BLUE);
        linearLayout.setBackgroundDrawable(gd);
    }

    void insertNestedFragment()
    {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.placeholder_b,fragmentB, "Fragment B");
        transaction.commit();
    }

}
