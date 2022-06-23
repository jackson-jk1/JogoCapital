package com.example.jogocapitalapp;

public class Estado {
    public String Nome;
    public Capital Capital;

    public Estado(String nome, Capital capital) {
        Nome = nome;
        Capital = capital;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
}

