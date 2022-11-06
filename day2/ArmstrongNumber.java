package week1.day2;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int num =371
				;
		int sum=0;
		int input = num;
		while (input>0)
		{
			int rem = input%10;
			 sum =sum +( rem *rem*rem);
			input = input/10;
		}
		System.out.println(sum);
		if(num ==sum)
			System.out.println("It is Amstrong number");
		else
			System.out.println("It is not an amstrong number");
		
		
	}

}
