package com.example.plantravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLogar, btnCadastrar;

    DataBaseOpenHelper db = new DataBaseOpenHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogar = findViewById(R.id.btnLogar);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        /*Inserir usuario
        db.cadastrarUsuario(new Usuario("Luiz Delgado", "luiz@gmail.com", "123456789"));
        db.cadastrarUsuario(new Usuario("Amanda Delgado", "amanda@gmail.com", "oioioi"));
        Apagar usuario
        Usuario user = new Usuario();
        user.setId(1);
        db.deletarUsuario(user);
        */
        //Toast.makeText(this, "Deu bom",Toast.LENGTH_SHORT).show();
    }

    public void logar(View v){
        Intent it = new Intent(MainActivity.this, Logar.class);
        startActivity(it);
    }

    public void cadastrar(View v){
        Intent it = new Intent(MainActivity.this, Cadastrar.class);
        startActivity(it);
    }
}
