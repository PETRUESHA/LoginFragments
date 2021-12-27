package com.example.loginfragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.loginfragments.databinding.ActivityMainBinding;
import com.example.loginfragments.databinding.FragmentBinding;

public class Fragment1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String login;
    private FragmentBinding bind;
    private TextView mainText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            login = getArguments().getString(MainActivity.KEY);
            Log.d("GGG", login);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bind = FragmentBinding.inflate(inflater, container, false);
        View view = bind.getRoot();
        mainText = bind.welcomeText;
        mainText.setText("Welcome, " + login + "!");
        return view;
    }
}