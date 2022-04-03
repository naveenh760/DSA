package math.factoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Factors {
	
	

	public static ArrayList<Integer> getFactors1(int A) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 1; i <= A; i++) {
			if (A % i == 0) {
				factors.add(i);
			}
		}
		return factors;
	}

	public static ArrayList<Integer> getFactors2(int A) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 1; i <= Math.sqrt(A); i++) {
			if (A % i == 0) {
				factors.add(i);
				if (i != Math.sqrt(A)) {
					factors.add(A / i);
				}
			}
		}
		Collections.sort(factors);
		return factors;
	}

	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<Integer> sieveOfErat(int n) {
		boolean[] primes = new boolean[n + 1];
		ArrayList<Integer> result = new ArrayList<Integer>();
		Arrays.fill(primes, true);

		for (int p = 2; p * p <= n; p++) {
			for (int i = p * p; i <= n; i += p) {
				primes[i] = false;
			}
		}

		for (int i = 2; i <= n; i++) {
			if (primes[i] == true) {
				result.add(i);
			}
		}

		return result;
	}

	public static int exactly3Divisors(int N) {
		ArrayList<Integer> primes = sieveOfErat((int) Math.sqrt(N));
		return primes.size();
	}

	public int gcdNaive(int A, int B) {
		if (A == 0) {
			return B;
		}
		if (B == 0) {
			return A;
		}
		int ans = 1;
		int min = Math.min(A,B);
		for (int f = min; f > 0; f--) {
			if (A % f == 0 && B % f == 0) {
				ans = f;
				break;
			}
		}
		return ans;
	}
	
	
	public static int gcdIterative(int A, int B) {
		//GCD(A,B) = GCD(B % A, A) 
		//GCD(0,B) = B
		while(A > 0) {
			int t = A;
			A = B % A;
			B = t;
	
		}
		return B;
	}
	
	public static int gcdRec(int A, int B) {
		if(A == 0) {
			return B;
		}
		return gcdRec(B % A, A);
	}
	
	
	 public ArrayList<Integer> allDivisors(ArrayList<Integer> A) {
		 int n = A.size();
		 int max = Collections.max(A);
		 ArrayList<Integer> sieve = new ArrayList<Integer>(Collections.nCopies(max + 1, 0));
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 for(int p = 1; p <= max; p++) {
			 for(int i = p; i <= max; i += p) {
				 sieve.set(i, sieve.get(i) + 1);
			 }
		 }
		
		 for(int i = 0; i < n; i++) {
			 result.add(sieve.get(A.get(i)));
		 }
		 
		 
		 return result;
	    }
	 
	 public static int findPos(int A) {
		 int exp =  (int) (Math.log(A) / Math.log(2));
		 return (int) Math.pow(2, exp);
	 }

	public int deleteOne(int[] A) {
		int n = A.length;
		int[] prefixGCD = new int[n];
		int[] suffixGCD = new int[n];
		prefixGCD[0] = A[0];
		suffixGCD[n - 1] = A[n - 1];
		for(int i = 1; i < n; i++){
			prefixGCD[i] = gcdRec(prefixGCD[i - 1], A[i]);
		}
		for(int i = n - 2; i >= 0; i--){
			suffixGCD[i] = gcdRec(suffixGCD[i + 1], A[i]);
		}

		int maxGCD = 1;
		for(int i = 0; i < n;i++){
			int curGCD;
			if(i == 0){
				curGCD = suffixGCD[i + 1];
			}
			else if( i == n - 1){
				curGCD = prefixGCD[ i - 1];
			}
			else{
				curGCD = gcdRec(prefixGCD[i - 1], suffixGCD[i + 1]);
			}
			maxGCD = Math.max(maxGCD,curGCD);
		}
		return maxGCD;
	}

	public String enumeratingGCD(String A, String B) {
		if(A.equals(B)){
			return A;
		}
		else{
			return "1";
		}
	}

	public int divisorGame(int A, int B, int C) {
		int lcm = (B * C) / gcdRec(B,C);
		return A / lcm;
	}

	public int pubg(int[] A) {
		int n = A.length;
		int gcdArr = A[0];
		for(int i = 1; i < n; i++){
			gcdArr = gcdRec(gcdArr, A[i]);
		}
		return gcdArr;
	}

	public int findPosition(int A) {
		int exp =  (int) (Math.log(A) / Math.log(2));
		return (int) Math.pow(2, exp);
	}

	public int findPositionLoop(int A){
		int ans = 2;
		while(ans * 2 <= A){
			ans = ans * 2;
		}
		return ans;
	}

	public int repeatedSubtraction(int A, int B) {
		if(A == 0 || B == 0){
			return Math.max(A,B);
		}
		return 2 * gcdRec(A,B);
	}

	public static void main(String[] args) {
		// System.out.println(Factors.getFactors2(85416));
		/*
		 * ArrayList<Integer> results = sieveOfErat(50); for(int result: results) {
		 * System.out.print(result + " "); }
		 */
		//System.out.println(exactly3Divisors(30));
	//	System.out.println(gcdIterative(6, 12));
		System.out.println(findPos(10));
	}

}
