package com.example.plantravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity {

    private ListView listViewUsuarios;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    DataBaseOpenHelper db = new DataBaseOpenHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
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
}
