package com.example.plantravel;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewTravel extends Fragment {

    Context ctx;
    public NewTravel() {
        this.ctx = ctx;
    }

    private Button btnLoc, btnSelect, btnCriarViagem;
    private EditText edtLocal;
    private TextView txtEnd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = getActivity().findViewById(android.R.id.content);
        Snackbar.make(v, "Nova Viagem", Snackbar.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_new_travel, container, false);

    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        btnLoc = (Button) getView().findViewById(R.id.btnLoc);
        btnSelect = (Button) getView().findViewById(R.id.btnSelect);
        btnCriarViagem = getView().findViewById(R.id.btnCriarViagem);
        edtLocal = (EditText) getView().findViewById(R.id.edtLoc);
        txtEnd = (TextView) getView().findViewById(R.id.endereco);

        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String endereco = edtLocal.getText().toString();
                GeoLocation geoLocation = new GeoLocation();
                geoLocation.getAdress(endereco, getContext(), new GeoHandler());
            }
        });

        /*btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ctx, Principal.class);
                startActivity(it);
            }
        });*/

        btnCriarViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(ctx, "Viagem criada", Toast.LENGTH_SHORT).show();
                Fragment fragmento = new Inicio();
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.nav_host_fragment, fragmento);
                trans.commit();
            }
        });
    }

    /*public void criarViagem(View v){
        Toast.makeText(ctx, "Viagem criada", Toast.LENGTH_SHORT).show();
        Fragment fragmento = new Inicio();
        FragmentTransaction trans = getFragmentManager().beginTransaction();
        trans.replace(R.id.nav_host_fragment, fragmento);
        trans.commit();
    }*/

    private class GeoHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            String endereco;
            switch(msg.what){
                case 1:
                    Bundle bundle = msg.getData();
                    endereco = bundle.getString("endereco");
                    break;
                default:
                    endereco = null;
            }

            txtEnd.setText(endereco);
        }
    }
}
