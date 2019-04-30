/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Autor;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author alumnogreibd
 */
public class VAutor extends javax.swing.JDialog {
    
    aplicacion.FachadaAplicacion fa;
         
    /*** Creates new form VUsuario*/
    public VAutor(aplicacion.FachadaAplicacion fa) {
        //super(parent, modal);
        this.fa=fa;
        initComponents();
        
        //Executamos a funcion para encher a taboa
        //buscarUsuarios();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        textoNome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAutores = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnGuardarU = new javax.swing.JButton();
        btnBorrarU = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        etqtnome = new javax.swing.JLabel();
        nomeAutor = new javax.swing.JTextField();
        etqFec1 = new javax.swing.JLabel();
        dataNac = new javax.swing.JTextField();
        etqtFec2 = new javax.swing.JLabel();
        dataFal = new javax.swing.JTextField();

        setTitle("Gestion Usuarios");

        jLabel3.setText("Nome:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablaAutores.setModel(new ModeloTablaAutores());
        tablaAutores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaAutores.getTableHeader().setReorderingAllowed(false);
        tablaAutores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAutoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAutores);

        btnNovo.setText("Nuevo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnGuardarU.setText("Guardar");
        btnGuardarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarUActionPerformed(evt);
            }
        });

        btnBorrarU.setText("Borrar");
        btnBorrarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarUActionPerformed(evt);
            }
        });

        Exit.setText("Sair");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        etqtnome.setText("Nome:");

        etqFec1.setText("Data Nacemento:");

        etqtFec2.setText("Data Falecemento:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnNovo)
                                .addGap(28, 28, 28)
                                .addComponent(btnGuardarU)
                                .addGap(37, 37, 37)
                                .addComponent(btnBorrarU))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etqtFec2)
                                    .addComponent(etqtnome, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(etqFec1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dataNac, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(dataFal)
                                    .addComponent(nomeAutor))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Exit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqtnome)
                    .addComponent(nomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqFec1)
                    .addComponent(dataNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqtFec2)
                    .addComponent(dataFal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnGuardarU)
                    .addComponent(btnBorrarU)
                    .addComponent(Exit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        buscarAutores();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
       
        //Poñemos en blanco todos os JField        
        nomeAutor.setText("");
        dataNac.setText("");
        dataFal.setText("");
      
        //Quitamos a seleccion das filas da taboa dos Usuarios
        tablaAutores.clearSelection();

    }//GEN-LAST:event_btnNovoActionPerformed
    
    private void btnGuardarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUActionPerformed
        // TODO add your handling code here:  
        Autor newAutor;
        ModeloTablaAutores mta;        
        
        //Iicializamos a taboa con ModeloTablaUsuarios
        mta = (ModeloTablaAutores) tablaAutores.getModel();
        
        //Asignamos os valores dos JField ao novo usuario
        newAutor =new Autor(nomeAutor.getText(), Date.valueOf(dataNac.getText()), Date.valueOf(dataFal.getText()));    
        
        //Bucle modificación/inserción
        if (tablaAutores.getSelectedRow() > 0){ //modificación de usuarios
            //System.out.println("probando");
                String idU = mta.obtenerAutor(tablaAutores.getSelectedRow()).getNombre(); //Seleccion Usuario
                mta.actualizarAutor(tablaAutores.getSelectedRow(), newAutor);
                fa.actualizarAutor(idU, newAutor);           
        }else {                                  //inserción de usuarios
                mta.novoAutor(newAutor);
                fa.insertarAutor(newAutor);
        }
    }//GEN-LAST:event_btnGuardarUActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void btnBorrarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarUActionPerformed
        // TODO add your handling code here:
        ModeloTablaAutores mta;
        String nome;
        
        mta = (ModeloTablaAutores) tablaAutores.getModel();
        //Extraemos a PK do usuario seleccionado e borramos
        nome = mta.obtenerAutor(tablaAutores.getSelectedRow()).getNombre();
        fa.borrarUsuario(nome);
      
        //Actualizamos a lista con buscarUsuarios
        buscarAutores();
    }//GEN-LAST:event_btnBorrarUActionPerformed

    private void tablaAutoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAutoresMouseClicked
        // TODO add your handling code here:
        Autor  a;
        ModeloTablaAutores mta;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        //Asignamos a variable a taboa
        mta=(ModeloTablaAutores)tablaAutores.getModel();
        
        //asignamos usuario pinchado
        a = mta.obtenerAutor(tablaAutores.getSelectedRow());
        
        //Asignamos aos campos de texto os correspondentes ao seleccionado na taboa
        nomeAutor.setText(a.getNombre());
        dataNac.setText(sdf.format(a.getFechaNacemento()));
        dataFal.setText(sdf.format(a.getFechaFalecemento()));
    }//GEN-LAST:event_tablaAutoresMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JButton btnBorrarU;
    private javax.swing.JButton btnGuardarU;
    private javax.swing.JButton btnNovo;
    private javax.swing.JTextField dataFal;
    private javax.swing.JTextField dataNac;
    private javax.swing.JLabel etqFec1;
    private javax.swing.JLabel etqtFec2;
    private javax.swing.JLabel etqtnome;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeAutor;
    private javax.swing.JTable tablaAutores;
    private javax.swing.JTextField textoNome;
    // End of variables declaration//GEN-END:variables
    
    private void buscarAutores(){
        ModeloTablaAutores mta;
     
        mta =(ModeloTablaAutores) tablaAutores.getModel();
        java.util.List<Autor> f;
        mta.setFilas((f= fa.obtenerAutores(textoNome.getText())));
        
        if (mta.getRowCount()>0){
                tablaAutores.setRowSelectionInterval(0, 0);
                nomeAutor.setText(f.get(0).getNombre());
               // dataNac.setText(f.get(0).getFechaNacemento());
                btnBorrarU.setEnabled(true);
                btnGuardarU.setEnabled(true);
        }
        else {
            btnBorrarU.setEnabled(false);
            btnGuardarU.setEnabled(false);
        }
    }   

}
