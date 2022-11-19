package week2.day2;

public class ReverseEvenWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "I am a software tester";
		String[] split = test.split("\\s");

	
	

		for (int i = 0; i < split.length; i++) 
		{
			char[] cA = split[i].toCharArray();
			char[] bA=new char[split[i].length()];
			char c;
			
			
			if(i%2==1)
			{
				
				for(int j =0;j<=split[i].length()-1;j++)
				{
					
					   c = cA[(split[i].length()-1)-j];
					   bA[j]=c;
				}
				String string = String.valueOf(bA);
				
				split[i]= string;	
			}
			
		}
		for(String var :split)
		{
			System.out.println(var);
		}
			
		}

	}
