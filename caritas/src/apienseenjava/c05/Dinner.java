package apienseenjava.c05;

//: c05:Dinner.java

import apienseenjava.c05.dessert.Cookie;

// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// Uses the library.

public class Dinner {
    public Dinner() {
        System.out.println("Dinner constructor");
    }

    public static void main( String [] args ) {
        Cookie x = new Cookie();
        //! x.bite(); // Can't access
    }
} ///:~