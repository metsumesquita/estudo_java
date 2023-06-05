package dao.implementacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import dao.EnderecoDao;
import model.Endereco;
import model.util.Conectar;

public class EnderecoDaoImpl implements EnderecoDao {
    Conectar conexao;

    public EnderecoDaoImpl(Conectar conexao) {
        super();
        this.conexao = conexao;
    }

    @Override
    public Integer salvar(Endereco endereco) {
        Connection conn = conexao.getConnection();
        Integer id = null;
        String sql = "INSERT INTO ENDERECO (RUA,NUMERO,COMPLEMENTO)" + "VALUES (?,?,?)";
        try {
            // preparar a string para receber os valores de parametros
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, endereco.getNomeRua());
            ps.setInt(2, endereco.getNumeroRua());
            ps.setString(3, endereco.getCompleto());
            ps.execute();
            System.out.println("Endereco inserida com sucesso");
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(4);
                System.out.println("id inserido foi " + id);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Endereco no banco " + ex.getMessage());
        } finally {
            conexao.fecharConexao(conn);
        }
        return id;
    }

    @Override
    public void remover(int id) {

        Connection conn = conexao.getConnection();
        String sql = "DELETE FROM ENDERECO WHERE  ID_ENDECO = ?";
        try {
            // preparar a string para receber os valores de parametros
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(4, id);
            ps.execute();
            System.out.println("Endereco deletado com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao remover o endereco  " + ex.getMessage());
        } finally {
            conexao.fecharConexao(conn);
        }
    }

    @Override
    public void alterar(Endereco endereco) {

        Connection conn = conexao.getConnection();
        String sql = "ALTER FROM ENDERECO WHERE ID_ENDECO = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(2, endereco.getNomeRua());
            ps.setInt(3, endereco.getNumeroRua());
            ps.setString(4, endereco.getCompleto());

            ps.executeUpdate();
            System.out.println("Conta atualizadacom sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar a conta " + ex.getMessage());
        } finally {
            conexao.fecharConexao(conn);
        }
    }

    @Override
    public Endereco pesquisar(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pesquisar'");
    }

    @Override
    public List<Endereco> listarTodosEndereco() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodosEndereco'");
    }

}