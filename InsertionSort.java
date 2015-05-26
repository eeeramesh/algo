/*
Algorithm - ↑ scans from left to right.
Invariants -
・Entries the left of ↑ (including ↑) are in ascending order. 
. Entries to the right of ↑ have not yet been seen

Properties -
    Stable (Equal items never move past each other)
    O(1) extra space
    O(n2) comparisons and swaps
    Adaptive: O(n) time when nearly sorted
    Very low overhead

*/￼

public class InsertionSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {//Move the pointer to the right
			for (int j = i; j > 0; j--) {//Moving from right to left, exchange a[i] with each larger entry to its left
				if (less(a[j], a[j-1])) 
					exch(a, j, j-1);
				else break;
			}
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


public class InsertionSortUsingComparator {
	￼
	public static void sort(Object[] a, Comparator comparator) //Use Object instead of Comparable
	{
	   int N = a.length;
	   for (int i = 0; i < N; i++)
	      for (int j = i; j > 0 && less(comparator, a[j], a[j-1]); j--)
	         exch(a, j, j-1);
	}
	private static boolean less(Comparator c, Object v, Object w) {
		return c.compare(v, w) < 0;
	}
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}

class ObjectComparator implements Comparator {
	@override
	public int compare(Object v, Object w)
   {  
   	return v.name.compareTo(w.name);  
   }
}