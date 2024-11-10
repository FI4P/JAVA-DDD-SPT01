package com.redeancora.models;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;


public class Cotacao {
    private List<Produto> listaProdutosCotacao;

    public Cotacao(){
        this.listaProdutosCotacao = new ArrayList<>();
    }

    public List<Produto> getListaProdutosCotacao() {
        return listaProdutosCotacao;
    }

    public void adicionarProdutoCotacao(Produto produto) {
        listaProdutosCotacao.add(produto);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Produto produto : listaProdutosCotacao) {
            total += produto.getPreco();
        }
        return total;
    }


    public void gerarResumoCotacao() {
        System.out.println("Resumo da Cotação:");
        for (Produto produto : listaProdutosCotacao) {
            System.out.println(produto.getNome() + " - R$" + produto.getPreco());
        }
        System.out.println("Valor Total: R$" + calcularValorTotal());
    }

}
