import java.io.IOException;

public class Bozo {

	public static void main(String[] args) throws IOException {
		
		int rodada = 0;
		Placar placar = new Placar();
		RolaDados dados = new RolaDados(5);
		int pontDados[] = new int[5];
		
		String troca = new String();
		int addPlacar;
		
		while(rodada < 10) {
			System.out.println(placar.toString());
			System.out.println("****** Rodada " + (rodada + 1));
			System.out.println("Pressione ENTER para lançar os dados");
			EntradaTeclado.leString();
			
			pontDados = dados.rolar();
			System.out.println(dados.toString());
			
			for (int i = 0; i < 2; i++) {
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
			
			System.out.println(placar.toString());
			System.out.print("Escolha a posição que quer ocupar com essa jogada ===> ");
			addPlacar = EntradaTeclado.leInt();
			
			placar.add(addPlacar, pontDados);
			System.out.println(placar.toString());
			System.out.println("Fim Da Rodada " + (rodada + 1));
			rodada++;
		}
		
		
		
	}

}
