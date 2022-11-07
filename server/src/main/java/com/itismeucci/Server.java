package com.itismeucci;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.*;

public class Server {
    private ArrayList<Biglietto> biglietti = new ArrayList<>();
    ObjectMapper parser = new ObjectMapper();
    private ServerSocket server;
    private Socket client;
    private String recv;
    private BufferedReader in;
    private DataOutputStream out;

    public Server()
    {
        try {
            this.server = new ServerSocket(10000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Biglietto> getBiglietti() {
        return this.biglietti;
    }

    public void setBiglietti(ArrayList<Biglietto> biglietti) {
        this.biglietti = biglietti;
    }

    public ServerSocket getServer() {
        return this.server;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }

    public Socket getClient() {
        return this.client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

    public String getRecv() {
        return this.recv;
    }

    public void setRecv(String recv) {
        this.recv = recv;
    }

    public BufferedReader getIn() {
        return this.in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    public DataOutputStream getOut() {
        return this.out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    public Socket listen() throws IOException {
        this.client = server.accept();
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.out = new DataOutputStream(client.getOutputStream());
        return client;
    }

    public void negotiate() throws IOException {
        this.recv = in.readLine();
        System.out.print("Stringa ricevuta: " + this.recv + '\n');
        out.writeBytes(this.recv + '\n');
        Messaggio msg = parser.readValue(recv, Messaggio.class);
        if (msg.getBiglietti().isEmpty())
        {
            Messaggio tuttiBiglietti = new Messaggio();
            tuttiBiglietti.setBiglietti(biglietti);
            out.writeBytes(parser.writeValueAsString(tuttiBiglietti));
        }
        this.client.close();
    }
}
