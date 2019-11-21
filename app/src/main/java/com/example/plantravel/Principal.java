package com.example.plantravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity {

    private ListView listViewUsuarios;
    private Button btnAddAmigo;             /* adicionado botão pra add amigo */
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    ArrayList<String> list_items = new ArrayList<String>();
    int count = 0;

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

        listViewUsuarios.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listViewUsuarios.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                count = count +1;
                mode.setTitle(count + " itens selecionados");

                list_items.add(arrayList.get(position));
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.my_context_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_selected_item:
                        for(String msg: list_items){
                            Log.d("Lista TESTE", "\nID: " + list_items.get(0));
                            Log.d("Lista TESTE", "\nID: " + list_items.get(1));
                            adapter.remove(msg);
                        }
                        Toast.makeText(getBaseContext(), count + " itens selecionados", Toast.LENGTH_SHORT).show();
                        count = 0;
                        mode.finish();
                        return true;
                        //break;

                    default:
                        return false;
                }
                //return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }
    public void addAmigo(View view) {
        Intent it = new Intent(this, AddAmigo.class);
        startActivity(it);
    }
}
