package com.example.nestedfragments;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by Shrey on 01/05/2017.
 */

public class FragmentB extends Fragment
{
    EditText et2;
    int num2;
    FragmentC fragmentC = new FragmentC();
    FragmentA fA;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View v= inflater.inflate(R.layout.fragment_b, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        et2=(EditText)getView().findViewById(R.id.et2);
        et2.addTextChangedListener(new TextWatcher()
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
                    num2=Integer.parseInt(s.toString());
                }
                catch (Exception e)
                {
                    num2=0;
                }

                FragmentC fC = (FragmentC) getChildFragmentManager().findFragmentByTag("Fragment C");
                fC.recall();

            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });

        fA = (FragmentA) getParentFragment();

        setBorder();
        insertNestedFragment();

    }

    void setBorder()
    {
        LinearLayout linearLayout = (LinearLayout)getView().findViewById(R.id.fragment_b);
        GradientDrawable gd = (GradientDrawable)getView().getBackground();
        gd.setStroke(14, Color.RED);
        linearLayout.setBackgroundDrawable(gd);
    }

    void insertNestedFragment()
    {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.placeholder_c,fragmentC, "Fragment C");
        transaction.commit();
    }

    int getSum()
    {
        return fA.getNum1()+num2;
    }
}
