package com.DSA;
import java.util.*;

class CollectLinked {
	public static void main(String args[]) {
		LinkedList<String> list = new LinkedList<String>();
		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(1);
		list2.add(2);


		list.add("is");
		list.add("a");
		list.addLast("list");
		list.addFirst("this");
		list.add(3, "linked");
		System.out.println(list);

		System.out.println(list.get(0));
		System.out.println(list.size());   
		list.remove(3);
		list.removeFirst();
		list.removeLast();

		System.out.println(list);

		Collections.reverse(list2);
		System.out.println(list2);
	}
}
