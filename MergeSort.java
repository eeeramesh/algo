￼

/*
Properties
    Stable
    Θ(n) extra space for arrays (as shown)
    Θ(lg(n)) extra space for linked lists
    Θ(n·lg(n)) time  - refer to page 15 in MergeSort.pdf
    Not adaptive
    Does not require random access to data
*/



public class MergeSort {￼

	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo) return;   // recursion exit condition
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}


	//a - original array with sorted subarray , aux - auxillary array 
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid); // precondition: a[lo..mid]   sorted
		assert isSorted(a, mid + 1, hi); // precondition: a[mid+1..hi] sorted
		

		for (int k = lo; k <= hi; k++) //copy from original array (sorted subarray) to auxillary array
			aux[k] = a[k];

		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) //merge
		{
			if (i > mid) 					a[k] = aux[j++];
			else if (j > hi) 				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))  a[k] = aux[j++];
			else 							a[k] = aux[i++];
		}

		assert isSorted(a, lo, hi); // postcondition: a[lo..hi] sorted
	}

/*
Practical improvements

Use insertion sort for small subarrays.
・Mergesort has too much overhead for tiny subarrays. (no recursion stack overhead - so runtime improves)
・Cutoff to insertion sort for ≈ 7 items.
*/
￼
private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
	if (hi <= lo + CUTOFF - 1) {
		Insertion.sort(a, lo, hi);
		return;
	}
	int mid = lo + (hi - lo) / 2;
	sort(a, aux, lo, mid);
	sort(a, aux, mid + 1, hi);
	merge(a, aux, lo, mid, hi);
}


/*
Stop if already sorted.
・Is biggest item in first half ≤ smallest item in second half? 
・Helps for partially-ordered arrays.
*/	
￼
private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
{
   if (hi <= lo) return;
   int mid = lo + (hi - lo) / 2;
   sort (a, aux, lo, mid);
   sort (a, aux, mid+1, hi);
   if (!less(a[mid+1], a[mid])) return; //Stop if already sorted
   merge(a, aux, lo, mid, hi);
}

/*
Eliminate the copy to the auxiliary array. Save time (but not space)
by switching the role of the input and auxiliary array in each recursive call.
*/
￼
private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
{
   int i = lo, j = mid+1;
   for (int k = lo; k <= hi; k++)
	{
      if      (i > mid)          aux[k] = a[j++];//merge from a[] to aux[]
      else if (j > hi)           aux[k] = a[i++];
      else if (less(a[j], a[i])) aux[k] = a[j++];
      else                       aux[k] = a[i++];
	}	
}

private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
{
   if (hi <= lo) return;
   int mid = lo + (hi - lo) / 2;
   sort (AUX, a, lo, mid);		//Note: sort(a) initializes aux[] and sets aux[i] = a[i] for each i.
   sort (AUX, a, mid+1, hi);
   merge(a, AUX, lo, mid, hi);	//switch roles of aux[] and a[]
}