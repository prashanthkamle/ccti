package interview.ccti.arrays;

/**
 * Question 1.7
 * @author prashanth
 *
 */
public class MatrixRotator {
	private static void rotate(int[][] matrix) {
		int size = matrix[0].length;
		for(int layer = 0; layer < size/2; layer++) {
			rotateLayer(matrix, layer, size);
		}
	}
	
	private static void rotateLayer(int[][] matrix, int layer, int size) {
		int min = layer;
		int max = size - 1 - layer;
		
		for(int i = min; i < max; i++) {
			int reversei = max - i + layer;
			int tmp = matrix[layer][i];
			matrix[layer][i] = matrix[reversei][layer];
			matrix[reversei][layer] = matrix[max][reversei];
			matrix[max][reversei] = matrix[i][max];
			matrix[i][max] = tmp;
		}
		
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 2, 3, 4},
				{ 5, 6, 7, 8},
				{ 9, 10, 11, 12},
				{ 13, 14, 15, 16}
		};
		
		rotate(matrix);		

		int size = matrix[0].length;		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		
	
	}
}
