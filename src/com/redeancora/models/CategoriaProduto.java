package com.redeancora.models;

import java.util.List;
import java.util.ArrayList;

public class CategoriaProduto {
    private String nome;
    private String descricao;
    private List<Produto> listaProdutos;


    public CategoriaProduto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.listaProdutos = new ArrayList<Produto>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

}

