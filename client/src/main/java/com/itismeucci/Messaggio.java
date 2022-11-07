package com.itismeucci;

import java.util.ArrayList;

public class Messaggio {
    private ArrayList<Biglietto> biglietti = new ArrayList<>();


    public ArrayList<Biglietto> getBiglietti() {
        return this.biglietti;
    }

    public void setBiglietti(ArrayList<Biglietto> biglietti) {
        this.biglietti = biglietti;
    }
    
}
