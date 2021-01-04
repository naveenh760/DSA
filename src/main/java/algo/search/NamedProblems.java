package algo.search;

public class NamedProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int paint(int A, int B, int[] C) {
		int mod = 10000003;
		int n = C.length;
		long[] times = new long[n];
		long maxTime = Integer.MIN_VALUE;
		long sumTimes = 0;
		for(int i = 0; i < n; i++) {
			times[i] = (long)B * (long)C[i];
			maxTime = Math.max(maxTime, times[i]);
			sumTimes = sumTimes + times[i];
		}
		
		long low = maxTime;
		long high = sumTimes;
		long ans = 0;
		while(low <= high) {
			long mid = low + (high - low) / 2;
			int paintersRequired = calculatePainters(times, mid);
			if(paintersRequired > A) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
				ans = mid;
			}
		}
		return (int) (ans % mod);
    }

	private int calculatePainters(long[] times, long mid) {
		int n = times.length;
		int count = 0;
		long currSum = 0;
		for(int i = 0; i < n; i++) {
			if(currSum + times[i] > mid) {
				count++;
				currSum = times[i];
			}
			else {
				currSum += times[i];
			}
		}
		count++;
		return count;
	}

}
