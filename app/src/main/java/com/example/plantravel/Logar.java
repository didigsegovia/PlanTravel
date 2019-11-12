package com.example.plantravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Logar extends AppCompatActivity {
    private EditText edtEmail, edtSenha;
    private Button btnLogin;

    DataBaseOpenHelper db = new DataBaseOpenHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logar);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogin = findViewById(R.id.btnLogin);
    }

    public void Login(View v){
        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();

        String senhaBD = db.buscarSenha(email);
        if(senha.equals(senhaBD)){
            Intent it = new Intent(Logar.this, MenuLateral.class);
            startActivity(it);

        }else{
            Toast temp = Toast.makeText(Logar.this, "Senha/Login incorreto!", Toast.LENGTH_SHORT);
            temp.show();
        }

    }
}
