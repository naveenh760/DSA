package algo.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class AppliedProbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Integer> posNeg(ArrayList<Integer> A) {
		int n = A.size();
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> posNos = new ArrayList<Integer>();
		ArrayList<Integer> negNos = new ArrayList<Integer>();
		int countPos = 0;
		int countNeg = 0;
		for(int i = 0; i < n; i++) {
			if(A.get(i) >= 0) {
				posNos.add(A.get(i));
			}
			else {
				negNos.add(A.get(i));
			}
		}
		countPos = posNos.size();
		countNeg = negNos.size();
		int minCnt = Math.min(countPos,countNeg);
		for(int i = 0; i < minCnt; i++) {
			result.add(negNos.get(i));
			result.add(posNos.get(i));
		}
		
		//only one of the two loops will be executed
		for(int i = minCnt; i < countPos; i++) {
			result.add(posNos.get(i));
		}
		for(int i = minCnt; i < countNeg; i++) {
			result.add(negNos.get(i));
		}
		
		
		return result;
    }

}
