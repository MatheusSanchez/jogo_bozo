

public class Bozo {

	public static void main(String[] args) {
		
		RolaDados dados = new RolaDados(5);
		int valores[] = new int[5];
		
		valores = dados.rolar();
		
		for (int i = 0; i < valores.length; i++) {
			System.out.println(valores[i]);
		}
		
	}

}
