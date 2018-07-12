package apienseenjava.c08;

//: c08:MultiImplementation.java
// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// With concrete or abstract classes, inner 
// classes are the only way to produce the effect
// of "multiple implementation inheritance."

class C1 {}
abstract class D {}

class Z extends C1 {
  D makeD() { return new D() {}; }
} 

public class MultiImplementation {
  static void takesC(C1 c) {}
  static void takesD(D d) {}
  public static void main(String[] args) {
    Z z = new Z();
    takesC(z);
    takesD(z.makeD());
  }
} ///:~