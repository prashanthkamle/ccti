package interview.ccti.recursionanddp;

import java.util.ArrayList;
import java.util.List;

public class Queens {
	public static void main(String[] args) {
		List<Integer[]> queenPosns = placeQueens(4);
		
		for(Integer[] posns : queenPosns) {
			for(Integer p : posns) {
				for(int i = 0; i < posns.length; i++) {
					if(i == p) {
						System.out.print("Q ");
					} else {
						System.out.print("X ");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	private static List<Integer[]> placeQueens(int gridSize) {
		
		ArrayList<Integer[]> result = new ArrayList<>();
		
		placeQueens(gridSize, 0, new Integer[gridSize], result);
		
		return result;
	}

	private static void placeQueens(int gridSize, int rowNum, Integer[] currGrid, ArrayList<Integer[]> result) {
		if(rowNum == gridSize) {
			result.add(currGrid.clone());
		}
		
		for(int c = 0; c < gridSize; c++) {
			if(canPlace(currGrid, rowNum, c)) {
				currGrid[rowNum] = c;
				placeQueens(gridSize, rowNum + 1, currGrid, result);
			}
		}
		
	}

	private static boolean canPlace(Integer[] currGrid, int row1, int col1) {
		
		for(int row2 = 0; row2 < row1; row2++) {
			int col2 = currGrid[row2];
			
			if(col1 == col2) {
				return false;
			}
			
			int colDiff = Math.abs(col1 - col2);
			int rowDiff = row1 - row2;
			
			if(rowDiff == colDiff) {
				return false;
			}
		}
		
		return true;
	}


}
