package view;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDesktop = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        cadastroLivro = new javax.swing.JMenuItem();
        cadastroVendedor = new javax.swing.JMenuItem();
        cadastroCliente = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Livraria");
        setName("FramePrincipal"); // NOI18N

        javax.swing.GroupLayout painelDesktopLayout = new javax.swing.GroupLayout(painelDesktop);
        painelDesktop.setLayout(painelDesktopLayout);
        painelDesktopLayout.setHorizontalGroup(
            painelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1204, Short.MAX_VALUE)
        );
        painelDesktopLayout.setVerticalGroup(
            painelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        fileMenu.setMnemonic('f');
        fileMenu.setText("Cadastro");

        cadastroLivro.setMnemonic('o');
        cadastroLivro.setText("Livro");
        cadastroLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroLivroActionPerformed(evt);
            }
        });
        fileMenu.add(cadastroLivro);

        cadastroVendedor.setMnemonic('s');
        cadastroVendedor.setText("Vendedor");
        cadastroVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroVendedorActionPerformed(evt);
            }
        });
        fileMenu.add(cadastroVendedor);

        cadastroCliente.setMnemonic('a');
        cadastroCliente.setText("Cliente");
        fileMenu.add(cadastroCliente);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Vendas");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Livro");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Gerar relatório");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(copyMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Sair");
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelDesktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelDesktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void cadastroVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroVendedorActionPerformed
        // TODO add your handling code here:

        TelaCadastroVendedor telaVendedor = new TelaCadastroVendedor();

        Dimension desktopSize = painelDesktop.getSize();
        Dimension jInternalFrameSize = telaVendedor.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        telaVendedor.setLocation(width, height);

        painelDesktop.add(telaVendedor);
        telaVendedor.setVisible(true);
    }//GEN-LAST:event_cadastroVendedorActionPerformed

    private void cadastroLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroLivroActionPerformed
         TelaCadastroLivro telaLivro = new TelaCadastroLivro();

        Dimension desktopSize = painelDesktop.getSize();
        Dimension jInternalFrameSize = telaLivro.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        telaLivro.setLocation(width, height);

        painelDesktop.add(telaLivro);
        telaLivro.setVisible(true);
    }//GEN-LAST:event_cadastroLivroActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cadastroCliente;
    private javax.swing.JMenuItem cadastroLivro;
    private javax.swing.JMenuItem cadastroVendedor;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JDesktopPane painelDesktop;
    // End of variables declaration//GEN-END:variables

}
