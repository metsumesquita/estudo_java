
package model;

public class Pessoa {

    private String nome;

    private String cpf;
    private char sexo;
    private Endereco endereco;
    private Contas conta;

    
    
    public Pessoa(String nome, String cpf, char sexo, Endereco endereco, Contas conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.endereco = endereco;
        this.conta = conta;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Contas getConta() {
        return conta;
    }
    public void setConta(Contas conta) {
        this.conta = conta;
    }

}
