package com.test.web;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class LeetCode {
	   public static boolean isAnagram(String s, String t) {
	        Map<Character, Integer> map = new HashMap<Character, Integer>();
	        for(int i =0;i< s.length(); i++)
	        {
	            if(map.containsKey(s.charAt(i)))
	            {
	            	int x = map.get(s.charAt(i)) + 1;
	                map.put(s.charAt(i), x);
	            }
	            else
	            {
	                map.put(s.charAt(i), 1);
	            }
	        }
	        
	        for(int j =0 ;j< t.length(); j++)
	        {
	            if(map.containsKey(t.charAt(j)))
	            {
	            	int x = map.get(t.charAt(j)) -1;
	                map.put(t.charAt(j), x);
	            }
	            else
	            {
	                return false;
	            }
	        }
	        
	        for(Character key: map.keySet())
	        {
	            if(map.get(key) != 0)
	            {
	                return false;
	            }
	        }
	        
	        return true;
	    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean x = isAnagram("aa", "a");
		System.out.println(x);
	}
}
