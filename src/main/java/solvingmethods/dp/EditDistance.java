package solvingmethods.dp;

import java.util.Arrays;

public class EditDistance {
	
	
	public int editDistRec(String s1, String s2, int m, int n) {
		if(m == 0) {
			return n;
		}
		if(n == 0) {
			return m;
		}
		
		if(s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return editDistRec(s1, s2, m-1, n-1);
		}
		else {
			return 1 + Math.min(editDistRec(s1, s2, m, n-1),
					            Math.min(editDistRec(s1, s2, m, n-1), 
					            		  editDistRec(s1, s2, m-1, n-1))
					  );
		}
	}
	
	
	public int editDistance(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int lookup[][] = new int[m + 1][n + 1];
		for (int[] row : lookup) {
			Arrays.fill(row, -1);
		}
		
		return editDistanceMemo(s1,s2,m,n,lookup);
	}

	private int editDistanceMemo(String s1, String s2, int m, int n, int[][] lookup) {
		if(lookup[m][n] == -1) {
			if(m == 0) {
				lookup[m][n] = n;
			}
			else if(n == 0) {
				lookup[m][n] = m;
			}
			
			else if(s1.charAt(m - 1) == s2.charAt(n - 1)) {
				lookup[m][n] =  editDistRec(s1, s2, m-1, n-1);
			}
			else {
				lookup[m][n] =  1 + Math.min(editDistRec(s1, s2, m, n-1),
						            Math.min(editDistRec(s1, s2, m, n-1), 
						            		  editDistRec(s1, s2, m-1, n-1))
						  );
			}
		}
		return lookup[m][n];
	}

    private int editDistanceTab(String s1, String s2) {
    	int m = s1.length();
    	int n = s2.length();
    	int lookup[][] = new int[m+1][n+1];
    	for(int i= 0; i<= m;i++) {
    		lookup[i][0] = i;
    	}
    	for(int j=0; j <= n;j++) {
    		lookup[0][j] = j;
    	}
    	
    	for(int i = 1; i <= m; i++) {
    		for(int j = 1; j <= n; j++) {
    			if(s1.charAt(i -1) == s2.charAt(j -1)) {
    				lookup[i][j] = lookup[i-1][j-1];
    			}
    			else {
    				lookup[i][j] = 1 + Math.min(lookup[i][j-1], 
    										    Math.min(lookup[i-1][j], lookup[i-1][j-1])
    						);
    			}
    		}
    	}
    	return lookup[m][n];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
