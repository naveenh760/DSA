package datastructures.string;

import java.util.Scanner;

public class StringOps {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		System.out.println(reverseComplement(input));
		sc.close();
	}
	
	
	//A&T , G&C
	//Input: AAGCTC  Ouput: GAGCTT
	// Time - O(n)
	public static String reverseComplement(String pattern) {
		StringBuilder sb = new StringBuilder(pattern.length());
		char[] chars = pattern.toCharArray();
		int length = chars.length;
		
		for(int i = length -1 ; i >=0; i--) {
			switch (chars[i]) {
			case 'A':
				sb.append('T');
				break;
			case 'T':
				sb.append('A');
				break;
			case 'G':
				sb.append('C');
				break;
			case 'C':
				sb.append('G');
			default:
				break;
			}
		}
		return sb.toString();
	}
	 
	  
	
	
	
	
	
	
}
