package examenredes;

import java.awt.List;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

class Objeto implements Serializable{
    String[] lista;
    String[] listaDes;
    char[][] SopaLetras;
    char coordenadas[][];
    
    public Objeto(String[] lista, char[][] SopaLetras, String[] listades,char[][] coordenadas ){
        this.lista=lista;
        this.SopaLetras=SopaLetras;
        this.listaDes=listades;
        this.coordenadas=coordenadas;
    }  
}   
    
public class HiloSSopadeLetaras extends Thread{
    private int puerto;
    private JFrame ventana;
    ServerSocket s;
    Socket cl;
    private boolean continuar =true;
    public HiloSSopadeLetaras(int pto, JFrame ventana){//Iniciamos el constructor del servidor de la sopa de letras
    this.puerto=pto;
    this.ventana=ventana;
    }
    
    
    
    public void run(){
    
         
     try{
        s= new ServerSocket(puerto);
        cl=s.accept();
        
        //Creamos los flujos de salida o entrada de objetos
        ObjectInputStream ois= new ObjectInputStream(cl.getInputStream());
        ObjectOutputStream oos= new ObjectOutputStream(cl.getOutputStream());
 
        //Creamos las variable para guardar la lista de palabras
        String [] palabras=new String[20];
        String [] palabras2=new String[20];
            try {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\javis\\Documents\\NetBeansProjects\\ExamenRedes\\palabras.txt"));
              int i=0;
              while((palabras[i] = br.readLine()) != null){
                palabras2[i]=palabras[i];  
                System.out.println(palabras[i]);
                i++;
              }
            }
            catch(Exception e) {
              System.out.println("Excepcion leyendo fichero" + e);
            }
        //Teniendo las palabras las guardamos en el objeto para enviarlas
            System.out.println("Dsordenamos las letras de manera aleatoria");
            Random pal=new Random();
            for(int x=0; x<15;x++){
                    String resultado= "";
                    int zz,azar;
                    for (zz=palabras[x].length();zz>2;zz--){
                        azar = pal.nextInt(zz)+1;
                        resultado = resultado + palabras[x].substring(azar-1,azar);
                        palabras[x] =  palabras[x].substring(0,azar-1)+palabras[x].substring(azar,zz);  
                    }
                  System.out.println(palabras[x]=resultado+palabras[x]);  
            }
 
        //Creamos el arreglo bidimencional con la sopa de letras 
        char [][] sopa=new char[16][16];
        char [][] coor=new char[16][16];      //Guardamos las coordenadas el punto ce inicio y el punto final
        
            for(int i=0;i<16;i++){
                for(int j=0;j<16;j++){
                    sopa[i][j]=' ';
                }
            }
            for(int i=0;i<16;i++){
                for(int j=0;j<16;j++){
                    coor[i][j]=' ';
                }
            }
        
        //Rellenamo la matriz 
                
    try{    
                System.out.println("Rellenamos la matriz ");
                int numx, numy, posicion;
                int acomoda=0;
                int col, contador;
                
                while(acomoda<15){
                       posicion=pal.nextInt(8)+1;
                       System.out.println("La palabra de la sopa es: "+acomoda);
                       System.out.println(posicion);
                       int tam=0;
                       switch(posicion){
                           case 1:
                               int y=0;
                                    while(y<1){
                                        numx=pal.nextInt(16);
                                        numy=pal.nextInt(16);
                                        System.out.println("x: "+numx);
                                        System.out.println("y: "+numy);
                                        if((numx+palabras2[acomoda].length())<16){
                                             col=colision(sopa, numx, numy, posicion, palabras2[acomoda]);
                                             if(col==1){
                                                 tam=palabras2[acomoda].length();
                                                 tam=tam-1;
                                                 coor[numy][numx]=(char)(acomoda+48);  //Guardamos la coordenada de inicio
                                                 System.out.printf(" La cordenada de inicio es: (%d ,%d)-%c\n",numx, numy,coor[numy][numx]);
                                                 coor[numy][numx+tam]=(char)(acomoda+48);      //Guardamos la pocision final
                                                 System.out.printf("La cordenada de final es: (%d ,%d)-%c\n",numx+tam,numy,coor[numy][numx+tam]);
                                                 System.out.println("Es posible colocar la palabra");
                                                 for(int p=0;p<palabras2[acomoda].length();p++)
                                                 sopa[numy][numx+p]=palabras2[acomoda].charAt(p);
                                                 y++;
                                             break;    
                                             }
                                        continue;   
                                        }
                                    }
                                acomoda++;
                               break;
                           case 2:
                                    y=0;
                                    while(y<1){
                                        numx=pal.nextInt(16);
                                        numy=pal.nextInt(16);
                                        System.out.println("x: "+numx);
                                        System.out.println("y: "+numy);
                                        if((numy-palabras2[acomoda].length())>-1){
                                            col=colision(sopa, numx, numy, posicion, palabras2[acomoda]);
                                            if(col==1){
                                             tam=palabras2[acomoda].length();
                                             tam=tam-1;
                                             coor[numy][numx]=(char)(acomoda+48);  //Guardamos la coordenada de inicio
                                             System.out.printf(" La cordenada de inicio es: (%d ,%d)-%c\n",numx, numy,coor[numy][numx]);
                                             coor[numy-tam][numx]=(char)(acomoda+48);      //Guardamos la pocision final   
                                             System.out.printf("La cordenada de final es: (%d ,%d)-%c\n",numx,numy-tam,coor[numy-tam][numx]);
                                             System.out.println("Es posible colocar la palabra");
                                             for(int p=0;p<palabras2[acomoda].length();p++)
                                             sopa[numy-p][numx]=palabras2[acomoda].charAt(p);
                                            y++;
                                            break;
                                            }
                                        continue;
                                        }
                                    }
                                acomoda++;
                               break;
                           case 3:    
                                    y=0;
                                    while(y<1){
                                        numx=pal.nextInt(16);
                                        numy=pal.nextInt(16);
                                        System.out.println("x: "+numx);
                                        System.out.println("y: "+numy);
                                        if((numx-palabras2[acomoda].length())>-1 ){
                                            col=colision(sopa, numx, numy, posicion, palabras2[acomoda]);
                                            if(col==1){
                                             tam=palabras2[acomoda].length();
                                             tam=tam-1;
                                             coor[numy][numx]=(char)(acomoda+48);  //Guardamos la coordenada de inicio
                                              System.out.printf(" La cordenada de inicio es: (%d ,%d)-%c\n",numx, numy,coor[numy][numx]);
                                             coor[numy][numx-tam]=(char)(acomoda+48);      //Guardamos la pocision final
                                              System.out.printf(" La cordenada de final es: (%d ,%d)-%c\n",numx-tam, numy,coor[numy][numx-tam]);
                                             for(int p=0;p<palabras2[acomoda].length();p++)
                                             sopa[numy][numx-p]=palabras2[acomoda].charAt(p);
                                            y++;
                                            break;
                                            }
                                        continue;
                                        }
                                    }
                                acomoda++;
                               break;
                           case 4:    
                                y=0;
                                    while(y<1){
                                        numx=pal.nextInt(16);
                                        numy=pal.nextInt(16);
                                        System.out.println("x: "+numx);
                                        System.out.println("y: "+numy);
                                        if((numy+palabras2[acomoda].length())<16 ){
                                            col=colision(sopa, numx, numy, posicion, palabras2[acomoda]);
                                            if(col==1){
                                             tam=palabras2[acomoda].length();
                                             tam=tam-1;
                                             coor[numy][numx]=(char)(acomoda+48);  //Guardamos la coordenada de inicio
                                              System.out.printf(" La cordenada de inicio es: (%d ,%d)-%c\n",numx, numy,coor[numy][numx]);
                                             coor[numy+tam][numx]=(char)(acomoda+48);      //Guardamos la pocision final
                                              System.out.printf(" La cordenada de final es: (%d ,%d)-%c\n",numx, numy+tam,coor[numy+tam][numx]);
                                             for(int p=0;p<palabras2[acomoda].length();p++)
                                             sopa[numy+p][numx]=palabras2[acomoda].charAt(p);
                                            y++;
                                            break;
                                            }
                                        continue;
                                        }
                                    }
                                acomoda++;
                               break;
                           case 5:
                                y=0;
                                    while(y<1){
                                        numx=pal.nextInt(16);
                                        numy=pal.nextInt(16);
                                        System.out.println("x: "+numx);
                                        System.out.println("y: "+numy);
                                        if((numy+palabras2[acomoda].length())<16 && (numx+palabras2[acomoda].length())<16){
                                            col=colision(sopa, numx, numy, posicion, palabras2[acomoda]);
                                            if(col==1){
                                             tam=palabras2[acomoda].length();
                                             tam=tam-1;
                                             coor[numy][numx]=(char)(acomoda+48);  //Guardamos la coordenada de inicio
                                              System.out.printf(" La cordenada de inicio es: (%d ,%d)-%c\n",numx, numy,coor[numy][numx]);
                                             coor[numy+tam][numx+tam]=(char)(acomoda+48);      //Guardamos la pocision final
                                              System.out.printf(" La cordenada de final es: (%d ,%d)-%c\n",numx+tam, numy+tam,coor[numy+tam][numx+tam]);
                                             int p=0;
                                             for( p=0;p<palabras2[acomoda].length();p++)
                                             sopa[numy+p][numx+p]=palabras2[acomoda].charAt(p);
                                             
                                            y++;
                                            break;
                                            }
                                        continue;
                                        }
                                    }
                                acomoda++;
                               break;
                           
                           case 6:
                                y=0;
                                    while(y<1){
                                        numx=pal.nextInt(16);
                                        numy=pal.nextInt(16);
                                        System.out.println("x: "+numx);
                                        System.out.println("y: "+numy);
                                        if((numy-palabras2[acomoda].length())>-1 && (numx+palabras2[acomoda].length())<16){
                                            col=colision(sopa, numx, numy, posicion, palabras2[acomoda]);
                                            if(col==1){
                                             tam=palabras2[acomoda].length();
                                             tam=tam-1;
                                             coor[numy][numx]=(char)(acomoda+48);  //Guardamos la coordenada de inicio
                                              System.out.printf(" La cordenada de inicio es: (%d ,%d)-%c\n",numx, numy,coor[numy][numx]);
                                             coor[numy-tam][numx+tam]=(char)(acomoda+48);      //Guardamos la pocision final
                                              System.out.printf(" La cordenada de final es: (%d ,%d)-%c\n",numx+tam, numy-tam,coor[numy-tam][numx+tam]);
                                             for(int p=0;p<palabras2[acomoda].length();p++)
                                             sopa[numy-p][numx+p]=palabras2[acomoda].charAt(p);
                                            y++;
                                            break;
                                            }
                                        continue;
                                        }
                                    }
                                acomoda++;
                               break;
                           
                           case 7:    
                               y=0;
                                    while(y<1){
                                        numx=pal.nextInt(16);
                                        numy=pal.nextInt(16);
                                        System.out.println("x: "+numx);
                                        System.out.println("y: "+numy);
                                        if((numy-palabras2[acomoda].length())>-1 && (numx-palabras2[acomoda].length())>-1){
                                            col=colision(sopa, numx, numy, posicion, palabras2[acomoda]);
                                            if(col==1){
                                             tam=palabras2[acomoda].length();
                                             tam=tam-1;
                                             coor[numy][numx]=(char)(acomoda+48);  //Guardamos la coordenada de inicio
                                              System.out.printf(" La cordenada de inicio es: (%d ,%d)-%c\n",numx, numy,coor[numy][numx]);
                                             coor[numy-tam][numx-tam]=(char)(acomoda+48); 
                                              System.out.printf(" La cordenada de inicio es: (%d ,%d)-%c\n",numx-tam, numy-tam,coor[numy-tam][numx-tam]);
                                              int p;  
                                             for(p=0;p<palabras2[acomoda].length();p++)
                                             sopa[numy-p][numx-p]=palabras2[acomoda].charAt(p);
                                             
                                            y++;
                                            break;
                                            }
                                        continue;
                                        }
                                    }
                                acomoda++;
                               break;
                                
                           case 8:
                               y=0;
                                    while(y<1){
                                        numx=pal.nextInt(16);
                                        numy=pal.nextInt(16);
                                        System.out.println("x: "+numx);
                                        System.out.println("y: "+numy);
                                        if((numy+palabras2[acomoda].length())<16 && (numx-palabras2[acomoda].length())>-1 ){
                                            col=colision(sopa, numx, numy, posicion, palabras2[acomoda]);
                                            if(col==1){
                                             tam=palabras2[acomoda].length();
                                             tam=tam-1;
                                             coor[numy][numx]=(char)(acomoda+48);  //Guardamos la coordenada de inicio
                                              System.out.printf(" La cordenada de inicio es: (%d ,%d)-%c\n",numx, numy,coor[numy][numx]);
                                             coor[numy+tam][numx-tam]=(char)(acomoda+48);  
                                              System.out.printf(" La cordenada de inicio es: (%d ,%d)-%c\n",numx-tam, numy+tam,coor[numy+tam][numx-tam]);
                                             for(int p=0;p<palabras2[acomoda].length();p++)
                                             sopa[numy+p][numx-p]=palabras2[acomoda].charAt(p);
                                            y++;
                                            break;
                                            }
                                        continue;
                                        }
                                    }
                                acomoda++;
                                break;
                            
                                default:
                                break;   
                        
                       }
                }
            //Imprimimos la matriz
                for(int i=0;i<16;i++){
                    for(int j=0;j<16;j++){
                        System.out.printf("%c",sopa[i][j]);
                    }
                    System.out.println();
                }
            System.out.println("Llenando la matriz de coordenadas...");
            //Imprimimos las pocisiones
                for(int i=0;i<16;i++){
                    for(int j=0;j<16;j++){
                        System.out.printf("%c",coor[i][j]);
                    }
                    System.out.printf("\n");
                }
                
        }catch(Exception e){
            System.out.println("Fallo al llenar la Matriz");
        }
    //Envia la lista de palabras  y la sopa de letras
    
    Objeto[] O1=new Objeto[1];
        O1[0]=new Objeto(palabras2,sopa, palabras, coor);
        //enviamos el objeto
        System.out.println("Enviando objeto...");
        oos.writeObject(O1[0]);
    
    
        JOptionPane.showMessageDialog(ventana, "Se ha establecido la conexion");
        }catch(Exception e){
        JOptionPane.showMessageDialog(ventana, "No se ha podido realizar la conexion");//Mensaje en caso de que no se haya logrado crear la conexion
        }
     
    }
    
    
        public void detenElHilo() 
        { 
        continuar=false; 
        } 
    
