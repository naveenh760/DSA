package math.factoring;

import java.util.Arrays;

public class Modular {

	public static void main(String[] args) {
		System.out.println(power(3,34,1000000007));

	}
	
	public static long power(long a, long b, int m) {
		if(b == 0) {
			return 1;
		}
		if(b % 2 == 0) {
			return power((a*a) % m, b / 2, m);
		}
		else {
			return (a * power((a*a) % m, b / 2, m)) % m;
		}
	}
	
	
	public int modularInverse(int A, int B) {
		return (int) power(A, B - 2, B);
	}
	
	
	
	public int pairSum(int[] A, int B) {
		long ans = 0;
		int n = A.length;
		int mod = (int) (Math.pow(10, 9)) + 7; 
		long[] cnt = new long[B];
		Arrays.fill(cnt, 0);
		for(int i = 0; i < n; i++) {
			cnt[A[i] % B]++;
		}
		ans = cnt[0]*(cnt[0] - 1) / 2;
		ans = ans % mod;
		int i = 1;
		int j = B - 1;
		while(i <= j) {
			if(i == j) {
				ans = ans + cnt[i]*(cnt[j] - 1) / 2;
			}
			else {
				ans = ans + (cnt[i] * cnt[j]);
			}
			ans = ans % mod;
			i++;
			j--;
		}
		
		
		return (int)ans;
    }
	

}
