/**
 *
 * Egileak: Iñaki Goirizelaia eta Maider Huarte. UPV/EHU.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPBezeroariArreta {
    private Socket tcpBezeroa;
    private DataInputStream datuSarrera;
    private DataOutputStream datuIrteera;
    
    //Eraikitzailea
    TCPBezeroariArreta( Socket tcpBezeroa ) {
        this.tcpBezeroa = tcpBezeroa;
    }

    //@SuppressWarnings("CallToThreadDumpStack")
    void ZerbitzuNagusia( ) {
         System.out.println( "Bezero berria "+tcpBezeroa.getInetAddress( )+" helbidetik" );
       
        try {
            datuSarrera = new DataInputStream( tcpBezeroa.getInputStream( ) );
            
            //honen hutsegite bakarra, tcpBezeroa jadanik itxita egotea close()-ekin (mutur honetan)
            datuIrteera=new DataOutputStream( tcpBezeroa.getOutputStream( ) );
            
            try {
                aplikaziokoMezuenHartuEmanaZerbitzarian( );
            }
            finally {
                datuSarrera.close( ); 
                datuIrteera.close( );
                tcpBezeroa.close( );
            }
        }
        catch( Exception ioe ) {
            ioe.printStackTrace( );
        }
    }
    
    private void aplikaziokoMezuenHartuEmanaZerbitzarian( ) throws IOException{ 
        /*Dena delakoa egin: zerbitzariarekiko mezuak idatzi/irakurri, 
          erabiltzailearekin komunikatu, fitxategietan idatzi/irakurri, informazioa prozesatu...*/
        String iritsitakoMezua = datuSarrera.readUTF( );
        System.out.println( "Bezerotik jasotako mezua: "+iritsitakoMezua );
        
        String bidaltzekoMezua = "Agur zerbitzaritik";
        datuIrteera.writeUTF( bidaltzekoMezua );
        System.out.println( "Bezeroari bidalitako mezua: "+bidaltzekoMezua );
         
        //return;
    }
}

