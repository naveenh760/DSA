package datastructures.trees;

import java.util.ArrayList;

public class TreeCompare {
	
	public int isSameTree(TreeNode A, TreeNode B) {
        ArrayList<Integer> preOrderA = new ArrayList<Integer>();
        ArrayList<Integer> preOrderB = new ArrayList<Integer>();
        ArrayList<Integer> inOrderA = new ArrayList<Integer>();
        ArrayList<Integer> inOrderB = new ArrayList<Integer>();
        TreeTraversals.preorder(A,preOrderA);
        TreeTraversals.preorder(B,preOrderB);
        TreeTraversals.inorder(A,inOrderA);
        TreeTraversals.inorder(B,inOrderB);
        if(preOrderA.equals(preOrderB) && inOrderA.equals(inOrderB) ){
            return 1;
        }
        return 0;
        
    }
	
	public int isSameTree1(TreeNode A, TreeNode B) {
		if(isSameTreeBool(A, B)) {
			return 1;
		}
		return 0;
	}
	
	public boolean isSameTreeBool(TreeNode A, TreeNode B) {
		if(A == null && B == null) {
			return true;
		}
		if(A == null || B == null) {
			return false;
		}
		
		return A.val == B.val && isSameTreeBool(A.left, B.left) && isSameTreeBool(A.right, B.right);
	}
	
	public boolean isMirrorTreeBool(TreeNode A, TreeNode B) {
		if(A == null && B == null) {
			return true;
		}
		if(A == null || B == null) {
			return false;
		}
		
		return A.val == B.val && isMirrorTreeBool(A.left, B.right) && isMirrorTreeBool(A.right, B.left);
	}
	
}
