package model.DAO;

import DB.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Livro;
import model.bean.Vendedor;

public class LivroDAO implements iDAO<Livro> {

    private final String INSERT = "INSERT INTO livro(ISBN, TITULO, AUTOR, PAGINAS, PRECO, CATEGORIA, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private final String UPDATE = "UPDATE vendedor SET ISBN=?, TÍTULO=?, AUTOR=?, PAGINAS=?, PREÇO=?, STATUS=? WHERE ID =?";
    private final String DELETE = "DELETE FROM livro WHERE ID =?";
    private final String LISTALL = "SELECT * FROM livro";
    private final String LISTBYID = "SELECT * FROM livro WHERE ID=?";
    private final String LISTBYISBN = "SELECT * FROM livro WHERE ISBN=?";

    private Connect conn = null;
    private Connection conexao = null;

    @Override
    public Livro inserir(Livro novoLivro) {
        conexao = this.getConnect().connection;
        if (novoLivro != null && conexao != null) {
            try {
                PreparedStatement transacaoSQL;
                transacaoSQL = conexao.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
                
                //INSERT INTO livro(ISBN, TITULO, AUTOR, PAGINAS, PRECO, CATEGORIA, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?)

                transacaoSQL.setInt(1, novoLivro.getISBN());
                transacaoSQL.setString(2, novoLivro.getTitulo());
                transacaoSQL.setString(3, novoLivro.getAutor());
                transacaoSQL.setInt(4, novoLivro.getPaginas());
                transacaoSQL.setDouble(5, novoLivro.getPreco());
                transacaoSQL.setString(6, novoLivro.getCategoria());
                transacaoSQL.setBoolean(7, novoLivro.isStatus());
                
                System.out.println(transacaoSQL.toString());
                

                transacaoSQL.execute();
                JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso", "Registro inserido", JOptionPane.INFORMATION_MESSAGE);

                try (ResultSet generatedKeys = transacaoSQL.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        novoLivro.setId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Não foi possível recuperar o ID.");
                    }
                }

                conn.fechaConexao(conexao, transacaoSQL);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir o livro no banco de " + "dados. \n" + e.getMessage(), "Erro na transação SQL", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Os dados do livro não podem estar vazios.", "Livro não informado", JOptionPane.ERROR_MESSAGE);
        }

