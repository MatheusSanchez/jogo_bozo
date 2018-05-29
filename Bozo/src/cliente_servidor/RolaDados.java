package cliente_servidor;
import dado.Dado;

public class RolaDados {
	
	private int nDados;
	private Dado vetDados[];
	
	public RolaDados(int nDados) {
		this.nDados = nDados;
		this.vetDados = new Dado[nDados];
		for(int i = 0; i < this.nDados; i++) {
			vetDados[i] = new Dado();
		}
	}
	
	public int[] rolar() {
		
		int retornoDados[] = new int[this.nDados];
		
		
		for(int i = 0; i < this.nDados; i++) {
			
			retornoDados[i] = this.vetDados[i].rolar();
		}
		
		return retornoDados;
	}
	
	public int[] rolar(boolean[] quais) {
		
		int retornoDados[] = new int[this.nDados];
		
		for(int i = 0; i < this.nDados; i++) {
			
			retornoDados[i] = this.vetDados[i].getFace();
			if(quais[i] ==  true){
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
			
			quais[(s.charAt(i)) - 49] = true;
		}
		
		
		return rolar(quais);
	}
	
	@Override
	public java.lang.String toString(){
		
		String strDado = new String();
		String vetStrDado[][] = new String[this.nDados][5];
		//System.out.print("Cheguei no roel");
		for(int i = 0; i < this.nDados ;i++) {
			
			strDado = vetDados[i].toString();
			vetStrDado[i] = strDado.split("\n");

		}
		
		
		
		// concatenando a string de retorno
		strDado = "";
		
		for(int i = 0; i < 5 ;i++) {
			for(int j = 0; j < this.nDados ;j++) {
				strDado += vetStrDado[j][i];
			}
			strDado += '\n';
		}

		return strDado;
		
	}
	
	public int[] valoresAnteriores() {
		int retornoDados[] = new int[this.nDados];
	    for(int i = 0; i < 5; i++) {
	    	retornoDados[i] = vetDados[i].getFace();
	    }
	    return retornoDados;
	}
	
	public String toNumbers(){
    	String array = new String();
    	for(int i = 0; i < 4; i ++){
    		//System.out.print("Array " + vetDados[i].getFace());
    		array += vetDados[i].getFace();
    		array += " ";
    	}
    	array += vetDados[4].getFace();
		array += "\0";
    	
    	
    	return array;
    } 

	
}


