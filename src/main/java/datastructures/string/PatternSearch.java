package datastructures.string;

public class PatternSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean isAnagramPresent(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		
		int countTextWindow[] = new int[256];
		int countPattern[] = new int[256];
		
		for(int i = 0; i < m; i++) {
			countTextWindow[text.charAt(i)]++;
			countPattern[pattern.charAt(i)]++;
		}
		
		for(int i = m; i < n; i++) {
			if(isCountSame(countTextWindow,countPattern)) {
				return true;
			}
			countTextWindow[text.charAt(i)]++;
			countTextWindow[text.charAt(i - m)]--;
		}
		
		if(isCountSame(countTextWindow, countPattern)) {
			return true;
		}
		
		return false;
	}

	private boolean isCountSame(int[] countTextWindow, int[] countPattern) {
		for(int i = 0; i < 256; i++) {
			if(countTextWindow[i] != countPattern[i]) {
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean areRotations(String s1, String s2 )
    {
		return (s1.length()==s2.length() && (s1+s1).contains(s2));
    }
	
	public boolean naivePatternSearch(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		
		for(int i = 0; i <= n - m; i++) {
			int j;
			for(j = 0; j < m; j++) {
				if(text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if( j == m) {
				return true;
			}
		}
		return false;
	}
	
	public boolean distinctPatternSearch(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		
		for(int i = 0; i <= n - m;) {
			int j;
			for(j = 0; j < m; j++) {
				if(text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if( j == m) {
				return true;
			}
			if(j == 0) {
				i++;
			}
			else {
				i = i + j;
			}
		}
		return false;
	}
}
