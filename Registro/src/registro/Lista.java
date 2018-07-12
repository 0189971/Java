/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
        
        
        
public class Lista extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    String [] documentos=new String[2000]; 
    
    ConexionBD con2 = new ConexionBD();
    Connection cn2 = con2.conexion();
    int total=0;
    String [] nombreA = new String[2000];
    
    public Lista() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(0, 139, 139));
        
        nombreA=Gnombresdocs (nombreA);
        
        try {
            System.out.println("Cargando lista...");
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("ApePaterno");
            modelo.addColumn("ApeMaterno");
            modelo.addColumn("Correo");
            modelo.addColumn("Direccion");
            modelo.addColumn("Codigo Postal");
            modelo.addColumn("Colonia");
            modelo.addColumn("Tipo");
            modelo.addColumn("Teleforno");
            modelo.addColumn("Movil");
            modelo.addColumn("Traje");
            
            String sql ="";
            sql = "SELECT * FROM registrodatos ORDER BY idRegistro";
              String datos[] = new String [15];
               Statement st;
              
              try{
                st = (Statement) cn2.createStatement();
                ResultSet rs = (ResultSet) st.executeQuery(sql);
               
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    documentos[total]=datos[1]+".pdf";
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    datos[4]=rs.getString(5);
                    datos[5]=rs.getString(6);
                    datos[6]=rs.getString(12);
                    datos[7]=rs.getString(15);
                    datos[8]=rs.getString(7);
                    datos[9]=rs.getString(9);
                    datos[10]=rs.getString(10);
                    datos[11]=rs.getString(11);
                    
                    modelo.addRow(datos);
                    total++;
                }
              }catch(Exception e){
              }
                jTable2.setModel(modelo);
        }catch(Exception e){
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        busca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Bnombre = new javax.swing.JRadioButton();
        BapePaterno = new javax.swing.JRadioButton();
        Bapematerno = new javax.swing.JRadioButton();
        Propio = new javax.swing.JRadioButton();
        movil = new javax.swing.JRadioButton();
        tel = new javax.swing.JRadioButton();
        NumR = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista General");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Buscar");

        busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(Bnombre);
        Bnombre.setText("Nombre");

        buttonGroup1.add(BapePaterno);
        BapePaterno.setText("ApePaterno");

        buttonGroup1.add(Bapematerno);
        Bapematerno.setText("ApeMaterno");

        buttonGroup1.add(Propio);
        Propio.setText("Propio");

        buttonGroup1.add(movil);
        movil.setText("Movil");

        buttonGroup1.add(tel);
        tel.setText("Telefono");

        buttonGroup1.add(NumR);
        NumR.setText("Numero de Registro");

        jButton2.setText("Imprimir lista completa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Imprimir Personal");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Imprimer seleción");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Actualizar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(NumR)
                                        .addGap(28, 28, 28)
                                        .addComponent(Bnombre)
                                        .addGap(18, 18, 18)
                                        .addComponent(BapePaterno)
                                        .addGap(18, 18, 18)
                                        .addComponent(Bapematerno)
                                        .addGap(27, 27, 27)
                                        .addComponent(Propio)
                                        .addGap(18, 18, 18)
                                        .addComponent(tel)
                                        .addGap(18, 18, 18)
                                        .addComponent(movil)))
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(196, 196, 196)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bnombre)
                    .addComponent(BapePaterno)
                    .addComponent(Bapematerno)
                    .addComponent(Propio)
                    .addComponent(tel)
                    .addComponent(movil)
                    .addComponent(NumR))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String busqueda;
        String consulta="SELECT * FROM registrodatos ORDER BY idRegistro";
        busqueda=busca.getText().trim().toUpperCase();
        
        if(NumR.isSelected()==true){
            consulta="SELECT * FROM registrodatos WHERE idRegistro LIKE '"+busqueda+"%'";
        }else if(Bnombre.isSelected()==true){
            consulta="SELECT * FROM registrodatos WHERE Nombre LIKE '"+busqueda+"%'";
        }else if(BapePaterno.isSelected()==true){
            consulta="SELECT * FROM registrodatos WHERE ApePaterno LIKE '"+busqueda+"%'";
        }else if(Bapematerno.isSelected()==true){
            consulta="SELECT * FROM registrodatos WHERE ApeMaterno LIKE '"+busqueda+"%'";
        }else if(Propio.isSelected()==true){
            consulta="SELECT * FROM registrodatos WHERE Traje LIKE '"+busqueda+"%'";
        }else if(tel.isSelected()==true){
            consulta="SELECT * FROM registrodatos WHERE Telefono LIKE '"+busqueda+"%'";
        }else if(movil.isSelected()==true){
            consulta="SELECT * FROM registrodatos WHERE Movil LIKE '"+busqueda+"%'";
        }        
        
            String datos2[] = new String [22];
            Statement st; 
            
            
                ResetearM();
            
            
            System.out.println(consulta);
                try{
                
                st = (Statement) cn2.createStatement();
                ResultSet rs2 = (ResultSet) st.executeQuery(consulta);
                    while(rs2.next()){
                        datos2[0]=rs2.getString(1);
                        datos2[1]=rs2.getString(2);
                        datos2[2]=rs2.getString(3);
                        datos2[3]=rs2.getString(4);
                        datos2[4]=rs2.getString(5);
                        datos2[5]=rs2.getString(6);
                        datos2[6]=rs2.getString(12);
                        datos2[7]=rs2.getString(15);
                        datos2[8]=rs2.getString(7);
                        datos2[9]=rs2.getString(9);
                        datos2[10]=rs2.getString(10);
                        datos2[11]=rs2.getString(11);
                        
                        modelo.addRow(datos2);
                    }
              }catch(Exception e){
              }
        jTable2.setModel(modelo);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Document doc= new Document();
        String nompdf="Charros.pdf";
        try {    
            
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(nompdf));
                doc.open();
                
                Image foto2 =Image.getInstance("escudo1.png");
                foto2.scaleToFit(500, 500);
                foto2.setAlignment(Element.ALIGN_CENTER);
                
                doc.add(foto2);
                
                Paragraph parrafo=new Paragraph("LISTADO DE GREMIO");
                parrafo.setAlignment(Element.ALIGN_CENTER);
                doc.add(parrafo);
                
                String sql="SELECT Nombre, ApePaterno, ApeMaterno, Movil, Tipo FROM registrodatos";
                String datos2[] = new String [12];
                Statement st; 
                  
                    st = (Statement) cn2.createStatement();
                    ResultSet rs2 = (ResultSet) st.executeQuery(sql);
                    int type;
                    String tipos=null;
                   int i=0;
                    while(rs2.next()){
                        datos2[1]=rs2.getString(1);
                        datos2[2]=rs2.getString(2);
                        datos2[3]=rs2.getString(3);
                        datos2[4]=rs2.getString(4);
                        type=rs2.getInt(5);
                        i++;
                        if(type==1){
                            tipos="Socio";
                        }else if(type==2){
                            tipos="Charro";
                        }else if(type==3){
                            tipos="Simpatisante";
                        }
                        doc.add(new Paragraph("\n"+i+".- "+datos2[1]+" "+datos2[2]+" "+datos2[3]+"          Cel: "+datos2[4]+ "     Tipo: "+tipos));
                       
                    }
                doc.close();
                System.out.println("Cerramos el documento");
                JOptionPane.showMessageDialog(this, "Se ha generado el archivo con exito");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this,ex);
                Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadElementException ex) {
                Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        } catch (DocumentException ex) {
            Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
           Document doc2= new Document(); 
           Calendar calendario = Calendar.getInstance();
           int dia, mes, year, min, sec;
           dia=calendario.get(Calendar.DAY_OF_MONTH);
           mes=calendario.get(Calendar.MONTH);
           year=calendario.get(Calendar.YEAR);
           min=calendario.get(Calendar.MINUTE);
           sec=calendario.get(Calendar.SECOND);
           int cont=0;
           try {    
            
            try {
                PdfWriter.getInstance(doc2, new FileOutputStream("Datos_Personales"+dia+"_"+mes+"_"+year+"_"+min+"_"+sec+".pdf"));
                doc2.open();
                
                Image foto2 =Image.getInstance("escudo1.png");
                foto2.scaleToFit(400, 400);
                foto2.setAlignment(Element.ALIGN_CENTER);
                
                doc2.add(foto2);
                
                Paragraph parrafo=new Paragraph("INFORMACIÓN PERSONAL");
                parrafo.setAlignment(Element.ALIGN_CENTER);
                doc2.add(parrafo);
                
                String sql="SELECT Nombre, ApePaterno, ApeMaterno, Correo, Direccion, Telefono, Movil, Traje, CodigoPostal, fecha FROM registrodatos";
                String datos2[] = new String [12];
                Statement st; 
                  
                    st = (Statement) cn2.createStatement();
                    ResultSet rs2 = (ResultSet) st.executeQuery(sql);
                
                   int i=0;
                    while(rs2.next()){
                        datos2[1]=rs2.getString(1);
                        datos2[2]=rs2.getString(2);
                        datos2[3]=rs2.getString(3);
                        datos2[4]=rs2.getString(4);
                        datos2[5]=rs2.getString(5);
                        datos2[6]=rs2.getString(6);
                        datos2[7]=rs2.getString(7);
                        datos2[8]=rs2.getString(8);
                        datos2[9]=rs2.getString(9);
                        datos2[10]=rs2.getString(10);
                        
                        i++;
                        doc2.add(new Paragraph("\n Nombre: "+datos2[1]+"   Apepaterno: "+datos2[2]+"   ApeMaterno: "+datos2[3]));
                        doc2.add(new Paragraph("\n Fecha de nacimiento: "+datos2[10]+"   Dirección: "+datos2[5]+"   Codigo Postal:"+datos2[9]));
                        doc2.add(new Paragraph("\n Telefono fijo: "+datos2[6]+"   Telefono Movil: "+datos2[9]));
                        doc2.add(new Paragraph("\n Correo: "+datos2[4]+"\n\n\n\n"));
                        doc2.add(new Paragraph("Firma:______________________________________________"));
                        
                        
                        doc2.newPage();
                        Image foto3 =Image.getInstance("escudo1.png");
                        foto3.scaleToFit(400, 400);
                        foto3.setAlignment(Element.ALIGN_CENTER);

                        doc2.add(foto3);
                    }
                
                
                doc2.close();
                JOptionPane.showMessageDialog(this, "Se ha generado el archivo con exito"); 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadElementException ex) {
                Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        } catch (DocumentException ex) {
            Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            
        }
                    
                    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    //Tenemos que obtener todos los datos del modelo de la tabla para generar un pdf 
        System.out.println("El numero de registros es :" +modelo.getRowCount());
        Document doc= new Document();
        Calendar calendario = Calendar.getInstance();
           int dia, mes, year, min, sec;
           dia=calendario.get(Calendar.DAY_OF_MONTH);
           mes=calendario.get(Calendar.MONTH);
           year=calendario.get(Calendar.YEAR);
           min=calendario.get(Calendar.MINUTE);
           sec=calendario.get(Calendar.SECOND);
        String nompdf="Seleccion"+dia+"_"+mes+"_"+year+"_"+min+"_"+sec+".pdf";
                try {    
            
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(nompdf));
                doc.open();
                
                Image foto2 =Image.getInstance("escudo1.png");
                foto2.scaleToFit(500, 500);
                foto2.setAlignment(Element.ALIGN_CENTER);
                
                doc.add(foto2);
                
                Paragraph parrafo=new Paragraph("LISTA");
                parrafo.setAlignment(Element.ALIGN_CENTER);
                doc.add(parrafo);
                int counter=0, i=0;
                counter=modelo.getRowCount();
                String datos[]= new String[100];
                int  tipo=0;
                while(i<counter){
                    datos[0]=(String)modelo.getValueAt(i, 0);
                    datos[1]=(String)modelo.getValueAt(i, 1);
                    datos[2]=(String)modelo.getValueAt(i, 2);
                    datos[3]=(String)modelo.getValueAt(i, 3);
                    datos[4]=(String)modelo.getValueAt(i, 4);
                    datos[5]=(String)modelo.getValueAt(i, 5);
                    datos[6]=(String)modelo.getValueAt(i, 6);
                    datos[7]=(String)modelo.getValueAt(i, 7);
                    datos[8]=(String)modelo.getValueAt(i, 8);
                    datos[9]=(String)modelo.getValueAt(i, 9);
                    datos[10]=(String)modelo.getValueAt(i,10);
                    datos[11]=(String)modelo.getValueAt(i,11);
                    System.out.println("Los valores son: "+ modelo.getValueAt(i, 0));
                    tipo=Integer.parseInt(datos[8]);
                    if(tipo==3){
                        datos[8]="SOCIO-CHARRO";
                    }else if(tipo==2){
                        datos [8]="CHARRO";
                    }else if(tipo== 1){
                        datos[8]="SOCIO";
                    }
                    doc.add(new Paragraph("\n N° de Registro: "+datos[0]+" Nombre: "+datos[1]+" "+datos[2]+" "+datos[3]+" Correo: "        
                    + datos[4]+" Direccion:"+datos[5]+" Código Postal: "+datos[6]+" Colonia: "+datos[7]+" Tipo: "+datos[8]
                    +" Telefono: "+datos[9]+" Movil: "+datos[10]+" Traje: "+datos[11]));
                    i++;
                }
                doc.close();
                JOptionPane.showMessageDialog(this, "Se ha generado el archivo con exito");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this,"Verificar que el pdf Selección este cerrado");
                Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadElementException ex) {
                Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
        } catch (DocumentException ex) {
            Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        total=0;
        ResetearM();
        try {
            
            String sql ="";
            sql = "SELECT * FROM registrodatos ORDER BY idRegistro";
              String datos[] = new String [15];
               Statement st;
              
              try{
                st = (Statement) cn2.createStatement();
                ResultSet rs = (ResultSet) st.executeQuery(sql);
               
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    documentos[total]=datos[1]+".pdf";
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    datos[4]=rs.getString(5);
                    datos[5]=rs.getString(6);
                    datos[6]=rs.getString(12);
                    datos[7]=rs.getString(15);
                    datos[8]=rs.getString(7);
                    datos[9]=rs.getString(9);
                    datos[10]=rs.getString(10);
                    datos[11]=rs.getString(11);
                    
                    modelo.addRow(datos);
                    total++;
                }
              }catch(Exception e){
              }
                jTable2.setModel(modelo);
        }catch(Exception e){
        }
    }//GEN-LAST:event_jButton5ActionPerformed
 
    public void ResetearM(){
        int i=0;
        System.out.println("-"+modelo.getRowCount());
        int e=modelo.getRowCount();
        while( i < e)
        {
            modelo.removeRow(0);
            i++;
        }
    }
    
    public String [] Gnombresdocs (String [] array){
        String sql="SELECT idRegistro FROM registrodatos";
        
               Statement st;
              try{
                st = (Statement) cn2.createStatement();
                ResultSet rs = (ResultSet) st.executeQuery(sql);
                int i=0;
                while(rs.next()){
                    array[i]=rs.getString(1);
                    i++;
                }
              }catch(Exception e){
              }
              
     return array;
    }
    
    
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
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BapePaterno;
    private javax.swing.JRadioButton Bapematerno;
    private javax.swing.JRadioButton Bnombre;
    private javax.swing.JRadioButton NumR;
    private javax.swing.JRadioButton Propio;
    private javax.swing.JTextField busca;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JRadioButton movil;
    private javax.swing.JRadioButton tel;
    // End of variables declaration//GEN-END:variables
}
