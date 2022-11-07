package com.itismeucci;

public class App {
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.connect();
            client.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
