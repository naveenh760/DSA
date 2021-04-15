package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeCompute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int OddEvenDiff1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		que.add(null);
		int level = 1;
		int curSum = 0;
		int oddSum = 0;
		int evenSum = 0;
		while (que.size() > 0) {
			TreeNode current = que.poll();
			if (current == null) {
				if(level % 2 == 0) {
					evenSum += curSum;
				}
				else {
					oddSum += curSum;
				}
				curSum = 0;
				level++;
				if (!que.isEmpty()) {
					que.add(null);
				}
				continue;
			}
			curSum = curSum + current.val;
			if (current.left != null) {
				que.add(current.left);
			}
			if (current.right != null) {
				que.add(current.right);
			}
		}
		return oddSum - evenSum;
	}
	
	
	public int oddEvenDiff(TreeNode root, int level, int diff) {
		if(root == null) {
			return diff;
		}
		if(level % 2 == 0) {
			diff = diff - root.val;
		}
		else {
			diff = diff + root.val;
		}
		diff = oddEvenDiff(root.left, level + 1, diff);
		diff = oddEvenDiff(root.right, level + 1, diff);
		return diff;
	}
	
	
	public int oddEvenDiff(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return root.val - oddEvenDiff(root.left) - oddEvenDiff(root.right);
	}
	
	
	


}
