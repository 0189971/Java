package servidor2;

import Servidorweb.*;
import java.io.*;
import java.net.*;

public class head {
    public static void main(String []args) throws UnknownHostException, IOException
    {
        ServerSocket ss = new ServerSocket(7000);
        for(;;)
        {
            Socket nuevo = ss.accept();
            if(nuevo == null)
                continue;
            else
                break;
        }
        
        
    }
}
