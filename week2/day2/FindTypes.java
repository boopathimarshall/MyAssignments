package week2.day2;

public class FindTypes {

	public static void main(String[] args) {
		String test = "$$ Welcome to 2nd Class of Automation $$ ";

		char[] cA = test.toCharArray();
		int alpha = 0, space = 0, num = 0, spl = 0;

		for (int i = 0; i < cA.length; i++) {

			if (Character.isLetter(cA[i])==true)
				alpha++;
			else if (Character.isDigit(cA[i])==true)
				num++;
			else if (Character.isSpaceChar(cA[i])==true)
				space++;
			else 
				
				spl++;


		}
		System.out.println( "You have " +alpha+" letters");
		System.out.println( "You have " +num+" numbers");
		System.out.println( "You have " +space+" spaces");
		System.out.println( "You have " +spl+" specials");
	}

}
