/*
Algorithm - ↑ scans from left to right.
Invariants -
・Entries the left of ↑ (including ↑) fixed and in ascending order. 
・No entry to right of ↑ is smaller than any entry to the left of ↑.

Properties -
Not stable (Long-distance exchange might move an item past some equal item)
O(1) extra space
Θ(n2) comparisons
Θ(n) swaps 

Built-in comparable types. Integer, Double, String, Date, File, ... 
User-defined comparable types. Implement the Comparable interface.

*/

public class SelectionSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++)
				if (less(a[j], a[min])) 
					min = j;
			exch(a, i, min);
		}
	}

	￼
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