package com.developer.bianca.createyouraccounttp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RemoveRegisterFragment extends Fragment {

    public RemoveRegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_remove_register, container, false);
    }

    public static RemoveRegisterFragment newInstance(){
        RemoveRegisterFragment fragment = new RemoveRegisterFragment();
        return fragment;
    }
}
