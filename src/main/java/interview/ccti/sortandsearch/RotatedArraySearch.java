package interview.ccti.sortandsearch;

public class RotatedArraySearch {
	
	public static void main(String[] args) {
		int arr1[] = { 20, 25, 0, 5, 15, 17 };
		int arr2[] = { 5, 15, 17, 20, 25, 0 };
		int arr3[] = { 5, 5, 15, 20, 5, 5 };
		
		int posn1 = find(arr1, 15);
		System.out.println(posn1);
		
		int posn2 = find(arr2, 15);
		System.out.println(posn2);
		
		int posn3 = find(arr2, 12);
		System.out.println(posn3);
		
		int posn4 = find(arr3, 20);
		System.out.println(posn4);
	}

	private static int find(int[] arr, int key) {
		
		return find(arr, key, 0, arr.length - 1);
	}

	private static int find(int[] arr, int key, int low, int high) {
			
		if(low > high) {
			return -1;
		}
		
		int mid = (low + high)/2;
		System.out.println(low + " " + mid + " " + high);
		
		if(arr[mid] == key) {
			return mid;
		}
		
		
		if(arr[low] <= arr[mid]) { //left side is ok
			if(key < arr[mid]) {
				return find(arr, key, low, mid - 1);
			} else {
				return find(arr, key, mid + 1, high);
			}
		} else if(arr[low] > arr[mid]) { //right is ok
			if(key > arr[mid]) {
				return find(arr, key, mid +1, high);
			} else {
				return find(arr, key, low, mid - 1);
			}
		} 
		//else if(arr[mid]  )
		
		
		
		
		return -1;
	}

}
