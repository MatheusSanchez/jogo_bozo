import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import excecoes.BozoException;
import placar.Placar;

public class PlacarTeste {
	
	private Placar p;
	
	@Before
	public void setupTest() {
		p = new Placar();
	}
	@After
	public void setupTestAfter() {
		p = null;
	}
	
	
	@Test
	public void testGetScore() throws IllegalArgumentException, IOException, BozoException {
		p.add(1, new int[] {1, 1, 1, 1, 1} );
		p.add(2, new int[] {2, 2, 2, 2, 2} );
		p.add(3, new int[] {3, 3, 3, 3, 3} );
		p.add(4, new int[] {4, 4, 4, 4, 4} );
		p.add(5, new int[] {5 ,5, 5, 5, 5} );
		p.add(6, new int[] {6, 6, 6, 6, 6} );
		p.add(7, new int[] {2, 2, 2, 3, 3} );
		p.add(8, new int[] {1, 2, 3, 4, 5} );
		p.add(9, new int[] {1, 2, 2, 2, 2} );
		p.add(10, new int[] {1, 1, 1, 1, 1} );
		int k = p.getScore();
		assertEquals(210, k);
	}
	
	@Test
	public void testGetScoreFalhaFullHand() throws IllegalArgumentException, IOException, BozoException {
		p.add(1, new int[] {1, 1, 1, 1, 1} );
		p.add(2, new int[] {2, 2, 2, 2, 2} );
		p.add(3, new int[] {3, 3, 3, 3, 3} );
		p.add(4, new int[] {4, 4, 4, 4, 4} );
		p.add(5, new int[] {5 ,5, 5, 5, 5} );
		p.add(6, new int[] {6, 6, 6, 6, 6} );
		p.add(7, new int[] {3, 3, 1, 2, 2} );
		p.add(8, new int[] {2, 3, 4, 5, 6} );
		p.add(9, new int[] {1, 3, 2, 2, 2} );
		p.add(10, new int[] {1, 2, 1, 1, 1} );
		int k = p.getScore();
		assertEquals(125, k);
	}
	
	@Test
	public void toStringPreenchido() throws IllegalArgumentException, IOException, BozoException {
		String retorno = "";
		
		p.add(1, new int[] {1, 2, 3, 4, 5} );
		p.add(2, new int[] {1, 2, 3, 4, 5} );
		p.add(3, new int[] {1, 2, 3, 4, 5} );
		p.add(4, new int[] {1, 2, 3, 4, 5} );
		p.add(5, new int[] {1, 2, 3, 4, 5} );
		p.add(6, new int[] {1, 2, 3, 4, 5} );
		p.add(7, new int[] {1, 2, 3, 4, 5} );
		p.add(8, new int[] {1, 2, 3, 4, 5} );
		p.add(9, new int[] {1, 2, 3, 4, 5} );
		p.add(10, new int[] {1, 2, 3, 4, 5} );
		
		retorno += ("   " + p.tabuleiro[0] + "   |");
		retorno += ("  " + p.tabuleiro[6] + "   |");
		retorno += ("  " + p.tabuleiro[3] + "   |");
		
		retorno += '\n';
		retorno += ("------------------------\n");
		
		retorno += ("   " + p.tabuleiro[1] + "   |");
		retorno += ("  " + p.tabuleiro[7] + "   |");
		retorno += ("  " + p.tabuleiro[4] + "   |");
		
		retorno += '\n';
		retorno += ("------------------------\n");
		
		retorno += ("  " + p.tabuleiro[2] + "   |");
		retorno += ("  " + p.tabuleiro[8] + "   |");
		retorno += ("  " + p.tabuleiro[5] + "   |");
		
		retorno += '\n';
		retorno +=("------------------------\n");
		
		retorno += ("       |"  + "  " + p.tabuleiro[9] + "   " +  "|   ");
		
		retorno +='\n';
		retorno +=("       x-------x        \n");
		
		assertEquals(p.toString(), retorno);
	}
	
	@Test
	public void toStringNull() throws IllegalArgumentException, IOException, BozoException {
		String retorno = "";
		
		retorno +=("  (1)  |");
		retorno += ("  (7)  |");
		retorno += ("  (4)  |");
		
		retorno += '\n';
		retorno += ("------------------------\n");
		
		retorno +=("  (2)  |");
		retorno +=("  (8)  |");
		retorno +=("  (5)  |");
		
		retorno += '\n';
		retorno += ("------------------------\n");
		
		retorno += ("  (3)  |");
		retorno += ("  (9)  |");
		retorno += ("  (6)  |");
		
		retorno += '\n';
		retorno +=("------------------------\n");
		
		retorno += ("       |  (10) |         ");
		
		retorno +='\n';
		retorno +=("       x-------x        \n");
		
		assertEquals(p.toString(), retorno);
	}
	
	@Test
	public void testGetScoreCasosRestantes() throws IllegalArgumentException, IOException, BozoException {
		p.add(1, new int[] {1, 1, 1, 1, 1} );
		p.add(2, new int[] {2, 2, 2, 2, 2} );
		p.add(3, new int[] {3, 3, 3, 3, 3} );
		p.add(4, new int[] {4, 4, 4, 4, 4} );
		p.add(5, new int[] {5 ,5, 5, 5, 5} );
		p.add(6, new int[] {6, 6, 6, 6, 6} );
		p.add(7, new int[] {3, 3, 1, 2, 2} );
		p.add(8, new int[] {2, 3, 5, 5, 6} );
		p.add(9, new int[] {1, 3, 2, 2, 2} );
		p.add(10, new int[] {1, 2, 1, 1, 1} );
		int k = p.getScore();
		assertEquals(105, k);
	}
	
	@Test(expected=BozoException.class)
	public void testGetScoreCasosRestantes2() throws IllegalArgumentException, IOException, BozoException {
		p.add(1, new int[] {1, 1, 1, 1, 1} );
		p.add(1, new int[] {1, 2, 2, 2, 2} );
	}

}


