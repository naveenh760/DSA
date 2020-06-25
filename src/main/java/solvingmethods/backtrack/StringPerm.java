package solvingmethods.backtrack;

public class StringPerm {

	public static void main(String[] args) {
		String str = "ABC";
		allPermuteNoAB(str, 0, 2);
	}
		
	public static void allPermuteNoAB(String str, int l, int r) {
		if(l == r) {
			System.out.println(str);
			return;
		}
		else {
			for(int i=l ; i<=r; i++) {
				if(isSafe(str, l, i, r)) {
					str = swap(str,l,i);
					allPermuteNoAB(str, l + 1, r);
					str = swap(str,l,i);
				}
				
			}
		}
	}

	private static String  swap(String str, int l, int r) {
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(l, str.charAt(r));
		sb.setCharAt(r, str.charAt(l));
		return sb.toString();
		
	}

	static boolean isSafe(String str, int l, int i, int r) {
		if(l != 0 && str.charAt(l -1) == 'A' && str.charAt(i) == 'B') {
			return false;
		}
		if( r == l + 1 && str.charAt(i) == 'A' && str.charAt(l) == 'B') {
			return false;
		}
		return true;
	}

}
