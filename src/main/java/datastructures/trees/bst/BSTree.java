package datastructures.trees.bst;

import datastructures.trees.TreeNode;
import datastructures.trees.TreeProperties;

public class BSTree {
	private TreeNode root;

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

	private TreeNode insertRec(TreeNode root, int data) {
		// Base case of recursion
		if (root == null) {
			root = new TreeNode(data);
		} else {
			if (data < root.getData()) {
				root.setLeft(insertRec(root.getLeft(), data));
			} else if (data > root.getData()) {
				root.setRight(insertRec(root.getRight(), data));
			}
		}
		return root;
	}

	public void insert(int data) {
		root = insertRec(root, data);
	}

	public void insertIter(int data) {
		TreeNode newNode = new TreeNode(data);
		if (root == null) {
			root = newNode;
		}
		TreeNode parent = null;
		TreeNode current = root;
		while (current != null) {
			parent = current;
			if (data < current.getData()) {
				current = current.getLeft();
			} else if (data > current.getData()) {
				current = current.getRight();
			} else {
				return;
			}
		}
		if (data < parent.getData()) {
			parent.setLeft(newNode);
		} else if (data > parent.getData()) {
			parent.setRight(newNode);
		}
	}

	public TreeNode find(int data) {
		if (root == null) {
			return null;
		}
		TreeNode current = root;
		while (current != null) {
			if (current.getData() == data) {
				return current;
			}

			else if (current.getData() < data) {
				current = current.getRight();
			} else {
				current = current.getLeft();
			}
		}
		return null;
	}

	public TreeNode findRec(TreeNode root, int data) {
		if (root == null) {
			return null;
		}

		if (root.getData() == data) {
			return root;
		} else if (root.getData() < data) {
			return findRec(root.getRight(), data);
		} else {
			return findRec(root.getLeft(), data);
		}
	}

	public TreeNode findRecElement(int data) {
		return findRec(root, data);
	}

	public TreeNode findMin() {
		if (root == null) {
			return null;
		}
		TreeNode current = root;
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current;
	}

	public TreeNode findMinRec(TreeNode root) {
		if (root == null) {
			return null;
		} else {

			// Base case
			if (root.getLeft() == null) {
				return root;
			} else {
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
		if (root == null) {
			return null;
		}
		TreeNode current = root;
		while (current.getRight() != null) {
			current = current.getRight();
		}

		return current;
	}

	public TreeNode findMaxRec(TreeNode root) {
		if (root == null) {
			return null;
		} else {
			if (root.getRight() == null) { // Base case
				return root;
			} else {
				return findMaxRec(root.getRight());
			}
		}

	}

	public int findMaxElement() {
		return findMax().getData();
	}

	

	public void printGivenLevel(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.println(root.getData());
		} else if (level > 1) {
			printGivenLevel(root.getLeft(), level - 1);
			printGivenLevel(root.getRight(), level - 1);

		}
	}

	public void printLevelOrder(TreeNode root) {
		int h = TreeProperties.height(root);
		for (int i = 1; i <= h; i++) {
			printGivenLevel(root, i);
		}
	}

	public TreeNode delete(TreeNode root, int data) {
		if (root == null) {
			return null;
		}
		if (data < root.getData()) {
			root.setLeft(delete(root.getLeft(), data));
		} else if (data > root.getData()) {
			root.setRight(delete(root.getRight(), data));
		} else {
			if (root.getLeft() == null) {
				return root.getRight();
			} else if (root.getRight() == null) {
				return root.getLeft();
			} else {
				TreeNode succ = getSucc(root);
				root.setData(succ.getData());
				root.setRight(delete(root.getRight(), succ.getData()));
			}
		}
		return root;
	}

	private TreeNode getSucc(TreeNode root) {
		TreeNode current = root.getRight();
		while (current != null && current.getLeft() != null) {
			current = current.getLeft();
		}
		return current;
	}

	public TreeNode floor(int x) {
		TreeNode res = null;
		TreeNode current = root;
		while (current != null) {
			if (current.getData() == x) {
				return current;
			} else if (current.getData() < x) {
				res = current;
				current = current.getRight();
			} else {
				current = current.getLeft();
			}
		}
		return res;
	}

	public TreeNode ceil(int x) {
		TreeNode current = root;
		TreeNode res = null;
		while (current != null) {
			if (current.getData() == x) {
				return current;
			} else if (current.getData() < x) {
				current = current.getRight();
			} else {
				res = current;
				current = current.getLeft();
			}
		}
		return res;
	}

}
