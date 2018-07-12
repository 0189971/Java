package apienseenjava.c08;

//: c08:MultiInterfaces.java
// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// Two ways that a class can 
// implement multiple interfaces.

interface A1 {}
interface B {}

class X implements A1, B {}

class Y1 implements A1 {
  B makeB() {
    // Anonymous inner class:
    return new B() {};
  }
}

public class MultiInterfaces {
  static void takesA(A1 a) {}
  static void takesB(B b) {}
  public static void main(String[] args) {
    X x = new X();
    Y1 y = new Y1();
    takesA(x);
    takesA(y);
    takesB(x);
    takesB(y.makeB());
  }
} ///:~