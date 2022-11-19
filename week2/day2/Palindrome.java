package week2.day2;

public class Palindrome {

	public static void main(String[] args) {

		String s = "malayalam";
		char[] cA = s.toCharArray();
		char[] rV = new char[cA.length];

		for (int i = 0; i < cA.length; i++) {
			rV[i] = cA[(cA.length - 1) - i];

		}

		String rev = String.valueOf(rV);
		System.out.println("Giver word : " + s);
		System.out.println("Reversed word : " + rev);

		if (s.equalsIgnoreCase(rev)) {
			System.out.println("It is Palindrome");
		} else
			System.out.println("IT is not a palindrome");

	}

}
