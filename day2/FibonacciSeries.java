package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		int num = 8;
		int firstNum=0;
		int secNum=1;
		int sum;
		
		System.out.println(firstNum);
		
		for (int i = 0; i <=num; i++) {
			
			sum = firstNum+secNum;
			firstNum =secNum;
			secNum =sum;
			System.out.println(sum);
		}
		
	}

}
