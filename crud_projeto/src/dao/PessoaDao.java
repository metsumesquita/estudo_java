package dao;



import java.util.List;

import model.Pessoa;
public interface PessoaDao {
  
  
    public void salvar(Pessoa pessoa);
    public void remover(Pessoa pessoa);
    public void alterar( Pessoa pessoa);
    public Pessoa pesquisar(String cpf);
    public List<Pessoa>listarTodasPessoas();
}