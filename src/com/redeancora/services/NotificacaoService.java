package com.redeancora.services;

import com.redeancora.models.Notificacao;
import com.redeancora.models.Mecanico;

public class NotificacaoService {

    public void enviarNotificacao(Notificacao notificacao) {
        System.out.println("Enviando notificação para " + notificacao.getDestinatario().getNome() + ": " + notificacao.getMensagem());
    }

    public void notificarAtualizacaoPedido(Mecanico mecanico, String mensagem) {
        Notificacao notificacao = new Notificacao("Status do Pedido", mensagem, mecanico);
        enviarNotificacao(notificacao);
    }

    public void notificarSaldoFidelidade(Mecanico mecanico) {
        String mensagem = "Seu saldo de pontos de fidelidade é: " + mecanico.getProgramaFidelidade().getSaldoPontos();
        Notificacao notificacao = new Notificacao("Saldo Fidelidade", mensagem, mecanico);
        enviarNotificacao(notificacao);
    }
}
