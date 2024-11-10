package com.redeancora.models;

import java.util.List;
import java.util.UUID;

public class Pedido {
    private String idPedido;
    private Mecanico mecanico;
    private List<Produto> listaProdutos;
    private String status;
    private double valorTotal;
    private Pagamento pagamento;  // Agora o Pedido contém um objeto Pagamento

    public Pedido(Mecanico mecanico, List<Produto> listaProdutos) {
        this.idPedido = geraPedidoId();
        this.mecanico = mecanico;
        this.listaProdutos = listaProdutos;
        this.valorTotal = calcularValorTotal();
        this.status = "Aguardando pagamento";
        this.pagamento = null;
    }

    // Getters e Setters
    public String getIdPedido() { return idPedido; }
    public Mecanico getMecanico() { return mecanico; }
    public List<Produto> getListaProdutos() { return listaProdutos; }
    public String getStatus() { return status; }
    public double getValorTotal() { return valorTotal; }
    public Pagamento getPagamento() { return pagamento; }

    public void setStatus(String status) { this.status = status; }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    private double calcularValorTotal() {
        double total = 0;
        for (Produto produto : listaProdutos) {
            total += produto.getPreco();
        }
        return total;
    }

    public static String geraPedidoId(){
        String id = UUID.randomUUID().toString();
        return id.replaceAll("-", "").substring(0, 25);
    }

    public void processarPagamento(String metodoPagamento) {
        this.pagamento = new Pagamento(metodoPagamento);
        this.pagamento.processarPagamento();
        setStatus("Em separação");
    }
}
