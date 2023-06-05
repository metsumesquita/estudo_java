package controller;

import java.sql.Connection;

import dao.ContaDao;
import dao.implementacao.ContaDaoImpl;
import model.Contas;
import model.util.Conectar;

public class Principal {
    public static void main(String[] args) {
        Conectar conexao = new Conectar();
        // Connection conn =conexao.getConnection();
        // Contas conta = new Contas();

        // conta.setNumeroConta(1001);
        // conta.setSaldo(4000d);
        // conta.setLimite(30000d);
        ContaDao contaDao = new ContaDaoImpl(conexao);
        // contaDao.salvar(conta);
        Contas contaS = contaDao.pesquisar(1001);
        System.out.println(contaS.toString());

    }
}
