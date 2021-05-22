package solvingmethods.greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class Problems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] shipCompany(int A, int B, int[] C) {
		int maxMoney = 0;
		int minMoney = 0;
		int ans[] = new int[2];
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int number: C) {
			maxHeap.add(number);
			minHeap.add(number);
		}
		for(int i = 1; i <= A; i++) {
			int max = maxHeap.poll();
			maxMoney = maxMoney + max;
			maxHeap.add(max - 1);
			
			int min  = minHeap.poll();
			minMoney = minMoney + min;
			if(min - 1 > 0) {
				minHeap.add(min - 1);
			}
			
		}
		
		ans[0] = maxMoney;
		ans[1] = minMoney;
		return ans;
		
	}
	

}
