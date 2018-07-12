package anumcioP;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author javis
 */
public class mult {
    public static void main(String[] args) {
      Scanner leenumero= new Scanner(System.in);
      String Number1, Number2;
      int Num1[], Num2[];
      System.out.println("Ingresa el num1: ");
      Number1=leenumero.nextLine();
      System.out.println("Ingresa el num2: ");
      Number2=leenumero.nextLine();
      int a=Number1.length();
      int b=Number2.length();
      Num1 = new int[a];
      Num2= new int[b];
      


      for (int i=0; i<a;i++){
          Num1[i]= Integer.parseInt(String.valueOf(Number1.charAt(i)));
          
      }
      
      for (int i=0; i<b;i++){
          Num2[i]= Integer.parseInt(String.valueOf(Number2.charAt(i)));
      }
      

       int potencia= (int) Math.pow(4,2);
        BigInteger x = DyV(Num1,Num2,a,b);
        System.out.println("\n\t MULTIPLICACION: "+x);
    }
    public static BigInteger DyV(int A[], int B[],int a, int b){
        BigInteger resultado=BigInteger.ZERO;
        
          if (a==1 || b==1){
            String num1="", num2="";
            for(int i=0;i<A.length;i++)
                num1 =num1+ String.valueOf(A[i]);
            for(int i=0;i<B.length;i++)
                num2 =num2+ String.valueOf(B[i]);
            
            int n1= Integer.parseInt(num1);
            int n2= Integer.parseInt(num2);
            int mult=n1*n2;
            resultado=BigInteger.valueOf(mult);
            return resultado;
        }
          
        int IA[]=Dividir(A,1);
        int DA[]=Dividir(A,0);
        int IB[]=Dividir(B,1);
        int DB[]=Dividir(B,0);
        
        int a_aux = 0, b_aux = 0;
        
        if(a%2==0)
            a_aux=(a/2);
        else if ((a%2)!=0)
            a_aux=(a/2);
        
        
        if(b%2==0)
            b_aux=(b/2);

        else if((b%2)!=0)
            b_aux=(b/2);
        

        BigInteger P1=DyV(IA,IB, a/2, b/2);
        BigInteger P2=DyV(IA,DB, a/2, b/2);
        BigInteger P3=DyV(DA,IB, a/2, b/2);
        BigInteger P4=DyV(DA,DB, a/2, b/2);
               
        System.out.println("\nP1: "+P1);
        System.out.println("P2: "+P2);
        System.out.println("P3: "+P3);
        System.out.println("P4: "+P4);
        
        BigInteger potab=BigInteger.valueOf((int)Math.pow(10,b_aux+a_aux));
        BigInteger pota=BigInteger.valueOf((int)Math.pow(10,a_aux));
        BigInteger potb=BigInteger.valueOf((int)Math.pow(10,b_aux));
        
        BigInteger T1= new BigInteger(potab.multiply(P1).toString());
        BigInteger T2= new BigInteger(pota.multiply(P2).toString());
        BigInteger T3= new BigInteger(potb.multiply(P3).toString());
        
        BigInteger R1=new BigInteger(T1.add(T2).toString());
        BigInteger R2=new BigInteger(T3.add(P4).toString());
        
        resultado =new BigInteger(R1.add(R2).toString());
        
        //
        
        System.out.println("10^"+"("+b_aux+"+"+a_aux+")"+"*"+P1+": "+T1);
        System.out.println("10^"+"("+a_aux+")"+"*"+P2+": "+T2);
        System.out.println("10^"+"("+b_aux+")"+"*"+P3+": "+T3);
        System.out.println("El resultado es: "+resultado);
        return resultado;
        
      
        
    }
    
    public static int[] Dividir(int Arreglo[], int lado){
        int n=Arreglo.length;
        if(n%2==0)
            n=n;
        else
            n=n+1;
        
        int ladoFinal[]=null;

        if(lado==1){      //LADO Izq
            String Izq="";
            
            for(int i=0; i<n/2;i++)
               Izq=Izq+String.valueOf(Arreglo[i]);    
            
            ladoFinal=new int[Izq.length()];
            
            for (int i=0; i<Izq.length();i++)
            ladoFinal[i]= Integer.parseInt(String.valueOf(Izq.charAt(i)));
            
                  
        }
        else if(lado==0){     //LADO der
            String der="";
            
            if(Arreglo.length%2==0){
            for(int i=n/2; i<n;i++)
               der=der+String.valueOf(Arreglo[i]); 
            }
            else{
            for(int i=n/2; i<n-1;i++)
               der=der+String.valueOf(Arreglo[i]); 
            } 
            
            ladoFinal=new int[der.length()];
            
            for (int i=0; i<der.length();i++)
            ladoFinal[i]= Integer.parseInt(String.valueOf(der.charAt(i)));
             
        }
        
        return ladoFinal;

    }
}
