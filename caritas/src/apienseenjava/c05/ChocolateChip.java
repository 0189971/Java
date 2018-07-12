package apienseenjava.c05;

//: c05:ChocolateChip.java

import apienseenjava.c05.dessert.Cookie;

// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// Can't access friendly member
// in another class.

public class ChocolateChip extends Cookie {
    public ChocolateChip() {
        System.out.println( "ChocolateChip constructor" );
    }

    public static void main( String [] args ) {
        ChocolateChip x = new ChocolateChip();
        //! x.bite(); // Can't access bite
    }
} ///:~