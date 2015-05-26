￼
/*
Algorithm - Move entries more than one position at a time by h-sorting the array

Properties -
    Not stable (Long-distance exchanges)
    O(1) extra space
    O(n3/2) time as shown (see below)
    Adaptive: O(n·lg(n)) time when nearly sorted

Useful in practice.
・Fast unless array size is huge (used for small subarrays). 
・Tiny, fixed footprint for code (used in some embedded systems).
・Hardware sort prototype.
*/￼
public class ShellSort {
	public static void sort(Comparable[] a) {
		int N = a.length;

		int h = 1;
		//3x+1 increment sequence
		while (h < N / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, ...

		while (h >= 1) { // h-sort the array.
			for (int i = h; i < N; i++) {//insertion sort (h instead of 1)
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
				exch(a, j, j - h);
			}
			h = h / 3;//move to next increment
		}
	}
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	￼
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}

￼