package com.redeancora.ui;

import com.redeancora.models.Loja;
import com.redeancora.models.Mecanico;
import com.redeancora.services.*;

import java.util.List;
import java.util.Scanner;

public class HistoricoMenu {
    private List<Loja> lojas;
    private Mecanico mecanico;
    private CotacaoService cotacaoService;
    private PedidoService pedidoService;
    private ProgramaFidelidadeService programaFidelidadeService;
    private NotificacaoService notificacaoService;
    private PagamentoService pagamentoService;
    private HistoricoService historicoService;
    private MainMenu mainMenu;

    public HistoricoMenu(List<Loja> lojas, CotacaoService cotacaoService, Mecanico mecanico, PedidoService pedidoService, ProgramaFidelidadeService programaFidelidadeService, NotificacaoService notificacaoService, PagamentoService pagamentoService, HistoricoService historicoService) {
        this.lojas = lojas;
        this.cotacaoService = cotacaoService;
        this.mecanico = mecanico;
        this.pedidoService = pedidoService;
        this.programaFidelidadeService = programaFidelidadeService;
        this.notificacaoService = notificacaoService;
        this.pagamentoService = pagamentoService;
        this.historicoService = historicoService;
        this.mainMenu = new MainMenu(lojas, mecanico, cotacaoService, pedidoService, programaFidelidadeService,notificacaoService,pagamentoService, historicoService);
    }

    public void exibirMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n===== Menu de Histórico =====");
            System.out.println("1. Exibir Histórico de Cotações");
            System.out.println("2. Exibir Histórico de Pedidos");
            System.out.println("3. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    exibirHistoricoCotacoes();
                    break;
                case 2:
                    exibirHistoricoPedidos();
                    break;
                case 3:
                    mainMenu.exibirMenu(scanner);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Exibe o histórico de cotações
    private void exibirHistoricoCotacoes() {
        historicoService.obterHistoricoCotacoes(mecanico);

    }

    // Exibe o histórico de pedidos
    private void exibirHistoricoPedidos() {
        historicoService.obterHistoricoPedidos(mecanico);

    }
}
