/**
 *
 * Egileak: Iñaki Goirizelaia eta Maider Huarte. UPV/EHU.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPZerbitzaria {
    private static int ataka = 1234;


    public static void main( String[ ] parametroak ) {
        
        try( ServerSocket zerbitzaria = new ServerSocket( ataka ) ) {

                System.out.println( "Zerbitzaria "+ataka+" atakan entzuten" );
                while ( true ) {
                    System.out.println( "\nZerbitzaria bezero berri bat itxaroten" );
                    Socket bezeroa = zerbitzaria.accept( );

                    TCPBezeroariArreta ba = new TCPBezeroariArreta( bezeroa );
                    ba.ZerbitzuNagusia( );
                }
        }
        catch( IOException ioe ) {
            ioe.printStackTrace( );
        }
    }
}

