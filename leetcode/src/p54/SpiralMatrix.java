package p54;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return new ArrayList<Integer>();
		}
		int colLength = matrix.length;

		int rowLength = matrix[0].length;
		int up = 0;
		int down = colLength - 1;
		int right = rowLength - 1;
		int left = 0;
		ArrayList<Integer> result = new ArrayList<Integer>(rowLength * colLength);
		while (down >= up && left <= right) {
			for (int i = left; i <= right; i++) {
				result.add(matrix[up][i]);
			}
			for (int i = up + 1; i <= down; i++) {
				result.add(matrix[i][right]);
			}
			if (left < right && up < down) {
				for (int i = right - 1; i >= left + 1; i--) {
					result.add(matrix[down][i]);
				}
				for (int i = down; i >= up + 1; i--) {
					result.add(matrix[i][left]);
				}
			}
			up++;
			down--;
			left++;
			right--;
		}
		return result;
	}

	public static void main(String[] args) {
//		int[][] matrix = { { 1, 2, 3, 10 }, { 4, 5, 6, 11 }, { 7, 8, 9, 12 }, { 5, 8, 3, 4 } };
//		int[][] matrix = { { 3 }, { 2 } };
		int[][] matrix = { { 6, 9, 7 } };
		List<Integer> list = new SpiralMatrix().spiralOrder(matrix);
		System.out.println(list);
	}
}
