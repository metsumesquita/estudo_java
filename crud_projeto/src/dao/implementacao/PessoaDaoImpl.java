package dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.ContaDao;
import dao.EnderecoDao;
import dao.PessoaDao;
import model.Pessoa;
import model.util.Conectar;

public class PessoaDaoImpl implements PessoaDao {
    Conectar conexao;
    EnderecoDao enderecos;
    ContaDao contas;

    public PessoaDaoImpl(Conectar conexao) {
        super();
        this.conexao = conexao;
        enderecos = new EnderecoDaoImpl(this.conexao);
        contas = new ContaDaoImpl(this.conexao);
    }

    @Override
    public void salvar(Pessoa pessoa) {
        Connection conn = conexao.getConnection();
        String sql = "INSERT INTO PESSOA (CPF,NOME,SEXO,IDADE,NUMERO_CONTA,ENDERECO_ID)" + "VALUES (?,?,?,?,?)";
        try {
            // preparar a string para receber os valores de parametros
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pessoa.getCpf());
            ps.setString(2, pessoa.getNome());
            ps.setString(3, pessoa.getSexo());
            ps.setInt(4, pessoa.getIdade());
            ps.setInt(5, pessoa.getConta().getNumeroConta());
            ps.setInt(6, pessoa.getEndereco().getId());

            ps.execute();
            System.out.println("Pessoa adicionada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir pessoa no banco " + ex.getMessage());
        } finally {
            conexao.fecharConexao(conn);
        }

    }

    @Override
    public void remover(String cpf) {

        Connection conn = conexao.getConnection();
        String sql = "DELETE FROM PESSOA WHERE CPF = ?";
        Pessoa person = pesquisar(cpf);
        try {
            // preparar a string para receber os valores de parametros
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            ps.execute();
            System.out.println("Pessoa deletada com sucesso");
            contas.remover(person.getConta().getNumeroConta());
            enderecos.remover(person.getEndereco().getId());
        } catch (SQLException ex) {
            System.out.println("Erro ao deletas pessoa do banco de dados " + ex.getMessage());
        } finally {
            conexao.fecharConexao(conn);
        }

    }

    @Override
    public void alterar(Pessoa pessoa) {
        Connection conn = conexao.getConnection();
        String sql = "UPDATE FROM PESSOA WHERE NOME = ?,SEXO ?,IDADE=?,ENDERECO_ID=?,NUMERO_CONTA=? WHERE CPF =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, pessoa.getNome());
            ps.setString(3, pessoa.getSexo());
            ps.setInt(4, pessoa.getIdade());
            ps.setInt(5, pessoa.getConta().getNumeroConta());
            ps.setInt(6, pessoa.getEndereco().getId());
            ps.executeUpdate();
            System.out.println("Conta atualizadacom sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar a conta " + ex.getMessage());
        } finally {
            conexao.fecharConexao(conn);
        }

    }

    @Override
    public Pessoa pesquisar(String cpf) {
        Connection conn = conexao.getConnection();
        Pessoa pessoa = new Pessoa();
        String sql = "SELECT FROM * PESSOA   WHERE CPF =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pessoa.setNome(rs.getString("NOME"));
                pessoa.setCpf(rs.getString("CPF"));
                pessoa.setSexo(rs.getString("SEXO"));
                pessoa.setIdade(rs.getInt("IDADE"));
                pessoa.setEndereco(this.enderecos.pesquisar(rs.getInt("ENDERECO_ID")));
                pessoa.setConta(this.contas.pesquisar(rs.getInt("NUMERO_CONTA")));

            }

        } catch (Exception ex) {
            System.out.println("Erro ao pesquisar conta");
        } finally {
            conexao.fecharConexao(conn);
        }
        return pessoa;
    }

    @Override
    public List<Pessoa> listarTodasPessoas() {
        Connection conn = conexao.getConnection();
        List<Pessoa> retorno = new ArrayList<Pessoa>();
        String sql = "SELECT * FROM CONTA ";
        try {
            // preparar a string para receber os valores de parametros
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(rs.getString("NOME"));
                pessoa.setSexo(rs.getString("SEXO"));
                pessoa.setIdade(rs.getInt("IDADE"));
                pessoa.setEndereco(this.enderecos.pesquisar(rs.getInt("ENDERECO_ID")));
                pessoa.setConta(this.contas.pesquisar(rs.getInt("NUMERO_CONTA")));
                retorno.add(pessoa);
            }

        } catch (Exception ex) {
            System.out.println("esta conta nao esta no banco de dados " + ex.getMessage());
        } finally {
            conexao.fecharConexao(conn);
        }
        return retorno;
    }

}
