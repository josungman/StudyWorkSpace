package chapter15.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx1 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(99);
		set.add(33);
		set.add(22);

		System.out.println("size:" + set.size());

		for (Integer a : set) {
			System.out.println(a);
		}

		System.out.println();

		set.add(99);
		System.out.println("size:" + set.size());

		for (Integer a : set) {
			System.out.println(a);
		}

	}
}
