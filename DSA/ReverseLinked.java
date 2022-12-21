package com.DSA;

import com.DSA.LL.Node;

public class ReverseLinked {

	Node head;
	private int size;

	public ReverseLinked() {
		size = 0;
	} 
	public class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
			this.next = null;
			size++;
		}
	}
	//	 above is the class for Node creation

	public void addFirst(String data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void addLast(String data) {
		Node newNode = new Node(data);

		if(head == null) {
			head = newNode;
			return;
		}

		Node lastNode = head;
		while(lastNode.next != null) {
			lastNode = lastNode.next;
		}

		lastNode.next = newNode;
	}

	public void printList() {
		Node currNode = head;

		while(currNode != null) {
			System.out.print(currNode.data+" -> ");
			currNode = currNode.next;
		}

		System.out.println("null");
	}

	public void removeFirst() {
		if(head == null) {
			System.out.println("Empty List, nothing to delete");
			return;
		}

		head = this.head.next;
		size--;
	}

	public void removeLast() {
		if(head == null) {
			System.out.println("Empty List, nothing to delete");
			return;
		}

		size--;
		if(head.next == null) {
			head = null;
			return;
		}

		Node currNode = head;
		Node lastNode = head.next;
		while(lastNode.next != null) {
			currNode = currNode.next;
			lastNode = lastNode.next;
		}

		currNode.next = null;
	}


	public int getSize() {
		return size;
	}

	//	   Adding value in middle
	public void addInMiddle(int index, String data) {
		if(index > size || index < 0) {
			System.out.println("Invalid Index value");
			return;
		}
		size++;

		Node newNode = new Node(data);
		if(head == null || index == 0) {
			newNode.next = head;
			head = newNode;
			return;
		}
		Node currNode = head;
		for(int i=1; i<size; i++) {
			if(i == index) {
				Node nextNode = currNode.next;
				currNode.next = newNode;
				newNode.next = nextNode;
				break;
			}
			currNode = currNode.next;
		}
	}

	public void reverseList() {
		if(head == null || head.next == null) {
			return;
		}

		Node prevNode = head;
		Node currNode = head.next;
		while(currNode != null) {
			Node nextNode = currNode.next;
			currNode.next = prevNode;
			//	           update
			prevNode = currNode;
			currNode = nextNode;
		}
		head.next = null;
		head = prevNode;
	}

	public Node reverseListRecursive(Node head) {
		//empty node || last node or only one node
		if(head == null || head.next == null) {
			return head;
		}

		Node newHead = reverseListRecursive(head.next);

		head.next.next = head;
		head.next = null;
		return newHead;
	}



	public static void main(String[] args) {
		ReverseLinked list = new ReverseLinked();
		list.addLast("3");
		list.addLast("4");
		list.addLast("5");
		list.addFirst("1");
		list.addInMiddle(1, "2");
		list.printList();

		System.out.println();
		list.reverseList();
		list.printList();

		System.out.println();
		list.head = list.reverseListRecursive(list.head);
		list.printList();
	}

}
