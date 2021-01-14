package algo.sorting.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortingProbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minAbsDiff(int[] A) {
		int n = A.length;
		Arrays.sort(A);
		int minAbsDiff = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			int absDiff = Math.abs(A[i] - A[i + 1]);
			minAbsDiff = Math.min(minAbsDiff, absDiff);
		}
		return minAbsDiff;
	}

	public int consecutiveElements(int[] A) {
		int n = A.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Set<Integer> hashset = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			hashset.add(A[i]);
		}
		for (int i = 0; i < n; i++) {
			min = Math.min(min, A[i]);
			max = Math.max(max, A[i]);
		}
		for (int i = min; i <= max; i++) {
			if (!hashset.contains(i)) {
				return 0;
			}
		}
		return 1;
	}

	public int consecutiveElements1(int[] A) {
		int n = A.length;
		Arrays.sort(A);
		for (int i = 1; i < n; i++) {
			if (A[i] - A[i - 1] != 1) {
				return 0;
			}
		}
		return 1;
	}

	public int kthsmallest(final int[] A, int k) {
		int n = A.length;
		for (int i = 0; i < k; i++) {
			int minIdx = i;
			for (int j = i; j < n; j++) {
				if (A[j] < A[minIdx]) {
					minIdx = j;
				}
			}
			swap(A, i, minIdx);
		}
		return A[k - 1];
	}

	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	public int sumTheDifference(int[] A) {
        int n = A.length;
        long sumOfMax = 0;
        long sumOfMin = 0;
        long mod = (long)(Math.pow(10,9)) + 7;
        Arrays.sort(A);
        for(int i = 0; i < n; i++){
            sumOfMax = sumOfMax + (((long)(pow(i)) * (long)A[i])) % mod;
            sumOfMax = sumOfMax % mod;
            sumOfMin = sumOfMin + (((long)(pow(n-1-i)) * (long)A[i])) % mod;
            sumOfMin = sumOfMin % mod;
            
        }
        
        long diff = sumOfMax - sumOfMin + mod;
        return (int) (diff % mod);
    }
    
    public long pow(int num){
         long mod = (long)(Math.pow(10,9)) + 7;
         long p = 1;
         for(int i = 0;i <num;i++ ){
             p = 2 * p;
             p = p % mod;
         }
        return p;
    }
    
    public int maxChunksSorted(int[] A) {
        int n = A.length;
        int count = 0;
        int maxLeft = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            maxLeft = Math.max(maxLeft,A[i]);
            if(maxLeft == i){
                count++;
            }
        }
        return count;
    }
    
    public int[] maxMinMagic(int A[]) {
    	int n = A.length;
    	Arrays.sort(A);
    	int[] ans = new int[2];
    	int mod = (int) Math.pow(10, 9) + 7;
    	long maxSum = 0;
    	long minSum = 0;
    	for(int i = 0; i < n - 1; i = i + 2) {
    		minSum = (minSum + Math.abs(A[i] - A[i + 1])) % mod;
    	}
    	for(int i = 0; i < n / 2; i++) {
    		maxSum = (maxSum + Math.abs(A[i] - A[n-1-i])) % mod;
    	}
    	
    	ans[0] = (int) maxSum;
    	ans[1] = (int) minSum;
    	return ans;
    }
    
    public int maxMod(int[] A) {
        int max = 0;
        int n = A.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(A[j] != 0){
                   max = Math.max(max, A[i] % A[j]);  
                }
               
            }
        }
        return max;
    }
    
    public int maxMod1(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        for(int i = n - 1; i > 0; i--){
            if(A[i] != A[i-1]){
                return A[i-1] % A[i];
            }
        }
        return 0;
    }
    
    
    public int makeUnique1(int[] arr) {
    	int n = arr.length;
    	Map<Integer, Integer> freqMap = new TreeMap<Integer,Integer>();
    	for(int i = 0; i < n; i++) {
    		if(freqMap.containsKey(arr[i])) {
    			freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
    		}
    		else {
    			freqMap.put(arr[i], 1);
    		}
    	}
    	int opsCnt = 0;
    	Iterator<Integer> iter = freqMap.keySet().iterator();
    	// This doesnt work becuase we cannot modify map while traversing
    	while(iter.hasNext()) {
    		int key = iter.next();
    		int curFreq = freqMap.get(key);
    		if(curFreq == 1) {
    			continue;
    		}
    		else {
    			freqMap.put(key, 1);
    			int diff = curFreq - 1;
    			opsCnt = opsCnt + diff;
    			int nextKey = key + 1;
    			if(freqMap.containsKey(nextKey)) {
    				freqMap.put(nextKey, freqMap.get(nextKey) + diff);
    			}
    			else {
    				freqMap.put(nextKey, diff);
    			}
    		}
    	}
    	return opsCnt;
    }
    
    
    public int makeUnique(int[] A) {
        int n = A.length;
        int count = 0;
        Arrays.sort(A);
        for(int i = 1; i < n; i++){
            if(A[i] == A[i - 1]){
                A[i]++;
                count++;
            }
            else if(A[i] < A[i - 1]){
                int temp = A[i];
                A[i] = A[i - 1] + 1;
                count = count + (A[i] - temp);
            }
        }
        return count;
    }
    
    
    
    
    
}
