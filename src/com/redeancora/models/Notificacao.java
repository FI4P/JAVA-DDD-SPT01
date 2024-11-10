package com.redeancora.models;

import java.util.Date;

public class Notificacao {
    private String tipoNotificacao;
    private String mensagem;
    private Date dataEnvio;
    private Mecanico destinatario;


    public Notificacao(String tipoNotificacao, String mensagem, Mecanico destinatario) {
        this.tipoNotificacao = tipoNotificacao;
        this.mensagem = mensagem;
        this.dataEnvio = new Date();
        this.destinatario = destinatario;
    }

    // Getters e Setters
    public String getTipoNotificacao() { return tipoNotificacao; }
    public void setTipoNotificacao(String tipoNotificacao) { this.tipoNotificacao = tipoNotificacao; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public Date getDataEnvio() { return dataEnvio; }
    public void setDataEnvio(Date dataEnvio) { this.dataEnvio = dataEnvio; }

    public Mecanico getDestinatario() { return destinatario; }
    public void setDestinatario(Mecanico destinatario) { this.destinatario = destinatario; }

    public void enviarNotificacao() {
        System.out.println("Enviando notificação para: " + destinatario.getNome());
        System.out.println("Tipo: " + tipoNotificacao);
        System.out.println("Mensagem: " + mensagem);
        System.out.println("Data de Envio: " + dataEnvio);
    }

    public void exibirNotificacao() {
        System.out.println("Notificação recebida:");
        System.out.println("Tipo: " + tipoNotificacao);
        System.out.println("Mensagem: " + mensagem);
        System.out.println("Data de Envio: " + dataEnvio);
    }
}
