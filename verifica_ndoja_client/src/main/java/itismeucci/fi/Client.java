package itismeucci.fi;

import java.io.*;
import java.net.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {

    public void comunica() throws IOException {
        int portaServer = 8080; // porta x servizio data e ora
        Socket miosocket;
        BufferedReader tastiera; // buffer per l'input da tastiera
        DataOutputStream outVersoServer; // stream output
        BufferedReader inDalServer; // stream input

        miosocket = new Socket("127.0.0.1", portaServer);
        tastiera = new BufferedReader(new InputStreamReader(System.in));
        outVersoServer = new DataOutputStream(miosocket.getOutputStream());
        inDalServer = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
        ObjectMapper objectMapper = new ObjectMapper();

        Messaggio primo = new Messaggio();
        String msgP = objectMapper.writeValueAsString(primo);
        outVersoServer.writeBytes(msgP + "\n"); // 1
        String StringaRicevuta = inDalServer.readLine(); //2
        System.out.println("la lista è "+StringaRicevuta);
        System.out.println("scegli cosa comprare (id)");
        String StringaUtente = tastiera.readLine(); //3
        outVersoServer.writeBytes(StringaUtente +"\n");
        System.out.println("risposta:" + inDalServer.readLine());
        miosocket.close();
    }
}
