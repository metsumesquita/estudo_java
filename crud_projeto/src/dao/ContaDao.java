package dao;

import java.util.List;
import model.Contas;

public interface ContaDao {

    public void salvar(Contas conta);

    public void remover(int numero);

    public void alterar(Contas conta);

    public Contas pesquisar(int numero);

    public List<Contas> listarTodasContas();

}
