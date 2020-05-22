package model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Show implements Serializable {
    private String nome;
    private String local;
    private String imagem;
    private BigDecimal preco;
    private String data;
    private String dia;


    public Show(String nome, String local, String imagem, BigDecimal preco, String data, String dia) {
        this.nome = nome;
        this.local = local;
        this.imagem = imagem;
        this.preco = preco;
        this.data = data;
        this.dia = dia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getLocal() {
        return local;
    }

    public String getImagem() {
        return imagem;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getData() {
        return data;
    }

    public String getDia() {
        return dia;
    }
}
