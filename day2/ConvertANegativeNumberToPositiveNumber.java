package week1.day2;

public class ConvertANegativeNumberToPositiveNumber {

	public static void main(String[] args) {
	
		
		int num = 30;
		
		if (num<0)
		{
			num = num*(-1);
			System.out.println("Converted number :"+num);
		}
		else
			System.out.println("It is Positive number"+num);
		
		
		

	}

}
