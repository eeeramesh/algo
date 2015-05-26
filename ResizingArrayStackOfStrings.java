￼
/*
Efficient solution.
・push(): double size of array s[] when array is full.
・pop(): halve size of array s[] when array is one-quarter full (one-half full Too expensive in worst case).
*/

public class ResizingArrayStackOfStrings {
   private String[] s;
   private int N = 0;

   ￼public ResizingArrayStackOfStrings() {
      s = new String[1]; //size 1 - client wont pass size
   }
   public boolean isEmpty() {
      return N == 0;
   }

   public void push(String item) {
      if (N == s.length) resize(2 * s.length); //resize
      s[N++] = item;
   }

   private void resize(int capacity) {
      String[] copy = new String[capacity];
      for (int i = 0; i < N; i++)
      copy[i] = s[i];
      s = copy;
   }

   public String pop() {
      String item = s[--N];
      s[N] = null;
      if (N > 0 && N == s.length / 4) resize(s.length / 2); //resize
      return item;
   }
}