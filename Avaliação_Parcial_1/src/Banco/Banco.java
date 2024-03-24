/*
 * Nome dos alunos & Ra:
 * Eduardo Diamandis		2203426
 * Breno Fachini			1900617
 * Lucas Alves Mota Folli	2203210

 */
package Banco;
import java.util.Scanner;
public class Banco {
	public static Scanner entrada;
	public static void mostrarInfo(ContaBancaria[] contas) {
	System.out.println("\nContas de todos os clientes:");
	for (int i = 0; i < contas.length; i++) {
	System.out.println("[" + i + "]" + contas[i].toString());
	}
	System.out.println("");}


public static void interacaoSacar(ContaBancaria[] contas) { 
	boolean clienteValido = false; 
	int indiceConta = -1; 
	while (!clienteValido) { 
	mostrarInfo(contas); 
	System.out.print("O saque será efetuado na conta de qual cliente? (0 a " + (contas.length - 1) + "): "); 
	indiceConta = entrada.nextInt(); 
	if (indiceConta >= 0 && indiceConta < contas.length) { 
	clienteValido = true; 
	} else { 
	System.out.println("Índice de cliente inválido!"); 
	} 
	} 
	System.out.print("Qual o valor do saque? "); 
	double saque = entrada.nextDouble(); 
	contas[indiceConta].sacar(saque); 
	System.out.println("Saque finalizado.\n");
	System.out.println("CPMF = "+contas[indiceConta].getCPMF());
} 
public static void interacaoDepositar(ContaBancaria[] contas) { 
// instruções do método a ser desenvolvido 
	boolean clienteValido = false; 
	int indiceConta = -1; 
	while (!clienteValido) { 
	mostrarInfo(contas); 
	System.out.print("O deposito será efetuado na conta de qual cliente?(0 a " + (contas.length - 1) + "): "); 
	indiceConta = entrada.nextInt(); 
	if (indiceConta >= 0 && indiceConta < contas.length) { 
	clienteValido = true; 
	} else { 
	System.out.println("Índice de cliente inválido!"); 
	} 
	} 
	System.out.print("Qual o valor do deposito? "); 
	double deposito = entrada.nextDouble(); 
	contas[indiceConta].depositar(deposito); 
	System.out.println("Deposito finalizado.\n"); 

} 
public static void interacaoTransferir(ContaBancaria[] contas) { 
// instruções do método a ser desenvolvido 
	boolean clienteValido = false; 
	int indiceConta = -1;
	int ContaTransfere = -1;
	while (!clienteValido) { 
	mostrarInfo(contas); 
	System.out.print("A transferencia será efetuado para qual cliente?(0 a " + (contas.length - 1) + "): "); 
	indiceConta = entrada.nextInt(); 
	if (indiceConta >= 0 && indiceConta < contas.length) { 
	clienteValido = true; 
	} else { 
	System.out.println("Índice de cliente inválido!"); 
	} 
	} 
	System.out.print("Qual o valor da transferencia? "); 
	double valor = entrada.nextDouble();  
	System.out.println("Qual o a sua conta ?.\n");
	ContaTransfere = entrada.nextInt();
	if (indiceConta >= 0 && indiceConta < contas.length) { 
		clienteValido = true; 
		} else { 
		System.out.println("Índice de cliente inválido!"); 
		} 
	 contas[ContaTransfere].transferir(valor,contas[indiceConta]);
	 System.out.println("Transferencia concluida !");
	 
	 
	 
		}
    
	


	
public static void main(String[] args) { 
	ContaBancaria[] contas = new ContaBancaria[5]; 
	contas[0] = new ContaBancaria("Marcos", 1000.00); 
	contas[1] = new ContaBancaria("Júlia", 250.00); 
	contas[2] = new ContaBancaria("João", 2500.00); 
	contas[3] = new ContaBancaria("Roberto", 3000.00); 
	contas[4] = new ContaBancaria("Janaína", 4500.00); 
	entrada = new Scanner(System.in); 
	boolean sair = false; 
	while (!sair) { 
	System.out.println("Escolha uma operação:"); 
	System.out.println("(1) mostrar informações de todas as contas"); 
	System.out.println("(2) sacar"); 
	System.out.println("(3) depositar"); 
	System.out.println("(4) transferir"); 
	System.out.println("(5) sair"); 
	System.out.print("Opção escolhida: "); 
	int escolha = entrada.nextInt(); 
	System.out.println();
	switch (escolha) { 
	case 1: 
	mostrarInfo(contas); 
	break; 
	case 2: 
	interacaoSacar(contas); 
	break; 
	case 3: 
	interacaoDepositar(contas); 
	break; 
	case 4: 
	interacaoTransferir(contas); 
	break; 
	case 5: 
	sair = true; 
	break; 
	default: 
System.out.println("Opção inválida!"); 
} 
System.out.println(); 
} 
System.out.println("Fim do programa!"); 
} 
} 
