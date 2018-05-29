package cliente_servidor;

import java.io.IOException;

import excecoes.BozoException;



public class Bozo {
	private RolaDados dados;
	private Placar placar;

	public Bozo() {
		this.dados = new RolaDados(5);
		this.placar = new Placar();
	}

    public String principal(String args) throws IllegalArgumentException, IOException, BozoException {
		String[] a = args.split(" ");
		
		if(a[0].equals("T")) {
			String rola = new String();
			boolean quais[] = new boolean[5];
			for(int i = 1; i < 6; i ++) {
				if(a[i].equals("1")) {
					quais[i-1] = true;
				}else {
					quais[i-1] = false;
				}
				
			}
			//System.out.println("Aqui " + rola + "-");
			dados.rolar(quais);
			return dados.toNumbers();	
		}
		else if(a[0].charAt(0) == 'P') {
            int posicao = Integer.parseInt(a[1]);
			placar.add(posicao, dados.valoresAnteriores());
			return ""+placar.getScore();
		}
		else if(a[0].charAt(0) == 'R') {
			dados.rolar();
			return dados.toNumbers();
		}
		else if(a[0].charAt(0) == 'F') {
			return "Voce fez " + placar.getScore() + " Pontos";
		}
		else {
			return "Você digitou alguma coisa errada :(";
		}
    }
}
