package BinarySearch;

public class T2_MountainPeek {

	public int peakIndexInMountainArray(int[] A) {
		int start = 0, end = A.length - 1;
		while (start < end) {
			int mid = (end + start) / 2;
			if (A[mid] > A[mid + 1]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;

	}
}
