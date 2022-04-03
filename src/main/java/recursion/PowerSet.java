package recursion;

import java.util.*;
import java.util.stream.Collectors;

public class PowerSet {

	public static void main(String[] args) {
		// powerSet("SAI");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= 2; i++) {
			arr.add(i);
		}
		arr.add(1);
//	powerSet(arr);
		powerSetDup(arr);
	//	System.out.println(sixlet(arr, 2));


	}

	public static void powerSet(String input, int index, String current) {
		if (index == input.length()) {
			System.out.print(current + " ");
			return;
		}

		powerSet(input, index + 1, current + input.charAt(index));
		powerSet(input, index + 1, current);
	}

	public static void powerSet(String input) {
		powerSet(input, 0, "");
	}

	public static void powerSet(ArrayList<Integer> arr, int index, ArrayList<Integer> current) {
		if (index == arr.size()) {
			System.out.println(current + " ");
			return;
		}
		ArrayList<Integer> curExclude = new ArrayList<Integer>(current);
		powerSet(arr, index + 1, curExclude);
		current.add(arr.get(index));
		ArrayList<Integer> curInclude = new ArrayList<Integer>(current);
		powerSet(arr, index + 1, curInclude);

	}
	
	public static void powerSet1(ArrayList<Integer> arr, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> ans) {
		if (index == arr.size()) {
			ans.add(new ArrayList<Integer>(current));
			return;
		}
		powerSet1(arr, index + 1, current,ans);
		current.add(arr.get(index));
		powerSet1(arr, index + 1, current, ans);
		current.remove(current.size() - 1);
	}

	public static void powerSet(ArrayList<Integer> arr) {
		Collections.sort(arr);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		powerSet1(arr, 0, new ArrayList<Integer>(), ans);
		Comparator<ArrayList<Integer>> comparator = (o1, o2) -> {
			int minSize = Math.min(o1.size(), o2.size());
			for (int i = 0; i < minSize; i++) {
				int c = o1.get(i).compareTo(o2.get(i));
				if (c != 0) {
					return c;
				}
			}
			return Integer.compare(o1.size(), o2.size());
		};
		Collections.sort(ans,comparator);
		
	}


	public static void powerSetDup(ArrayList<Integer> arr) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> freqArr = getFrequency(arr);
		powerSetDup(freqArr, 0, new ArrayList<Integer>() , ans);
		System.out.println(ans);
		
	}

	static ArrayList<ArrayList<Integer>> getFrequency(ArrayList<Integer> arr) {
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		for(int num: arr) {
			if(freqMap.containsKey(num)) {
				freqMap.put(num,freqMap.get(num) + 1);
			}
			else {
				freqMap.put(num, 1);
			}
		}
		Set<Integer> keys = freqMap.keySet();
		ArrayList<ArrayList<Integer>> freqArr = new ArrayList<ArrayList<Integer>>();
		for(int key: keys) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(key);
			temp.add(freqMap.get(key));
			freqArr.add(temp);
		}
		return freqArr;
	}

	private static void powerSetDup(ArrayList<ArrayList<Integer>> freqArr, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> ans) {
		if(index == freqArr.size()) {
			ans.add(new ArrayList<Integer>(current));
			return;
		}
		int key = freqArr.get(index).get(0);
		int freq = freqArr.get(index).get(1);
		for(int i = 0; i <= freq; i++) {
			for(int j = 0; j < i; j++) {
				current.add(key);
			}
			powerSetDup(freqArr,index + 1,current, ans);
			for(int j = 0; j < i; j++) {
				int ind = current.size() - 1;
				current.remove(ind);
			}
		}
		
	}

	public static int sixlet(ArrayList<Integer> arr, int B, int index, int sum, int count, int ans) {
		if (sum > 1000) {
			return ans;
		}
		if (count == B) {
			ans++;
			return ans;
		}
		if (index == arr.size()) {
			return ans;
		}

		return sixlet(arr, B, index + 1, sum + arr.get(index), count + 1, ans)
				+ sixlet(arr, B, index + 1, sum, count, ans);
	}

	public static int sixlets(ArrayList<Integer> a, int index, int sum, int cnt) {
		if (sum > 1000) {
			return 0;
		}
		if (cnt == 0) {
			return 1;
		}
		if (index == a.size()) {
			return 0;
		}

		return sixlets(a, index + 1, sum + a.get(index), cnt - 1) 
				+ sixlets(a, index + 1, sum, cnt);
	}

	public static int sixlet(ArrayList<Integer> arr, int B) {
		return sixlets(arr, 0, 0, B);
	}

	
}
