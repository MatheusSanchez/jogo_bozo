package cliente_servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;



public class Cliente {
	
	static boolean ocupado[] = new boolean[11];
	
	static int countChar(String dados, int c) {
		
		
		int count  = 0;
		
			for (int i = 0; i < dados.length(); i+=2) {
				if(Character.getNumericValue(dados.charAt(i)) == c) {
					count++;
				}
			}
				
		return count;
		
	}
	public static String troca_dados(String dados) {
		String retorno = "T ";
		String[] tmp;
		tmp = dados.split(" ");
		
		for(int i = 0; i < 4 ;i++) {
			int k = countChar(dados, (((int)(tmp[i].charAt(0))) - 48) );
			
			if(k >= 2){
				retorno += "0 ";
			}else {
				retorno += "1 ";
			}
			
		}
		
		int k = countChar(dados, (((int)(tmp[4].charAt(0))) - 48) );
		
		if(k >= 2){
			retorno += '0';
		}else {
			retorno += '1';
		}
		//retorno += '\0';
		
		System.out.println("  Retorno " + retorno);
		
		return retorno;
		
		
	}

	public static int calculaMaior(String DadosServer) {
		
		System.out.println("Recebido -> " + DadosServer);
		
		int tabuleiro[] = new int[11];
		//int i = 0;	
		
		for(int i = 1;i <= 6; i++) {
			tabuleiro[i] = countChar(DadosServer,i) * i;	
			//System.out.println("Posicao: " +i + " fez " +tabuleiro[i]+ " Pontos");
		}
		
		//contar quina
		for(int i = 1;i <= 6; i++) {
			int aux = countChar(DadosServer,i);
			if(aux == 0){
				continue;
			}else if(aux == 5){
				tabuleiro[10] = 40;
			}else if(aux < 5){
				tabuleiro[10] = 0;
				break;
			}
		}
		
		//contar quadra
		for(int i = 1;i <= 6; i++) {
			int aux = countChar(DadosServer,i);
			if(aux == 1 || aux == 0){
				continue;
			}else if(aux >= 4){
				tabuleiro[9] = 30;
			}else if(aux < 4){
				tabuleiro[9] = 0;
				break;
			}
		}		
		
		//sequencia
		
		
		for(int i = 1;i <= 5; i++) {
			if(countChar(DadosServer,i) == 1) {
				
				tabuleiro[8] = 20; 
			}else {
				
				tabuleiro[8] = 0;
				break;
			}
		}
		if(tabuleiro[8] == 0) {
			for(int i = 2; i <= 6; i++) {
				if(countChar(DadosServer,i) == 1) {
					
					tabuleiro[8] = 20; 
				}else {
					
					tabuleiro[8] = 0;
					break;
				}
			}
		}
		
		
		//contar full hand
		
		int count[] = new int [7];
		for(int i = 1;i <= 6; i++) {
			count[i] = countChar(DadosServer,i);
		}
		
		boolean flag = false;
		for(int i = 1;i <= 6; i++) {
			if(count[i] == 3) {
				flag = true;
				break;
			}
		}	
		
		boolean flag2 = false;
		for(int i = 1; (flag || flag2) && i <= 6; i++) {
			if(count[i] == 2) {
				flag2 = true;
				break;
			}
		}
		
		if(flag2 && flag) {
			tabuleiro[7] = 15;
		}else {
			tabuleiro[7] = 0;
		}
		
		for(int i = 1;i <= 6; i++) {
			tabuleiro[i] = countChar(DadosServer,i) * i;	
			System.out.println("Posicao: " +i + " fez " +tabuleiro[i]+ " Pontos");
		}
		System.out.println("Full Hand: " +tabuleiro[7]);
		System.out.println("Sequencia: " +tabuleiro[8]);
		System.out.println("Quadra: " +tabuleiro[9]);
		System.out.println("Quina: " +tabuleiro[10]);
		
		
		
		for(int i = 10;i <= 7; i--) {
			if(tabuleiro[i] != 0 && ocupado[i] == false){	 
					return i;
			}
		}
		
		int maior = 10;
		
		while(ocupado[maior] == true){ // pegando uma posicao valida
			maior--;	
		}
		
		for(int i = 1;i <= 6; i++) {
			if(tabuleiro[i] > tabuleiro[maior] && ocupado[i] == false){
				maior = i;
			}	
		}
		
		
		return maior;
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		

		Socket cliente = new Socket("127.0.0.1",9669);	// conecta com servidor
		 
		System.out.println("Conectamos com o servidor");	
		
		PrintStream saida = new  PrintStream(cliente.getOutputStream());
		Scanner teclado = new Scanner(System.in);
		Scanner server = new  Scanner(cliente.getInputStream());
		
		saida.println("I 9081453"); //inicia o jogo
		System.out.println(server.nextLine());// mensagens de boas vindas
	
		for(int i = 1;i <= 10 ;i++) {
			ocupado[i] = false;
		}
		
		
		for (int i = 1; i <= 10; i++) {
			saida.println("R"+i); // joga os dados	
			String str_dados = "";
			int pos_placar= 0;
			
			str_dados = server.nextLine(); // pega primeira string de dados
			System.out.println("Dados da jogada " + str_dados + "\n"); // printa os dados	
			
			
			saida.println(troca_dados(str_dados)); // alteracao
			str_dados = server.nextLine(); // pega os dados
			System.out.println("Dados da jogada " + str_dados + "\n"); // printa os dados
			saida.println(troca_dados(str_dados));	
			
			str_dados = server.nextLine(); // ultimos dados gerados
			System.out.println("Dados da jogada(ultimo) " + str_dados+ "\n");
			pos_placar = calculaMaior(str_dados);
			System.out.println("Melhor posicao " + pos_placar + "\n");
			System.out.println("Colocando na posicao " + pos_placar + " do placar");
			
			saida.println("P"+i+" "+ pos_placar); // coloca no placar
			ocupado[pos_placar] = true;
			
			System.out.println("Pontuação corrente " + server.nextLine() + "\n");
		}

		
		saida.print("F");
	}

}
