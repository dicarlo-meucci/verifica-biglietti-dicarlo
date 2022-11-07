package com.itismeucci;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        Biglietto b1 = new Biglietto("palco");
        Biglietto b2 = new Biglietto("tribuna");
        Biglietto b3 = new Biglietto("parterre");
        Biglietto b4 = new Biglietto("palco");
        Biglietto b5 = new Biglietto("tribuna");
        Biglietto b6 = new Biglietto("parterre");
        ArrayList<Biglietto> biglietti = new ArrayList<>();
        biglietti.add(b1);
        biglietti.add(b2);
        biglietti.add(b3);
        biglietti.add(b4);
        biglietti.add(b5);
        biglietti.add(b6);

        Server server = new Server();
        server.setBiglietti(biglietti);

        while (true)
        {
            try {
                server.listen();
                server.negotiate();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}
