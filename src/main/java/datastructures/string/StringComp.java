package datastructures.string;

import java.util.Arrays;

public class StringComp {

	public static void main(String[] args) {
		

	}

	public static boolean isAnagram(String s1, String s2) {
		int[] frequency = new int[256];
		if(s1.length() != s2.length()) {
			return false;
		}
		for(int i = 0; i < s1.length(); i++) {
			frequency[s1.charAt(i)]++;
		}
		for(int i = 0; i < s2.length(); i++) {
			frequency[s2.charAt(i)]--;
		}
		for(int i = 0; i < 256; i++) {
			if(frequency[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	static int repeatedCharacter(String str)
    {
        int res = Integer.MAX_VALUE;
        int n = str.length();
        int[] firstInd = new int[256];
        Arrays.fill(firstInd, -1);
        for(int i = 0; i < n; i++) {
        	char ch = str.charAt(i);
        	if(firstInd[ch] == -1) {
        		firstInd[ch] = i;
        	}
        	else {
        		res = Math.min(res, firstInd[ch]);
        	}
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
	
	
	static char nonrepeatingCharacter(String S)
    {
		int n = S.length();
        int[] firstInd = new int[256];
        Arrays.fill(firstInd, -1);
        for(int i = 0; i < n; i++) {
        	char ch = S.charAt(i);
        	if(firstInd[ch] == -1) {
        		firstInd[ch] = i;
        	}
        	else {
        		firstInd[ch] = -2;
        	}
        }
        int res = Integer.MAX_VALUE;
        for(int ind: firstInd) {
        	if(ind >= 0) {
        		res = Math.min(ind, res);
        	}
        }
        
        char nonRep = (res == Integer.MAX_VALUE ? '$': S.charAt(res));
        return nonRep;
    }
	
	
		
	
}
