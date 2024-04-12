import exception.LimiteCartaoExcedidoException;
import exception.SaldoInsuficienteException;

public interface ICartao {
    void pagarCompra(double valorCompra,String estabelecimento) throws SaldoInsuficienteException, LimiteCartaoExcedidoException;
    void imprimirComprovante(double valorCompra, String nomeEstabelecimento);
    void imprimirInformacoesCartao();
}
