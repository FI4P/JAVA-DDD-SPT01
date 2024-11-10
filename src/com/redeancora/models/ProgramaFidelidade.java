package com.redeancora.models;

public class ProgramaFidelidade {
    private int saldoPontos;

    public ProgramaFidelidade() {
        this.saldoPontos = 0;
    }

    public int getSaldoPontos() { return saldoPontos; }

    public void adicionarPontos(int pontos) {
        this.saldoPontos += pontos;
    }

    public void resgatarPontos(int pontos) {
        if (saldoPontos >= pontos) {
            saldoPontos -= pontos;
            System.out.println("Resgate realizado com sucesso.");
        } else {
            System.out.println("Pontos insuficientes.");
        }
    }
}
