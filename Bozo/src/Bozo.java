public class Bozo {

	public static void main(String[] args) {
		int i;
		int dados[] = new int[5];
		Placar placar = new Placar();
		for(i = 0; i < 5; i++) {
			Dado dado1 = new Dado();
			System.out.println("Este dado Tem " + dado1.getNlados() +  " Lados ");
			
			System.out.println("Rolando o Dado ");
			int face = dado1.rolar();
			dados[i] = face;
			
			System.out.println("Face obtida " + face);
			
			System.out.println(dado1.toString());
		}
		
		
		placar.add(4, dados);
		placar.toString();
	}

}
