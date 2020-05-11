package datastructures.heap;

import java.util.PriorityQueue;

public class HeapProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	void nearlySorted(int arr[],int k){
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0 ; i <= k && i < n; i++) {
        	pq.add(arr[i]);
        }
        
        int index = 0;
        for(int i = k + 1; i < n;i++) {
        	arr[index++] = pq.poll();
        	pq.add(arr[i]);
        }
        while(!pq.isEmpty()) {
        	arr[index++] = pq.poll();
        }
    }

}
