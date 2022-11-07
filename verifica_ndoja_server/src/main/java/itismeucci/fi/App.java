package itismeucci.fi;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Server server = new Server();
        try {
            server.connetti();
        } catch (Exception e) {}
    }
}
