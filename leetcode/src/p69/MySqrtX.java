package p69;

public class MySqrtX {
	int init;
	
	// recursiont solution
	public int mySqrtRecursion(int x) {
		init = x;
		return (int) sqrt(x, 20);
	}
	private double sqrt(double x, int times) {
		double newX = x - (x * x - init) / x / 2;
		times--;
		if (times == 0) {
			return newX;
		}
		return sqrt(newX, times);
	}
	
	// iteration solution
	public int mySqrtIterate(int x) {
		init = x;
		double xd = (double)x;
		for (int i = 0; i < 30; i++) {
			xd = xd - (xd * xd - init) /xd /2;
		}
		
		return (int)xd;
	}
	
	public static void main(String[] args) {
		System.out.println(new MySqrtX().mySqrtIterate(8));
	}
}
