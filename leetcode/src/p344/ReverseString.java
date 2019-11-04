package p344;

public class ReverseString {

	public void reverseStr(char[] s) {
		int len = s.length;
		for (int i = 0; i < len/2; i++) {
			swap(s, i, len - i - 1);
		}
	}
	private void swap(char[] c, int left, int right) {
		char puppet = c[left];
		c[left] = c[right];
		c[right] = puppet;
	}
	
	public static void main(String[] args) {
		String s = "saffowaeof32ff";
		char[] c = s.toCharArray();
		new ReverseString().reverseStr(c);
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
		}
	}
}
