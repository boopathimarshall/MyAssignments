package week1.day1;

public class TwoWheeler {

	int noOfWheels = 2;

	short noOfMirrors = 2;
	long chassisNumber =3210092819l;
	boolean isPunctured = false;
	String bikeName ="Royal Enfield";
	double runningKM = 34567.5;
	
	public static void main(String[] args) {
		TwoWheeler tw = new TwoWheeler();
		
		System.out.println(tw.noOfWheels);
		System.out.println(tw.chassisNumber);
		System.out.println(tw.isPunctured);
		System.out.println(tw.bikeName);
		System.out.println(tw.runningKM);

	}

}
