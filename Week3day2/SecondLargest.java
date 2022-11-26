package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SecondLargest {

	public static void main(String[] args) {

		int[] data = { 3, 2, 11, 4, 6, 7, 2, 3, 3, 6, 7 };

		Set<Integer> set = new TreeSet<Integer>();

		for (int i = 0; i < data.length; i++) {
			set.add(data[i]);

		}

		List<Integer> li = new ArrayList<Integer>();

		li.addAll(set);

		System.out.println("Orignial List : " + li);
		System.out.println(" Second largest : " + li.get(li.size() - 2));

	}

}
