package com.redeancora.models;

public class Mecanico {
    private String nome;
    private String cpf;
    private String telefone;
    private ProgramaFidelidade programaFidelidade;  // Relacionamento direto com ProgramaFidelidade
    private Historico historico;

    public Mecanico(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.programaFidelidade = new ProgramaFidelidade();
        this.historico = new Historico();
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getTelefone() { return telefone; }
    public ProgramaFidelidade getProgramaFidelidade() { return programaFidelidade; }
    public Historico getHistorico() { return historico; }

    public void verificarPontuacaoFidelidade() {
        System.out.println("Pontos de fidelidade: " + programaFidelidade.getSaldoPontos());
    }

    public void consultarHistoricoPedidos() {
        historico.consultarHistoricoPedidos();
    }

    public void consultarHistoricoCotacoes() {
        historico.consultarHistoricoCotacoes();
    }
}
