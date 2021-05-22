package solvingmethods.greedy;

public class CoinChange {

	public static void main(String[] args) {
		System.out.println(isPowerOf5(0));

	}

	public static boolean isPowerOf5(int num) {
		if (num <= 0) {
			return false;
		}
		int rem = 0;
		while (num > 1) {
			rem = num % 5;
			if (rem > 0) {
				return false;
			}
			num = num / 5;
		}
		return true;
	}

	public int coinChange(int A) {
		int totalCoins = 0;
		while (A > 0) {
			int largest = 1;
			int prevLargest = 1;
			while (largest <= A) {
				prevLargest = largest;
				largest = largest * 5;
			}
			totalCoins = totalCoins + (A / prevLargest);
			A = A % prevLargest;
		}
		return totalCoins;
	}

}
