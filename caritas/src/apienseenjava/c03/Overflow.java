package apienseenjava.c03;

//: c03:Overflow.java
// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// Surprise! Java lets you overflow.
public class Overflow {

    public static void main(String[] args) {
        int big = 0x7fffffff; // max int value
        int otro = Integer.MAX_VALUE;
        prt("big = " + big);
        prt("big = " + otro);
        int bigger = big + 1;
        prt("bigger = " + bigger);
        bigger -= 2;
        prt("bigger = " + bigger);
    }

    static void prt(String s) {
        System.out.println(s);
    }
} ///:~