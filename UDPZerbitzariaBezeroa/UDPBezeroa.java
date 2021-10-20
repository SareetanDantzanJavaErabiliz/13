/*
 * Egileak: Iñaki Goirizelaia eta Maider Huarte. UPV/EHU.
 * 
 * UDPBezeroa.java: Prozesu eta hari bakarreko oinarrizko UDP zerbitzaria+bezeroa
 * 
 * 
 * 
 * 
*/

import java.io.*;
import java.net.*;

public class UDPBezeroa {
    
    public static void main( String[ ] parametroak ) {
        
        String zerbitzuEskaera = "Kaixo bezerotik!!!!!!!";
        
        // mezua bytetan bihurtu eta bytetako arrayan gorde
        byte[ ] zerbitzuEskaeraMezua = zerbitzuEskaera.getBytes( ); 
        
        try( DatagramSocket udpZerbitzaria = new DatagramSocket( ) ) {
            DatagramPacket dp = new DatagramPacket( zerbitzuEskaeraMezua, 
                                                    zerbitzuEskaeraMezua.length,
                                                    InetAddress.getByName( "localhost" ),
                                                    1234 );
            udpZerbitzaria.send( dp );
            System.out.println( "Zerbitzariari bidalitako eskaera-mezua: "+zerbitzuEskaera ); 
            
            // Datuen hartu-emana
            aplikaziokoMezuenHartuEmanaBezeroan( udpZerbitzaria, dp );
        }
        catch( IOException ios ) {
            ios.getMessage( );
        }
    }
    
    private static void aplikaziokoMezuenHartuEmanaBezeroan( 
                        DatagramSocket udpZerbitzaria, 
                        DatagramPacket dp ) throws IOException {
        
        udpZerbitzaria.receive( dp );
        String jasotakoMezua = new String( dp.getData( ), 0, dp.getLength( ) );
        
        System.out.println( "Zerbitzaritik jasotako mezua: "+jasotakoMezua );
        

    }
}

