package com.itismeucci;

import java.util.ArrayList;

public class Biglietto {

    public static int ticketCount;
    private int id;
    private String nome;

    public Biglietto(String nome) {
        this.id = ticketCount;
        ticketCount++;
        this.nome = nome + "-" + id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}