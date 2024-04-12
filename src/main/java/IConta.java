import exception.SaldoInsuficienteException;

public interface IConta {
	
	void sacar(double valor) throws SaldoInsuficienteException;
	
	void depositar(double valor);
	
	void transferir(double valor, IConta contaDestino);
	
	void imprimirExtrato();
}
