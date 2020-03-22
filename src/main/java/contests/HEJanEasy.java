package contests;

import java.util.ArrayList;
import java.util.Scanner;

public class HEJanEasy {
     public static void main(String[] args) {
    	 String str = "dsdasvvcjkx";
    	 int k1 = 4;
    	// validPartition(str, k1);
    	 
    	 Scanner sc = new Scanner(System.in);
         int t = sc.nextInt();
         for(int i = 0; i < t; i++) {
        	 String s = sc.next();
        	 int k = sc.nextInt();
        	 validPartition(s, k);
        	 System.out.println();
        	 
         }
     }
	
	
	
	
	public static void validPartition(String s, int k) {
		ArrayList<String> strings = new ArrayList<String>();
		int len = s.length();
		int div = len / k;
		int rem = len % k;
		if( (rem == 0 && div >= k) || (rem == k -1 && div >= k-1)) {
			int start = 0;
			while(start + k  <= len) {
				strings.add(s.substring(start, start + k));
				start = start + k;	
			}
			if(start < len) {
				strings.add(s.substring(start));
			}
			
			int i;
			for(i= 0 ; i < strings.size() -1; i++) {
				System.out.print(strings.get(i));
				System.out.print("-");
			}
			System.out.print(strings.get(i));
		}
		else {
			System.out.println("-1");
		}
		
	}
}
