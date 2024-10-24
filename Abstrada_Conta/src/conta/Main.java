package conta;

// Classe Main
public class Main {
    public static void main(String[] args) {
        // Criando uma Conta Corrente com saldo inicial de 700 e limite de 150
        ContaCorrente cc = new ContaCorrente(700, 150);
        System.out.println("Conta Corrente:");
        cc.consulta();

        // Tentando sacar 600 (dentro do limite)
        cc.saque(600);  
        cc.consulta();

        // Depositando 100 na conta corrente
        cc.deposito(100);
        cc.consulta();

        System.out.println();

        // Criando uma Conta Poupança com saldo inicial de 300
        ContaPoupanca cp = new ContaPoupanca(300);
        System.out.println("Conta Poupança:");
        cp.consulta();

        // Tentando sacar 350 (maior que o saldo, não permitido)
        cp.saque(350);  

        // Tentando sacar 100 (permitido)
        cp.saque(100);  
        cp.consulta();

        // Depositando 50 na conta poupança
        cp.deposito(50);
        cp.consulta();
    }
}
