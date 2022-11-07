package itismeucci.fi;

public class Biglietto {
    static int conta = 0;
    String numero;
    int id;

    public Biglietto() {
    }

    public Biglietto(String numero){
        this.numero = numero;
        id = 0;
        conta++;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
            " numero='" + getNumero() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }

}
