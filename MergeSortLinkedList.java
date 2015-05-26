

class MergeSortLinkedList {

	public Node mergeSort(Node head) {

		if (head == null) return null;

		if (head.next == null) return head;

		Node first = head;
		Node mid = findMiddle(first);
		Node second = mid.next;
		mid.next = null;
		Node left = mergeSort(first);
		Node right = mergeSort(second);
		Node result = merge(left, right);
		return result;

	}

	public Node findMiddle(Node head) {
		if (head == null) return null;

		Node slow, fast;
		slow = head;
		fast = head;

		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;

	}

	public Node merge(Node first, Node second) {

		Node head = null;
		while (first != null && second != null) {

			if (first.data < second.data) {
				if (head == null) {
					head = new Node(first.data);
				} else head.append(head, first.data);
				first = first.next;
			} else if (second.data < first.data) {
				if (head == null) {
					head = new Node(second.data);
				} else head.append(head, second.data);
				second = second.next;
			} else {
				if (head == null) {
					head = new Node(first.data);
					head.append(head, second.data);
				} else {
					head.append(head, first.data);
					head.append(head, second.data);
				}
				second = second.next;
				first = first.next;
			}
		}
		while (first != null) {
			if (head == null) {
				head = new Node(first.data);
			} else head.append(head, first.data);
			first = first.next;
		}
		while (second != null) {
			if (head == null) {
				head = new Node(second.data);
			} else head.append(head, second.data);
			second = second.next;
		}


		return head;
	}

	

	public static void main(String[] args) throws java.lang.Exception {
		Node head = new Node(5);
		head.append(head, 1);
		head.append(head, 5);
		head.append(head, 1);
		head.append(head, 5);
		head.append(head, 3);
		System.out.println("Unsoreted linked list:");
		head.display();
		MergeSortLinkedList tmp = new MergeSortLinkedList();
		Node result = tmp.mergeSort(head);
		System.out.println("\nSorted linked list:");
		result.display();
	}
}


class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}

	void append(Node head, int val) {
		Node temp = new Node(val);
		Node cur = head;

		if (head == null) {
			return;
		}
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = temp;
		return;

	}

	void display() {

		Node cur = this;
		while (cur != null) {
			System.out.print(cur.data + "->");
			cur = cur.next;
		}
	}
}