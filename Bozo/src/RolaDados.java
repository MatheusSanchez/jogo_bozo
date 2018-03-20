
public class RolaDados {
	
	private int nDados;
	private Dado vetDados[];
	
	public RolaDados(int nDados) {
		this.nDados = nDados;
		this.vetDados = new Dado[nDados];
		
	}
	
	public int[] rolar() {
		int retornoDados[] = new int[5];
		
		for(int i = 0; i < this.nDados; i++) {
			retornoDados[i] = this.vetDados[i].rolar();
		}	
		
		return retornoDados;
	}
	
	public int[] rolar(boolean[] quais) {
		
		int retornoDados[] = new int[5];
		
		for(int i = 0; i < nDados; i++) {
			if(quais[i]){
				retornoDados[i] = this.vetDados[i].rolar();
			}	
		}	
		
		return retornoDados;
	}
	
	public int[] rolar(java.lang.String s){
		
		boolean quais[] = new boolean[this.nDados];
		
		for(int i = 0; i < this.nDados ;i++) {
			quais[i] = false;
		}
		
		s = s.replaceAll(" ","");
		
		for(int i = 0; i < s.length() ;i++) {
			quais[(int)(s.charAt(i))] = true;
		}
		
		
		return rolar(quais);
	}
	
	@Override
	public java.lang.String toString(){
		
		String strDado = new String();
		String vetStrDado[][] = new String[this.nDados][5];
		
		for(int i = 0; i < this.nDados ;i++) {
			
			strDado = vetDados[i].toString();
			vetStrDado[i] = strDado.split("\n");
			System.out.println(vetStrDado[i]);
			
		}
		

		return strDado;
		
	}
	
}



