/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.TipoSuministrador;
import aplicacion.Suministrador;
import aplicacion.TipoUsuario;

/**
 *
 * @author alumnogreibd
 */
public class VSumins extends javax.swing.JDialog{
    
    aplicacion.FachadaAplicacion fa;
         
    /*** Creates new form VUsuario*/
    public VSumins(aplicacion.FachadaAplicacion fa) {
        //super(parent, modal);
        this.fa=fa;
        initComponents();
        
        tipoS.setModel(new javax.swing.DefaultComboBoxModel(TipoSuministrador.values()));
                    
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
        textoBusqueda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        etqtCIF = new javax.swing.JLabel();
        txtCIF = new javax.swing.JTextField();
        etqtNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        etqtPais = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        tipoS = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSumins = new javax.swing.JTable();

        setTitle("Gestion Usuarios");

        jLabel3.setText("CIF:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnNovo.setText("Nuevo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        Exit.setText("Sair");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        etqtCIF.setText("CIF:");

        etqtNome.setText("Nome:");

        jLabel8.setText("Tipo:");

        etqtPais.setText("Pais:");

        txtPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaisActionPerformed(evt);
            }
        });

        tipoS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoSActionPerformed(evt);
            }
        });

        tablaSumins.setModel(new ModeloTablaSuministradores());
        jScrollPane1.setViewportView(tablaSumins);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etqtNome)
                            .addComponent(etqtCIF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(txtCIF))
                        .addGap(309, 309, 309))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(30, 30, 30)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(btnBorrar)
                        .addGap(53, 53, 53)
                        .addComponent(Exit)
                        .addGap(34, 34, 34))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(30, 30, 30)
                            .addComponent(tipoS, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etqtPais)
                        .addGap(30, 30, 30)
                        .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(261, 261, 261)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqtCIF)
                    .addComponent(txtCIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(tipoS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqtNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqtPais)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnGuardar)
                    .addComponent(Exit)
                    .addComponent(btnBorrar))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(160, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        buscarUsuarios();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
       
        //Poñemos en blanco todos os JField        
        txtCIF.setText("");
        txtPais.setText("");
        txtNome.setText("");
      
        //Quitamos a seleccion das filas da taboa dos Usuarios
        tablaSumins.clearSelection();

    }//GEN-LAST:event_btnNovoActionPerformed
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:  
        Suministrador nSumin;
        ModeloTablaSuministradores mts;        
        
        //Iicializamos a taboa con ModeloTablaUsuarios
        mts = (ModeloTablaSuministradores) tablaSumins.getModel();
        
        //Asignamos os valores dos JField ao novo usuario
        nSumin =new Suministrador(txtCIF.getText(), txtNome.getText(),
                                  txtPais.getText(), (TipoSuministrador) tipoS.getSelectedItem());    
        
        //Bucle modificación/inserción
        if (tablaSumins.getSelectedRow() > 0){ //modificación de usuarios
            //System.out.println("probando");
                String cif = mts.obtenerSuministrador(tablaSumins.getSelectedRow()).getCIF(); //seleccion Suministrador
                mts.actualizarSuministrador(tablaSumins.getSelectedRow(), nSumin);
                fa.actualizarSuministrador(cif, nSumin);           
        }else {                                  //inserción de usuarios
                mts.novoSuministrador(nSumin);
                fa.insertarSuministrador(nSumin);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tipoSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoSActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        ModeloTablaSuministradores mts;
        String cif;
        
        mts = (ModeloTablaSuministradores) tablaSumins.getModel();
        //Extraemos a PK do usuario seleccionado e borramos
        cif = mts.obtenerSuministrador(tablaSumins.getSelectedRow()).getCIF();
        fa.borrarSuministrador(cif);
      
        //Actualizamos a lista con buscarUsuarios
        buscarUsuarios();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JLabel etqtCIF;
    private javax.swing.JLabel etqtNome;
    private javax.swing.JLabel etqtPais;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaSumins;
    private javax.swing.JTextField textoBusqueda;
    private javax.swing.JComboBox tipoS;
    private javax.swing.JTextField txtCIF;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPais;
    // End of variables declaration//GEN-END:variables
    
    private void buscarUsuarios(){
        ModeloTablaSuministradores mts;
     
        mts =(ModeloTablaSuministradores) tablaSumins.getModel();
        java.util.List<Suministrador> f;
        
        f =fa.obtenerSumins(textoBusqueda.getText());
        mts.setFilas(f);
        
        if (mts.getRowCount()>0){
                tablaSumins.setRowSelectionInterval(0, 0);
                txtCIF.setText(f.get(0).getCIF());
                txtNome.setText(f.get(0).getNombre());
                txtPais.setText(f.get(0).getPais());
                tipoS.setSelectedItem(f.get(0).getTipo());
                btnBorrar.setEnabled(true);
                btnGuardar.setEnabled(true);
        }
        else {
            btnBorrar.setEnabled(false);
            btnGuardar.setEnabled(false);
        }
    }   

}
