import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;

import placar.Placar;

import org.junit.Test;

import excecoes.BozoException;

public class PlacarTeste {
	
	private static Placar p;

	@BeforeClass
	public static void setupBeforeClassPlacar() {
		 p = new Placar();
	}
	
	@Test (expected=BozoException.class)
	public void TestAdd() throws IllegalArgumentException, IOException, BozoException {
		p.add(1,new int [] {1,2,3,4,5}); // 1
		p.add(2,new int [] {1,2,3,4,5}); // 2
		p.add(3,new int [] {1,2,3,4,5}); // 3
		p.add(4,new int [] {1,2,3,4,5}); // 4
		p.add(5,new int [] {1,2,3,4,5}); // 5
		p.add(6,new int [] {1,2,3,4,5}); // 6
		p.add(7,new int [] {1,2,3,4,5}); // 0
		p.add(8,new int [] {1,2,3,4,5}); // 0
		p.add(9,new int [] {1,2,3,4,5}); // 0
		p.add(10,new int [] {1,2,3,4,5}); // 0
		p.add(10,new int [] {1,2,3,4,5}); // posicao ocupada
		int k = p.getScore();
		assertEquals(35, k);
	}
	
	/*@Test
	public void TestToString() {
		String retorno = new String();
		retorno = "";
		String resultado;
		
		if(p.tabuleiro[0] < 0)retorno +=("  (1)  |");
		else retorno +=("   " + p.tabuleiro[0] + "   |");
		
		if(p.tabuleiro[6] < 0) retorno += ("  (7)  |");
		else retorno += ("  " + p.tabuleiro[6] + "   |");
		
		if(p.tabuleiro[3] < 0) retorno += ("  (4)  |");
		else retorno += ("  " + p.tabuleiro[3] + "   |");
		
		retorno += '\n';
		retorno += ("------------------------\n");
		
		if(p.tabuleiro[0] < 0){
			
		}
		
		if(p.tabuleiro[1] < 0) retorno +=("  (2)  |");
		else retorno += ("   " + p.tabuleiro[1] + "   |");
		
		if(p.tabuleiro[7] < 0) retorno +=("  (8)  |");
		else retorno += ("  " + p.tabuleiro[7] + "   |");
		
		if(p.tabuleiro[4] < 0) retorno +=("  (5)  |");
		else retorno += ("  " + p.tabuleiro[4] + "   |");
		
		retorno += '\n';
		retorno += ("------------------------\n");
		
		if(p.tabuleiro[2] < 0) retorno += ("  (3)  |");
		else retorno += ("  " + p.tabuleiro[2] + "   |");
		
		if(p.tabuleiro[8] < 0) retorno += ("  (9)  |");
		else retorno += ("  " + p.tabuleiro[8] + "   |");
		
		if(p.tabuleiro[5] < 0) retorno +=("  (6)  |");
		else retorno += ("  " + p.tabuleiro[5] + "   |");
		
		retorno += '\n';
		retorno +=("------------------------\n");
		
		if(p.tabuleiro[9] < 0) retorno += ("       |  (10) |         ");
		else retorno += ("       |"  + "  " + p.tabuleiro[9] + "   " +  "|   ");
		
		retorno +='\n';
		retorno +=("       x-------x        \n");
		
			
	
	}*/
	

}
