package ahorcado;

import java.net.*;
import java.io.*;
import java.util.Scanner;
public class CLahorcado {
        
        public static void main(String[] args){
            Scanner entra =new Scanner(System.in);
        try{

            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribe la direccion del servidor:");
            String host=br.readLine();
            System.out.println("Escribe el puerto:");
            int pto=Integer.parseInt(br.readLine());
            Socket cl= new Socket(host,pto);
            PrintWriter pw= new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
            PrintWriter pw2= new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
            BufferedReader br2= new BufferedReader(new InputStreamReader(cl.getInputStream()));
            BufferedReader br3= new BufferedReader(new InputStreamReader(cl.getInputStream()));
                System.out.println("Selecciona la dificultad");
                System.out.println("1.-Facil");
                System.out.println("2.-Medio");
                System.out.println("3.-Dificil");
            int num;
            for(;;){   
                
                String msj= br.readLine();
                num=Integer.parseInt(msj);
                         if(num < 1 && num > 3){
                            pw.println(msj);
                            pw.flush();
                            br2.close();
                            br.close();
                            cl.close();
                         System.exit(0);
                         }else if(num==1){
                             pw.println(msj);
                             pw.flush();
                             String msjR=br2.readLine();
                            
                             System.out.println("La longitd es de: "+msjR);
                             int tam=Integer.parseInt(msjR);
                             for(int i=0;i<tam;i++)
                                System.out.printf("_ ");
                                System.out.println();
                             for(int j=0;j<tam+3; j++){
                                System.out.printf("Turno N°%d ",j);
                                System.out.println("escribe la letra que mas deseas");
                                String letra=br.readLine();
                                char let=letra.charAt(0);
                                pw2.println(let);
                                pw2.flush();
                                System.out.println("El ahorcado es:");
                                String ahor=br3.readLine();
                                 System.out.println(ahor);
                                
                                 if(ahor.equals("Felicidades")){
                                     
                                   br2.close();
                                   br.close();
                                   cl.close();
                                   System.exit(0);
                                   
                                 }else if( j == (tam+2)){
                                     System.out.println("Has perdido");
                                   br2.close();
                                   br.close();
                                   cl.close();
                                   System.exit(0);
                                 }
                                 
                             }
                             
                             continue;
                         }else if(num==2){
                             pw.println(msj);
                             pw.flush();
                             String msjR=br2.readLine();
                            
                             System.out.println("La longitd es de: "+msjR);
                             int tam=Integer.parseInt(msjR);
                             for(int i=0;i<tam;i++)
                                System.out.printf("_ ");
                                System.out.println();
                             for(int j=0;j<tam+3; j++){
                                System.out.printf("Turno N°%d ",j);
                                System.out.println("escribe la letra que mas deseas");
                                String letra=br.readLine();
                                char let=letra.charAt(0);
                                pw2.println(let);
                                pw2.flush();
                                System.out.println("El ahorcado es:");
                                String ahor=br3.readLine();
                                System.out.println(ahor); 
                                
                                 if(ahor.equals("Felicidades")){
                                     
                                   br2.close();
                                   br.close();
                                   cl.close();
                                   System.exit(0);
                                   
                                 }else if( j == (tam+1)){
                                     System.out.println("Has perdido");
                                   br2.close();
                                   br.close();
                                   cl.close();
                                   System.exit(0);
                                 }
                                
                                
                                
                             }
                             continue;
                         }else if(num==3){
                             pw.println(msj);
                             pw.flush();
                             String msjR=br2.readLine();
                            
                             System.out.println("La longitd es de: "+msjR);
                             int tam=Integer.parseInt(msjR);
                             for(int i=0;i<tam;i++)
                                System.out.printf("_ ");
                                System.out.println();
                             for(int j=0;j<tam+3; j++){
                                System.out.printf("Turno N°%d ",j);
                                System.out.println("escribe la letra que mas deseas");
                                String letra=br.readLine();
                                char let=letra.charAt(0);
                                pw2.println(let);
                                pw2.flush();
                                System.out.println("El ahorcado es:");
                                String ahor=br3.readLine();
                                System.out.println(ahor);
                                
                                 if(ahor.equals("Felicidades")){
                                     
                                   br2.close();
                                   br.close();
                                   cl.close();
                                   System.exit(0);
                                   
                                 }else if( j == tam){
                                     System.out.println("Has perdido");
                                   br2.close();
                                   br.close();
                                   cl.close();
                                   System.exit(0);
                                 }
                                
                                
                             }
                             continue;
                         }
                         
            }
            
        }catch(Exception e){
        e.printStackTrace();
    }
 
}
}
