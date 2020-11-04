package misc;

public class utilities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	printPowers(7, 20);
		

	}
	
	
	public static void printPowers(int num, int lastPower) {
		for(int i = 1; i <= lastPower; i++) {
			System.out.println(num + "^" + i + " = " + Math.pow(num, i) );
		}
	}
	
	public String solve(String A) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < A.length(); i++) {
        	char ch = A.charAt(i);
        	if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        		s.append(ch);
        	}
        }
        return s.toString();
    }

}
