package dado;

public class Dado {
	
	private int Numerolados;
	private int face; // face para cima do dado
	
	
	public Dado() {
		this.Numerolados = 6;
		this.face = 0;
	}
	
	public Dado(int k) {
		this.Numerolados = k;
	}
	
	public int getFace() {
		return this.face;
	}
	
	/*public int getNlados() {
		
		return this.Numerolados;
	}*/
	
	public int rolar() { // rola o dado
		
		Random r = new Random();
		this.face = (r.getIntRand(Numerolados));
		return	getFace();
		
	}
	
@Override
	public java.lang.String toString(){
	
		String resultado = new String();
		
		if(this.face == 1) {
			resultado = "+-----+    \n" + 
						"|     |    \n" + 
						"|  *  |    \n" + 
						"|     |    \n" + 
						"+-----+    ";
		}else if(this.face == 2) {
			resultado = "+-----+    \n" + 
						"|*    |    \n" + 
						"|     |    \n" + 
						"|    *|    \n" + 
						"+-----+    ";
		}else if(this.face == 3) {
			resultado = "+-----+    \n" + 
						"|*    |    \n" + 
						"|  *  |    \n" + 
						"|    *|    \n" + 
						"+-----+    ";
		}else if(this.face == 4) {
			resultado = "+-----+    \n" + 
						"|*   *|    \n" + 
						"|     |    \n" + 
						"|*   *|    \n" + 
						"+-----+    ";
		}else if(this.face == 5) {
			resultado = "+-----+    \n" + 
						"|*   *|    \n" + 
						"|  *  |    \n" + 
						"|*   *|    \n" + 
						"+-----+    ";
		}else if(this.face == 6) {
			resultado = "+-----+    \n" + 
						"|* * *|    \n" + 
						"|     |    \n" + 
						"|* * *|    \n" + 
						"+-----+    ";
		}
		
		return resultado;
	
	}
	
}	
