package datastructures.trees;

import java.util.ArrayList;
import java.util.List;

public class BSTree {
	private TreeNode root;
	public List<Integer> contents = new ArrayList<Integer>();
	
	public Integer[] getContentsInOrder() {
		clearContents();
		inorder();
		Integer[] array = new Integer[contents.size()];
		System.arraycopy(contents.toArray(), 0, array, 0, contents.size());
		return array;
	}
	
	public void clearContents() {
		contents.clear();
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public BSTree(TreeNode root) {
		this.root = root;
	}
	
	public BSTree() {
		this(null);
	}
	
	public void preorder() {
		preorder(root);
	}
	
	public void inorder() {
		inorder(root);
	}
	
	public void postorder() {
		postorder(root);
	}
	
	private void preorder(TreeNode root) {
		if(root != null) {
			System.out.print(root.getData() + " ");
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}
	
	private void inorder(TreeNode root) {
		if(root != null) {
			inorder(root.getLeft());
			contents.add(root.getData());
		//	System.out.print(root.getData() + " ");
			inorder(root.getRight());
		}
	}
	
	private void postorder(TreeNode root) {
		if(root != null) {
			postorder(root.getLeft());
			postorder(root.getRight());
			System.out.print(root.getData() + " ");
			
		}
	}

	
	private TreeNode insertRec(TreeNode root, int data) {
		TreeNode newNode = new TreeNode(data);
		
		//Base case of recursion
		if(root == null) {
			root = newNode;
		}
		else {
			if( data <= root.getData()) {
				root.setLeft(insertRec(root.getLeft(), data));
			}
			else {
				root.setRight(insertRec(root.getRight(), data));
			}
		}
		return root;
	}
	
	
	public void insert(int data) {
		root = insertRec(root, data);
	}
	
	public TreeNode find(int data) {
		if(root == null) {
			return null;
		}
		TreeNode current = root;
		while( current != null) {
			if(current.getData() == data) {
				return current;
			}
			
			else if( current.getData() < data) {
				current = current.getRight();
			}
			else {
				current = current.getLeft();
			}
		}
		return null;
	}
	
	public TreeNode findRec(TreeNode root, int data) {
		if(root == null) {
			return null;
		}
		
		if(root.getData() == data) {
			return root;
		}
		else if(root.getData() < data) {
			return findRec(root.getRight(), data);
		}
		else {
			return findRec(root.getLeft(), data);
		}
	}
	
	public TreeNode findRecElement(int data) {
		return findRec(root,data);
	}
	
	public TreeNode findMin() {
		if(root == null) {
			return null;
		}
		TreeNode current = root;
		while(current.getLeft() != null) {
			current = current.getLeft();
		}
		return current;
	}
	
	public TreeNode findMinRec(TreeNode root) {
		if( root == null) {
			return null;
		}
		else {
			
			// Base case 
			if( root.getLeft() == null) {   
				return root;
			}
			else {
				return findMinRec(root.getLeft());
			}
		}
	}
	
	
	public int findMinRecElement() {
		return findMinRec(root).getData();
	}
	
	public int findMinElement() {
		return findMin().getData();
	}
	
	public TreeNode findMax() {
		if(root == null) {
			return null;
		}
		TreeNode current = root;
		while(current.getRight() != null) {
			current = current.getRight();
		}
		
		return current;
	}
	
	public TreeNode findMaxRec(TreeNode root) {
		if(root == null) {
			return null;
		}
		else {
			if(root.getRight() == null) {  // Base case
				return root;
			}
			else {
				return findMaxRec(root.getRight());
			}
		}
			
	}
	
	public int findMaxElement() {
		return findMax().getData();
	}
}
