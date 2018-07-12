package Servidorweb;

import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
//----------------------------------------------------------------------------------------------------------

public class ServidorWEB
{
    public static final int PUERTO=8000; //definimos puerto
    ServerSocket ss; ///Implementamos un socket servidor en espera de peticiones

    public ServidorWEB() throws Exception
    {
        System.out.println("Iniciando Servidor");
        this.ss=new ServerSocket(PUERTO); //instanciamos nuestro ss con el puerto definido
        System.out.println("Servidor iniciado");
        System.out.println("Esperando peticiones");
        
        for(;;)
        {
            //Se ocupa el boton en el formulario y este "accept" recibe enzacebado 
            //el puerto, aqui como en el formulario es el 8000
            Socket accept=ss.accept();
            new Manejador(accept).start();  //creamos el hilo con el socket especificado
        }
    }
		
    class Manejador extends Thread
    {
        protected Socket socket; 
        protected PrintWriter pw;//imprime representaciones de formato de objetos a una secuencia de salida de texto
        protected BufferedOutputStream bos; //para la salida de datos 
        protected BufferedReader br; //Lee texto de una corriente de caracteres de entrada
        protected String FileName;//
        protected ArrayList<String> cadenas = new ArrayList(); //arreglo para las cadenas 
			
        public Manejador(Socket _socket) throws Exception //asigna valor al socket
        {
            this.socket=_socket;
        }

        public void run()
        {
            try
            {
                //Se coloca un el flujo de entrada del socket, para leer ENCABEZADO
                br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bos=new BufferedOutputStream(socket.getOutputStream()); //se coloca el flujo de salida 
                pw=new PrintWriter(new OutputStreamWriter(bos));//se asigana a printwriter el flujo de salida
                int flag=0;  //para saber si es get=1,post=2,head=3
                String line = br.readLine(); 
                cadenas.add(line); //Agrego al arreglo la cadena de br
                System.out.println("Esta es la cadena bufferedreader");
                System.out.println(line); // se imprime line
//Saber si es get post o head--------------------------------------------------------------------------------------------------------------------------
                //Si la 1° linea posee get, entonces lees de aqui con get...
                if(line.contains("GET"))
                {
                    flag=1;
                    while (true)
                    {
                        line=br.readLine();
                        System.out.println("METODO GET");
                        System.out.println(line);
                        if(line.length() == 0)
                            break;
                        cadenas.add(line);
                    }
                }
                //Checamos POST
                else if(line.contains("POST"))
                {
                    flag=2;
                    while (true)
                    {
                        line=br.readLine();
                        System.out.println("METODO POST");
                        System.out.println("Entra a este lugar...si "+line);

                        if(line.length() == 0)
                        {
                            System.out.println("fin");
                            break;
                        }                                                
                        cadenas.add(line);
                    }                    
                }
                //Checamos <HEAD
                
                else if(line.contains("HEAD"))
                {
                    flag=3;
                    System.out.println(flag);
                    while (true)
                    {
                        line=br.readLine();
                        System.out.println("METODO HEAD");
                        System.out.println("head "+line);

                        if(line.length() == 0)
                        {
                            System.out.println("fin");
                            break;
                        }                                                
                        cadenas.add(line);
                    }
                }
                    
                if(flag==1)
                    verificaget();
                else if(flag==2)
                    verificapost();
                else if(flag==3)
                    verificahead();

                //Si no hay encabezado (lo que no creo), manda esta pagina de error...
                if(line==null)
                {
                    System.out.println("OJO -- si necesita el encabezado...");
                    pw.println("<!DOCTYPE html>");
                    pw.println("HTTP/1.0 200 Okay");
                    pw.flush();
                    pw.println();
                    pw.flush();
                    pw.println("<html><head><title>Servidor WEB");
                    pw.println("</title><body bgcolor=\"#AACCFF\"<br>Linea Vacia</br>");
                    pw.println("</body></html>");
                    pw.flush();
                    socket.close();
                    return;
                }

                System.out.println("Cliente Conectado desde: "+socket.getInetAddress());
                System.out.println("Por el puerto: "+socket.getPort());
                System.out.println("Datos: "+cadenas.get(0));

                pw.flush();
                bos.flush();
                socket.close();
            }
            catch(Exception e)
            {
                    e.printStackTrace();
            }
        }

