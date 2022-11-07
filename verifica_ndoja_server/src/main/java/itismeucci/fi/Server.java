package itismeucci.fi;


import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {

    ArrayList<Socket> listaUtenti = new ArrayList<>();

    public void connetti() throws IOException {

        System.out.println("server partito");
        ServerSocket server = new ServerSocket(8080);
        Biglietto b1 = new Biglietto("palco-a1");
        Biglietto b2 = new Biglietto("palco-a2");
        Biglietto b3 = new Biglietto("palco-a3");
        Biglietto b4 = new Biglietto("palco-a4");
        ArrayList<Biglietto> biglietti = new ArrayList<>();
        biglietti.add(b1);
        biglietti.add(b2);
        biglietti.add(b3);
        biglietti.add(b4);
        Messaggio msg = new Messaggio(biglietti);
        for (;;) {
            Socket client = server.accept();
            listaUtenti.add(client);
            (new Utenti(client,listaUtenti,msg,server)).start();
        }
        
    }

    
}