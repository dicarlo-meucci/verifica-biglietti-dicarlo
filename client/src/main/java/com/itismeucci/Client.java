package com.itismeucci;
import java.io.*;
import java.net.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {
    ObjectMapper parser = new ObjectMapper();
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String clientString;
    private String serverString;

    public Socket connect() throws IOException
    {
        this.socket = new Socket(InetAddress.getLocalHost(), 10000);
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        return socket;
    }
    
    public void send() throws IOException
    {
        this.clientString = parser.writeValueAsString(new Messaggio());
        out.writeBytes(clientString + '\n');
        serverString = in.readLine();
        System.out.print("Risposta dal server: " + serverString + '\n');
        serverString = in.readLine();
        socket.close();
    }
}