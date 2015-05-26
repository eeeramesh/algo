￼
/*
Algorithm Basic plan.
・Shuffle the array. 
・Partition so that, for some j
	– entry a[j] is in place
	– no larger entry to the left of j
	– no smaller entry to the right of j
・Sort each piece recursively.

Properties -
    Not stable
    O(lg(n)) extra space 
    O(n2) time, but typically O(n·lg(n)) time
    Not adaptive


*/
public class QuickSort {

	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a); // shuffle needed because of worst case o(n2) for sorted array
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		while (true) {
			while (less(a[++i], a[lo])) //find item on left to swap
			if (i == hi) break;
			while (less(a[lo], a[--j])) //find item on right to swap
			if (j == lo) break;
			if (i >= j) break; //check if pointers cross
			exch(a, i, j); //swap
		}
		exch(a, lo, j); //swap with partitioning item
		return j; //return index of item now known to be in place
	}
	
}