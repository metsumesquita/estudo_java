package dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.ContaDao;
import model.Contas;
import model.util.Conectar;

public class ContaDaoImpl implements ContaDao {

    Conectar conexao;

    public ContaDaoImpl(Conectar conexao) {
        super();
        this.conexao = conexao;
    }

    @Override
    public void salvar(Contas conta) {
        Connection conn = conexao.getConnection();
        String sql = "INSERT INTO CONTA (NUMERO,SALDO,LIMITE)" + "VALUES (?,?,?)";
        try {
            //preparar a string para receber os valores de parametros
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, conta.getNumeroConta());
            ps.setDouble(2, conta.getSaldo());
            ps.setDouble(3, conta.getLimite());
            ps.execute();
            System.out.println("Conta inserida com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir a conta no banco " + ex.getMessage());
        } finally {
            conexao.fecharConexao(conn);
        }

    }

    @Override
    public void remover(int numero) {
    	
        Connection conn = conexao.getConnection();
        String sql = "DELETE FROM CONTA WHERE NUMERO = ?";
        try {
            //preparar a string para receber os valores de parametros
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,numero);
         
            ps.execute();
            System.out.println("Conta deletada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir a conta no banco " + ex.getMessage());
        } finally {
            conexao.fecharConexao(conn);
    }
        }

    @Override
    public void alterar(Contas conta) {

    	
        Connection conn = conexao.getConnection();
        String sql = "ALTER FROM CONTA WHERE NUMERO = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

         
            ps.executeUpdate();
            System.out.println("Conta deletada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir a conta no banco " + ex.getMessage());
        } finally {
            conexao.fecharConexao(conn);
        }
    }

    @Override
    public Contas pesquisar(int numero) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pesquisar'");
    }

    @Override
    public List<Contas> listarTodasContas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodasContas'");
    }

}
