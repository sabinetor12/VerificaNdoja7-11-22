package itismeucci.fi;

import java.util.ArrayList;

public class Messaggio {
    public ArrayList<Biglietto> lista = new ArrayList<>();

    public Messaggio() {
    }
    
    public Messaggio(ArrayList<Biglietto> lista) {
        this.lista = lista;
    }

    public ArrayList<Biglietto> getLista() {
        return this.lista;
    }

    public void setLista(ArrayList<Biglietto> lista) {
        this.lista = lista;
    }


}
