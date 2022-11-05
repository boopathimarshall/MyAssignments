package week1.day1;

public class Mobile {

	String mobileBrandName = "VIVO";
	char mobileLogo ='V';
	short noOfMobilePiece =5;
	int modelNumber = 50;
	long mobileImeiNumber = 123123123123l;
	float mobilePrice = 9999.99f;
	boolean isDamaged =false;
	public static void main(String[] args) {
		
		Mobile mb = new Mobile();
System.out.println(mb.mobileBrandName);
System.out.println(mb.mobileLogo);
System.out.println(mb.noOfMobilePiece);
System.out.println(mb.modelNumber);
System.out.println(mb.mobileImeiNumber);
System.out.println(mb.mobilePrice);
System.out.println(mb.isDamaged);


	}

}
