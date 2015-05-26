￼import java.util.Iterator;

public class StackGenericsWithIterator<Item> implements Iterable<Item> {//all String replaced with Item, implements Iterable
   private Node first = null;
   private class Node {
      Item item;
      Node next;
   }
   public Iterator<Item> iterator() {
      return new ListIterator();
   }
   private class ListIterator implements Iterator<Item> {//implements Iterator
      private Node current = first;
      public boolean hasNext() {
         return current != null;
      }
      public void remove() { /* not supported */
      }
      public Item next() {￼￼//throw NoSuchElementException
         Item item = current.item;
         current   = current.next;
         return item;
      }
   }
   public boolean isEmpty() {
      return first == null;
   }
   public void push(Item item) {
      Node oldfirst = first;
      first = new Node();
      first.item = item;
      first.next = oldfirst;
   }
   public Item pop() {
      Item item = first.item;
      first = first.next;
      return item;
   }
}