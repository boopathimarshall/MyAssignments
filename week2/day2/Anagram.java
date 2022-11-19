package week2.day2;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {

		String a = "stops";
		String b = "Wespot";
		int count = 0;

		char[] cA = a.toCharArray();
		char[] cB = b.toCharArray();

		Arrays.sort(cA);
		Arrays.sort(cB);

		if (cA.length == cB.length) {
			for (int i = 0; i < cA.length; i++) {
				if (cA[i] == cB[i]) {
					count++;
				} else {
					System.out.println(" Same sized text but not a Anagram");
					break;
				}
			}
			if (count == cA.length)
				System.out.println("IT is Anagram");

		} else {
			System.out.println("Two words length are different and so Not a Anagram");
		}

	}

}
