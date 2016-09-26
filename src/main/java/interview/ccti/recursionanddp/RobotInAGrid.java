package interview.ccti.recursionanddp;

import java.util.ArrayList;
import java.util.List;

/**
 * Question 8.2
 * @author prashanth
 *
 */
public class RobotInAGrid {

	static class Point {
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "(" + r + "," + c + ")";
		}
	}

	private static boolean findPath(int[][] grid, Point p, List<Point> path) {
		
		if(p.r < 0 || p.c < 0 || grid[p.r][p.c] == -1) {
			return false;
		}
		System.out.println(p);
		boolean isOrigin = p.c == 0 && p.r == 0;
		
		Point up = new Point(p.r-1, p.c);
		Point left = new Point(p.r, p.c - 1);
		if(isOrigin || findPath(grid, up, path) || findPath(grid, left, path)) {
			path.add(p);
			return true;
		}
		
		return false;
	}
	
	private static List<Point> findPath(int[][] grid) {
		Point p = new Point(grid.length - 1, grid[0].length - 1);
		
		ArrayList<Point> path = new ArrayList<>();
		
		findPath(grid, p, path);
		return path;
	}
	
	public static void main(String[] args) {
		int[][] grid1 =  {
			{ 0, 0, -1, 0 },
			{ 0, 0, 0, 0 },
			{ -1, -1, -1, 0 }			
		};
		
		int[][] grid2 =  {
				{  0,  0,  0, 0 },
				{  0 , 0,  -1, 0 },
				{ -1 , 0,  -1, 0 },
				{ -1,  0,  -1, 0 }
			};
		
		List<Point> path1 = findPath(grid1);
		System.out.println(path1);
		
		List<Point> path2 = findPath(grid2);
		System.out.println(path2);
		
	}
	
}
