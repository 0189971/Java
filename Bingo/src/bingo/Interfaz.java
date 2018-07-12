package bingo;
import java.awt.Color;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author Yuca
 */
public class Interfaz extends javax.swing.JFrame {
    /**
     * Creates new form Interfaz
     */
    JLabel numero[][];
    int numrand[]= new int [16];
    String distribuir[]={};
    Bingo b = new Bingo();         
    MulticastSocket cl=null;
    InetAddress gpo=null;
    int contaux=0;    
    
    public Interfaz() {
        initComponents();
         this.setResizable(false);
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
        this.setTitle("Bingooo"); 
       b.conexion();
        iniciar();
        multi();
    }
    
    public void iniciar(){
         LJugador.setText(b.usuario);
           for (int i = 0; i < 16; i++) {
                numrand[i]=b.result[i];
                System.out.println("Num listos: "+numrand[i]);
            }
        gridsnumeros();
        DistribuirNumeros();
    }
    
    public boolean seleccion(String  num){ 
       boolean gano=false;       
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {           
                if(this.numero[i][j].getText().equals(num)){
                        this.numero[i][j].setText("<html><body><font color = \"red\"><s>"+this.numero[i][j].getText()+"</s></font></body></html>");
                        contaux++;
                        if(contaux==16)
                            gano=true;
                } 
            }   
        }  
        return gano;
    }
    
    public void multi(){
               try{
                    cl = new MulticastSocket(9001);
                    String dir = "227.1.2.3";
                    try{
                        gpo = InetAddress.getByName(dir);
                    }catch(UnknownHostException u){
                    }
                    cl.joinGroup(gpo);
                    cl.setReuseAddress(true);
                    int a=0;
                    for(;;){
                        DatagramPacket p = new DatagramPacket(new byte[40],40);
                        cl.receive(p);
                        String numero = new String (p.getData(),0,p.getLength());
                        System.out.println(numero);  

                        if(seleccion(numero)==true){              
                           String msj="-"+LJugador.getText();
                            byte[]b=msj.getBytes();
                            DatagramPacket pr = new DatagramPacket(b,b.length,gpo,9000);
                            cl.send(pr);
          
                            DatagramPacket p3 = new DatagramPacket(new byte[40],40);
                            cl.receive(p3);
                            String win = new String (p3.getData(),0,p3.getLength());
//                          System.out.println("Palabra recibida: "+win);  
//                           System.out.println("Ganaste "+LJugador.getText()+"Lugar: "+win);  
                            //JOptionPane.showMessageDialog(null, "Ganaste "+LJugador.getText()+"Lugar: "+win, "Ganador", JOptionPane.WARNING_MESSAGE);
                              try{
                                Thread.sleep(5000);
                                }catch(InterruptedException ie){}
                            System.exit(0);
                        }
                        else{
                              String msj="Sigue:"+numero;
                               byte[]b=msj.getBytes();
                               DatagramPacket pr = new DatagramPacket(b,b.length,gpo,9000);
                               cl.send(pr);
                        }
                        try{
                        Thread.sleep(750);
                       }catch(InterruptedException ie){
                        }
                    }
         }catch(Exception e){
             System.out.println("No funcionó");
         }finally{
                   try {
                       cl.leaveGroup(gpo);
                   } catch (IOException ex) {
                   }
         cl.close();
         }
    }
    
     public void DistribuirNumeros(){
        int aux=0;
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                
                if(numero[i][j].getText().equals("")){
                   numero[i][j].setText(""+numrand[aux]);
                   aux++;
                }
                System.out.print(" "+numero[i][j].getText());
            }
            System.out.println();
        }
    }
    
      public void gridsnumeros(){
                numero= new JLabel[4][4];
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        numero[i][j] = new JLabel("",javax.swing.SwingConstants.CENTER);
                        numero[i][j].setName("");
                        numero[i][j].setBackground(Color.WHITE);
                        numero[i][j].setFont(new java.awt.Font("Comic Sans MS",1,14));
                        numero[i][j].setForeground(new java.awt.Color(0,5,2));
                        numero[i][j].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                        numero[i][j].setOpaque(true);
                        numero[i][j].setBorder(new javax.swing.border.LineBorder(Color.BLACK,1));
                        PTablita.add(numero[i][j]);
                   
                    }

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

        PTablita = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LJugador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PTablita.setBackground(new java.awt.Color(0, 0, 0));
        PTablita.setLayout(new java.awt.GridLayout(4, 4));

        jLabel1.setText("Jugador: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PTablita, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(LJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(PTablita, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel LJugador;
    private javax.swing.JPanel PTablita;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
