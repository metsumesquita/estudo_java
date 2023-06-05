package model;

public class Contas {
    private int numeroConta;
    private Double saldo;
    private Double limite;

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(double d) {
        this.saldo = d;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "Contas [numeroConta=" + numeroConta + ", saldo=" + saldo + ", limite=" + limite + "]";
    }

}
