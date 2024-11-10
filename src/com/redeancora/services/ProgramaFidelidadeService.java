package com.redeancora.services;

import com.redeancora.models.Mecanico;
import org.jetbrains.annotations.NotNull;

public class ProgramaFidelidadeService {

    public void adicionarPontosFidelidade(@NotNull Mecanico mecanico, int pontosFidelidade) {
        mecanico.getProgramaFidelidade().adicionarPontos(pontosFidelidade);
    }

    public int consultarSaldo(@NotNull Mecanico mecanico) {
        return mecanico.getProgramaFidelidade().getSaldoPontos();
    }

    public void resgatarPontos(@NotNull Mecanico mecanico, int pontos) {
        mecanico.getProgramaFidelidade().resgatarPontos(pontos);
    }
}
