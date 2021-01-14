package algo.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	void bucketSort(int arr[]) {
		bucketSort(arr, 5);
	}
	
	void bucketSort(int arr[], int bucketCount) {
		int n = arr.length;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			max = Math.max(max, arr[i]);
		}
		
		int bucketSize = (max / bucketCount ) + 1;
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < bucketCount; i++) {
			buckets.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < n; i++) {
			int bucketNo = arr[i] / bucketSize;
			buckets.get(bucketNo).add(arr[i]);
		}
		int index = 0;
		for(int i = 0; i < bucketCount; i++) {
			ArrayList<Integer> currentBucket = buckets.get(i);
			Collections.sort(currentBucket);
			for(int j = 0; j < currentBucket.size(); j++) {
				arr[index] = currentBucket.get(j);
				index++;
			}
		}
		
	}

}
