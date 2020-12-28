package recursion.backtrack;

public class StringPerm {

	public static void main(String[] args) {
		String str = "ABCD";
		allPermuteNoAB(str, 0, 2);
	}
	
	
	public static void allPermute(String str, int l, int r) {
		if(l == r) {
			System.out.println(str);
			return;
		}
		else {
			for(int i=l ; i<=r; i++) {
				str = swap(str,l,i);
				allPermute(str, l + 1, r);
				str = swap(str,l,i);
			}
		}
	}
	
	public static void allPermuteDups(String str, int l, int r) {
		if(l == r) {
			System.out.println(str);
			return;
		}
		else {
			for(int i=l ; i<=r; i++) {
				if(shouldSwap(str, l, i)) {
					str = swap(str,l,i);
					allPermuteDups(str, l + 1, r);
					str = swap(str,l,i);
				}
			}
		}
	}


		
	public static void allPermuteNoAB(String str, int l, int r) {
		if(l == r) {
			System.out.println(str);
			return;
		}
		else {
			for(int i=l ; i<=r; i++) {
				if(shouldSwap(str, l, i) && isSafe(str, l, i, r)) {
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
	
	private static boolean shouldSwap(String str, int l, int curr) {
		for(int i = l; i < curr; i++) {
			if(str.charAt(i) == str.charAt(curr)) {
				return false;
			}
		}
		return true;
	}


	static boolean isSafe(String str, int l, int i, int r) {
		if(l != 0 && str.charAt(l -1) == 'A' && str.charAt(i) == 'B') {
			return false;
		}
		if(str.charAt(i) == 'A' && str.charAt(l) == 'B') {
			return false;
		}
		return true;
	}

}
