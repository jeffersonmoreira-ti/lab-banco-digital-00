package exception;

public class LimiteEspecialExcedidoException extends Throwable {
    @Override
    public String getMessage(){
        return "Limite Especial Excedido.";
    }
}
