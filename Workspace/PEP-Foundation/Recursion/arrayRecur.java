package Recursion;

import java.util.ArrayList;

public class arrayRecur {

	public static void main(String[] args) {
		int[] arr = { 11, 55, 22, 2, 33, 55, 11, 23, 55 };
		display(arr, 0);
		System.out.println();
		displayr(arr, 0);
		System.out.println();
		System.out.println(max(arr, 0));
		System.out.println(find(arr, 0, 3));
		System.out.println(fi(arr, 0, 55));
		System.out.println(li(arr, 0, 55));
		System.out.println(lastIndex(arr, 55, 0));
		int[] indices = ai(arr, 0, 55, 0);
		for (int element : indices) {
			System.out.print(element + " ");
		}
		System.out.println();
		System.out.println(allIdxArrayList(arr, 0, 55, 0));
		System.out.println();
		int[] arr_sort = { 2, 3, 5, 1, 4 };
		// bubbleSortRecursiveAlter(arr_sort, 0, 0);
		sortArr(arr_sort, 0, 0);
		for (int element : arr_sort) {
			System.out.print(element + " ");
		}
		System.out.println();
		printPattern1(0, 0, 3);
		printPattern2(0, 0, 3);
		printPat2(0, 3);
	}

	private static void display(int[] arr, int si) {
		if (si == arr.length) {
			return;
		}
		System.out.print(arr[si] + " ");
		display(arr, si + 1);
	}

	private static void displayr(int[] arr, int si) {
		if (si == arr.length) {
			return;
		}
		display(arr, si + 1);
		System.out.print(arr[si] + " ");
	}

	private static int max(int[] arr, int si) {
		if (si == arr.length - 1) {
			return arr[si];
		}
		int m = max(arr, si + 1);
		return Math.max(m, arr[si]);
	}

	private static boolean find(int[] arr, int si, int val) {
		if (si == arr.length) {
			return false;
		}
		if (arr[si] == val) {
			return true;
		}
		boolean isPresent = find(arr, si + 1, val);
		return isPresent;
	}

	private static int fi(int[] arr, int si, int val) {
		if (si == arr.length) {
			return -1;
		}
		if (arr[si] == val) {
			return si;
		}
		int idx = fi(arr, si + 1, val);
		return idx;
	}

	private static int li(int[] arr, int si, int val) {
		if (si == arr.length) {
			return -1;
		}
		int idx = li(arr, si + 1, val);
		if (idx != -1) {
			return idx;
		} else {
			if (arr[si] == val) {
				return si;
			} else {
				return -1;
			}
		}
	}

	public static int[] ai(int[] arr, int si, int val, int count) {
		int[] ans = null;
		if (si == arr.length) {
			ans = new int[count];
			return ans;
		}
		if (arr[si] == val) {
			count++;
		}
		ans = ai(arr, si + 1, val, count);
		if (arr[si] == val) {
			ans[count - 1] = si;
		}
		return ans;
	}

	public static int lastIndex(int[] arr, int element, int currentIndex) {
		if (currentIndex == arr.length) {
			return -1;
		}
		int rr = lastIndex(arr, element, currentIndex + 1);
		if (rr == -1) {
			// Not found so far
			if (arr[currentIndex] == element) {
				return currentIndex;
			} else {
				return -1;
			}
		} else {
			// We have found it , keep on returning that result
			return rr;
		}
	}

	// All index revisited - MY WAY : Post work 

	public static ArrayList<Integer> allIdxArrayList(int[] arr, int idx, int element, int count) {
		if (idx == arr.length) {
			ArrayList<Integer> br = new ArrayList<>(count);
			for (int i = 0; i < count; i++) {
				br.add(0);
			}
			return br;
		}
		ArrayList<Integer> rr = null;
		if (arr[idx] == element) {
			rr = allIdxArrayList(arr, idx + 1, element, count + 1);
			rr.set(count, idx);
			// rr.add(index);
			return rr;
		} else {
			rr = allIdxArrayList(arr, idx + 1, element, count);
			return rr;
		}
	}

	public static int[] allIdxArray(int[] arr, int idx, int element, int count) {
		if (idx == arr.length) {
			int[] br = new int[count];
			return br;
		}
		int[] rr;
		if (arr[idx] == element) {
			rr = allIdxArray(arr, idx + 1, element, count + 1);
			rr[count] = idx;
			return rr;
		} else {
			rr = allIdxArray(arr, idx + 1, element, count);
			return rr;
		}
	}

	public static void bubbleSortRecursiveAlter(int[] arr, int i, int count) {
		if (count == arr.length) {
			return;
		}
		if (i == arr.length - count - 1) {
			bubbleSortRecursiveAlter(arr, 0, count + 1);
			return;
		}
		if (arr[i] > arr[i + 1]) {
			arr[i + 1] = arr[i + 1] ^ arr[i];
			arr[i] = arr[i + 1] ^ arr[i];
			arr[i + 1] = arr[i + 1] ^ arr[i];
		}
		bubbleSortRecursiveAlter(arr, i + 1, count);
	}

	// Sort array - Revisited (Pre work)

	public static void sortArr(int[] arr, int i, int iterNum) {
		if (iterNum == arr.length) {
			return;
		}
		if (i == arr.length - iterNum - 1) {
			sortArr(arr, 0, iterNum + 1);
			return;
		}
		if (arr[i] > arr[i + 1]) {
			arr[i + 1] = arr[i + 1] ^ arr[i];
			arr[i] = arr[i + 1] ^ arr[i];
			arr[i + 1] = arr[i + 1] ^ arr[i];
		}
		sortArr(arr, i + 1, iterNum);
	}

	public static void printPattern1(int r, int c, int n) {
		if (n == 0) {
			return;
		}
		if (c == r + 1) {
			System.out.println();
			printPattern1(r + 1, 0, n - 1);
			return;
		}
		System.out.print("*\t");
		printPattern1(r, c + 1, n);
	}

	public static void printPattern2(int r, int c, int n) {
		if (n == 0) {
			return;
		}
		if (c == n) {
			System.out.println();
			printPattern2(r + 1, 0, n - 1);
			return;
		}
		System.out.print("*\t");
		printPattern2(r, c + 1, n);
	}

	// Print pattern 3 , 2 ,1
	public static void printPat2(int c, int n) {
		if (n == 0) {
			return;
		}
		if (c == n) {
			System.out.println();
			printPat2(0, n - 1); // No use of r here
			return;
		}
		System.out.print("* ");
		printPat2(c + 1, n);
	}

}
