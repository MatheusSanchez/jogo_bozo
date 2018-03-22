import java.io.IOException;

public class Placar {
	int tabuleiro[] = new int[10];
	
	public Placar(){
	
		for(int i = 0; i < 10; i++) {
			tabuleiro[i] = -1;
		}
	}
	
	public void add(int posicao, int dados[]) throws java.lang.IllegalArgumentException, IOException{
		posicao--;
		int j, soma = 0;
		for (int i = 0; i < dados.length; i++) {
			System.out.println("Dado "+ i + " = " + dados[i]);

		}
			
		try{
			if(this.tabuleiro[posicao] == -1) { // posições não ocupadas
				
				if(posicao < 6) {
					for(j = 0; j < dados.length; j++) {	
						if(dados[j] == posicao + 1)
							soma += dados[j];					
					}
					
					tabuleiro[posicao] += soma;
				}else if(posicao < 10){
					System.out.println("DAora fera");
					tabuleiro[posicao] += soma;
				}else{
					System.out.println("Esta posição não existe no tabuleiro !");
					System.out.println("Digite uma posição valida !");
					throw new IllegalArgumentException();
				}
				
			}else {
				System.out.println("Esta posição ja esta ocupada, lamento !");
				System.out.println("Digite uma posição vazia !");
				throw new IllegalArgumentException();
			}
			
		}catch(java.lang.IllegalArgumentException e) {
			posicao = EntradaTeclado.leInt();
			this.add(posicao,dados);
			return;
		}
	}
	
	public int getScore(){
		int soma = 0;
		int i;
		for(i = 0; i < 10; i++) {
			soma += tabuleiro[i];
		}
		return soma;
	}
	
	@Override 
	public java.lang.String toString(){
		
		String resul = new String();
		
		resul = " "+tabuleiro[0]+"   |   "+tabuleiro[6]+"    |   "+tabuleiro[3]+" \n" + 
				" --------------------------\n" + 
				" "+tabuleiro[1]+"   |   "+tabuleiro[7]+"    |   "+tabuleiro[4]+" \n" + 
				" -------------------------- \n" + 
				" "+tabuleiro[2]+"   |   "+tabuleiro[8]+"    |   "+tabuleiro[5]+" \n" + 
				"-------------------------- \n" + 
				"        |   "+tabuleiro[8]+"   | \n" + 
				"        +----------+ ";
		
	
		
		
			
		return resul;
	}
	
	
}
