￼
/*
Knuth shuffle
￼・In iteration i, pick integer r between 0 and i uniformly at random.
￼・Swap a[i] and a[r].
common bug: between 0 and N – 1 
correct variant: between i and N – 1
*/
public class Shuffle
{
   ...
   public static void shuffle(Object[] a)
   {
      int N = a.length;
      for (int i = 0; i < N; i++)
      {
         int r = StdRandom.uniform(i + 1);//between 0 and i
         exch(a, i, r);
         }
	} 
}
