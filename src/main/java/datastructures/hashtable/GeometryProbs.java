package datastructures.hashtable;

import java.util.HashMap;
import java.util.Map;

public class GeometryProbs {

	public static void main(String[] args) {
		int[] A = {1,1,2,2};
		int[] B = {1,2,1,2};
		System.out.println(countRectangles(A, B));

	}
	
	public static int countRectangles(int[] A, int[] B) {
		Map<Pair, Integer> pointFreq = new HashMap<Pair, Integer>();
		int n = A.length;
		for(int i = 0; i < n; i++) {
			Pair p = new Pair(A[i], B[i]);
			if(pointFreq.containsKey(p)) {
				pointFreq.put(p, pointFreq.get(p) + 1);
			}
			else {
				pointFreq.put(p, 1);
			}
		}
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				Pair pi = new Pair(A[i],B[i]);
				Pair pj = new Pair(A[j], B[j]);
				Pair p1 = new Pair(A[i], B[j]);
				Pair p2 = new Pair(A[j], B[i]);
				if(!p1.equals(pi) && !p1.equals(pj) && !p2.equals(pi) && !p2.equals(pj)) {
					if(pointFreq.containsKey(p1)  && pointFreq.containsKey(p2)) {
						cnt = cnt + (pointFreq.get(p1) * pointFreq.get(p2) ) ;
						System.out.println(A[i] +" " +B[i] +"  " + A[j] +" "+B[j] +"  " + A[i] +" " +B[j] +"  " + A[j] +" "+B[i]);
					}

				}
			}
		}
		
		return cnt / 2;
    }
	
	
	public int pointsOnLine(int[] A, int[] B) {
		int n = A.length;
		int ans = 0;
		for(int i = 0; i < n; i++) {
			int overlap = 0;
			int vertical = 0;
			int curMax = 0;
			Map<Pair,Integer> map = new HashMap<Pair, Integer>();
			for(int j = i + 1; j < n; j++) {
				if(A[i] == A[j] && B[i] == B[j]) {
					overlap++;
				}
				else if(A[i] == A[j]) {
					vertical++;
				}
				else {
					int gcd = gcd(B[j] - B[i], A[j] -A[i]);
					int num = (B[j] - B[i]) / gcd;
					int den = (A[j] - A[i]) / gcd;
					Pair pair = new Pair(num, den);
					if(map.containsKey(pair)) {
						map.put(pair, map.get(pair) + 1);
					}
					else {
						map.put(pair,1);
					}
					curMax = Math.max(curMax, map.get(pair));
				}
				curMax = Math.max(curMax, vertical);
			}
			ans = Math.max(curMax + overlap + 1, ans);
		}
		return ans;
    }
	
	
	public int rightAngleTriangles(int[] A, int[] B) {
		int n = A.length;
		int cnt = 0;
		int mod = (int) Math.pow(10, 9)  + 7;
		Map<Integer, Integer> mapA = new HashMap<Integer, Integer>();
		Map<Integer, Integer> mapB = new HashMap<Integer, Integer>();
		for(int i = 0; i < n; i++) {
			if(mapA.containsKey(A[i])) {
				mapA.put(A[i], mapA.get(A[i]) + 1);
			}
			else {
				mapA.put(A[i], 1);
			}
			
			if(mapB.containsKey(B[i])) {
				mapB.put(B[i], mapB.get(B[i]) + 1);
			}
			else {
				mapB.put(B[i], 1);
			}
			
		}
		
		for(int i = 0; i < n; i++) {
			cnt = cnt + (mapA.get(A[i]) - 1) * (mapB.get(B[i]) - 1);
		}
		
		
		
		return cnt % mod;
		
	}
	
	
	public  int gcd(int a, int b) {
		if(a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}
	
	

}


class Pair {
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		return x + y;
	}
	

	@Override
	public boolean equals(Object obj) {
		Pair p = (Pair) obj;
		return (p.x == x && p.y == y);
	}
	
}
