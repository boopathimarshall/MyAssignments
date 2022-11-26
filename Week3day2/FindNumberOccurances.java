package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindNumberOccurances {

	public static void main(String[] args) {
		
	int[] num	= {2,3,5,6,3,2,1,4,2,1,6,-1,-1};
	
	Arrays.sort(num);
	
	Map<Integer, Integer> mp = new LinkedHashMap<Integer, Integer>();
	
	for (int i = 0; i < num.length; i++) {
		
		if(mp.containsKey(num[i]))
		{
			int val = mp.get(num[i]);
			mp.put(num[i], val+1);
			
		}
		else
		{
			mp.put(num[i], 1);
		}
		
	}
	System.out.println(mp);
	
	List<Integer> li = new ArrayList<Integer>();	
	Set<Entry<Integer, Integer>> entrySet = mp.entrySet();
	
	
	for (Entry<Integer, Integer> entry : entrySet) {
		System.out.println(entry);
		 li.add(entry.getValue());
		
	}
	Integer max = Collections.max(li);
	
	System.out.println("Highest occurance");
	for (Entry<Integer, Integer> entry : entrySet) {
		if(entry.getValue()==max)
		{
			System.out.print(entry.getKey());
			System.out.print(" ");
		}
	}
	
	
	
	
	

	}

}
