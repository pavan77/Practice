package jpractice;

public class LinkedList<E> {

	Node head;

	void add(E data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node cNode = head;
			Node pNode = null;
			while (cNode != null) {
				pNode = cNode;
				cNode = cNode.next;
			}

			pNode.next = newNode;
		}
	}

	LinkedList<E> copyList() {
		LinkedList<E> newList = new LinkedList<>();
		Node cNode = head;
		while (cNode != null) {
			newList.add(cNode.data);
			cNode = cNode.next;
		}
		return newList;
	}

	class Node {
		Node next;
		E data;

		Node(E data) {
			this.data = data;
		}

	}
}
