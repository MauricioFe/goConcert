package model;

import java.math.BigDecimal;

public class Show {
    private final String nome;
    private final String local;
    private final String imagem;
    private final BigDecimal preco;
    private final String data;
    private final String dia;


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
