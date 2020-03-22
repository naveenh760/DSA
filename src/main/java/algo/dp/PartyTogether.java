package algo.dp;

import java.util.Arrays;

public class PartyTogether {

	int MAXN = 1000;
	int[] dp= new int[MAXN];
	
	public void reset() {
		Arrays.fill(dp, -1);
	}
	
	public PartyTogether() {
		Arrays.fill(dp, -1);
	}
	
	public int partyRec(int n) {
		if(n <= 1) {
			return 1;
		}
		else {
			return partyRec(n - 1) + (n - 1)* partyRec(n - 2);
		}
	}
	
	public int partyMemo(int n) {
		if(dp[n] == -1) {
			if( n <= 1) {
				dp[n] = 1;
			}
			else {
				dp[n] = partyMemo(n - 1) + (n - 1)* partyMemo(n - 2);
			}
		}
		return dp[n];
	}
	
	public int partyTab(int n) {
		int[] party = new int[ n + 1];
		party[0] = 1;
		party[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			party[i] = party[ i - 1] + (n - 1)* party[ i - 2];
		}
		return party[n];
	}
}

