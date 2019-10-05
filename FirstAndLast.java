class Demo {
	public static void main(String[] args) {
		int arr[] = {2, 3, 3, 3, 4, 6, 8, 9, 10, 23, 34, 45, 67, 67};
		System.out.println(binSearchFirst(arr, 3));
		System.out.println(binSearchLast(arr, 3));	
	}

	public static int binSearchFirst(int arr[], int key) {
		int l = 0;
		int r = arr.length-1;
		while (l<=r) {
			int mid = l + (r-l)/2;
			if (arr[mid] == key){
				if (mid == 0)
					return mid;
				else if (arr[mid] == arr[mid-1])
					r = mid-1;
				else
					return mid;
			}
			else if (arr[mid] > key)
				r = mid-1;
			else
				l = mid+1;
		}
		return -1;
	}
