package Banco;
import java.util.Random;
public class ContaBancaria {
	private double CPMF;
	private String senha;
	private static int ultimoNumeroConta = 1000; // Último número de conta utilizado
	private String correntista; // nome do correntista
	private int numeroConta; // número da conta
	private double saldo; // saldo da conta
	public ContaBancaria(String correntista, double saldo) {
	ultimoNumeroConta++;
	this.numeroConta = ultimoNumeroConta;
	this.saldo = saldo;
	this.correntista = correntista;
	this.gerarSenha(9);
	this.CPMF = 0;
	}
	public void depositar(double valor) {
		this.saldo = this.saldo + valor;
		}
	public void sacar(double valor) {
		double desconto = valor * 0.0025;
		this.saldo = this.saldo - valor;
		this.CPMF = desconto;
		
		}
		public void transferir(double valor, ContaBancaria contaDestino) {
		// instruções do método a ser desenvolvido
			contaDestino.depositar(valor);
			this.sacar(valor);
			
			
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
		
		public  void addSaldo(double valor) {
			this.saldo = saldo+valor;
		}
	
	private void gerarSenha(int tamanho) {
		Random r = new Random();
		String novaSenha = "";
		int i = 0;
		while(i < tamanho) {
			Integer nextInt = r.nextInt();
			senha = senha + nextInt.toString();
			i = i + 1;
		}
		this.senha = novaSenha;
	}
	
	public void trocarSenha(String novaSenha) {
		this.senha = novaSenha;
	}
	
	public String getSenha() {
		return this.senha;
	}
	public double getCPMF() {
		return this.CPMF;
	}
	
}


	



