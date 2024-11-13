package com.redeancora.services;

import com.redeancora.models.Mecanico;

public class HistoricoService {

    public void obterHistoricoPedidos(Mecanico mecanico) {
        mecanico.getHistorico().consultarHistoricoPedidos();
    }


    public void obterHistoricoCotacoes(Mecanico mecanico) {
        mecanico.getHistorico().consultarHistoricoPedidos();
    }
}
