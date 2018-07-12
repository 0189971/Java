package apienseenjava.c13;

//: c13:Applet1.java
// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// Very simple applet.
import javax.swing.*;
import java.awt.*;

public class Applet1 extends JApplet {
    @Override
    public void init() {
        getContentPane().add(new JLabel("Applet!"));
    }
} ///:~