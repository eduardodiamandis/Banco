package Banco;

import java.util.Random;

public class ContaBancaria {
    private static int ultimoNumeroConta = 1000; // Último número de conta utilizado
    private String correntista; // nome do correntista
    private int numeroConta; // número da conta
    private double saldo; // saldo da conta
	private double CPMF;
	private String senha;

    public ContaBancaria(String correntista, double saldo) {
        ultimoNumeroConta++;
        this.numeroConta = ultimoNumeroConta;
        this.saldo = saldo;
        this.correntista = correntista;
        this.criarSenha();
        this.CPMF = 0;
    }

    public void depositar(double valor) {
        this.saldo = this.saldo + valor;
    }

    public void sacar(double valor) {
        // 0.25% é igual a 0.0025
        double cpmfDoSaque = valor * 0.0025;
        double valorRealSacado = valor * (1 - 0.0025);
        // talvez esse método pudesse, em outra interpretação, retornar o valor real sacado, já com dedução de impostos
        this.saldo = this.saldo - valor;
        this.CPMF = this.CPMF + cpmfDoSaque;
    }

    public void transferir(double valor, ContaBancaria contaDestino) {
        // instruções do método a ser desenvolvido
        contaDestino.depositar(valor);
        this.removerValor(valor);
        // como trata-se de uma trasferência e não de um saque, entendo que o imposto CPMF não é cobrado aqui
    }

	private void criarSenha() {
		Random r = new Random();
		String novaSenha = "";
		int i = 0;
		while (i < 6) {
			Integer nextInt = r.nextInt(10);
			senha = senha + nextInt.toString();
			i = i + 1;
		}
		this.senha = novaSenha;
	}

    public double getSaldo() {
        return this.saldo;
    }

    public int getNumeroConta() {
        return this.numeroConta;
    }

    public String toString() {
        return "Conta de " + this.correntista + " - Saldo de R$ " + this.saldo;
    }
    public String getSenha() {
        return this.senha;
    }

    public double getCPMF() {
        return this.CPMF;
    }

    private void removerValor(double valor) {
        this.saldo = this.saldo - valor;
    }

}


	



