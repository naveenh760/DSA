package datastructures.trees.bst;

import java.util.ArrayList;
import java.util.Collections;

import datastructures.trees.TreeNode;
import datastructures.trees.TreeTraversals;

public class BSTreeProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Integer> recoverTree(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        TreeTraversals.inorder(A, inorder);
        ArrayList<Integer> sorted = new ArrayList<Integer>(inorder);
        Collections.sort(sorted);
        int n = inorder.size();
        for(int i = 0; i < n; i++) {
        	if(inorder.get(i) != sorted.get(i)) {
        		ans.add(inorder.get(i));
        		ans.add(sorted.get(i));
        		break;
        	}
        }
        Collections.sort(ans,Collections.reverseOrder());
        return ans;
    }
	
	public ArrayList<Integer> recoverTree1(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        TreeTraversals.inorder(A, inorder);
        int n = inorder.size();
        for(int i = 0; i < n - 1; i++) {
        	if(inorder.get(i) > inorder.get(i+1)) {
        			temp.add(inorder.get(i));
        			temp.add(inorder.get(i + 1));
        		
        	}
        }
        if(temp.size() == 2) {
        	Collections.sort(temp);
        	return temp;
        }
        else {
        	ans.add(Math.max(temp.get(0), temp.get(1)));
        	ans.add(Math.min(temp.get(2), temp.get(3)));
        }
        
        Collections.sort(ans);
        return ans;
    }
	
	
	boolean isValidBST(TreeNode root, int greatestLowerbound, int leastUpperbound) {
		if(root == null) {
			return true;
		}
		
		return (root.val > greatestLowerbound) && (root.val < leastUpperbound) 
			   && isValidBST(root.left, greatestLowerbound, Math.min(leastUpperbound, root.val))
			   && isValidBST(root.right, Math.max(greatestLowerbound, root.val), leastUpperbound);
	}
	
	boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

}
