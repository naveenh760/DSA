package utilities;

import java.util.HashMap;
import java.util.Map;

public class ArrayUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	public static Map<Integer, Integer> computeFreqMap(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int num: arr) {
			if(map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			}
			else {
				map.put(num, 1);
			}
		}
		return map;
	}
	
	
	

}
