import exception.SaldoInsuficienteException;

public class CartaoDebito extends Cartao {
    public CartaoDebito(Conta conta) {
        super(conta);
    }

    @Override
    public void pagarCompra(double valor,String estabelecimento) throws SaldoInsuficienteException {
        this.conta.sacar(valor);
        super.imprimirComprovante(valor, estabelecimento);
    }

    @Override
    public void imprimirInformacoesCartao() {
        System.out.println("\n");
        System.out.println("===================== Informações do Cartão de Débito =====================");

        System.out.println("===================== Informações do Cartão de Débito =====================");
        System.out.println("\n");
    }
}
