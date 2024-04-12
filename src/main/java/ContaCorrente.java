import exception.LimiteEspecialExcedidoException;
import exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta {

    private double limiteEspecial;
    private double saldoLimiteEspecial;

    public ContaCorrente(Cliente cliente, double limiteEspecial) {
        super(cliente);
        this.limiteEspecial = limiteEspecial;
        this.saldoLimiteEspecial = limiteEspecial;
    }


    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > (this.saldo + this.saldoLimiteEspecial)) throw new SaldoInsuficienteException();
        saldo -= valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        try {
            atualizarLimiteEspecial(valor);
            this.sacar(valor);
        } catch (SaldoInsuficienteException | LimiteEspecialExcedidoException e) {
            throw new RuntimeException(e);
        }
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
        System.out.println("Limite Especial: "+this.saldoLimiteEspecial);
    }

    private void atualizarLimiteEspecial(double valor) throws LimiteEspecialExcedidoException {
        if (saldoLimiteEspecial >= valor) {
            this.saldoLimiteEspecial -= valor;
        } else {
            throw new LimiteEspecialExcedidoException();
        }
    }

}
