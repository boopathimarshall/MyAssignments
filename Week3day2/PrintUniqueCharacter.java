package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class PrintUniqueCharacter {

	public static void main(String[] args) {

		String name = "Boopathi varma";

		char[] cA = name.toCharArray();

		Set<Character> set = new LinkedHashSet<Character>();

		for (Character character : cA) {
			set.add(character);

		}
		System.out.println(set);

	}

}
