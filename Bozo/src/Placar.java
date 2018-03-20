
public class Placar {
	int tabuleiro[] = new int[10];
	
	public void add(int posicao, int dados[]) {
		int j, soma = 0;
		if(posicao < 6) {
			for(j = 0; j < 5; j++) {
				if(dados[j] == posicao) soma += dados[j];
			}
		}else if(posicao == 6) soma += 15; 
		else if(posicao == 7) soma += 20;
		else if(posicao == 8) soma += 30;
		else if(posicao == 9) soma += 40;
		tabuleiro[posicao] = soma;
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
	public String toString(){
		if(tabuleiro[0] == 0) System.out.print("  (1)  |");
		else System.out.print("  " + tabuleiro[0] + "   |");
		if(tabuleiro[6] == 0) System.out.print("  (7)  |");
		else System.out.print("  " + tabuleiro[6] + "   |");
		if(tabuleiro[3] == 0) System.out.println("  (4)  |");
		else System.out.println("  " + tabuleiro[3] + "   |");
		System.out.print("------------------------\n");
		if(tabuleiro[1] == 0) System.out.print("  (2)  |");
		else System.out.print("  " + tabuleiro[1] + "   |");
		if(tabuleiro[7] == 0) System.out.print("  (8)  |");
		else System.out.print("  " + tabuleiro[7] + "   |");
		if(tabuleiro[4] == 0) System.out.println("  (5)  |");
		else System.out.println("  " + tabuleiro[4] + "   |");
		System.out.print("------------------------\n");
		if(tabuleiro[2] == 0) System.out.print("  (3)  |");
		else System.out.print("  " + tabuleiro[2] + "   |");
		if(tabuleiro[8] == 0) System.out.print("  (9)  |");
		else System.out.print("  " + tabuleiro[8] + "   |");
		if(tabuleiro[5] == 0) System.out.println("  (6)  |");
		else System.out.println("  " + tabuleiro[5] + "   |");
		System.out.print("------------------------\n");
		if(tabuleiro[9] == 0) System.out.println("       |  (10) |         ");
		else System.out.println("       |"  + "  " + tabuleiro[9] + "   " +  "|   ");
		System.out.print("       x-------x        \n");
		return null;
	}
	
	public Placar(){
		int i;
		for(i = 0; i < 10; i++) {
			tabuleiro[i] = 0;
		}
	}
}
