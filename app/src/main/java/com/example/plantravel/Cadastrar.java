package com.example.plantravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastrar extends AppCompatActivity {
    private Button btnFzrCadastro;
    private EditText edtNome, edtEmail, edtSenha, edtConfSenha;

    DataBaseOpenHelper db = new DataBaseOpenHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        edtConfSenha = findViewById(R.id.edtConfSenha);
        btnFzrCadastro = findViewById(R.id.btnFzrCadastro);
    }

    public void cadastrar(View v){
        String nome = edtNome.getText().toString();
        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();
        String confSenha = edtConfSenha.getText().toString();

        if(senha.equals(confSenha)){
            Usuario u = new Usuario();
            u.setNome(nome);
            u.setEmail(email);
            u.setSenha(senha);
            db.cadastrarUsuario(u);
            Toast.makeText(Cadastrar.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
            finish();

        }else{
            Toast.makeText(Cadastrar.this, "Senhas diferentes!", Toast.LENGTH_SHORT).show();
            edtSenha.setText(" ");
            edtConfSenha.setText(" ");
        }
    }
}
