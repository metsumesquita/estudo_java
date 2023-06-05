package dao;

import java.util.List;

import model.Endereco;

public interface EnderecoDao {

    public Integer salvar(Endereco endereco);

    public void remover(int numero_endereco);

    public void alterar(Endereco endereco);

    public Endereco pesquisar(int id);

    public List<Endereco> listarTodosEndereco();

}
