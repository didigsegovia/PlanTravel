package com.example.plantravel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ViagensAdapter extends RecyclerView.Adapter<LinhaHolder> {
    private String[] mDataset;
    private final List<UserModel> modelo;
    private Object Viagens;


    // Construtor

    public ViagensAdapter(List usuarios){
        modelo = usuarios;
    }




    @Override
    public LinhaHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new LinhaHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_adapter, parent, false));
    }

    //Modificar info da view
    @Override
    public void onBindViewHolder(LinhaHolder holder, final int position) {


        /***************************************************************************/
        /** AQUI FAZER A IMPLEMENTAÇÃO DO BANCO DE DADOS PRA PEGAR VIAGEM E AMIGOS**/
        /***************************************************************************/






        holder.titulo.setText(String.format(Locale.getDefault(), "%Viagem"));
                /* modelo.get(position).getName(),     // Nome da Viagem*/


        holder.amigos.setText(String.format(Locale.getDefault(), "%amigo" ));
        /*modelo.get(position).getAmigos(),       // Nome dos amigos */

        holder.manageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViagensAdapter.this.modificarItem(position);
            }
        });
        holder.excluirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViagensAdapter.this.deletarItem(position);
            }
        });

    }

    private void deletarItem(int position) {
        modelo.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, modelo.size());
    }

    private void modificarItem(int position) {
        /**Modificar item no BD**/

    }


    @Override
    public int getItemCount(){
        return modelo != null ? modelo.size() : 0;
    }

    /** Método publico pra fazer update na lista*/

    public void updateList(UserModel usuario){

        insertItem(usuario);
    }

    private void insertItem(UserModel usuario) {
        modelo.add(usuario);
        notifyItemInserted(getItemCount());
    }






}
