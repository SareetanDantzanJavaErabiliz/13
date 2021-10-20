/*
 * Egileak: Iñaki Goirizelaia eta Maider Huarte. UPV/EHU.
 * 
 * TCPBezeroa.java: Prozesu eta hari bakarreko oinarrizko TCP zerbitzaria+bezeroa
 * 
 * 
 * 
 * 
*/

import java.io.*;
import java.net.*;

public class TCPBezeroa {
    
    public static void main( String[ ] parametrok ) {
        
        try( Socket tcpZerbitzaria = new Socket( "localhost", 1234 );
             DataInputStream datuSarrera = new DataInputStream( tcpZerbitzaria.getInputStream( ) );
             DataOutputStream datuIrteera = new DataOutputStream( tcpZerbitzaria.getOutputStream( ) ) ) {
            
                aplikaziokoMezuenHartuEmanaBezeroan( datuSarrera, datuIrteera );
                
        }
        catch( IOException ios ) {
            ios.getMessage( );
        }
            
            
    }
    
    private static void aplikaziokoMezuenHartuEmanaBezeroan( 
                        DataInputStream datuSarrera,
                        DataOutputStream datuIrteera ) throws IOException {
        /*Dena delakoa egin: zerbitzariarekiko mezuak idatzi/irakurri, erabiltzailearekin komunikatu, 
          fitxategietan idatzi/irakurri, informazioa prozesatu...*/
        String bidaltzekoMezua = "Kaixo bezerotik";
        datuIrteera.writeUTF( bidaltzekoMezua );
        System.out.println( "Zerbitzariari bidalitako mezua: "+bidaltzekoMezua );
         
        String iritsitakoMezua = datuSarrera.readUTF( );
        System.out.println( "Zerbitzaritik jasotako mezua: "+iritsitakoMezua );
        //return;
    }
}
