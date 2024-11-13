package com.redeancora.ui;

import com.redeancora.models.Loja;
import com.redeancora.models.Mecanico;
import com.redeancora.services.*;

import java.util.Scanner;

public class LojaMenu {
    private Loja loja;
    private Mecanico mecanico;
    private CotacaoService cotacaoService;
    private PedidoService pedidoService;
    private ProgramaFidelidadeService programaFidelidadeService;
    private NotificacaoService notificacaoService;
    private PagamentoService pagamentoService;

    public LojaMenu(Loja loja,
                    CotacaoService cotacaoService,
                    PedidoService pedidoService,
                    ProgramaFidelidadeService programaFidelidadeService,
                    NotificacaoService notificacaoService,
                    PagamentoService pagamentoService,
                    Mecanico mecanico) {

        this.loja = loja;
        this.cotacaoService = cotacaoService;
        this.pedidoService = pedidoService;
        this.programaFidelidadeService = programaFidelidadeService;
        this.notificacaoService = notificacaoService;
        this.pagamentoService = pagamentoService;
        this.mecanico = mecanico;

    }

    public void exibirMenu(Scanner scanner){
        while (true){
            System.out.println("\n===== Menu da Loja " + loja.getNome() + " =====");
            System.out.println("1. Criar Cotação");
            System.out.println("2. Fazer Pedido");
            System.out.println("3. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    CotacaoMenu cotacaoMenu = new CotacaoMenu(loja, mecanico, cotacaoService);
                    cotacaoMenu.exibirMenu(scanner);
                    break;
                case 2:
                    PedidoMenu pedidoMenu = new PedidoMenu(loja, pedidoService, pagamentoService, mecanico);
                    pedidoMenu.exibirMenu(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }
    }

}
