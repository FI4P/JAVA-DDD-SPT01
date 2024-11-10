package com.redeancora.services;

import com.redeancora.models.Cotacao;
import com.redeancora.models.Mecanico;
import com.redeancora.models.Produto;
import java.util.List;

public class CotacaoService {

    public Cotacao criarCotacao(List<Produto> produtos, Mecanico mecanico) {
        Cotacao cotacao = new Cotacao();
        for (Produto produto : produtos) {
            cotacao.adicionarProdutoCotacao(produto);
        }
        mecanico.getHistorico().adicionarRegistroCotacao(cotacao);

        return cotacao;
    }

    public double calcularValorTotal(Cotacao cotacao) {
        return cotacao.calcularValorTotal();
    }

    public void adicionarProdutoNaCotacao(Cotacao cotacao, Produto produto) {
        cotacao.adicionarProdutoCotacao(produto);
    }

    public void removerProdutoDaCotacao(Cotacao cotacao, Produto produto) {
        cotacao.getListaProdutosCotacao().remove(produto);
    }
}
