package com.ds.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringCountCharactersAndReplacewithCount {

	public static void main(String[] args) {
		
		String s ="ABBBCCDDDDEEEEF"; //AB3C2D4E4F
		int len = s.length();
		Map<Character, Integer> dupMap = new HashMap<Character, Integer>();
		
		for(int i=0 ; i< len ; i++) {
			char c = s.charAt(i);
			
			if(dupMap.get(c) != null) 
				dupMap.put(c, dupMap.get(c)+1);
			else
				dupMap.put(c,1);
		}
	
		StringBuffer sb = new StringBuffer();
		
		Set<Character> keys = dupMap.keySet();
		
		for(char c : keys) {
			int count = dupMap.get(c);
			if(count >1) {
			   
			    sb.append(c);
				sb.append(count);
				continue;
			}
			sb.append(c);
		}
		  
		System.out.println(sb.toString());
		
	}
	
}