        public void rest() throws IOException{
        cl.close();
        s.close();
        }
    
        public int colision(char[][] sopa, int x, int y, int des, String palabra){
        int suma=0;
        switch(des){
        
            case 1:
                for(int c=0; c<palabra.length();c++){
                    if(sopa[y][x+c]==' ' || sopa[y][x+c]==palabra.charAt(c)){
                    suma++; 
                    }
                }
                if(suma==palabra.length()){
                return 1;
                }else{
                return 0;
                }
            case 2:
                 for(int c=0; c<palabra.length();c++){
                    if(sopa[y-c][x]==' ' || sopa[y-c][x]==palabra.charAt(c)){
                    suma++;
                    }
                }
                if(suma==palabra.length()){
                return 1;
                }else{
                return 0;
                }
            case 3:
                for(int c=0; c<palabra.length();c++){
                    if(sopa[y][x-c]==' ' || sopa[y][x-c]==palabra.charAt(c)){
                    suma++;
                    }
                }
                if(suma==palabra.length()){
                return 1;
                }else{
                return 0;
                }
                
            case 4:
                for(int c=0; c<palabra.length();c++){
                    if(sopa[y+c][x]==' ' || sopa[y+c][x]==palabra.charAt(c)){
                    suma++;
                    }
                }
                if(suma==palabra.length()){
                return 1;
                }else{
                return 0;
                }
            case 5:
                for(int c=0;c <palabra.length();c++){
                   if(sopa[y+c][x+c]==' ' || sopa[y+c][x+c]==palabra.charAt(c)){ 
                   suma++;
                   }
                }
                if(suma==palabra.length()){
                return 1;
                }else{
                return 0;
                }
            case 6:
                for(int c=0;c <palabra.length();c++){
                   if(sopa[y-c][x+c]==' ' || sopa[y-c][x+c]==palabra.charAt(c)){ 
                   suma++;
                   }
                }
                if(suma==palabra.length()){
                return 1;
                }else{
                return 0;
                }
            case 7:
                 for(int c=0;c <palabra.length();c++){
                   if(sopa[y-c][x-c]==' ' || sopa[y-c][x-c]==palabra.charAt(c)){ 
                   suma++;
                   }
                 
                 }
                if(suma==palabra.length()){
                return 1;
                }else{
                return 0;
                }
                
            case 8: 
                 for(int c=0;c <palabra.length();c++){
                    if(sopa[y+c][x-c]==' ' || sopa[y+c][x-c]==palabra.charAt(c)){ 
                    suma++;
                    }
                 }
                 }
                if(suma==palabra.length()){
                return 1;
                }else{
                return 0;
                }
        }
    }
   



