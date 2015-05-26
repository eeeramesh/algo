￼import java.util.Iterator;

public class FixedCapacityStackGenericsWithIterator<Item> implements Iterable<Item> {
	private Item[] s;
	private int N = 0;
	public FixedCapacityStackGenericsWithIterator(int capacity) {
		s = (Item[]) new Object[capacity]; //generic array creation not allowed in Java - "new Item[capacity]" 
	}
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	private class ReverseArrayIterator implements Iterator<Item> { //implements Iterator
		private int i = N;
		public boolean hasNext() {
			return i > 0;
		}
		public void remove() { /* not supported */
		}
		public Item next() {
			return s[--i];
		}
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public void push(Item item) {
		s[N++] = item;
	}
	public Item pop() {
		return s[--N];
	}
}