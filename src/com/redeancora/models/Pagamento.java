package com.redeancora.models;

public class Pagamento {
    private String metodoPagamento;
    private String statusPagamento;

    public Pagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
        this.statusPagamento = "Pendente";
    }

    // Getters e Setters
    public String getMetodoPagamento() { return metodoPagamento; }
    public String getStatusPagamento() { return statusPagamento; }

    public void processarPagamento() {
        this.statusPagamento = "Pago";
        System.out.println("Pagamento realizado com sucesso pelo método: " + metodoPagamento);
    }
}