        //Metodo para trabagar get
        public void verificaget()
        {
            if(!(cadenas.get(0).contains("?"))) //checamos si es get o head
                verificahead();
            else
            {
                //Hay '?' ... separa y busca los parametros para imprimirlos...
                StringTokenizer tokens=new StringTokenizer(cadenas.get(0),"?");//rompe una cadena en tokens
                String req_a=tokens.nextToken(); //regresa la cadena siguiente
                String req=tokens.nextToken();
                System.out.println("Token1: "+req_a);
                System.out.println("Token2: "+req);

                //Apartir de req, se obtendragn los parametros....
                char [] buf = req.toCharArray();//convierte la cadena en array de caracteres
                ArrayList<String> parametros = new ArrayList();
                ArrayList<String> valores = new ArrayList();
                String concatena="";
                for(int i=0;i<buf.length;i++)
                {
                    if(buf[i]=='+')
                    {
                        concatena +=" ";
                        continue;
                    }
                    else if(buf[i]=='=')
                    {
                        parametros.add(concatena);
                        concatena="";
                        continue;
                    }
                    else if(buf[i]=='&')
                    {
                        valores.add(concatena);
                        concatena="";
                        continue;
                    }
                    else if(buf[i]=='%')
                    {
                        valores.add(concatena);
                        concatena="";
                        break;
                    }
                    concatena += buf[i];
                }
                pw.println("<!DOCTYPE html>");
                pw.println("HTTP/1.0 200 Okay");
                pw.flush();
                pw.println();
                pw.flush();
                pw.print("<html><head><title>SERVIDOR WEB");
                pw.flush();
                pw.print("</title></head><body bgcolor=\"#FFFFFF\"><h1><br>Parametros Obtenidos: GET</br></h1>");
                pw.flush();
                pw.print("<table><tr>");
                pw.print("<th>Parametro</th><th>Valor</th></tr>");
                pw.flush();
                for (int i=0;i<parametros.size();i++)
                {
                    pw.print("<tr>");
                    
                    pw.print("<center>");
                    
                    pw.print("<td>"+parametros.get(i)+"</td><td>"+valores.get(i)+"</td>");
                    pw.print("</center>");
                    pw.print("</tr>");                
                }

                pw.flush();
                pw.print("</table></body></html>");
                pw.flush();
            }
            return;
        }

        //Metodo para trabagar post
        public void verificapost() throws IOException
        {
            //Buffer para leer parametros en caso de post
            char [] buf = new char[200];

            //Aqui, leemos lo ultimo de post...
            br.read(buf);
            System.out.println(buf);
            ArrayList<String> parametros = new ArrayList();
            ArrayList<String> valores = new ArrayList();
            String concatena="";
            for(int i=0;i<buf.length;i++)
            {
                if(buf[i]=='+')
                {
                    concatena +=" ";
                    continue;
                }
                else if(buf[i]=='=')
                {
                    parametros.add(concatena);
                    concatena="";
                    continue;
                }
                else if(buf[i]=='&')
                {
                    valores.add(concatena);
                    concatena="";
                    continue;
                }
                else if(buf[i]=='%' | buf[i]==' ')
                {
                    valores.add(concatena);
                    concatena="";
                    break;
                }                
                concatena += buf[i];
            }
            System.out.println("S9"+parametros.size()+" "+valores.size());
            pw.println("<!DOCTYPE html>");
            pw.println("HTTP/1.0 200 Okay");
            pw.flush();
            pw.println();
            pw.flush();
            pw.print("<html><head><title>SERVIDOR WEB");
            pw.flush();
            pw.print("</title></head><body bgcolor=\"#FFFFFF\"><h1><br>Parametros Obtenidos: POST</br></h1>");
            pw.flush();
            pw.print("<table style='text-align: center; margin: 0px auto;'><tr>");
            pw.print("<th>Parametro</th><th>Valor</th></tr>");
            pw.flush();
            for (int i=0;i<parametros.size();i++)
            {
                pw.print("<tr>");
                
                pw.print("<td>"+parametros.get(i)+"</td><td>"+valores.get(i)+"</td>");
                
                pw.print("</tr>");                
            }
            
            pw.flush();
            pw.print("</table></body></html>");
            pw.flush();
            System.out.println("S10");
            
            return;
        }
        //Metodo para trabagar head
        public void verificahead()
        {
            pw.println("<!DOCTYPE html>");
            pw.println("HTTP/1.0 200 Okay");
            pw.flush();
            pw.println();
            pw.flush();
            pw.print("<html><head><title>SERVIDOR WEB");
            pw.flush();
            pw.print("</title></head><body bgcolor=\"#FFFFFF\"><h1><br>Parametros Obtenidos: HEAD</br></h1>");
            pw.flush();
            pw.print("<p style=\"font-family:verdana; font-size:15pt\"");
            for (int i=0;i<cadenas.size();i++)
            {
                pw.print("<center>");
                pw.print(cadenas.get(i)+"<br>");
                pw.print("</center>");
                    
            }
            pw.print("</p></body></html>");
            pw.flush();
            pw.close();
            return;
        }

        //Este metodo repite el else if de arriba...
        //Busca en GET y de ahi busca el nombre del archivo
        public void getArch(String line)
        {
            int i;
            int f;
            if(line.toUpperCase().startsWith("GET"))
            {
                    i=line.indexOf("/");
                    f=line.indexOf(" ",i);
                    FileName=line.substring(i+1,f);
            }
            else
                FileName = "";
        }
        
    }

    public static void main(String[] args) throws Exception{
            ServidorWEB sWEB=new ServidorWEB();
    }
}
