package nc.java.study.numeric;

public class Numeric {

	public void convertFloat() {
		float f = 0;
		for (int i = 0; i < 10; i++) {
			f += i;
		}
		System.out.println(f);
	}
	
	public void passByValue(int points[]) {
		for (int i = 0; i < points.length; i++) {
			points[i] += 1;
		}
	}

	public void printPoints(int[] points) {
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}
		
	}

}
