/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CrudMovimentacao;

import br.com.Classes.Movimentacao;
import br.com.Exceptions.DataSourceException;
import br.com.Servicos.ServicoMovimentacao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jonat
 */
public class TelaAlterarStatus extends javax.swing.JInternalFrame {

    public static Movimentacao movimentacao;
    public static int id;

    public TelaAlterarStatus() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupPagoNaoPago = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonPago = new javax.swing.JRadioButton();
        jRadioButtonNaoPago = new javax.swing.JRadioButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alterar Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jRadioButtonPago.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroupPagoNaoPago.add(jRadioButtonPago);
        jRadioButtonPago.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonPago.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonPago.setSelected(true);
        jRadioButtonPago.setText("Pago");

        jRadioButtonNaoPago.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroupPagoNaoPago.add(jRadioButtonNaoPago);
        jRadioButtonNaoPago.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonNaoPago.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonNaoPago.setText("Não Pago");

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonCancelar.setText("Cancelar");

        jButtonSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonPago)
                    .addComponent(jRadioButtonNaoPago))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 41, Short.MAX_VALUE)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonPago)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonNaoPago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonSalvar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        ServicoMovimentacao servicoMovimentacao = new ServicoMovimentacao();
        if (jRadioButtonPago.isSelected() && movimentacao.getTipoMovimentacao().equalsIgnoreCase("despesa")) {
            movimentacao.setStatusDespesa("Pago");
            try {
                servicoMovimentacao.editarMovimentacao(id, movimentacao);
                JOptionPane.showMessageDialog(this, "Status alterado com sucesso!");
                this.dispose();
            } catch (DataSourceException ex) {
                Logger.getLogger(TelaAlterarStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (jRadioButtonNaoPago.isSelected() && movimentacao.getTipoMovimentacao().equalsIgnoreCase("despesa")) {
            movimentacao.setStatusDespesa("Não Pago");
            try {
                servicoMovimentacao.editarMovimentacao(id, movimentacao);
                JOptionPane.showMessageDialog(this, "Status alterado com sucesso!");
                this.dispose();
            } catch (DataSourceException ex) {
                Logger.getLogger(TelaAlterarStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não é possível alterar status de receita!", "ERRO", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupPagoNaoPago;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonNaoPago;
    private javax.swing.JRadioButton jRadioButtonPago;
    // End of variables declaration//GEN-END:variables
}
