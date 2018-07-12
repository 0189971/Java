/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.de.compras;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author javis
 */
public class Carrito extends javax.swing.JFrame {


    public Carrito() {
        initComponents();
    }
    
    public void mensaje(String men){
    JOptionPane.showMessageDialog(rootPane, men);
    }
    public void establecer(){
    
    System.out.println("Esperando a establecer conexion...");
    
    }
    
    public void conectar(){
    
    
    
    }
    
    private void agregarImagen(ImageIcon img, JLabel etiquetaImagen, Objeto[] a, int i) {
        nombre.setText(a[i].getNombre());
        img  = new ImageIcon(a[i].getPathImagen());
        etiquetaImagen = new JLabel(img);
        etiquetaImagen.setSize(150, 150);
        etiquetaImagen.setBounds(20, 0, 170, 150);
        this.add(etiquetaImagen);
    }
    
    private void compra(){
    
        try{
            
        //guardamos informacion de la coneccion en base al servidor 
        int pto=Integer.parseInt(PTO.getText());
        String host=HOST.getText();
        System.out.println("Conexión establecida...");
        
        
        
        Socket cl=new Socket(host,pto);
        
        ObjectOutputStream oos= new ObjectOutputStream(cl.getOutputStream());
        ObjectInputStream ois= new ObjectInputStream(cl.getInputStream());
        ObjectInputStream ois1= new ObjectInputStream(cl.getInputStream());
        ObjectInputStream ois2= new ObjectInputStream(cl.getInputStream());
        int[] almacen=new int[10];
        float[] pre=new float[10];
        String[] nom= new String[10];
        String[] imagen=new String[10];
        
        Objeto[] o1=new Objeto[10];
        
        o1[0]=(Objeto)ois.readObject();
        System.out.println("Objeto recibido con los datos:a->"+o1[0].precio+"b->"+o1[0].nombre+"c->"+o1[0].imagen);
        
        o1[1]=(Objeto)ois.readObject();
        System.out.println("Objeto recibido con los datos:a->"+o1[1].precio+"b->"+o1[1].nombre+"c->"+o1[1].imagen);
        
        o1[2]=(Objeto)ois.readObject();
        System.out.println("Objeto recibido con los datos:a->"+o1[2].precio+"b->"+o1[2].nombre+"c->"+o1[2].imagen);
        
        
        for(int i=0;i<3;i++){
        almacen[i]=o1[i].almacen;
            System.out.println("Los objetos en almacen son:"+almacen[i]);
        pre[i]=o1[i].precio;
        nom[i]=o1[i].nombre;
        imagen[i]=o1[i].imagen;
        }
        //Seleccionamos la venta que debemos realizar       
        
                
        
        int eleccion=0;
        Objeto[] o2=new Objeto[10];
        
        if(jRadioButton1.isSelected()==true){
            eleccion=1;
        }
        if(jRadioButton2.isSelected()==true){
            eleccion=2;            
        }
        if(jRadioButton3.isSelected()==true){
            eleccion=3;
        }
        switch(eleccion){
            case 1:
                
                mensaje("Desea confirmar la compra de un Arduino Mega");
                int numeroCom=Integer.parseInt((String) Spinner1.getValue());
                mensaje("El numero de objetos que va comprar son:"+numeroCom);
                o2[0]= new Objeto(almacen[0]-1,pre[0],nom[0],imagen[0]);
                oos.writeObject(o2[0]);
                oos.flush();
                System.out.println("Objeto enviado con los datos: a->"+o2[0].precio+"b->"+o2[0].nombre+"c->"+o2[0].imagen);
                
                //Esperamos la respuesta del servidor 
                o1[4]=(Objeto)ois.readObject();
                System.out.println("Objeto recivido");
                
                float IVA;
                float precioreal;
                IVA=(float) (o1[4].precio*(0.16));
                System.out.println(IVA);
                precioreal=IVA+(o1[4].precio);
                System.out.println("El total es:" +precioreal);
                
                
                break;
            case 2:
                mensaje("Desea confirmar la compra de una Ethernet Shield ");
                o2[1]= new Objeto(almacen[0]-1,pre[1],nom[1],imagen[1]);
                oos.writeObject(o2[1]);
                oos.flush();
                System.out.println("Objeto enviado con los datos: a->"+o2[1].precio+"b->"+o2[1].nombre+"c->"+o2[1].imagen);
                
                //Esperamos la respuesta del servidor 
                o1[4]=(Objeto)ois.readObject();
                System.out.println("Objeto recivido");
                IVA=(float) (o1[4].precio*(0.16));
                precioreal=IVA+(o1[4].precio);
                System.out.println("El total es:" +precioreal);
                
                break;
            case 3:
                mensaje("Desea confirmar la compra de un USB ftdi");
                o2[2]= new Objeto(almacen[0]-1,pre[2],nom[2],imagen[2]);
                oos.writeObject(o2[0]);
                oos.flush();
                System.out.println("Objeto enviado con los datos: a->"+o2[0].precio+"b->"+o2[0].nombre+"c->"+o2[0].imagen);
                
                //Esperamos la respuesta del servidor 
                o1[4]=(Objeto)ois.readObject();
                System.out.println("Objeto recivido");
                IVA=(float) (o1[4].precio*(0.16));
                precioreal=IVA+(o1[4].precio);
                System.out.println("El total es:" +precioreal);
                break;   
            default:
            break;
        } 
        //oos.close();
        //ois.close();
        //cl.close();
        
    
    }catch(Exception e){
        e.printStackTrace();
    } 
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Compra = new javax.swing.ButtonGroup();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        HOST = new javax.swing.JTextField();
        PTO = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        Spinner1 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        Conectar = new javax.swing.JButton();
        nombre = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tunga", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("Carrito de compras");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(380, 20, 250, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Lista de compra ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(140, 20, 110, 17);

        Compra.add(jRadioButton1);
        jRadioButton1.setText("Arduino Shield");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(290, 110, 93, 30);

        Compra.add(jRadioButton2);
        jRadioButton2.setText("USB ftdi");
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(300, 270, 90, 30);

        Compra.add(jRadioButton3);
        jRadioButton3.setText("Arduino Mega");
        getContentPane().add(jRadioButton3);
        jRadioButton3.setBounds(290, 430, 93, 23);

        jButton1.setText("Comprar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(460, 320, 100, 40);
        getContentPane().add(HOST);
        HOST.setBounds(390, 80, 110, 30);
        getContentPane().add(PTO);
        PTO.setBounds(540, 80, 100, 30);

        jLabel7.setText("Escribe el host");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(390, 60, 90, 14);

        jLabel8.setText("Escribe el puerto");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(540, 60, 80, 14);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(30, 220, 170, 130);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(30, 380, 170, 130);
        getContentPane().add(Spinner1);
        Spinner1.setBounds(220, 110, 40, 30);
        getContentPane().add(jSpinner3);
        jSpinner3.setBounds(220, 270, 40, 30);

        Conectar.setText("Conectar");
        Conectar.setBorderPainted(false);
        getContentPane().add(Conectar);
        Conectar.setBounds(550, 130, 90, 30);
        getContentPane().add(nombre);
        nombre.setBounds(40, 60, 160, 110);
        getContentPane().add(jSpinner4);
        jSpinner4.setBounds(230, 430, 30, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        compra();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Carrito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Compra;
    private javax.swing.JButton Conectar;
    private javax.swing.JTextField HOST;
    private javax.swing.JTextField PTO;
    private javax.swing.JSpinner Spinner1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel nombre;
    // End of variables declaration//GEN-END:variables
}
