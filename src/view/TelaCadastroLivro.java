/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import contoller.LivroController;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.bean.Livro;
import model.bean.Vendedor;

public class TelaCadastroLivro extends javax.swing.JInternalFrame {

    private javax.swing.table.DefaultTableModel tabelaModelo;
    private LivroController lController;
    private Livro lSelecionado = new Livro();
    private boolean podeEditar = false;
    public String ISBNText;
    
    
    public TelaCadastroLivro() {
        this.CriarTabelaModelo();
        initComponents();
        lController = new LivroController();
        lController.listarTodos(tabelaModelo);
        limparCampos();
    }

    public void CriarTabelaModelo() {

        this.tabelaModelo = new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null}
                },
                new String[]{
                    "ID", "ISBN", "Título", "Autor", "Categoria", "Paginas", "Preço", "Status"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.Integer.class,
                java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.Integer.class,
                java.lang.Double.class, java.lang.String.class
            };

            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        };
    }
    
     public void limparCampos() {
        lSelecionado = new Livro(); // 

        ISBN.setText("");
        nomeLivro.setText("");
        Autor.setText("");
        Paginas.setText("");
        Categoria.setText("");
        Preco.setText("");
        String status_index = "Disponível";
        
        //tabelaDeLivros.getSelectionModel().clearSelection();
        this.desabilitarCamposEdicao();
        lController.listarTodos(tabelaModelo);
    }
     
     public void desabilitarCamposEdicao() {
        this.ISBN.setEnabled(false);
        this.nomeLivro.setEnabled(false);
        this.Autor.setEnabled(false);
        this.Preco.setEnabled(false);
        this.Categoria.setEnabled(false);
        this.Paginas.setEnabled(false);
        

        this.podeEditar = false;

    }

    public void habilitarCamposEdicao() {
        this.nomeLivro.setEnabled(true);
        this.ISBN.setEnabled(true);
        this.Autor.setEnabled(true);
        this.Categoria.setEnabled(true);
        this.Preco.setEnabled(true);
        this.Paginas.setEnabled(true);
        

        this.podeEditar = true;

    }

    public void preencherLivro(Livro l, int id, int ISBN, String titulo, String autor, int paginas, String categoria, double preco, boolean status) {
        if (ISBN != 0 && titulo != null && autor != null && paginas != 0 && categoria != null && preco != 0) {
            l.setId(id);
            
            l.setISBN(ISBN); 
            l.setTitulo(titulo);
            l.setAutor(autor);
            
            l.setPaginas(paginas);
            l.setCategoria(categoria);
            
            l.setPreco(preco);
            l.setStatus(status);
        } else {
            this.limparCampos();
        }
    }

    public void preencherSelecionado(ListSelectionEvent e) {
        int linha = tabelaLivros.getSelectedRow();
        try {
            int id = Integer.parseInt(tabelaModelo.getValueAt(linha, 0).toString());
            int ISBN = Integer.parseInt(tabelaModelo.getValueAt(linha, 1).toString());
            String titulo = tabelaModelo.getValueAt(linha, 2).toString();
            String autor = tabelaModelo.getValueAt(linha, 3).toString();
            int paginas = Integer.parseInt(tabelaModelo.getValueAt(linha, 4).toString());
            String categoria = tabelaModelo.getValueAt(linha, 5).toString();
            double preco = Double.parseDouble(tabelaModelo.getValueAt(linha, 6).toString());
            boolean status = tabelaModelo.getValueAt(linha, 7).toString().equals("Disponível");

            this.preencherLivro(lSelecionado, id, ISBN, titulo, autor, paginas, categoria, preco, status);

            this.preencherCampos();
            this.habilitarCamposEdicao();
        } catch (Exception erro) {
            this.limparCampos();
        }
    }

     public void preencherCampos() {
        ISBN.setText(String.valueOf(lSelecionado.getISBN()));
        nomeLivro.setText(lSelecionado.getTitulo());
        Autor.setText(lSelecionado.getAutor());
        Categoria.setText(lSelecionado.getAutor());
        Paginas.setText(String.valueOf(lSelecionado.getPaginas()));
        Preco.setText(String.valueOf(lSelecionado.getPreco()));
        
        
    }




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        textoNome = new javax.swing.JLabel();
        nomeLivro = new javax.swing.JTextField();
        textoNome1 = new javax.swing.JLabel();
        ISBN = new javax.swing.JTextField();
        textoNome2 = new javax.swing.JLabel();
        Autor = new javax.swing.JTextField();
        textoNome3 = new javax.swing.JLabel();
        Categoria = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnProcurar = new javax.swing.JButton();
        textoNome4 = new javax.swing.JLabel();
        Paginas = new javax.swing.JTextField();
        textoNome5 = new javax.swing.JLabel();
        Preco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painel.setBackground(new java.awt.Color(0, 0, 0));

        textoNome.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        textoNome.setForeground(new java.awt.Color(255, 0, 0));
        textoNome.setText("Nome");

        nomeLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeLivroActionPerformed(evt);
            }
        });

        textoNome1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        textoNome1.setForeground(new java.awt.Color(255, 0, 0));
        textoNome1.setText("ISBN");

        ISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBNActionPerformed(evt);
            }
        });

        textoNome2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        textoNome2.setForeground(new java.awt.Color(255, 0, 0));
        textoNome2.setText("Autor");

        Autor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutorActionPerformed(evt);
            }
        });

        textoNome3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        textoNome3.setForeground(new java.awt.Color(255, 0, 0));
        textoNome3.setText("Categoria");

        Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriaActionPerformed(evt);
            }
        });

        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("DELETAR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnProcurar.setText("PROCURAR");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        textoNome4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        textoNome4.setForeground(new java.awt.Color(255, 0, 0));
        textoNome4.setText("Preço");

        Paginas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaginasActionPerformed(evt);
            }
        });

        textoNome5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        textoNome5.setForeground(new java.awt.Color(255, 0, 0));
        textoNome5.setText("Quantidade de páginas");

        Preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tabelaLivros);
        tabelaLivros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                preencherSelecionado(e);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoNome5)
                    .addComponent(Paginas, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoNome1)
                            .addComponent(ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoNome)
                            .addComponent(textoNome2)
                            .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoNome3)
                            .addComponent(Autor, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoNome4))
                        .addGap(81, 81, 81)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(textoNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(nomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoNome1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoNome2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoNome3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoNome4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoNome5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Paginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabelaLivros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                preencherSelecionado(e);
            }
        });

        getContentPane().add(painel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 650, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeLivroActionPerformed

    private void ISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISBNActionPerformed

    private void AutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AutorActionPerformed

    private void CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoriaActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
       this.habilitarCamposEdicao();
        this.ISBNText.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void PaginasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaginasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PaginasActionPerformed

    private void PrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       if (!this.podeEditar) {
            JOptionPane.showMessageDialog(this, "Escolha um livro na tabela ou clique em NOVO.\nÉ preciso preencher todos os campos.");
            return;
        }

        int id = lSelecionado.getId();
        int ISBN = Integer.parseInt(ISBN.getText());
        String titulo = nomeLivro.getText();
        String autor = Autor.getText();
        int paginas = Integer.parseInt(Paginas.getText());
        String categoria = (Categoria.getText());
        double preco = Double.parseDouble(Preco.getText());
   

        this.preencherLivro(lSelecionado, id, ISBN, titulo, autor, paginas, categoria, preco);

        if (lSelecionado != null && !(titulo.equals("") || autor.equals(""))) {
            System.out.println(lSelecionado);
            if (this.tabelaModelo == null) {
                System.out.println("A tabela é nula");
            }
            if (lSelecionado.getId() != 0) {
                // atualizar
                lController.salvar(this.tabelaModelo, lSelecionado, false);
            } else {
                // criar novo
                lController.salvar(this.tabelaModelo, lSelecionado, true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "É preciso preencher todos os campos.");
        }
        
        
        limparCampos();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
          if (lSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Este livro não consta no banco de dados.\nTente novamente." );
        } else {
            lController.excluir(tabelaModelo, lSelecionado);
        }

        limparCampos();
    }                                          

    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Autor;
    private javax.swing.JTextField Categoria;
    private javax.swing.JTextField ISBN;
    private javax.swing.JTextField Paginas;
    private javax.swing.JTextField Preco;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeLivro;
    private javax.swing.JPanel painel;
    private javax.swing.JTable tabelaLivros;
    private javax.swing.JLabel textoNome;
    private javax.swing.JLabel textoNome1;
    private javax.swing.JLabel textoNome2;
    private javax.swing.JLabel textoNome3;
    private javax.swing.JLabel textoNome4;
    private javax.swing.JLabel textoNome5;
    // End of variables declaration//GEN-END:variables
}
