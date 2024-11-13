package com.redeancora.ui;

import com.redeancora.models.Loja;
import com.redeancora.models.Mecanico;
import com.redeancora.models.Pagamento;
import com.redeancora.services.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Scanner;

public class MainMenu {

    private List<Loja> lojas;
    private Mecanico mecanico;
    private CotacaoService cotacaoService;
    private PedidoService pedidoService;
    private ProgramaFidelidadeService programaFidelidadeService;
    private NotificacaoService notificacaoService;
    private PagamentoService pagamentoService;
    private HistoricoService historicoService;

    public MainMenu(List<Loja> lojas, Mecanico mecanico
    , CotacaoService cotacaoService, PedidoService pedidoService, ProgramaFidelidadeService programaFidelidadeService
    , NotificacaoService notificacaoService, PagamentoService pagamentoService, HistoricoService historicoService) {
        this.lojas = lojas;
        this.mecanico = mecanico;
        this.cotacaoService = cotacaoService;
        this.pedidoService = pedidoService;
        this.programaFidelidadeService = programaFidelidadeService;
        this.notificacaoService = notificacaoService;
        this.pagamentoService = pagamentoService;
        this.historicoService = historicoService;
    }

    public void exibirMenu(@NotNull Scanner scanner) {
        while (true) {
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1. Selecionar Loja");
            System.out.println("2. Verificar Pontos de Fidelidade");
            System.out.println("3. Verificar Historico de pedidos e cotacoes");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    selecionarLoja(scanner);
                    break;
                case 2:
                    System.out.println("Saldo de pontos de fidelidade: " + programaFidelidadeService.consultarSaldo(mecanico));
                    break;
                case 3:
                    HistoricoMenu historicoMenu = new HistoricoMenu(lojas, cotacaoService, mecanico, pedidoService, programaFidelidadeService, notificacaoService, pagamentoService,historicoService);
                    historicoMenu.exibirMenu(scanner);
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void selecionarLoja(Scanner scanner) {
        System.out.println("\n===== Lojas Disponíveis =====");
        for (int i = 0; i < lojas.size(); i++) {
            System.out.println((i + 1) + ". " + lojas.get(i).getNome() + " - " + lojas.get(i).getLocalizacao());
        }
        System.out.print("Selecione uma loja: ");
        int escolhaLoja = scanner.nextInt();
        scanner.nextLine();

        if (escolhaLoja < 1 || escolhaLoja > lojas.size()) {
            System.out.println("Loja inválida.");
            return;
        }

        Loja lojaSelecionada = lojas.get(escolhaLoja - 1);
        LojaMenu lojaMenu = new LojaMenu(lojaSelecionada, cotacaoService, pedidoService, programaFidelidadeService, notificacaoService, pagamentoService, mecanico);
        lojaMenu.exibirMenu(scanner);
    }
}
