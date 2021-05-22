package solvingmethods.dp.dp1;

import java.util.Arrays;

public class Factorial {

	int MAXN = 1000;
	int[] lookup= new int[MAXN];
	
	public Factorial() {
		reset();
	}
	
	public void reset() {
		Arrays.fill(lookup, -1);
	}
	public static void main(String[] args) {
		Factorial fact = new Factorial();
		System.out.println(fact.factRec(3));
		System.out.println(fact.factMemo(3));
		System.out.println(fact.factTab(3));

	}
	
	public int factRec(int n) {
		if( n == 0) {
			return 1;
		}
		
		return n * factRec(n - 1);
	}
	
	
	public int factMemo(int n) {
		if(lookup[n] == -1) {
			if(n == 0) {
				lookup[n] = 1;
			}
			else {
				lookup[n] = n * factMemo(n - 1);
			}
		}
		return lookup[n];

	}
	
	public int factTab(int n) {
		int[] fact= new int[ n + 1];
		fact[0] = 1;
		for(int i = 1 ; i <= n; i++) {
			fact[i] = i * fact[i - 1];
		}
		
		return fact[n];
	}

}
