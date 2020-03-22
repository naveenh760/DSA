package math.basic;

public class Division {

	
	
	public static int countDigits(int num) {
		int count = 0;
		int temp = num;
		while(temp > 0) {
			temp = temp / 10;
			count++;
		}
		return count;
		
	}
	
	public static int countDigitsLog(int num) {
		return (int) Math.floor(Math.log10(num) + 1);
	}
	
}
