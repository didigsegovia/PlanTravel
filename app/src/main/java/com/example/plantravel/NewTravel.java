package com.example.plantravel;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
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
public class NewTravel extends Fragment {


    public NewTravel() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = getActivity().findViewById(android.R.id.content);
        Snackbar.make(v, "Nova Viagem", Snackbar.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_new_travel, container, false);

    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button btnLoc = (Button) getView().findViewById(R.id.btnLoc);
        EditText edtLocal = (EditText) getView().findViewById(R.id.edtLoc);
        final TextView txtEnd = (TextView) getView().findViewById(R.id.endereco);

        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtEnd.setText("macaco");   // Implementar funções da página NewTravel
            }
        });
    }

        public void clickBuscar(){
        /* Implementar botão de bsucar endereço ou a função do botão buscar(?)
        * Não tinha entendido bem esse botão mas manda verrr */
        }

}