        return novoLivro;
    }

    @Override
    public Livro atualizar(Livro obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int idLivro) {
        int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este livro?", "Confirmar exclusão",
			JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        // 0 - Sim  1 - Não
        if(confirmar == 1) {
            return;
        }
        conexao = this.getConnect().connection;
        if (conexao != null) {
            try {
                PreparedStatement transacaoSQL;
                transacaoSQL = conexao.prepareStatement(DELETE);

                transacaoSQL.setInt(1, idLivro);

                boolean erroAoExcluir = transacaoSQL.execute();

                if (erroAoExcluir) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir", "Não foi possível excluir as informações", JOptionPane.ERROR_MESSAGE);
                    throw new SQLException("Creating user failed, no rows affected.");
                }

                JOptionPane.showMessageDialog(null, "Registro excluido", "Livro excluido com sucesso", JOptionPane.INFORMATION_MESSAGE);

                conn.fechaConexao(conexao, transacaoSQL);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro na transação SQL", "Erro ao excluir livro no banco de" + "dados. \n" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Problemas de conexão", "Não foi possível se conectar ao banco.", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public List<Livro> buscarTodos() {
       conexao = this.getConnect().connection;

        ResultSet resultado = null;
        ArrayList<Livro> livros = new ArrayList<Livro>();

        if (conexao != null) {
            try {
                PreparedStatement transacaoSQL;
                transacaoSQL = conexao.prepareStatement(LISTALL);

                resultado = transacaoSQL.executeQuery();

                while (resultado.next()) {
                    Livro livroEncontrado = new Livro();

                    livroEncontrado.setId(resultado.getInt("id"));
                    livroEncontrado.setISBN(Integer.parseInt(resultado.getString("ISBN")));
                    livroEncontrado.setTitulo(resultado.getString("titulo"));
                    livroEncontrado.setAutor(resultado.getString("autor"));
                    livroEncontrado.setPaginas(Integer.parseInt(resultado.getString("paginas")));
                    livroEncontrado.setCategoria(resultado.getString("categoria"));
                    livroEncontrado.setPreco(Double.parseDouble(resultado.getString("preco")));
                    livroEncontrado.setStatus(resultado.getBoolean("status"));
                   
                    livros.add(livroEncontrado);
                    
                }
                
                conn.fechaConexao(conexao, transacaoSQL);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro na transação SQL", "Erro ao procurar livros no banco de" + "dados. \n" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Problemas de conexão", "Não foi possível se conectar ao banco.", JOptionPane.ERROR_MESSAGE);
        }

        return livros;
    }


    @Override
    public Livro buscarPorId(int id) {
         conexao = this.getConnect().connection;
        
        ResultSet resultado = null;
        Livro livroEncontrado = new Livro();

        if (conexao != null) {
            try {
                PreparedStatement transacaoSQL;
                transacaoSQL = conexao.prepareStatement(LISTBYID);
                transacaoSQL.setInt(1, id);

                resultado = transacaoSQL.executeQuery();

                while (resultado.next()) {

                    livroEncontrado.setId(resultado.getInt("id"));
                    livroEncontrado.setISBN(Integer.parseInt(resultado.getString("ISBN")));
                    livroEncontrado.setTitulo(resultado.getString("titulo"));
                    livroEncontrado.setAutor(resultado.getString("autor"));
                    livroEncontrado.setPaginas(Integer.parseInt(resultado.getString("paginas")));
                    livroEncontrado.setCategoria(resultado.getString("categoria"));
                    livroEncontrado.setPreco(Double.parseDouble(resultado.getString("preco")));
                    livroEncontrado.setStatus(resultado.getBoolean("status"));;
                   
                }
                
                conn.fechaConexao(conexao, transacaoSQL);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro na transação SQL", "Erro ao procurar livro no banco de" + "dados. \n" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Problemas de conexão", "Não foi possível se conectar ao banco.", JOptionPane.ERROR_MESSAGE);
        }

        return livroEncontrado;
    }
    
    public Livro buscarPorISBN(int ISBN) {
        conexao = this.getConnect().connection;
        
        ResultSet resultado = null;
        Livro livroEncontrado = new Livro();

        if (conexao != null) {
            try {
                PreparedStatement transacaoSQL;
                transacaoSQL = conexao.prepareStatement(LISTBYISBN);
                transacaoSQL.setInt(1, ISBN);

                resultado = transacaoSQL.executeQuery();

                while (resultado.next()) {

                    livroEncontrado.setId(resultado.getInt("id"));
                    livroEncontrado.setISBN(Integer.parseInt(resultado.getString("ISBN")));
                    livroEncontrado.setTitulo(resultado.getString("titulo"));
                    livroEncontrado.setAutor(resultado.getString("autor"));
                    livroEncontrado.setPaginas(Integer.parseInt(resultado.getString("paginas")));
                    livroEncontrado.setCategoria(resultado.getString("categoria"));
                    livroEncontrado.setPreco(Double.parseDouble(resultado.getString("preco")));
                    livroEncontrado.setStatus(resultado.getBoolean("status"));;
                   
                }
                
                conn.fechaConexao(conexao, transacaoSQL);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro na transação SQL", "Erro ao procurar livro no banco de" + "dados. \n" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Problemas de conexão", "Não foi possível se conectar ao banco.", JOptionPane.ERROR_MESSAGE);
        }

        return livroEncontrado;
    }

    public Connect getConnect() {
        this.conn = new Connect("root", "", "NovaLivraria");
        return this.conn;
    }
}

