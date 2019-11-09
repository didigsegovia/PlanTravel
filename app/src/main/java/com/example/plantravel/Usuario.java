package com.example.plantravel;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(){

    }

    public Usuario(int _id, String _nome, String _email, String _senha){
        this.id = _id;
        this.nome = _nome;
        this.email = _email;
        this.senha = _senha;
    }

    public Usuario(String _nome, String _email, String _senha){
        this.nome = _nome;
        this.email = _email;
        this.senha = _senha;
    }

    //########## GETTER AND SETTER ##########

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
