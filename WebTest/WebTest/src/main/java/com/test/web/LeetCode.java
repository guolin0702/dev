package com.test.web;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class LeetCode {
	 public static int removeElement(int[] A, int elem) {  
	        int number = 0;  
	        for (int i = 0; i < A.length; i++) {  
	            if (A[i] != elem) {  
	                A[number++] = A[i];  
	            }  
	  
	        }  
	        return number;  
	    }  
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,5};
		int x = removeElement(nums, 5);
		System.out.println(x);
	}
}
