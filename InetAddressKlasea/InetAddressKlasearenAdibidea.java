
package tcpsocket1;

/**
 *
 * Egileak: Iñaki Goirizelaia eta Maider Huarte. UPV/EHU.
 */

import java.io.*;  
import java.net.*;  

public class InetAddressKlasearenAdibidea {

    public static void main( String[ ] parametroak ) {

        try {

            InetAddress IP = InetAddress.getByName( "www.ehu.eus" );  

            System.out.println( "Konputagailuaren izena: "+IP.getHostName( ) );  
            System.out.println( "IP Helbidea: "+IP.getHostAddress( ) ); 
            System.out.println( "IP Helbide lokala: "+IP.getLocalHost( ) );  

        }
        catch ( Exception e ) {
            System.out.println( e );
        }  
  
    }
    
}
