package p59;

public class SpiralMatrix2 {

	public int[][] generateMatrix(int n) {
		int up = 0, down = n - 1, left = 0, right = n - 1, curr = 1;
		int[][] result = new int[n][n];
		while (curr <= n * n) {
			for (int i = left; i <= right; i++) {
				result[up][i] = curr++;

			}
			for (int i = up + 1; i <= down; i++) {
				result[i][right] = curr++;
			}
			for (int i = right - 1; i >= left + 1; i--) {
				System.out.print(down + "-" + i);
				System.out.println();
				result[down][i] = curr++;
			}
			for (int i = down; i >= up + 1; i--) {
				result[i][left] = curr++;
			}
			up++;
			down--;
			left++;
			right--;
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] result = new SpiralMatrix2().generateMatrix(3);
		for (int[] is : result) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(is[i] + "|");
			}
			System.out.println();
		}
	}
}
