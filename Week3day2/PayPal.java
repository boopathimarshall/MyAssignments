package week3.day2;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class PayPal {

	public static void main(String[] args) {

		String s = "PayPal India";

		char[] charArray = s.toCharArray();

		Set<Character> charSet = new LinkedHashSet<Character>();
		Set<Character> dupCharSet = new LinkedHashSet<Character>();

		for (int i = 0; i < charArray.length; i++) {

			if (charSet.contains(charArray[i])) {
				dupCharSet.add(charArray[i]);
			} else {
				charSet.add(charArray[i]);
			}

		}
		System.out.println("CharSet : " + charSet);
		System.out.println("duPCharSet : " + dupCharSet);

		boolean removeAll = charSet.removeAll(dupCharSet);
		charSet.remove(" ");
		String string = charSet.toString();
		String replace = string.replace(" ,","").replace(" ", "");
		
		System.out.println("After Removal : " + replace);
	}
}
