package itismeucci.fi;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Client cliente = new Client();
        try {
            cliente.comunica();
        } catch (Exception e) {}
        
    }
}
