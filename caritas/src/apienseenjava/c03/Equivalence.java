package apienseenjava.c03;

//: c03:Equivalence.java
// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
public class Equivalence {

    public static void main( String [] args ) {
        Integer n1 = new Integer( 47 );
        Integer n2 = new Integer( 47 );
        System.out.println( n1==n2 );
        System.out.println( n1!=n2 );
    }
} ///:~