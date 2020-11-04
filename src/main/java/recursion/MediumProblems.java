package recursion;

import java.util.ArrayList;

public class MediumProblems {

	public static void main(String[] args) {
		powerSet("SAI");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= 3; i++) {
			arr.add(i);
		}
		powerSet(arr);
		System.out.println(sixlet(arr, 2));

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

	public static void powerSet(ArrayList<Integer> arr) {
		powerSet(arr, 0, new ArrayList<Integer>());
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

	public static int sixlet(ArrayList<Integer> arr, int B) {
		return sixlet(arr, B, 0, 0, 0, 0);
	}

}
