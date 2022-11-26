package week3.day2;

import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MissingNumber {

	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 6, 8, 9, 7, 10, 4 };

		List<Integer> li = new ArrayList<Integer>();

		for (int i = 0; i < num.length; i++) {
			li.add(num[i]);

		}
		Collections.sort(li);

		for (int j = 0; j < li.size(); j++) {
			int value = li.get(j);

			if (j == (value - 1)) {
				continue;
			} else {
				System.out.println("Missing number is " + (j + 1));
				break;
			}
		}

	}
}
