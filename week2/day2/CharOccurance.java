package week2.day2;

public class CharOccurance {

	public static void main(String[] args) {
		String str = "welcomee to chennai";

		char[] newChararray = str.toCharArray();

		int count = 0;

		for (int i = 0; i < newChararray.length; i++) {
			if (newChararray[i] == 'e')
				count++;
		}
		System.out.println("'e' appeared  " + count + " times");

	}

}
