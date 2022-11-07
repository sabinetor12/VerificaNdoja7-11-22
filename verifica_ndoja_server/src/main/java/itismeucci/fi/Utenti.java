package itismeucci.fi;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Utenti extends Thread {
    Socket client;
    ArrayList<Socket> S;
    Messaggio msg;
    ServerSocket server;

    public Utenti(Socket client, ArrayList<Socket> S, Messaggio msg, ServerSocket server) {
        this.client = client;
        this.S = S;
        this.msg = msg;
        this.server = server;
    }

    public void run() {
        try {
            BufferedReader inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutput outVersoClient = new DataOutputStream(client.getOutputStream());
            ObjectMapper objectMapper = new ObjectMapper();

            String jsonRicevuto = inDalClient.readLine(); // 1
            Messaggio msgRicevuto = objectMapper.readValue(jsonRicevuto, Messaggio.class);
            if (msgRicevuto.lista.isEmpty()) {
                String msgDaInv = objectMapper.writeValueAsString(msg);
                outVersoClient.writeBytes(msgDaInv + "\n"); // 2 manda la lista completa
                // 3 Aspetta cosa vuole comprare il client
                String daComprare = inDalClient.readLine();
                String[] splited = daComprare.split(" ");
                msgDaInv = "";

                // cerca se quello che il client vuole comprare è disponibile
                for (String i : splited) {
                    Boolean trovato = false;
                    for (Biglietto j : msg.lista) {
                        if (j.getId() == Integer.parseInt(i)) {
                            msgDaInv = msgDaInv + "biglietto: " + j.toString();
                            trovato = true;
                            msg.lista.remove(j);
                            break;
                        }
                    }
                    if (!trovato) {
                        msgDaInv = msgDaInv + " il messaggio con id: " + i + " non e' disponibile     ";
                    }
                }
                outVersoClient.writeBytes(msgDaInv + "\n");
                client.close();
            }
        } catch (Exception e) {
        }
    }
}
