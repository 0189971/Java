package SegundoParcial;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JLabel;


public class HiloCliente extends Thread{
    private int port;
    private String url;
    private Socket s;
    private boolean bConectado;
    JLabel etiqueta;
    File archivo;
    Socket cl;
    Socket pcl;
    public String archivoborrar= "";
    public String controla="0";
    ReciveArrayList recive=null;
    int recivelist;
    String[] elementos;
    int numerodeele;
    ArrayList<String> List = new ArrayList<String>();
    
        HiloCliente(int port, String url, int recive) throws IOException{
            this.port=port;
            this.url=url; 
            this.recivelist=recive;
        }
    
    public void run(){
        System.out.println("Inicio del envio de archivos, listado y eliminación de archivos "+port);
        System.out.println(url);
        //Iniciamos la conec con el cliente
            try{
                //Iniciamos el cliente 
                try{
                    if(recive==null){
                    recive=new ReciveArrayList(recivelist);
                    recive.start();
                    }
                }catch(Exception e){}
                
                //Preparamos un Socket para enviar los archivos
                cl=new Socket(url,port);
                
                
                while(true){
                    //System.out.println("Cliente iniciado...");
                    //System.out.println(controla);
                    
                    switch(Integer.parseInt(controla)){
                        case 1:
                            //Accion para controlar el envio de archivos
                                    System.out.println("Enviando palabra clave...");
                                    try{
                                        
                                        //Enviamos un cadena al servidor de flujo para que se prepare a recibir el archivo
                                        DataOutputStream dos= new DataOutputStream(cl.getOutputStream());
                                        System.out.println("Enviando 1");
                                        dos.writeUTF("1");
                                        dos.flush();
                                        
                                        
                                        pcl=new Socket(url,port);
                                        
                                            DataOutputStream dos1= new DataOutputStream(pcl.getOutputStream());
                                            JFileChooser jf= new JFileChooser();   //  ----> jf.setMultiSelectionEnabled(true); Enviar varios archivos misma ruta..
                                                int r= jf.showOpenDialog(null);
                                                System.out.println(r);
                                                if(r==JFileChooser.APPROVE_OPTION){
                                                    File f= jf.getSelectedFile();  //File[] f= jf.getSelectedFiles();
                                                    String archivo=f.getAbsolutePath();
                                                    String nombre=f.getName();
                                                    long tam=f.length();

                                                    DataInputStream dis1=new DataInputStream(new FileInputStream(archivo));

                                                    System.out.println("Comienza el envio del archivo "+archivo);
                                                    dos1.writeUTF(nombre);
                                                    dos1.flush();
                                                    dos1.writeLong(tam);
                                                    dos1.flush();

                                                    int porcentaje=0;
                                                    byte[] buf= new byte[1500];
                                                    long enviados=0;
                                                    int n;

                                                    while(enviados<tam){
                                                        n=dis1.read(buf);
                                                        dos1.write(buf,0,n);
                                                        dos1.flush();
                                                        enviados=enviados+n;
                                                        porcentaje=(int)((enviados*100)/tam);
                                                        System.out.println("Completado el "+porcentaje+"%");
                                                    }//while

                                                System.out.println("Archivo enviado..");
                                                dos1.close();
                                                dis1.close();
                                            }
                                            }catch(Exception e){
                                                System.out.println("No se pudo realizar el enviado..");
                                            }
 
                                pcl.close();
                                controla="0";
                            break;
                        case 2:
                            //Accion para eliminar los archivos
                                    System.out.println("Enviando palabra clave...");
                                    try{
                                        //Enviamos un cadena al servidor de flujo para que se prepare a recibir el archivo
                                        DataOutputStream dos= new DataOutputStream(cl.getOutputStream());
                                        System.out.println("Enviando 2 para borrar archivos");
                                        dos.writeUTF("2");
                                        dos.flush();
                                         //Obtenemos el nombre del archivo para eliminar
                                        dos.writeUTF(archivoborrar);
                                        dos.flush();
                                        
                                    }catch(Exception e){
                                        System.out.println("No se pudo conectar...");
                                    }
                                controla="0";
                            break;
                        case 3:
                             //Accion para listar los archivos
                                    System.out.println("Enviando palabra clave...");
                                    try{
                                        //Enviamos un cadena al servidor de flujo para que se prepare a recibir el archivo
                                        DataOutputStream dos= new DataOutputStream(cl.getOutputStream());
                                        System.out.println("Enviando 3 para listar archivos");
                                        dos.writeUTF("3");
                                        dos.flush();
                                    }catch(Exception e){
                                        System.out.println("No se pudo conectar...");
                                    }
                                numerodeele=recive.getnum();
                                elementos=recive.getelementos();
                                List=recive.getArrayList();  
                                controla="0";
                            break;
                        default:
                            break;
                    }
                    
                    try{
                        Thread.sleep(1000);
                    }catch(Exception e){}
                
                }
                
            }catch(Exception e){}
    }

    public void eliminarArchivo(String nombre){
        try{
            //Nos preparamos para enviar el nombre del archivo
            DataOutputStream dos= new DataOutputStream(cl.getOutputStream());  
                    try{
                      dos.write(2); 
                      dos.flush();
                      Thread.sleep(500);
                    }catch(Exception e){}
            dos.writeBytes(nombre);
            dos.flush();
        }catch(Exception e){}
    }
    
    public void listarArchivos(){
            //Nos preparamos para enviar 
            try{
            DataOutputStream dos= new DataOutputStream(cl.getOutputStream());
                    try{
                      dos.write(3); 
                      dos.flush();
                      Thread.sleep(500);
                    }catch(Exception e){}

            }catch(Exception e){}
    }
    
    public ArrayList<String> getArrayList(){
        return List;
    }
    
}
