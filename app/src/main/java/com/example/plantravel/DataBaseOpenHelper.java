package com.example.plantravel;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
    public void addUsuario(Usuario u){
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

}
