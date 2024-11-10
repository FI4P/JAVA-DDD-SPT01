package com.redeancora.models;

import java.util.ArrayList;
import java.util.List;

public class Historico {
    private List<Cotacao> listaCotacoes;
    private List<Pedido> listaPedidos;

    public Historico() {
        this.listaCotacoes = new ArrayList<>();
        this.listaPedidos = new ArrayList<>();
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public List<Cotacao> getListaCotacoes() {
        return listaCotacoes;
    }

    public void adicionarRegistroCotacao(Cotacao cotacao) {
        listaCotacoes.add(cotacao);
    }

    public void adicionarRegistroPedido(Pedido pedido) {
        listaPedidos.add(pedido);
    }

    public void consultarHistoricoCotacoes() {
        System.out.println("Histórico de Cotações:");
        listaCotacoes.forEach(Cotacao::gerarResumoCotacao);
    }

    public void consultarHistoricoPedidos() {
        System.out.println("Historico de Pedidos:");
        listaPedidos.forEach(pedido -> System.out.println("Pedido #" + pedido.getIdPedido() + " - Valor Total: R$" + pedido.getValorTotal()));
    }
}

