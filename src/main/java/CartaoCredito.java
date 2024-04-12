import exception.LimiteCartaoExcedidoException;
import exception.SaldoInsuficienteException;
import lombok.Getter;


public class CartaoCredito extends Cartao {
    private double limite;
    private double saldoLimite;
    private double valorFatura;

    public CartaoCredito(Conta conta, double limite) {
        super(conta);
        this.limite = limite;
        this.saldoLimite = limite;
    }

    public void pagarFatura(double valorPago) {
        this.valorFatura -= valorPago;
    }


    @Override
    public void imprimirInformacoesCartao() {
        System.out.println("\n");
        System.out.println("===================== Informações do Cartão de Crédito =====================");
        System.out.printf("Limite Total do Cartão: %.2f%n", this.limite);
        System.out.printf("Limite Disponível do Cartão: %.2f%n", this.saldoLimite);
        System.out.printf("Total da Fatura do Cartão: %.2f%n", this.valorFatura);
        if (this.valorFatura < 0) {
            System.out.printf("O valor de %.2f será abatido na próxima fatura.%n", Math.abs(this.valorFatura));
        }

        System.out.println("=============================================================================");
        System.out.println("\n");
    }

    @Override
    public void pagarCompra(double valorCompra, String estabelecimento) throws SaldoInsuficienteException, LimiteCartaoExcedidoException {
        if (valorCompra <= this.saldoLimite) {

            atualizarLimiteCartao(valorCompra);
            atualizarValorFatura(valorCompra);
            imprimirComprovante(valorCompra, estabelecimento);
            imprimirInformacoesCartao();
        } else {
            throw new LimiteCartaoExcedidoException();
        }
    }

    private void atualizarLimiteCartao(double valor) throws LimiteCartaoExcedidoException {
        if (this.saldoLimite >= valor) {
            this.saldoLimite -= valor;
        } else {
            throw new LimiteCartaoExcedidoException();
        }
    }

    private void atualizarValorFatura(double valorCompra) {
        this.valorFatura += valorCompra;
    }

}

