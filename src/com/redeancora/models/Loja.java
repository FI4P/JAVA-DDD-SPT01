package com.redeancora.models;

import java.util.ArrayList;
import java.util.List;

public class Loja {

    private String nome;
    private String descricao;
    private String localizacao;
    private List<Produto> listaProdutos;

    public  Loja(String nome, String descricao, String localizacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.listaProdutos = new ArrayList<Produto>();

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }


}
