package com.example.plantravel;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Amigos extends Fragment {


    private final Context ctx;

    public Amigos(Context ctx) {
        // Required empty public constructor
        this.ctx = ctx;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = getActivity().findViewById(android.R.id.content);
        Snackbar.make(v, "Amigos", Snackbar.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_amigos, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        /* **** IMPLEMENTAR AQUI O CÓDIGO DO FRAGMENT, POIS IRÁ FUNCIONAR APENAS NESSE CAMPO **** */
        Intent it;
        it = new Intent(ctx, Principal.class);
        startActivity(it);


    }

}
