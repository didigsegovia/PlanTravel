package com.example.plantravel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.lang.UScript;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PlanTravel";

    private static final String TABELA_USUARIO = "tb_usuario";
    private static final String COLUNA_ID = "id";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_EMAIL = "email";
    private static final String COLUNA_SENHA = "senha";

    public DataBaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+ TABELA_USUARIO + "("
                + COLUNA_ID + " INTEGER PRIMARY KEY, " + COLUNA_NOME + " TEXT, "
                + COLUNA_EMAIL + " TEXT, " + COLUNA_SENHA + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // ########## CRIAÇÃO GRUD #########
    public void cadastrarUsuario(Usuario u){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUNA_NOME, u.getNome());
        values.put(COLUNA_EMAIL, u.getEmail());
        values.put(COLUNA_SENHA, u.getSenha());

        db.insert(TABELA_USUARIO, null, values);
        db.close();
    }

    public void deletarUsuario(Usuario u){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABELA_USUARIO, COLUNA_ID + " = ?", new String[] { String.valueOf(u.getId())});
        db.close();
    }

    public Usuario buscarUsuarios(Usuario u){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABELA_USUARIO, new String[] {COLUNA_ID, COLUNA_NOME, COLUNA_EMAIL}, COLUNA_ID + " = ?", new String[] {String.valueOf(u.getId())}, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        Usuario user = new Usuario();
        user.setId(Integer.parseInt(cursor.getString(0)));
        user.setNome(cursor.getString(1));
        user.setEmail(cursor.getString(2));

        return user;
    }

    public List<Usuario> listaUsuarios(){
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        String query = "SELECT * FROM " + TABELA_USUARIO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToNext()){
            do {
                Usuario u = new Usuario();
                u.setId(Integer.parseInt(cursor.getString(0)));
                u.setNome(cursor.getString(1));
                u.setEmail(cursor.getString(2));

                listaUsuarios.add(u);
            }while (cursor.moveToNext());
        }

        return listaUsuarios;
    }

    public String buscarSenha(String email){
        SQLiteDatabase db;

        db = this.getReadableDatabase();
        String query = "select email, senha from "+TABELA_USUARIO;
        Cursor cursor = db.rawQuery(query, null);
        String emailPesquisa, matchSenha;

        matchSenha = "Não encontrado!";

        if(cursor.moveToFirst()){
            do{
                emailPesquisa = cursor.getString(0);
                if(emailPesquisa.equals(email)){
                    matchSenha = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return matchSenha;
    }

}
