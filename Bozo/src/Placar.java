import java.io.IOException;
import java.util.Arrays;

public class Placar {
	
	int tabuleiro[] = new int[10]; // posiçoes do placar
	
	public Placar(){
		 // setando todas as posições nulas
		for(int i = 0; i < 10; i++) {
			tabuleiro[i] = -1;
		}
	}
	
	public void add(int posicao, int dados[]) throws java.lang.IllegalArgumentException, IOException{
		posicao--;
		int j, soma = 0;
		
		/*for (int i = 0; i < dados.length; i++) {
			System.out.println("Dado "+ i + " = " + dados[i]);

		}*/
			
		try{
			if(this.tabuleiro[posicao] == -1) { // posições não ocupadas
				
				if(posicao < 6) {
					for(j = 0; j < dados.length; j++) {	// se < 6 apenas percorre os dados e soma
						if(dados[j] == posicao + 1)
							soma += dados[j];					
					}
					tabuleiro[posicao] = soma;
					
				}else if(posicao < 10){
					if(posicao == 6) { // posição 7 full hand
						
						int c1 = 1;								
						int v1 = dados[0]; // valor 1
						
						int c2 = 0;								
						int v2 = 0; // valor 2
						
						for (int i = 1; i < dados.length; i++) { // compara se existem 3 e 2 valores iguais
							if(v1 == dados[i]) {
								c1++;
							}else {
								if(v2 == 0) {
									v2 = dados[i];
									c2++;
								}else if(v2 == dados[i]){
									c2++;
								}else {
									break;
								}
								
							}
						}
						if(c1 + c2 > 4) { // soma = 5
							tabuleiro[posicao] = 15;	
						}else {
							tabuleiro[posicao] = 0;
						}
						
					}else if(posicao == 7) { // posicao 8 sequencia
						
						// como sao duas sequencias possiveis
						
						Arrays.sort(dados); // ordenamos o vetor
						
						int vet[] = {1,2,3,4,5}; // e comparamos com as duas possiveis sequencias
						int vet2[] = {2,3,4,5,6};
						
						
						for (int i = 0; i < dados.length; i++) { // sequencia 1
							if(dados[i] != vet[i]) {
								tabuleiro[posicao] = 0;
								break;
							}else {
								tabuleiro[posicao] = 20;
							}

						}
						
						if(tabuleiro[posicao] == 0) {
							for (int i = 0; i < dados.length; i++) {  // sequencia 2
								if(dados[i] != vet2
										[i]) {
									tabuleiro[posicao] = 0;
									break;
								}else {
									tabuleiro[posicao] = 20;
								}

							}
						}
						
						
						
					
						
						
					}else if(posicao == 8) {  // posicao 9 quadra
						int c1;								
						int v1;	// como são apenas 5 dados, podemos comparar apenas a posicao 0 e 1 do vetor
						
						for (int i = 0; i < 2; i++) { 
							c1 = 0;
							v1 = dados[i];
							
							for (j = 0; j < dados.length; j++) {
								if(dados[j] == v1) {
									c1++;
								}
							}
							
							if(c1 >= 4){
								tabuleiro[posicao] = 30;
								break;
							}else {
								tabuleiro[posicao] = 0;
							}
						}
						
					}else if(posicao == 9){ //posicao 10 quina
				
						int verificador = dados[0]; // pega o primeiro e compara com o resto
						
						for(j = 1; j < dados.length; j++) {	
								if(verificador != dados[j]) {
									verificador = -1;
									break;
								}				
						}
						
						if(verificador > 0) {
							this.tabuleiro[posicao] = 40;
						}else {
							this.tabuleiro[posicao] = 0;
						}
					}
					
				}else{ // posição não existente
					System.out.println("Esta posição não existe no tabuleiro !");
					System.out.println("Digite uma posição valida !");
					throw new IllegalArgumentException();
				}
				
			}else { // posição ocupada
				System.out.println("Esta posição ja esta ocupada, lamento !");
				System.out.println("Digite uma posição vazia !");
				throw new IllegalArgumentException();
			}
			
		}catch(java.lang.IllegalArgumentException e) {
			posicao = EntradaTeclado.leInt();
			this.add(posicao,dados); // retorna pra função em caso de exceções
			return;
		}
	}
	
	public int getScore(){ // pega os pontos do tabuleiro
		
		int soma = 0;
		int i;
		for(i = 0; i < 10; i++) {
			soma += tabuleiro[i];
		}
		return soma;
	}
	
	@Override 
	public java.lang.String toString(){
		
		String retorno = new String();
		retorno = "";
		
		if(tabuleiro[0] < 0)retorno +=("  (1)  |");
		else retorno +=("   " + tabuleiro[0] + "   |");
		
		if(tabuleiro[6] < 0) retorno += ("  (7)  |");
		else retorno += ("  " + tabuleiro[6] + "   |");
		
		if(tabuleiro[3] < 0) retorno += ("  (4)  |");
		else retorno += ("  " + tabuleiro[3] + "   |");
		
		retorno += '\n';
		retorno += ("------------------------\n");
		
		if(tabuleiro[1] < 0) retorno +=("  (2)  |");
		else retorno += ("   " + tabuleiro[1] + "   |");
		
		if(tabuleiro[7] < 0) retorno +=("  (8)  |");
		else retorno += ("  " + tabuleiro[7] + "   |");
		
		if(tabuleiro[4] < 0) retorno +=("  (5)  |");
		else retorno += ("  " + tabuleiro[4] + "   |");
		
		retorno += '\n';
		retorno += ("------------------------\n");
		
		if(tabuleiro[2] < 0) retorno += ("  (3)  |");
		else retorno += ("  " + tabuleiro[2] + "   |");
		
		if(tabuleiro[8] < 0) retorno += ("  (9)  |");
		else retorno += ("  " + tabuleiro[8] + "   |");
		
		if(tabuleiro[5] < 0) retorno +=("  (6)  |");
		else retorno += ("  " + tabuleiro[5] + "   |");
		
		retorno += '\n';
		retorno +=("------------------------\n");
		
		if(tabuleiro[9] < 0) retorno += ("       |  (10) |         ");
		else retorno += ("       |"  + "  " + tabuleiro[9] + "   " +  "|   ");
		
		retorno +='\n';
		retorno +=("       x-------x        \n");
		
		
		return retorno;
	}
	
	
}
