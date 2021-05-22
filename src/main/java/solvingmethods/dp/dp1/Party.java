package solvingmethods.dp.dp1;

import java.util.Arrays;

public class Party {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//f(n) = f(n-1) + (n-1)*f(n-2), f(1) = 1 f(2) = 2
	public int partyRec(int A) {
		if(A <= 2) {
			return A;
		}
		return partyRec(A-1) + (A - 1)* partyRec(A - 2);
	}
	
	public int party(int A) {
		int[] lookup = new int[A + 1];
		Arrays.fill(lookup, -1);
		return partyMem(A,lookup);
	}
	
	private int partyMem(int A, int[] lookup) {
		if(lookup[A] == -1) {
			if(A <= 2) {
				lookup[A] = A;
			}
			else {
				lookup[A] = partyMem(A-1, lookup) + (A - 1) * partyMem(A - 2,lookup); 
			}
		}
		return lookup[A];
	}

	public int partyTab(int A) {
        int mod = 10003;
        if(A <= 2){
            return A;
        }
        int[] ways = new int[A + 1];
        ways[1] = 1;
        ways[2] = 2;
        for(int i = 3; i <= A; i++){
            ways[i] = ways[i - 1] % mod + (ways[i - 2] % mod)*(i - 1);
        }
        return ways[A] % mod;
    }

}
