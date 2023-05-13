package dao;

import java.util.List;

import model.Endereco;

public interface EnderecoDao {
    

    public void salvar(Endereco endereco);
    public void remover(Endereco endereco);
    public void alterar(Endereco endereco);
    public Endereco pesquisar(int id );
    public List<Endereco>listarTodosEndereco();
    



}
