package algo.sorting.problems.comparators;

import java.util.ArrayList;
import java.util.Comparator;

public class ClosestPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<ArrayList<Integer>> closestPoints(ArrayList<ArrayList<Integer>> A, int B) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		Comparator<ArrayList<Integer>> comp = (a,b) -> Double.compare(euclideanDistance(a), euclideanDistance(b));
		A.sort(comp);	
		ans.addAll(A.subList(0, B));
		return ans;
    }
	
	public double euclideanDistance(ArrayList<Integer> A) {
		int x = A.get(0);
		int y = A.get(1);
		double dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		return dist;
	}

}
