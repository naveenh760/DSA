package datastructures.hashtable;

import java.util.HashSet;

public class ArrayProbs {
	
	
 public static  boolean pairSumUnsorted(int arr[], int sum) {
	 HashSet<Integer> hashSet = new HashSet<Integer>();
	 for(int element: arr) {
		 if(hashSet.contains(sum - element)) {
			 return true;
		 }
		 hashSet.add(element);
	 }
	 return false;
 }

 
}
