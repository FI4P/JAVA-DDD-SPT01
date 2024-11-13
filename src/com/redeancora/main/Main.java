package com.redeancora.main;

import com.redeancora.models.Loja;
import com.redeancora.models.Mecanico;
import com.redeancora.models.Pedido;
import com.redeancora.models.Produto;
import com.redeancora.services.*;
import com.redeancora.models.Cotacao;
import com.redeancora.ui.MainMenu;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Mecanico mecanico = new Mecanico("Enzo Rodrigues", "46040298812", "11963142692");
        List<Loja> lojas = inicializarLojas();

        CotacaoService cotacaoService = new CotacaoService();
        PedidoService pedidoService = new PedidoService();
        PagamentoService pagamentoService = new PagamentoService();
        ProgramaFidelidadeService programaFidelidadeService = new ProgramaFidelidadeService();
        NotificacaoService notificacaoService = new NotificacaoService();
        HistoricoService historicoService = new HistoricoService();

        MainMenu mainMenu = new MainMenu(lojas, mecanico, cotacaoService, pedidoService, programaFidelidadeService,notificacaoService,pagamentoService, historicoService);
        mainMenu.exibirMenu(scanner);
    }



    public static @NotNull List<Loja> inicializarLojas(){

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("001", "Filtro de Óleo", 30.0, null, 10));
        produtos.add(new Produto("002", "Pneu", 250.0, null, 15));
        produtos.add(new Produto("003", "Bateria", 500.0, null, 5));
        produtos.add(new Produto("004", "Pastilha de Freio", 120.0, null, 20));
        produtos.add(new Produto("005", "Amortecedor", 350.0, null, 8));
        produtos.add(new Produto("006", "Correia Dentada", 75.0, null, 25));
        produtos.add(new Produto("007", "Filtro de Ar", 40.0, null, 30));
        produtos.add(new Produto("008", "Velas de Ignição", 60.0, null, 18));
        produtos.add(new Produto("009", "Disco de Freio", 220.0, null, 10));
        produtos.add(new Produto("010", "Radiador", 450.0, null, 6));

        Loja loja01 = new Loja("Rede Ancora - SP", "Loja filial em São Paulo", "São Paulo");
        Loja loja02 = new Loja("Rede Ancora - RJ", "Loja filial no Rio de Janeiro", "Rio de Janeiro");
        Loja loja03 = new Loja("Rede Ancora - MG", "Loja filial em Minas Gerais", "Minas Gerais");

        loja01.setListaProdutos(produtos);
        loja02.setListaProdutos(produtos);
        loja02.setListaProdutos(produtos);

        List<Loja> lojas = new ArrayList<>();
        lojas.add(loja01);
        lojas.add(loja02);
        lojas.add(loja03);


        return lojas;




    }


}