package dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            // preparar a string para receber os valores de parametros
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
            // preparar a string para receber os valores de parametros
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, numero);

            ps.execute();
            System.out.println("Conta deletada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao remover a conta do banco de dados " + ex.getMessage());
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
            ps.setDouble(1, conta.getSaldo());
            ps.setDouble(2, conta.getLimite());
            ps.executeUpdate();
            System.out.println("Conta atualizadacom sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar a conta " + ex.getMessage());
        } finally {
            conexao.fecharConexao(conn);
        }
    }

    @Override
    public Contas pesquisar(int numero) {
        Connection conn = conexao.getConnection();
        Contas conta = new Contas();
        String sql = "SELECT * FROM CONTA WHERE NUMERO= ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                conta.setNumeroConta(rs.getInt("NUMERO"));
                conta.setSaldo(rs.getDouble("SALDO"));
                conta.setLimite(rs.getDouble("LIMITE"));
            }
        } catch (Exception ex) {
            System.out.println("esta conta nao esta no banco de dados " + ex.getMessage());
        } finally {
            conexao.fecharConexao(conn);
        }
        return conta;
    }

    @Override
    public List<Contas> listarTodasContas() {
        Connection conn = conexao.getConnection();
        List<Contas> retorno = new ArrayList<Contas>();
        String sql = "SELECT * FROM CONTA ";
        try {
            // preparar a string para receber os valores de parametros
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Contas conta = new Contas();
                conta.setNumeroConta(rs.getInt("NUMERO"));
                conta.setSaldo(rs.getDouble("SALDO"));
                conta.setLimite(rs.getDouble("LIMITE"));
                retorno.add(conta);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao retorna a lista de contas existentes no banco " + ex.getMessage());
        } finally {
            conexao.fecharConexao(conn);
        }

        return retorno;
     

    }

}
