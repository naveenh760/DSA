package datastructures.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NodeProperties {

	public static void main(String[] args) {
		int[] preOrder = {1,2,4,5,3};
		int[] inOrder = {4,2,5,1,3};
		TreeNode root = TreeBuild.buildTreePreIn(preOrder, inOrder);
		System.out.println(findPath(root, 7));
		printInoutTime(root);
	}
	
	public static ArrayList<Integer> findPath(TreeNode root, int val){
		return findPath(root,val, new ArrayList<Integer>(), new ArrayList<Integer>());
	}
	
	public static ArrayList<Integer> findPath(TreeNode root, int val, ArrayList<Integer> current, ArrayList<Integer> ans){
		if(root == null) {
			return ans;
		}
		if(root.val == val) {
			current.add(root.val);
			return new ArrayList<Integer>(current);
		}
		
		current.add(root.val);
		ans = findPath(root.left, val, current, ans);
		ans = findPath(root.right, val, current, ans);
		current.remove(current.size() -1);
		return ans;
	}
	
	public static void printInoutTime(TreeNode root) {
		HashMap<Integer,Integer> inMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> outMap = new HashMap<Integer, Integer>();
		calculateInOutTime(root, inMap, outMap, 1);
		for(int num: inMap.keySet()) {
			System.out.println(num + " : " + inMap.get(num) + " " + outMap.get(num));
		}
		
	}
	
	
	public static int calculateInOutTime(TreeNode root, Map<Integer, Integer> inMap,Map<Integer, Integer> outMap, int t) {
		if(root == null) {
			return t;
		}
		inMap.put(root.val, t);
		t++;
		t = calculateInOutTime(root.left, inMap,outMap, t);
		t = calculateInOutTime(root.right, inMap,outMap, t);
		outMap.put(root.val, t);
		t++;
		return t;
	}

}



	
	

