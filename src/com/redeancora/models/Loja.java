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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public void adicionarProduto(Produto produto) {
        this.listaProdutos.add(produto);
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void listarProdutos() {
        System.out.println("\nProdutos disponíveis na loja " + nome + ":");
        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto produto = listaProdutos.get(i);
            System.out.println((i + 1) + ". " + produto.getNome() + " - R$" + produto.getPreco());
        }
    }


}
