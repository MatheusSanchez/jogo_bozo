

public class Dado {
	
	private int Numerolados;
	private int face;
	
	
	public Dado() {
		this.Numerolados = 6;
	}
	
	public Dado(int k) {
		this.Numerolados = k;
	}
	
	public int getFace() {
		return this.face;
	}
	
	public int getNlados() {
		
		return this.Numerolados;
	}
	
	public int rolar() {
		
		Random r = new Random();
		this.face = (r.getIntRand(Numerolados));
		return	getFace();
		
	}
	
@Override
	public java.lang.String toString(){
	
		String resultado = new String();
		
		if(this.face == 1) {
			resultado = "+-----+    \r\n" + 
						"|     |    \r\n" + 
						"|  *  |    \r\n" + 
						"|     |    \r\n" + 
						"+-----+";
		}else if(this.face == 2) {
			resultado = "+-----+    \r\n" + 
						"|*    |    \r\n" + 
						"|     |    \r\n" + 
						"|    *|    \r\n" + 
						"+-----+";
		}else if(this.face == 3) {
			resultado = "+-----+    \r\n" + 
						"|*    |    \r\n" + 
						"|  *  |    \r\n" + 
						"|    *|    \r\n" + 
						"+-----+";
		}else if(this.face == 4) {
			resultado = "+-----+    \r\n" + 
						"|*   *|    \r\n" + 
						"|     |    \r\n" + 
						"|*   *|    \r\n" + 
						"+-----+";
		}else if(this.face == 5) {
			resultado = "+-----+    \r\n" + 
						"|*   *|    \r\n" + 
						"|  *  |    \r\n" + 
						"|*   *|    \r\n" + 
						"+-----+";
		}else if(this.face == 6) {
			resultado = "+-----+    \r\n" + 
						"|* * *|    \r\n" + 
						"|     |    \r\n" + 
						"|* * *|    \r\n" + 
						"+-----+";
		}
		
		return resultado;
	
	}
	
}	
