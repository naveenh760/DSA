package solvingmethods.greedy;

import java.util.Arrays;

public class DistributeCandy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int distributeCandy(int[] A) {
        int n = A.length;
        int[] candies = new int[n];
        Arrays.fill(candies,1);
        for(int i = 1; i < n; i++ ){
            if(A[i] > A[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for(int i = n - 2; i >= 0; i--){
            if(A[i] > A[i + 1]){
                candies[i] = Math.max(candies[ i + 1] + 1,candies[i]);
            }
        }
        int totalCandies = 0;
        for(int candy: candies){
            totalCandies = totalCandies + candy;
        }
        return totalCandies;
    }

}
