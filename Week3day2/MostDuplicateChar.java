package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MostDuplicateChar {

	public static void main(String[] args) {
		
		String s = "abbabab";
		char[] cA = s.toCharArray();
		
		Map<Character, Integer> mp = new HashMap<Character,Integer>();
		
		for (int i = 0; i < cA.length; i++) {
			
			mp.put(cA[i], mp.getOrDefault(cA[i], 0)+1);
			
		}
		List<Integer> li = new ArrayList<Integer>();
		Set <Entry<Character,Integer>> entrySet=mp.entrySet();
		
		for (Entry<Character, Integer> entry : entrySet) {
			li.add(entry.getValue());
		}
		Integer max = Collections.max(li);
		System.out.print("Maximum Occurance :");
		for (Entry<Character, Integer> entry : entrySet) {
			if(entry.getValue()==max)
			{
				System.out.print(entry.getKey());
				System.out.print(" ");
			}
				
		}
		
		
		
		

	}

}
