package model;
public class Endereco {

    private int id;
    private String nomeRua;
    private Integer numeroRua;
    private String completo;

    public Endereco(int id, String nomeRua, Integer numeroRua, String completo) {
        this.id = id;
        this.nomeRua = nomeRua;
        this.numeroRua = numeroRua;
        this.completo = completo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public Integer getNumeroRua() {
        return numeroRua;
    }

    public void setNumeroRua(Integer numeroRua) {
        this.numeroRua = numeroRua;
    }

    public String getCompleto() {
        return completo;
    }

    public void setCompleto(String completo) {
        this.completo = completo;
    }


}