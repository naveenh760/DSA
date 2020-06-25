package datastructures.string;

public class StringPerm {

	public static void main(String[] args) {
		String str = "ABC";
		allPermute(str, 0, 2);

	}
	
	static int findRank(String str) 
    {
		int rank = 1;
		int n = str.length();
		int mul = factorial(n);
		int[] count = new int[256];
		for(int i = 0 ; i < n; i++) {
			char ch = str.charAt(i);
			count[ch]++;
			if(count[ch] > 1) {
				return 0;
			}	
		}
		for(int i = 1; i < 256; i++) {
			count[i] += count[i - 1];
		}
		for(int i = 0 ; i < n; i++) {
			 mul = mul / ( n - i);
			rank = rank + mul * count[str.charAt(i) - 1];
			for(int j = str.charAt(i); j < 256; j++) {
				count[j]--;
			}
		}
        return rank;
    }
	
	static int factorial(int n) {
		int fact = 1;
		for(int i = n; i > 0; i--) {
			fact = fact * i;
		}
		return fact;
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

	private static String  swap(String str, int l, int r) {
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(l, str.charAt(r));
		sb.setCharAt(r, str.charAt(l));
		return sb.toString();
		
	}
	

}
