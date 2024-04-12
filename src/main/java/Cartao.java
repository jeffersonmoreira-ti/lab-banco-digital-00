

public abstract class Cartao implements ICartao {
    protected Conta conta;
    protected int numero;
    private static int SEQUENCIAL = 1;

    public Cartao(Conta conta) {
        this.conta = conta;
        this.numero = SEQUENCIAL++;
    }

    public void imprimirComprovante(double valorCompra, String nomeEstabelecimento) {
        System.out.println("\n\n");
        System.out.println("========== Comprovante de Compra com Cartão ==========");
        System.out.printf("Estabelecimento: %s%n", nomeEstabelecimento);
        System.out.printf("Valor da Compra: %.2f%n", valorCompra);
        System.out.println("========== Fim da Impressão ==========");
        System.out.println("\n\n");
    }


}
