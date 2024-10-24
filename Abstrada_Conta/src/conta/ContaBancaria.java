package conta;

// Classe abstrata ContaBancaria
public abstract class ContaBancaria {
    public double saldo;

    // Métodos abstratos que as subclasses devem implementar
    public abstract void saque(double valor);
    public abstract void deposito(double valor);
    public abstract void consulta();

    // Construtor para iniciar o saldo
    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Getter para o saldo (caso precise ser acessado)
    public double getSaldo() {
        return saldo;
    }
}

// SubClasse ContaCorrente que herda de ContaBancaria
class ContaCorrente extends ContaBancaria {
    private double limite; // Limite após o saldo acabar
    private double TAXA_SAQUE = 2.0;  // Taxa de R$2 por saque
    private double TAXA_DEPOSITO = 1.0;  // Taxa de R$1 por depósito

    // Construtor que define o saldo inicial e o limite
    public ContaCorrente(double saldoInicial, double limite) {
        super(saldoInicial);
        this.limite = limite;
    }

    // Implementação do saque com taxa e limite
    @Override
    public void saque(double valor) {
        double valorComTaxa = valor + TAXA_SAQUE;
        if (saldo + limite >= valorComTaxa) {
            saldo -= valorComTaxa;
            System.out.println("Saque de R$" + valor + " realizado com sucesso. Taxa: R$" + TAXA_SAQUE);
        } else {
            System.out.println("Saque negado. Valor excede o saldo e o limite.");
        }
    }

    // Implementação do depósito com taxa
    @Override
    public void deposito(double valor) {
        saldo += valor - TAXA_DEPOSITO;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso. Taxa: R$" + TAXA_DEPOSITO);
    }

    // Consulta o saldo
    @Override
    public void consulta() {
        System.out.println("Saldo atual (Conta Corrente): R$" + saldo);
    }
}

// SubClasse ContaPoupanca que herda de ContaBancaria
class ContaPoupanca extends ContaBancaria {
    private double TAXA_SAQUE = 1.00;  // Taxa de R$0.50 por saque
    private double TAXA_DEPOSITO = 0.75;  // Taxa de R$0.25 por depósito

    // Construtor que define o saldo inicial
    public ContaPoupanca(double saldoInicial) {
        super(saldoInicial);
    }

    // Implementação do saque com restrição de não permitir saques maiores que o saldo
    @Override
    public void saque(double valor) {
        double valorComTaxa = valor + TAXA_SAQUE;
        if (saldo >= valorComTaxa) {
            saldo -= valorComTaxa;
            System.out.println("Saque de R$" + valor + " realizado. Taxa: R$" + TAXA_SAQUE);
        } else {
            System.out.println("Saque negado. Saldo insuficiente.");
        }
    }

    // Implementação do depósito com taxa
    @Override
    public void deposito(double valor) {
        saldo += valor - TAXA_DEPOSITO;
        System.out.println("Depósito de R$" + valor + " realizado. Taxa: R$" + TAXA_DEPOSITO);
    }

    // Consulta o saldo
    @Override
    public void consulta() {
        System.out.println("Saldo atual (Conta Poupança): R$" + saldo);
    }
}
