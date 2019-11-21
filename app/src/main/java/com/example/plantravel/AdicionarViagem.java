package com.example.plantravel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AdicionarViagem extends AppCompatActivity {
    Button btnAdicionarViagem;
    EditText edtViagem;
    EditText edtLocal;

    String nomeViagem;
    String nomeLocal;

    List<UserModel> modelo = new List<UserModel>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(@Nullable Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<UserModel> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] a) {
            return null;
        }

        @Override
        public boolean add(UserModel strings) {
            return false;
        }

        @Override
        public boolean remove(@Nullable Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends UserModel> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, @NonNull Collection<? extends UserModel> c) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public UserModel get(int index) {
            return null;
        }

        @Override
        public UserModel set(int index, UserModel element) {
            return null;
        }

        @Override
        public void add(int index, UserModel element) {

        }

        @Override
        public UserModel remove(int index) {
            return null;
        }

        @Override
        public int indexOf(@Nullable Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(@Nullable Object o) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator<UserModel> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<UserModel> listIterator(int index) {
            return null;
        }

        @NonNull
        @Override
        public List<UserModel> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    UserModel model;

    ViagensAdapter mAdapt;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_viagem);
        btnAdicionarViagem = (Button) findViewById(R.id.btnAddViagem);
        edtViagem = (EditText) findViewById(R.id.edtViagem);
        edtLocal = (EditText) findViewById(R.id.edtLocal);
    }


    public void adicionaViagem(View view){
        i = 0;
        nomeViagem = edtViagem.getText().toString();
        nomeLocal = edtLocal.getText().toString();



        model.nomeViagem = nomeViagem;
        model.localViagem = nomeLocal;

        modelo.add(i, model);


        mAdapt = new ViagensAdapter(modelo);
        mAdapt.updateList(model);

        Toast.makeText(AdicionarViagem.this, "Viagem Adicionada!", Toast.LENGTH_SHORT).show();
    }

}
