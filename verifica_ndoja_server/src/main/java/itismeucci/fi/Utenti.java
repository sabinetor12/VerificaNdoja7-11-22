package itismeucci.fi;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Utenti extends Thread {
    Socket client;
    ArrayList<Socket> S;
    Messaggio msg;

    public Utenti(Socket client, ArrayList<Socket> S,Messaggio msg) {
        this.client = client;
        this.S = S;
        this.msg = msg;
    }

    public void run(){
        try {
        BufferedReader inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        DataOutput outVersoClient = new DataOutputStream(client.getOutputStream());
        ObjectMapper objectMapper = new ObjectMapper();
        
        String jsonRicevuto =inDalClient.readLine(); //1
        Messaggio msgRicevuto = objectMapper.readValue(jsonRicevuto, Messaggio.class);
        if(msgRicevuto.lista.isEmpty())
        {
            String msgDaInv = objectMapper.writeValueAsString(msg);
            outVersoClient.writeBytes(msgDaInv + "\n"); //2 manda la lista completa
            
        }
        } catch (Exception e) {}
        
    }
}
    