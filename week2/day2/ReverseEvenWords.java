package week2.day2;

public class ReverseEvenWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "I am a software tester";
		String[] split = test.split("\\s");

		char [] cA;

		for (int i = 0; i < split.length; i++) 
		{
			if(i%2==1) {
				 cA = split[i].toCharArray();
				for (int j = 0;j<cA.length;i++)
				{
					cA[j]=cA[(cA.length-1)-j];
					System.out.print(cA[j]);
					System.out.print(" ");
				}
				
				
				
				
			}else
			{
				cA = split[i].toCharArray();
				System.out.print(cA);
				System.out.print(" 2nd");
				
			}
			
			//System.out.println(String.valueOf(cA));
			
		}

	}

}
