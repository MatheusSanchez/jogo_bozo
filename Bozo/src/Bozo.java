

public class Bozo {

	public static void main(String[] args) {
		
		Dado dado1 = new Dado();
		System.out.println("Este dado Tem " + dado1.getNlados() +  " Lados ");
		
		System.out.println("Rolando o Dado ");
		int face = dado1.rolar();
		
		System.out.println("Face obtida " + face);
		
		System.out.println(dado1.toString());
	}

}
