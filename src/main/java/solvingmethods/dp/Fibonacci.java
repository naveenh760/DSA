package solvingmethods.dp;

import java.util.Arrays;

public class Fibonacci {

	int MAXN = 1000;
	int[] lookup= new int[MAXN];
	
	public Fibonacci() {
		reset();
	}
	
	public void reset() {
		Arrays.fill(lookup, -1);
	}
	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		System.out.println(fib.fiboRec(7));
		System.out.println(fib.fiboMemo(7));
		System.out.println(fib.fiboTab(7));

	}
	
	public int fiboRec(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		
		return fiboRec(n - 1) + fiboRec( n - 2);
	}
	
	public int fiboMemo(int n) {
		if(lookup[n] == -1) {
			if(n == 0) {
				lookup[n] = 0;
			}
			else if( n == 1) {
				lookup[n] = 1;
			}
			else {
				lookup[n] = fiboMemo( n - 1) + fiboMemo( n - 2);
			}
		}
		return lookup[n];
	}
	
	public int fiboTab(int n) {
		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i= 2; i <= n ;i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

}
