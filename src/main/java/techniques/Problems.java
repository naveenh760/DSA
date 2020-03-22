package techniques;



public class Problems {

	public static void main(String[] args) {
	//	System.out.println(josephus(5, 2));
	}
	
	
	//Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n
	//Find no of ways to reach given score
	
	public static int totalWays(int n) {
		
		
		
		return 0;
	}
	
	
	//josephus(n,k) = (josephus(n-1,k) + k-1) % n + 1
	 //josephus(1,k) = 1
	public static int josephus(int n , int k) {
		if(n==1) {
			return 1;
		}
		else {
			return (josephus(n-1, k) + k - 1) % n + 1;
		}
	}
	
	}
