package dado;

import java.util.Calendar;

public class Random {
	private long p = 2147483648l;
	private long m = 843314861;
	private long a = 453816693;
	
	
	private long xi = 1023;


	public double getRand() {
		return Math.random();
	}
	
	public int getIntRand(int max){
		double d = getRand() * max;
		return (int) Math.abs(d) + 1; // mudamos este método para gerar mais aleatoriedade;
	}

	public void setSemente(int semente) {
       xi = semente;		
	}

	public Random(int k){

		xi = k;
	}
	
	public Random() {

		xi = Calendar.getInstance().getTimeInMillis();
	}
	
}