

public class Bozo {

	public static void main(String[] args) {
		
		RolaDados dados = new RolaDados(10);
		int valores[] = new int[10];
		
		valores = dados.rolar();
		
		for (int i = 0; i < valores.length; i++) {
			System.out.println(valores[i]);
		}
		dados.toString();
		
	}

}
