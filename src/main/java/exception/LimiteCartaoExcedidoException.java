package exception;

public class LimiteCartaoExcedidoException extends Throwable {
    @Override
    public String getMessage(){
        return "Limite do Cartão Excedido.";
    }
}
