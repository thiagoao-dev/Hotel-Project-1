/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifil.view;

import br.edu.unifil.model.QuartoModel;
import br.edu.unifil.model.ReservaModel;
import br.edu.unifil.model.VisitanteModel;

/**
 *
 * @author ThiagoAugustus
 */
public class ReservaView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReservaView
     */
    public ReservaView() {
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

        painelPrincipal = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        inputNome = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        labelTelefone = new javax.swing.JLabel();
        inputTelefone = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        labelDataEntrada = new javax.swing.JLabel();
        labelDataSaida = new javax.swing.JLabel();
        labelQuarto = new javax.swing.JLabel();
        inputComboQuarto = new javax.swing.JComboBox();
        inputValorPagamento = new javax.swing.JTextField();
        labelValorPagamento = new javax.swing.JLabel();
        labelObs = new javax.swing.JLabel();
        inputScrollObs = new javax.swing.JScrollPane();
        inputTextObs = new javax.swing.JTextArea();
        labelPago = new javax.swing.JLabel();
        inputCheckPago = new javax.swing.JCheckBox();
        btInserir = new javax.swing.JButton();
        inputEntrada = new org.jdesktop.swingx.JXDatePicker();
        inputSaida = new org.jdesktop.swingx.JXDatePicker();

        setClosable(true);
        setTitle("Cadastro de Reserva");
        setToolTipText("");

        painelPrincipal.setBackground(new java.awt.Color(204, 204, 204));
        painelPrincipal.setPreferredSize(new java.awt.Dimension(640, 400));

        labelNome.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelNome.setForeground(new java.awt.Color(102, 102, 102));
        labelNome.setText("Nome");

        inputNome.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        inputNome.setForeground(new java.awt.Color(51, 51, 51));
        inputNome.setToolTipText("Digite o nome do hospede");

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/unifil/image/ic-lupe-16.png"))); // NOI18N
        btPesquisar.setToolTipText("Pesquisar hospede?");
        btPesquisar.setFocusable(false);

        labelTelefone.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelTelefone.setForeground(new java.awt.Color(102, 102, 102));
        labelTelefone.setText("Telefone");

        inputTelefone.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        inputTelefone.setForeground(new java.awt.Color(51, 51, 51));
        inputTelefone.setToolTipText("Digite o nome do hospede");

        labelEmail.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(102, 102, 102));
        labelEmail.setText("E-mail");

        inputEmail.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        inputEmail.setForeground(new java.awt.Color(51, 51, 51));
        inputEmail.setToolTipText("Digite o nome do hospede");

        labelDataEntrada.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelDataEntrada.setForeground(new java.awt.Color(102, 102, 102));
        labelDataEntrada.setText("Entrada");

        labelDataSaida.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelDataSaida.setForeground(new java.awt.Color(102, 102, 102));
        labelDataSaida.setText("Saída");

        labelQuarto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelQuarto.setForeground(new java.awt.Color(102, 102, 102));
        labelQuarto.setText("Quarto");

        inputComboQuarto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        inputComboQuarto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "101", "102", "103", "104", "201", "202", "203", "204", "301", "302", "303", "304" }));

        inputValorPagamento.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        inputValorPagamento.setForeground(new java.awt.Color(51, 51, 51));
        inputValorPagamento.setToolTipText("Digite o nome do hospede");

        labelValorPagamento.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelValorPagamento.setForeground(new java.awt.Color(102, 102, 102));
        labelValorPagamento.setText("Pagamento");

        labelObs.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelObs.setForeground(new java.awt.Color(102, 102, 102));
        labelObs.setText("Observações");

        inputTextObs.setColumns(20);
        inputTextObs.setRows(5);
        inputScrollObs.setViewportView(inputTextObs);

        labelPago.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelPago.setForeground(new java.awt.Color(102, 102, 102));
        labelPago.setText("Pagamento adiantado?");

        inputCheckPago.setBackground(new java.awt.Color(204, 204, 204));
        inputCheckPago.setFocusable(false);

        btInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/unifil/image/ic-ok.png"))); // NOI18N
        btInserir.setToolTipText("Registrar reserva");
        btInserir.setBorderPainted(false);
        btInserir.setOpaque(false);
        btInserir.setPreferredSize(new java.awt.Dimension(60, 60));
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        inputEntrada.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        inputSaida.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTelefone)
                            .addComponent(labelNome)
                            .addComponent(labelDataEntrada)
                            .addComponent(labelQuarto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelPrincipalLayout.createSequentialGroup()
                                .addComponent(inputNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisar))
                            .addGroup(painelPrincipalLayout.createSequentialGroup()
                                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                                        .addComponent(inputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                        .addComponent(labelEmail))
                                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(inputComboQuarto, 0, 180, Short.MAX_VALUE)
                                            .addComponent(inputEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(15, 15, 15)
                                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(labelDataSaida)
                                            .addComponent(labelValorPagamento))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                    .addComponent(inputValorPagamento, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inputSaida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(inputScrollObs)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelObs)
                            .addGroup(painelPrincipalLayout.createSequentialGroup()
                                .addComponent(labelPago)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputCheckPago)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelPrincipalLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNome)
                            .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefone)
                    .addComponent(inputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmail)
                    .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelDataSaida)
                        .addComponent(labelDataEntrada)
                        .addComponent(inputSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inputEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuarto)
                    .addComponent(inputComboQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputValorPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelValorPagamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelObs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputScrollObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPago)
                    .addComponent(inputCheckPago))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        
        // Inicia os atributos necessários
        VisitanteModel hospede = new VisitanteModel();
        QuartoModel    quarto  = new QuartoModel();
        ReservaModel   reserva = new ReservaModel();
        
        reserva.setVisitanteReserva(hospede);
        reserva.setQuartoReserva(quarto);
        
        // Recupera o quarto
        quarto.setDescricaoQuarto((String) this.inputComboQuarto.getSelectedItem());
        
        System.out.println(this.inputComboQuarto.getSelectedItem());
        
        this.dispose();
    }//GEN-LAST:event_btInserirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JCheckBox inputCheckPago;
    private javax.swing.JComboBox inputComboQuarto;
    private javax.swing.JTextField inputEmail;
    private org.jdesktop.swingx.JXDatePicker inputEntrada;
    private javax.swing.JTextField inputNome;
    private org.jdesktop.swingx.JXDatePicker inputSaida;
    private javax.swing.JScrollPane inputScrollObs;
    private javax.swing.JTextField inputTelefone;
    private javax.swing.JTextArea inputTextObs;
    private javax.swing.JTextField inputValorPagamento;
    private javax.swing.JLabel labelDataEntrada;
    private javax.swing.JLabel labelDataSaida;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelObs;
    private javax.swing.JLabel labelPago;
    private javax.swing.JLabel labelQuarto;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JLabel labelValorPagamento;
    private javax.swing.JPanel painelPrincipal;
    // End of variables declaration//GEN-END:variables
}
