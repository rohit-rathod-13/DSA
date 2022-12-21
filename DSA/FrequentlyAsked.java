package com.DSA;

import java.util.*;

class FrequentlyAsked {

	static ListNode head;

	public class ListNode {
		String data;
		ListNode next;
		public Object val;

		ListNode(String data) {
			this.data = data;
			this.next = null;
		}
	}
	public void addFirst(String data) {
		ListNode newNode = new ListNode(data);
		newNode.next = head;
		head = newNode;
	}
	public void addLast(String data) {
		ListNode newNode = new ListNode(data);

		if(head == null) {
			head = newNode;
			return;
		}

		ListNode lastNode = head;
		while(lastNode.next != null) {
			lastNode = lastNode.next;
		}

		lastNode.next = newNode;
	}

	public void printList() {
		ListNode currNode = head;

		while(currNode != null) {
			System.out.print(currNode.data+" -> ");
			currNode = currNode.next;
		}

		System.out.println("null");
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head.next == null) {
			return null;
		}


		int size = 0;
		ListNode temp = head;
		while(temp != null) {
			temp = temp.next;
			size++;
		}

		//removing SIZEth node from last i.e. head
		if(n == size) {
			return head.next;
		}

		//find previous node
		int ptf = size - n; // position to find
		ListNode prev = head; // previous node
		int cp = 1; // current position

		while(cp != ptf) {
			prev = prev.next;
			cp++;
		}

		prev.next = prev.next.next;
		return head;
	}

	//	palindrome 
	public static ListNode getMiddle(ListNode head) {
		ListNode hare = head;
		ListNode turtle = head;
		while (hare.next != null && hare.next.next != null) {
			hare = hare.next.next;
			turtle = turtle.next;
		}
		return turtle;
	}


	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}


	public static boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) {
			return true;
		}

		ListNode firstHalfEnd = getMiddle(head);
		ListNode secondHalfStart = reverse(firstHalfEnd.next);
		ListNode firstHalfStart = head;

		while(secondHalfStart != null) {
			if(secondHalfStart.val != firstHalfStart.val) {
				return false;
			}
			secondHalfStart = secondHalfStart.next;
			firstHalfStart = firstHalfStart.next;
		}

		return true;
	}

	//	detecting cycle
	public static boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if(fast == slow) {
				return true;
			}
		}

		return false;
	}



	public static void main(String[] args) {
		FrequentlyAsked list = new FrequentlyAsked();
		list.addLast("is");
		list.addLast("a");
		list.addLast("list");
		list.printList();

		list.addFirst("this");
		list.printList();

		removeNthFromEnd(head, 3);
		list.printList();

		isPalindrome(head);

		boolean cyc=hasCycle(head);
		System.out.println(cyc);
	}

}
