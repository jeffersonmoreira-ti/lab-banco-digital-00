import exception.LimiteCartaoExcedidoException;
import exception.SaldoInsuficienteException;

public class Main {

    public static void main(String[] args) {
        Cliente jeff = new Cliente();
        jeff.setNome("Jeff");

        Conta cc = new ContaCorrente(jeff, 1000);
        Conta poupanca = new ContaPoupanca(jeff);

        CartaoCredito cartaoCredito = new CartaoCredito(cc, 1000);
        Cartao cartaoDebito = new CartaoDebito(cc);

        cc.depositar(100);
        cc.imprimirExtrato();
        try {
            cc.transferir(500, poupanca);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        try {
            cartaoCredito.pagarCompra(5000, "Mercadinho do Valter");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Não foi possível realizar o pagamento. Motivo: " + e.getMessage());
        } catch (LimiteCartaoExcedidoException e) {
            System.out.println("Não foi possível realizar o pagamento. Motivo: " + e.getMessage());
        }

        try {
            cartaoCredito.pagarCompra(50, "Mercadinho do Valter");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Não foi possível realizar o pagamento. Motivo: " + e.getMessage());
        } catch (LimiteCartaoExcedidoException e) {
            System.out.println("Não foi possível realizar o pagamento. Motivo: " + e.getMessage());
        }

        try {
            cartaoDebito.pagarCompra(12, "Empadinhas Só Sucesso");
        } catch (SaldoInsuficienteException | LimiteCartaoExcedidoException e) {
            System.out.println("Não foi possível realizar o pagamento. Motivo: " + e.getMessage());
        }

        cartaoCredito.imprimirInformacoesCartao();

        cartaoCredito.pagarFatura(1000);

        cartaoCredito.imprimirInformacoesCartao();
    }

}
