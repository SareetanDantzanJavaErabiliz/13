/**
 *
 * Egileak: Iñaki Goirizelaia eta Maider Huarte. UPV/EHU.
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPBezeroariArreta {
    private DatagramPacket dp;
    private InetAddress bezeroIA;
    private int bezeroAtaka;
    private DatagramSocket zerbitzaria;

    UDPBezeroariArreta( DatagramPacket dp,DatagramSocket z ) {
        this.dp = dp;
        this.bezeroIA = dp.getAddress( );
        this.bezeroAtaka = dp.getPort( );
        this.zerbitzaria = z;
    }

    void ZerbitzuNagusia( ) {
        try {
            aplikaziokoMezuenHartuEmanaZerbitzarian( );
        }
        catch( Exception ioe ) {
            ioe.printStackTrace( );
        }
    }
    
    private void aplikaziokoMezuenHartuEmanaZerbitzarian( ) throws IOException{
        /*Dena delakoa egin: zerbitzariarekiko mezuak idatzi/irakurri, 
          erabiltzailearekin komunikatu, fitxategietan idatzi/irakurri, informazioa prozesatu...*/
        String jasotakoMezua = new String( dp.getData( ), 0, dp.getLength( ) );
        System.out.println( "Bezerotik jasotako mezua: "+jasotakoMezua );
        
        String bidaltzekoMezua = "Agur zerbitzaritik";
        dp = new DatagramPacket( bidaltzekoMezua.getBytes( ),
                                 bidaltzekoMezua.getBytes( ).length,
                                 bezeroIA,
                                 bezeroAtaka); 
        
        //bidaltzeko mezua prestatu
        zerbitzaria.send( dp ); //mezua bidali
        
        System.out.println( "Bezeroari bidalitako mezua: "+bidaltzekoMezua );

        //return;
    }
}

