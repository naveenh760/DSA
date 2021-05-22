package datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class EasyProbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 
	public ArrayList<Integer> solve(ArrayList<Integer> A) {
		ArrayList<Integer> sorted = new ArrayList<Integer>(A);
		Collections.sort(sorted);
		sorted.remove(sorted.size() -1);
		sorted.remove(sorted.size() - 1);
		Set<Integer> set = new HashSet<Integer>();
		for(int num: sorted) {
			set.add(num);
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int num: A) {
			if(set.contains(num)) {
				ans.add(num);
			}
		}
		return ans;
    }

}
