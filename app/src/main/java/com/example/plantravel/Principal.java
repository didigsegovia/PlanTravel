package com.example.plantravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity {

    private ListView listViewUsuarios;
    private Button btnAddAmigo;             /* adicionado botão pra add amigo */
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    DataBaseOpenHelper db = new DataBaseOpenHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnAddAmigo = findViewById(R.id.btnAddAmigo);
        listViewUsuarios = findViewById(R.id.listUsuarios);
        listarUsuarios();
    }

    public void listarUsuarios(){
        List<Usuario> usuarios = db.listaUsuarios();

        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(Principal.this, android.R.layout.simple_list_item_1, arrayList);
        listViewUsuarios.setAdapter(adapter);
        for(Usuario u : usuarios){
            //Log.d("Lista", "\nID: " + u.getId() + " Nome: " + u.getNome());
            arrayList.add(u.getId() + " - " + u.getNome());
            adapter.notifyDataSetChanged();
        }
    }
    public void addAmigo(View view) {
        Intent it = new Intent(this, AddAmigo.class);
        startActivity(it);
    }
}
