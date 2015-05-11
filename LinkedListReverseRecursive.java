class Node<T>
{
    Node<T> next;
    public T data;
}

class LinkedList<T>
{
    Node<T> head = null;

    public void Reverse()
    {
        if (head != null)
            head = RecursiveReverse(null, head);
    }

    private Node<T> RecursiveReverse(Node<T> prev, Node<T> curr)
    {
        Node<T> next = curr.next;
        curr.next = prev;
        return (next == null) ? curr : RecursiveReverse(curr, next);
    }
}