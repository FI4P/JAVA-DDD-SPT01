package com.redeancora.services;

import com.redeancora.models.Pagamento;
import com.redeancora.models.Pedido;

public class PagamentoService {

    public Pagamento processarPagamento (Pedido pedido, String metodoPagamento){

        Pagamento pagamento = new Pagamento(metodoPagamento);
        pagamento.processarPagamento();
        pedido.setPagamento(pagamento);
        System.out.println("Pagamento processado para o pedido #" + pedido.getIdPedido());

        return pagamento;

    }

    public String verificarStatusPagamento (Pedido pedido){
        if(pedido.getPagamento() != null){
            return pedido.getPagamento().getStatusPagamento();
        }else{
            return "Pagamento não efetuado";
        }
    }

    public void emitirRecibo(Pedido pedido) {
        if (pedido.getPagamento() != null && "Pago".equals(pedido.getPagamento().getStatusPagamento())) {
            System.out.println("Recibo do Pedido #" + pedido.getIdPedido());
            System.out.println("Valor Total: R$ " + pedido.getValorTotal());
            System.out.println("Status do Pagamento: " + pedido.getPagamento().getStatusPagamento());
        } else {
            System.out.println("Pagamento não concluído para o pedido #" + pedido.getIdPedido());
        }
    }

}
