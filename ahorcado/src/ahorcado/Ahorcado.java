package ahorcado;

import java.net.*;
import java.io.*;
import java.util.Random;
public class Ahorcado {


    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] palabrafacil= {"hola", "tango", "redes", "oro" };
        String[] palabramedio={"carrera", "sistema", "computadora", "porteria"};
        String[] palabradif={"ferrocarril", "celulares", "aplicacion","multibote"};
        
        try{
            ServerSocket by= new ServerSocket(2000);
            System.out.println("Servidor iniciado...");
            System.out.println("Listo para recibir mennsajes...");
            int num;
            for(;;){
                Socket cl =by.accept();
                System.out.printf("Cliente conectado desde "+cl.getInetAddress()+":"+cl.getPort()+"\n");
                PrintWriter pw= new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
                PrintWriter pw2= new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
                BufferedReader br= new BufferedReader(new InputStreamReader(cl.getInputStream()));
                BufferedReader br3= new BufferedReader(new InputStreamReader(cl.getInputStream()));
                 for(;;){
                     String msj= br.readLine();
                     num=Integer.parseInt(msj);
                     
                     switch(num){
                     case 1:
                         Random pal= new Random();
                         int pnum=pal.nextInt(3)+1;
                         int longitud=palabrafacil[pnum].length();
                         String elec=""; char palabra;
                         elec=palabrafacil[pnum];
                         System.out.println(elec);
                            System.out.println("La longitud de la cadena facil es:"+longitud);
                            System.out.println("El numero de oportunidades para ganar es:" +(longitud+3));
                            String aux ="";
                                for(int i=0;i<longitud;i++){
                                palabra=elec.charAt(i);
                                aux=aux+"_ ";
                                System.out.print(palabra);
                                }
                                System.out.println();
                                System.out.println(aux);
                                System.out.println();
                                pw.println(longitud);
                                pw.flush();
                                
                                char[] guarda = new char[100];
                                char[] imp=new char[100];
                                String completando="";
                                
                                for(int z=0; z<100;z++)
                                    imp[z]='_';
                                
                                for(;;){
                                String recib=br3.readLine();
                                    
                                    if(elec.indexOf(recib)>=0){
                                        System.out.println(recib);
                                            for(int j=0;j<(elec.length());j++){
                                               if(recib.charAt(0)==elec.charAt(j)){
                                                guarda[j]=recib.charAt(0);
                                               }else{
                                                guarda[j]='_';
                                               }
                                            }
                                        for(int k=0;k<(elec.length());k++){
                                            if(guarda[k]==recib.charAt(0)){
                                                imp[k] =guarda[k];
                                            }
                                        }
                                        
                                        for(int f=0;f<(elec.length());f++){
                                            completando=completando+imp[f];
                                        }
                                        
                                        System.out.printf(completando+"\n");
                                        System.out.println(elec);
                                        
                                        if(elec.equals(completando)){
                                            pw.println("Felicidades");
                                            pw.flush();
                                            pw.close();
                                            br.close();
                                            cl.close();
                                            System.exit(0);
                                        }
                                            
                                            pw.println(completando);
                                            pw.flush();
                                            completando="";
                                            
                                        
                                        continue;
                                    }else{
                                        System.out.println("No esta");
                                        pw.println("La letra no se encuentra");
                                        pw.flush();
                                        continue;
                                    }
                                }              
                       
                     case 2:
                                                     Random pal2= new Random();
                         int pnum2=pal2.nextInt(3)+1;
                         int longitud2=palabramedio[pnum2].length();
                         String elec2=""; char palabra2;
                         elec2=palabramedio[pnum2];
                         System.out.println(elec2);
                            System.out.println("La longitud de la cadena medio es:"+longitud2);
                            System.out.println("El numero de oportunidades para ganar es:" +(longitud2+3));
                            String aux2 ="";
                                for(int i=0;i<longitud2;i++){
                                palabra2=elec2.charAt(i);
                                aux2=aux2+"_ ";
                                System.out.print(palabra2);
                                }
                                System.out.println();
                                System.out.println(aux2);
                                System.out.println();
                                pw.println(longitud2);
                                pw.flush();
                                
                                char[] guarda2 = new char[100];
                                char[] imp2=new char[100];
                                String completando2="";
                                
                                for(int z=0; z<100;z++)
                                    imp2[z]='_';
                                
                                for(;;){
                                String recib2=br3.readLine();
                                    
                                    if(elec2.indexOf(recib2)>=0){
                                        System.out.println(recib2);
                                            for(int j=0;j<(elec2.length());j++){
                                               if(recib2.charAt(0)==elec2.charAt(j)){
                                                guarda2[j]=recib2.charAt(0);
                                               }else{
                                                guarda2[j]='_';
                                               }
                                            }
                                        for(int k=0;k<(elec2.length());k++){
                                            if(guarda2[k]==recib2.charAt(0)){
                                                imp2[k] =guarda2[k];
                                            }
                                        }
                                        
                                        for(int f=0;f<(elec2.length());f++){
                                            completando2=completando2+imp2[f];
                                        }
                                        
                                        System.out.printf(completando2);
                                        
                                        if(elec2.equals(completando2)){
                                            pw.println("Felicidades");
                                            pw.flush();
                                            pw.close();
                                            br.close();
                                            cl.close();
                                            System.exit(0);
                                        }
                                            
                                            pw.println(completando2);
                                            pw.flush();
                                            completando2="";
                                        
                                        
                                        
                                        continue;
                                    }else{
                                        System.out.println("No esta");
                                        pw.println("La letra no se encuentra");
                                        pw.flush();
                                        continue;
                                    }
                                } 
                        
                           
                     case 3:
                                                  Random pal3= new Random();
                         int pnum3=pal3.nextInt(3)+1;
                         int longitud3=palabradif[pnum3].length();
                         String elec3=""; char palabra3;
                         elec3=palabradif[pnum3];
                         System.out.println(elec3);
                            System.out.println("La longitud3 de la cadena facil es:"+longitud3);
                            System.out.println("El numero de oportunidades para ganar es:" +(longitud3+3));
                            String aux3 ="";
                                for(int i=0;i<longitud3;i++){
                                palabra3=elec3.charAt(i);
                                aux3=aux3+"_ ";
                                System.out.print(palabra3);
                                }
                                System.out.println();
                                System.out.println(aux3);
                                System.out.println();
                                pw.println(longitud3);
                                pw.flush();
                                
                                char[] guarda3 = new char[100];
                                char[] imp3=new char[100];
                                String completando3="";
                                
                                for(int z=0; z<100;z++)
                                    imp3[z]='_';
                                
                                for(;;){
                                String recib3=br3.readLine();
                                    
                                    if(elec3.indexOf(recib3)>=0){
                                        System.out.println(recib3);
                                            for(int j=0;j<(elec3.length());j++){
                                               if(recib3.charAt(0)==elec3.charAt(j)){
                                                guarda3[j]=recib3.charAt(0);
                                               }else{
                                                guarda3[j]='_';
                                               }
                                            }
                                        for(int k=0;k<(elec3.length());k++){
                                            if(guarda3[k]==recib3.charAt(0)){
                                                imp3[k] =guarda3[k];
                                            }
                                        }
                                        
                                        for(int f=0;f<(elec3.length());f++){
                                            completando3=completando3+imp3[f];
                                        }
                                        
                                        System.out.printf(completando3);
                                       
                                        if(elec3.equals(completando3)){
                                            pw.println("Felicidades");
                                            pw.flush();
                                            pw.close();
                                            br.close();
                                            cl.close();
                                            System.exit(0);
                                        }
                                            
                                            pw.println(completando3);
                                            pw.flush();
                                            completando3="";
                                        
                                        
                                        continue;
                                    }else{
                                        System.out.println("No esta");
                                        pw.println("La letra no se encuentra");
                                        pw.flush();
                                        continue;
                                    }
                                } 
                     default:
                         System.out.println("Termina cliente...");
                         pw.close();
                         br.close();
                         cl.close();
                         break;
                     
                 
                 }
                     
                     
                     
                 
        
        }
        }
        }catch(Exception e){
        e.printStackTrace();
        }

        
        
    }
    
}
