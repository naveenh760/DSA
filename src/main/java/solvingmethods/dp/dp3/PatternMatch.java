package solvingmethods.dp.dp3;

public class PatternMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
	
	
	boolean patternMatchRec(String text, String pattern, int tInd, int pInd) {
		if(tInd == -1 && pInd == -1) {
			return true;
		}
		else if(pInd == -1) {
			return false;
		}
		else if(tInd == -1) {
			boolean val = true;
			for(int i = pInd; i >= 0; i--) {
				if(pattern.charAt(i) != '*') {
					val = false;
					break;
				}
			}
			return val;
		}
		
		
		if(pattern.charAt(pInd) == '?') {
			return patternMatchRec(text, pattern, tInd - 1, pInd - 1);
		}
		else if(pattern.charAt(pInd) == '*') {
			return patternMatchRec(text, pattern, tInd, pInd - 1) || 
					patternMatchRec(text, pattern, tInd - 1, pInd);
		}
		else {
			if(pattern.charAt(pInd) == text.charAt(tInd)) {
				return patternMatchRec(text, pattern, tInd - 1, pInd - 1);
			}
			else {
				return false;
			}
		}
	}
	
	
	boolean patternMatchTab(String text, String pattern) {
		int tLen = text.length();
		int pLen = pattern.length();
		
		boolean[][] lookup = new boolean[pLen + 1][tLen + 1];
		lookup[0][0] = true;
		for(int j = 1; j <= tLen; j++) {    //Matching empty pattern
			lookup[0][j] = false;
		}
		for(int i = 1; i <= pLen; i++) {
			lookup[i][0] = false;
		}
		for(int i = 1; i <= pLen; i++) {
			if(pattern.charAt( i - 1) == '*') {
				lookup[i][0] = true;
			}
			else {
				break;
			}
		}
		
		for(int i = 1; i <= pLen; i++) {
			for(int j = 1; j <= tLen; j++) {
				if(pattern.charAt(i - 1) == '?') {
					lookup[i][j] = lookup[i - 1][j - 1];
				}
				else if(pattern.charAt(i - 1) == '*') {
					lookup[i][j] = lookup[i - 1][j] || 
							lookup[i][j - 1];
				}
				else {
					if(pattern.charAt(i - 1) == text.charAt(j - 1)) {
						lookup[i][j] =  lookup[i - 1][j - 1];
					}
					else {
						lookup[i][j] =  false;
					}
				}
				
			}
		}
		return lookup[pLen][tLen];
	}
	
	
	int patternMatch(String text, String pattern) {
		int pInd = pattern.length();
		int tInd = text.length();
		Boolean[][] lookup = new Boolean[pInd + 1][tInd + 1];
		if(patternMatchMem(text, pattern, pInd, tInd, lookup)) {
			return 1;
		}
		return 0;
	}
	
	
	boolean patternMatchMem(String text, String pattern, int pInd, int tInd, Boolean[][] lookup) {
		if (lookup[pInd][tInd] == null) {
			if (pInd == 0 && tInd == 0) {
				lookup[pInd][tInd] = true;
			} else if (pInd == 0) {
				lookup[pInd][tInd] = false;
			} else if (tInd == 0) {
				boolean val = true;
				for (int i = pInd; i > 0; i--) {
					if (pattern.charAt(i - 1) != '*') {
						val = false;
						break;
					}
				}
				lookup[pInd][tInd] = val;
			} else if (pattern.charAt(pInd - 1) == '?') {
				lookup[pInd][tInd] = patternMatchMem(text, pattern, pInd - 1, tInd - 1, lookup);
			} else if (pattern.charAt(pInd - 1) == '*') {
				lookup[pInd][tInd] = patternMatchMem(text, pattern, pInd - 1, tInd, lookup) || patternMatchMem(text, pattern, pInd, tInd - 1, lookup);
			} else {
				if (pattern.charAt(pInd - 1) == text.charAt(tInd - 1)) {
					lookup[pInd][tInd] = patternMatchMem(text, pattern, pInd - 1, tInd - 1, lookup);
				} else {
					lookup[pInd][tInd] = false;
				}
			} 
		}
		return lookup[pInd][tInd];
	}
	

}
