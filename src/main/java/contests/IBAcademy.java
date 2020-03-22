package contests;

import java.util.Arrays;

public class IBAcademy {
	
public static void main(String[] args) {
//	String A = "AbcaZeoB";
//	System.out.println(perform(A));
	count();
	
}
	
public static void count() {
	int cnt =0;
	for(int i =1 ; i<= 500; i++) {
		if(i % 3 == 0 || i % 7 == 0 || i % 9 == 0) {
			cnt++;
		}
	}
  System.out.println(cnt);	
}


public static String perform(String A) {
	StringBuilder sb = new StringBuilder(A);
	StringBuilder noUpper = new StringBuilder();
	sb.append(A);
	System.out.println(sb);
	Character c;
	for(int i = 0 ; i < sb.length(); i++) {
		c = sb.charAt(i);
		if(!Character.isUpperCase(c)) {
			noUpper.append(c);
		}
	} 
	
	System.out.println(noUpper);
	for(int i = 0; i < noUpper.length(); i++) {
		c = noUpper.charAt(i);
		if(c.equals('a') || c.equals('e') || c.equals('i') || c.equals('o') || c.equals('u')) {
			noUpper.replace(i, i + 1, "#");
		}
	}
	
	return noUpper.toString();
}
	

}
