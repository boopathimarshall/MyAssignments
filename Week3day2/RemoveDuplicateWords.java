package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateWords {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		String[] split = text.split(" ");

		Set<String> rmvDp = new LinkedHashSet<String>();

		for (int i = 0; i < split.length; i++) {
			rmvDp.add(split[i]);

		}	
		String string = rmvDp.toString();
		String replace = string.replace(",", "").replace("[","").replace("]","");
		System.out.println(replace);
	}

}
