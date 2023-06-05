
package model;


public class Pessoa {

    private String nome;

    private String cpf;
    private String sexo;
    private Endereco endereco;
    private Contas conta;

    private int idade;
    
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public Pessoa(String nome, String cpf, String sexo,int idade, Endereco endereco, Contas conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.endereco = endereco;
        this.conta = conta;
        this.idade= idade;
    }
    public Pessoa() {
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
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
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
