package com.example.plantravel;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Inicio extends Fragment {
    RecyclerView myRecView;
    private ViagensAdapter viagensAdapter;
    Context context;
    LinearLayoutManager layMan;
    private View view;
    private Bundle savedInstanceState;


    @Override
    public void onAttach(Context context){
        this.context = context;
        super.onAttach(context);
    }


    public Inicio() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = getActivity().findViewById(android.R.id.content);
        Snackbar.make(v, "Inicio", Snackbar.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        /** TRECHO DE CÓDIGO PARA INCIALIZAR O RECYCLERVIEW, NÃO MEXER MTO NESSA PARTE */
        myRecView = (RecyclerView) getView().findViewById(R.id.recyclerViagens);
        layMan = new LinearLayoutManager(context);

        myRecView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        myRecView.setLayoutManager(layMan);

        viagensAdapter = new ViagensAdapter(new ArrayList<>(0));
        myRecView.setAdapter(viagensAdapter);
        /** FECHAMENTO DO TRECHO **********************************************************/


        /* **** IMPLEMENTAR AQUI O CÓDIGO DO FRAGMENT, POIS IRÁ FUNCIONAR APENAS NESSE CAMPO **** */



    }



}
