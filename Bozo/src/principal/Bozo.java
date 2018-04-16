package principal;
import java.io.IOException;

import entradaTeclado.EntradaTeclado;
import excecoes.BozoException;
import placar.Placar;
import placar.RolaDados;

public class Bozo {

	public static void main(String[] args) throws IOException {
		
		int rodada = 0; // controle de rodadas
		Placar placar = new Placar();
		RolaDados dados = new RolaDados(5);
		int pontDados[] = new int[5]; // veotr com os inteiros dos dados que foram girados
		
		String troca = new String(); // string que informa quais dados o usuario quer trocar
		int addPlacar; //posicao placar para adicionar
		
		System.out.println(placar.toString()); // placar inicial;
		
		while(rodada < 10) {
			
			System.out.println("****** Rodada " + (rodada + 1));
			System.out.println("Pressione ENTER para lançar os dados");
			EntradaTeclado.leString(); 
			
			pontDados = dados.rolar(); // rolando dados
			System.out.println(dados.toString()); // printando os dados
			
			for (int i = 0; i < 2; i++) { // direito de trocar os dados 2 vezes
				System.out.println("Digite os números dos dados que quiser TROCAR. Separados por espaços.");
				troca = "";
				troca = EntradaTeclado.leString();
				
				if(!(troca.isEmpty() )) {
					pontDados = dados.rolar(troca);
					System.out.println(dados.toString());
				}else {
					System.out.println(dados.toString());
				}
				
			}
			System.out.println();
			System.out.println();
			System.out.println(placar.toString()); // placar atual
			
			System.out.print("Escolha a posição que quer ocupar com essa jogada ===> ");
			
			try {
				addPlacar = EntradaTeclado.leInt();	
				System.out.println();
				System.out.println();
				placar.add(addPlacar, pontDados); // adiciona os dados na posição digitada pelo usuario
			}
			catch (BozoException e) {	
			    System.out.println(e);
			}
			catch (Exception e) {	
			   System.out.println("Voce digitou algo que não é um número ! Perdeu a vez.");
			}
			
			System.out.println(placar.toString()); // printa o placar
			rodada++;
		}
		System.out.println("**************************************");
		System.out.println("RESULTADO FINAL " + placar.getScore()); // resultado final do jogo
		System.out.println("**************************************");
	}

}
