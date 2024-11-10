package com.redeancora.services;

import com.redeancora.models.Mecanico;
import com.redeancora.models.Pedido;
import com.redeancora.models.Produto;

import java.util.List;

public class PedidoService {

    public Pedido criarPedido(Mecanico mecanico, List<Produto> produtos){
        Pedido pedido = new Pedido(mecanico, produtos);
        mecanico.getHistorico().adicionarRegistroPedido(pedido);
        return pedido;
    }

    public Pedido atualizarPedido(Pedido pedido, String status){
        pedido.setStatus(status);
        return pedido;
    }

    public double calcularFrete(Pedido pedido, double distancia) {
        return distancia * 5;
    }

    public void finalizarPedido(Pedido pedido) {
        pedido.setStatus("Finalizado");
        System.out.println("Pedido #" + pedido.getIdPedido() + " finalizado com sucesso.");
    }







}