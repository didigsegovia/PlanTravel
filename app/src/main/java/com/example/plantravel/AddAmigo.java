package com.example.plantravel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddAmigo extends AppCompatActivity {
    Button btnFotoAmigo;
    ImageView fotoTirada=null ;
    EditText edtNomeAmigo=null ;
    Bitmap imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_addamigo);
        Button btnFotoAmigo = (Button) findViewById(R.id.btnFotoAmigo);
        EditText edtNomeAmigo = (EditText) findViewById(R.id.edtNomeAmigo);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }   // Checa permissão para acessar câmera

        fotoTirada = (ImageView) findViewById(R.id.fotoAmigo);


    } // Fim onCreate

    public void tiraFoto(View v) {
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(it, 1);  // Request code 1

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imagem = (Bitmap) extras.get("data");
            fotoTirada.setImageBitmap(imagem);

        }

        super.onActivityResult(requestCode, resultCode, data);

    }

    public void salvarAlt(View v){

        String nomeAmigo = edtNomeAmigo.getText().toString();
        if(!nomeAmigo.isEmpty()){
            /* IMPLEMENTAR A PARTE DE ADICIONAR AMIGO NO BANCO DE DADOS */
            /* foto na variável "imagem" e nome na variavel "nomeAmigo" */
            finish();

        }


    }
}
