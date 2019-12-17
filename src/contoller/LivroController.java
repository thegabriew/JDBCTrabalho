package contoller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DAO.LivroDAO;
import model.bean.Livro;
import model.bean.Vendedor;



public class LivroController {
   
    private Livro livroSelecionado;
    private List<Livro> tabelaDeLivros;
    private LivroDAO lDAO;
    
    public LivroController() {
        lDAO = new LivroDAO();
    }
    
    public void listarTodos(DefaultTableModel modeloTabela) {
        modeloTabela.setNumRows(0);
        List<Livro> listaLivros = lDAO.buscarTodos();

        for (Livro l : listaLivros) {
            modeloTabela.addRow(new Object[]{l.getId(), l.getISBN(),
                l.getTitulo(), l.getPaginas(), l.getPaginas(), l.getCategoria(), l.getPreco(), l.isStatus() ? "Disponível" : "Indisponível"});
        }
    }
    
    public void salvar(DefaultTableModel modeloTabela, Livro livro, boolean novo ) {
        if( novo ) {
            lDAO.inserir(livro);
       } else {
            lDAO.atualizar(livro);
        }
        this.listarTodos(modeloTabela);
    }
        
    
        
        public void listarPorId(DefaultTableModel modeloTabela, int id) {
        modeloTabela.setNumRows(0);
        Livro livroBuscado = lDAO.buscarPorId(id);

        modeloTabela.addRow(new Object[]{livroBuscado.getId(), livroBuscado.getISBN(),
            livroBuscado.getTitulo(), livroBuscado.getAutor(), livroBuscado.getPaginas(), livroBuscado.getCategoria(),
            livroBuscado.getPreco(), livroBuscado.isStatus() ? "Disponível" : "Indisponível"});
    }
        
        public void listarPorISBN(DefaultTableModel modeloTabela, int ISBN){
        modeloTabela.setNumRows(0);
        Livro livroBuscado = lDAO.buscarPorISBN(ISBN);
        
        modeloTabela.addRow(new Object[]{livroBuscado.getId(), livroBuscado.getISBN(),
            livroBuscado.getTitulo(), livroBuscado.getAutor(), livroBuscado.getPaginas(), livroBuscado.getCategoria(),
            livroBuscado.getPreco(), livroBuscado.isStatus() ? "Disponível" : "Indisponível"});        
    }
    
    
    public void excluir(DefaultTableModel modeloTabela, Livro livro ) {
        System.out.println("Excluindo livro No.: " + livro.getId());
        if( livro.getId() != 0 ) {
            lDAO.excluir(livro.getId());
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir as informações.\nLivro não localizado.", "Erro ao excluir", JOptionPane.ERROR_MESSAGE);
        }
        this.listarTodos(modeloTabela);
    }
    
}
