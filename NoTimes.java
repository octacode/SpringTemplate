class Demo {
	public static void main(String[] args) {
		int arr[] = new int[]{2, 6, 8, 10, 13, 24, 48, 60, 78, 80};
		System.out.println(binSearch(arr));
	}

	public static int binSearch(int arr[]) {
		int l = 0;
		int r = arr.length-1;
		while (l<=r) {
			int mid = l+(r-l)/2;
			if (mid == 0 || mid==arr.length-1)
					return mid;
			else if (arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1])
				return mid;
			else if (arr[mid] > arr[r])
				l = mid+1;
			else
				r = mid-1;
		}
		return -1;
	}
}
