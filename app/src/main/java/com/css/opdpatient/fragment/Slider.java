package com.css.opdpatient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.css.opdpatient.R;

/***
 * Project created by Jyoti on 19 Jan 2018 Friday
 *Navigation drwaer of the application
 */
public class Slider extends BaseFragment {

    private String TAG = "Slider";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.slider, container, false);

        initUIControls(view);

        registerForListener();

        setUIData();

        return view;
    }
}
