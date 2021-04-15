package datastructures.trees;

public class TreeNode {
 
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public int getData() {
		return val;
	}
	public void setData(int data) {
		this.val = data;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public TreeNode(int data) {
		this.val = data;
		this.left = null;
		this.right = null;
	}
	
}
