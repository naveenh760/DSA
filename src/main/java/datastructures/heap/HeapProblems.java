package datastructures.heap;

import java.util.ArrayList;
import java.util.Collections;
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
	
	int maxItems(int[] arr, int sum) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int item: arr) {
			minHeap.add(item);
		}
		
		int totalItems = 0;
		while(!minHeap.isEmpty()) {
			int curMin = minHeap.poll();
			if( curMin < sum) {
				totalItems++;
				sum = sum - curMin;
			}
			else {
				break;
			}
		}
		return totalItems;
	}
	
	
	public static ArrayList<Integer> kLargest(int arr[], int k)
    {
		int n = arr.length;
        ArrayList<Integer> klargeList = new ArrayList<Integer>(k);        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i=0; i< k ;i++) {
        	minHeap.add(arr[i]);
        }
        
        for(int i= k; i < n; i++) {
        	if(arr[i] > minHeap.peek()) {
        		minHeap.poll();
        		minHeap.add(arr[i]);
        	}
        }
        while(!minHeap.isEmpty()) {
        	klargeList.add(minHeap.poll());
        }
        Collections.sort(klargeList, Collections.reverseOrder());
        return klargeList;
    }

}
