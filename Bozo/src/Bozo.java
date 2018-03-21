

public class Bozo {

	public static void main(String[] args) {
		
		RolaDados dados = new RolaDados(10);
		int valores[] = new int[10];
		
		dados.rolar();
		String s = dados.toString();
		System.out.println(s);
		
		boolean[] quais = new boolean[10];
		quais[0] = true;
		quais[1] = true;
		dados.rolar(quais);
		
		s = dados.toString();
		System.out.println(s);
		
		
		
	
		
		
	}

}
