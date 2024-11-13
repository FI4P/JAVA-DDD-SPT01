package com.redeancora.ui;

import com.redeancora.models.Loja;

import com.redeancora.models.Mecanico;
import com.redeancora.models.Pedido;
import com.redeancora.models.Produto;
import com.redeancora.services.PagamentoService;
import com.redeancora.services.PedidoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidoMenu {

    private Loja loja;
    private PedidoService pedidoService;
    private PagamentoService pagamentoService;
    private Mecanico mecanico;

    public PedidoMenu(Loja loja, PedidoService pedidoService, PagamentoService pagamentoService, Mecanico mecanico) {
        this.loja = loja;
        this.pedidoService = pedidoService;
        this.pagamentoService = pagamentoService;
        this.mecanico = mecanico;
    }

    public void exibirMenu(Scanner scanner) {
        System.out.println("\n===== Criando Pedido =====");
        List<Produto> produtosPedido = new ArrayList<>();

        while (true) {
            System.out.println("Selecione um produto para adicionar ao pedido:");
            loja.listarProdutos();
            System.out.print("Digite o código do produto ou 0 para finalizar: ");
            int produtoEscolhido = scanner.nextInt();
            scanner.nextLine();

            if (produtoEscolhido == 0) break;

            Produto produto = loja.getListaProdutos().get(produtoEscolhido - 1);
            produtosPedido.add(produto);
            System.out.println("Produto adicionado: " + produto.getNome());
        }

        Pedido pedido = pedidoService.criarPedido(mecanico, produtosPedido);
        System.out.print("Digite o método de pagamento (ex.: Cartão, Boleto): ");
        String metodoPagamento = scanner.nextLine();

        pagamentoService.processarPagamento(pedido, metodoPagamento);
        pedidoService.finalizarPedido(pedido);
        mecanico.getProgramaFidelidade().adicionarPontos(10);

        System.out.println("Pedido criado e finalizado com sucesso!");
    }

}
