package interview.ccti.recursionanddp;

public class MagicIndex {
	
	public static int findMagicIndexNoDups(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		
		while(low <= high) {
			int mid = (high + low)/2;
			//System.out.println(mid + " " + low + " " + high);
			if(arr[mid] == mid) {
				return mid;
			}
			if(arr[mid] < mid) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
	
	public static int findMagicIndexDups(int[] arr) {				
		return findMagicIndexDups(arr, 0, arr.length - 1);
	}
	
	public static int findMagicIndexDups(int[] arr, int low, int high) {
		if(low > high) {
			return -1;
		}
		
		int mid = (low + high)/2;
		if(arr[mid] == mid) {
			return mid;
		}
		
		//System.out.println(low + " " + mid + " " + high);
		int res = -1;
		if(arr[mid] < mid) {
			//search right
			int start = Math.max(arr[mid], mid + 1);
			res = findMagicIndexDups(arr, start, high);
		} 
		if(res == -1) {
			//search left
			int end = Math.min(arr[mid], mid - 1);
			res = findMagicIndexDups(arr, low, end);
		}
		return res;
				
	}
	
	public static void main(String[] args) {
		int[] arr1 = { -1, -3, 0, 3, 5, 6 };
		int[] arr2 = { 0, 0, 0, 2, 3, 3 };
		
		System.out.println(findMagicIndexNoDups(arr1));
		System.out.println(findMagicIndexNoDups(arr2)); //returns incorrect result
		System.out.println();
		System.out.println(findMagicIndexDups(arr1));
		System.out.println(findMagicIndexDups(arr2));
		
	}
}
