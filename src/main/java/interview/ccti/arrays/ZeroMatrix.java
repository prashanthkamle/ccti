package interview.ccti.arrays;

/**
 * Question 1.7
 * @author prashanth
 *
 */
public class ZeroMatrix {
	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 2, 3, 4},
				{ 5, 0, 0, 8},
				{ 9, 10, 11, 12},
				{ 13, 14, 15, 0}
		};
		
		makeZero(matrix);

		int size = matrix[0].length;		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

	private static void makeZero(int[][] matrix) {
		int len = matrix[0].length;
		
		for(int i = 0; i < len; i++) {
			for(int j = i; j < len; j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;					
				}
			}
		}
		
		for(int i = 0; i < len; i++) {
			if(matrix[0][i] == 0) {
				for(int j = 0; j < len; j++) {
					matrix[j][i] = 0;
				}
			}
			if(matrix[i][0] == 0) {
				for(int j = 0; j < len; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
	}
}
