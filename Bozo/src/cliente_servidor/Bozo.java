package cliente_servidor;
import placar.RolaDados;

import java.io.IOException;

import excecoes.BozoException;
import placar.Placar;

public class Bozo {
	private RolaDados dados;
	private Placar placar;
	int retornoDados[];

	public Bozo() {
		this.dados = new RolaDados(5);
		this.placar = new Placar();
	}

    public String principal(String args) throws IllegalArgumentException, IOException, BozoException {
    	int aux;
		String[] a = args.split(" ");
		
		
		if(a[0].equals("T")) {
			String rola = "";
			
			boolean[] quais = new boolean[6];
			
			for(int i = 1; i < 6; i ++){
				if(a[i].equals('1')){
					quais[i-1] = true;
				}else{
					quais[i-1] = false;
				}
				
			}	
			
			
			retornoDados = dados.rolar(quais);
			
			for(int i = 0; i < 4; i ++){
				aux = (retornoDados[i]);
				rola += aux ;
				rola += " ";
			}
			aux = (retornoDados[4]);
			rola += aux;
	
			
			return rola;	
		}
		else if(a[0].charAt(0) == 'P') {
            int posicao = Integer.parseInt(a[1]);
			placar.add(posicao-1, retornoDados);
			return ""+placar.getScore();
		}
		else if(a[0].charAt(0) == 'R'){
			retornoDados = dados.rolar("11111");
			String rola = "";
			for(int i = 0; i < 4; i ++){
				aux = (retornoDados[i]);
				rola += aux ;
				rola += " ";
			}
			aux = (retornoDados[4]);
			rola += aux ;
		
			return rola;
		}
		else if(a[0].charAt(0) == 'F') {
			return placar.getScore() + "";
		}
		else {
			return "Deu Ruim Molecada";
		}
    }
}
