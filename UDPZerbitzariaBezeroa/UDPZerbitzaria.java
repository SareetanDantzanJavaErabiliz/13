/*
 * Egileak: Iñaki Goirizelaia eta Maider Huarte. UPV/EHU.
 * 
 * UDPZerbitzaria.java: Prozesu eta hari bakarreko oinarrizko UDP zerbitzaria+bezeroa
 * 
 * 
 * 
 * 
*/

import java.io.*;
import java.net.*;

public class UDPZerbitzaria {
    public static void main( String[] parametroak ) {
        DatagramSocket zerbitzaria; //Zerbitzua prestatu
        try {
            
            //Zerbitzua ataka batean prestatu eta hasi
            zerbitzaria = new DatagramSocket( 1234 ); 
            
            //Datuen hartu-emana prestatu zerbitzarian
            DatagramPacket dp; 
            
            try {
                System.out.println( "UDP Zerbitzaria "+1234+" atakan entzuten" );

                while( true ) //Etengabeko ataza
                {
                    System.out.println( "\nUDP Zerbitzaria bezero berri baten mezua itxaroten" );
                    dp=new DatagramPacket( new byte[ 1024 ], 1024); 

                    //Zerbitzu-eskaera mezua jaso
                    zerbitzaria.receive( dp );
                    
                    UDPBezeroariArreta ba = new UDPBezeroariArreta( dp, zerbitzaria ); //Bezeroarekiko lana prestatu
                    ba.ZerbitzuNagusia( );//Bezeroarekiko lana egin
                }
            }
            finally {
                zerbitzaria.close( );
            }
        }
        catch( IOException ioe ) {
            ioe.printStackTrace( );
        }
    }
}

