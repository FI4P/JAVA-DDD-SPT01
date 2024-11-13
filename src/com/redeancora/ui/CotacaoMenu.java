package com.redeancora.ui;

import com.redeancora.models.Cotacao;
import com.redeancora.models.Loja;
import com.redeancora.models.Mecanico;
import com.redeancora.models.Produto;
import com.redeancora.services.CotacaoService;

import java.util.Scanner;

public class CotacaoMenu {
    private Loja loja;
    private CotacaoService cotacaoService;
    private Mecanico mecanico;

    public CotacaoMenu(Loja loja, Mecanico mecanico, CotacaoService cotacaoService) {
        this.loja = loja;
        this.mecanico = mecanico;
        this.cotacaoService = cotacaoService;
    }

    public void exibirMenu(Scanner scanner) {
        System.out.println("\n===== Criando Cotação =====");
        Cotacao cotacao = new Cotacao();

        while (true) {
            System.out.println("Selecione um produto para adicionar à cotação:");
            loja.listarProdutos();
            System.out.print("Digite o código do produto ou 0 para finalizar: ");
            int produtoEscolhido = scanner.nextInt();
            scanner.nextLine();

            if (produtoEscolhido == 0) break;

            Produto produto = loja.getListaProdutos().get(produtoEscolhido - 1);
            cotacaoService.adicionarProdutoNaCotacao(cotacao, produto);
            System.out.println("Produto adicionado: " + produto.getNome());
        }

        double total = cotacaoService.calcularValorTotal(cotacao);
        System.out.println("Cotação criada com sucesso. Valor total: R$ " + total);
    }

}
