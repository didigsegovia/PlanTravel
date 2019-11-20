package com.example.plantravel;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class LinhaHolder extends RecyclerView.ViewHolder {
    public TextView titulo;
    public TextView amigos;
    public ImageButton manageButton;
    public ImageButton excluirButton;

    public LinhaHolder(View itemView){
        super(itemView);
        titulo = (TextView) itemView.findViewById(R.id.textViagem);
        amigos = (TextView) itemView.findViewById(R.id.textAmigos);
        manageButton = (ImageButton) itemView.findViewById(R.id.editViagem);
        excluirButton = (ImageButton) itemView.findViewById(R.id.deleteViagem);
    }

}
