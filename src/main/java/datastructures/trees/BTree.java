package datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTree {
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

	public BTree(TreeNode root) {
		this.root = root;
	}

	public BTree() {
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
		if (root != null) {
			System.out.print(root.getData() + " ");
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}

	private void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.getLeft());
			contents.add(root.getData());
			// System.out.print(root.getData() + " ");
			inorder(root.getRight());
		}
	}

	private void postorder(TreeNode root) {
		if (root != null) {
			postorder(root.getLeft());
			postorder(root.getRight());
			System.out.print(root.getData() + " ");

		}
	}

	public void levelOrder() {
		if (root == null) {
			return;
		}
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		while (!que.isEmpty()) {
			TreeNode current = que.poll();
			System.out.print(current.getData() + " ");
			if (current.getLeft() != null) {
				que.add(current.getLeft());
			}
			if (current.getRight() != null) {
				que.add(current.getRight());
			}
		}
	}

	public void levelOrderLineByLine() {
		if (root == null) {
			return;
		}
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		que.add(null);
		while (que.size() > 1) {
			TreeNode current = que.poll();
			if (current == null) {
				System.out.println();
				que.add(null);
				continue;
			}
			System.out.print(current.getData() + " ");
			if (current.getLeft() != null) {
				que.add(current.getLeft());
			}
			if (current.getRight() != null) {
				que.add(current.getRight());
			}
		}
	}

	public void levelOrderLineByLine1() {
		if (root == null) {
			return;
		}
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		while (!que.isEmpty()) {
			int count = que.size();
			for (int i = 0; i < count; i++) {
				TreeNode current = que.poll();
				System.out.print(current.getData() + " ");
				if (current.getLeft() != null) {
					que.add(current.getLeft());
				}
				if (current.getRight() != null) {
					que.add(current.getRight());
				}
			}
			System.out.println();
		}
	}

	private int size(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + size(root.getLeft()) + size(root.getRight());
	}

	public int size() {
		return size(root);
	}
	
	public int sizeIter() {
		if (root == null) {
			return 0;
		}
		int count = 0;
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		while (!que.isEmpty()) {
			TreeNode current = que.poll();
			count++;
			if (current.getLeft() != null) {
				que.add(current.getLeft());
			}
			if (current.getRight() != null) {
				que.add(current.getRight());
			}
		}
		return count;
	}
	
	
	private int getMax(TreeNode root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(root.getData(), Math.max(getMax(root.getLeft()), getMax(root.getRight())));
	}
	
	public int getMax() {
		return getMax(root);
	}
	
	public int getMaxIter() {
		int max = Integer.MIN_VALUE;
		if (root == null) {
			return max;
		}
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		while (!que.isEmpty()) {
			TreeNode current = que.poll();
			max = Math.max(max, current.getData());
			if (current.getLeft() != null) {
				que.add(current.getLeft());
			}
			if (current.getRight() != null) {
				que.add(current.getRight());
			}
		}
		return max;
	}
	
	private int height(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
	}
	
	public int height() {
		return height(root);
	}

}
