package datastructures.trees;

public class TreeBuild {

	public TreeNode prev = null;

	TreeNode bToDLL(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode head = bToDLL(root.getLeft());

		if (prev == null) {
			head = root;
		} else {
			prev.setRight(root);
			root.setLeft(prev);
		}
		prev = root;

		bToDLL(root.getRight());
		return head;
	}

	public static TreeNode buildTreePreIn(int[] preOrder, int[] inOrder) {
		int n = preOrder.length;
		return buildTreePreIn(preOrder, inOrder, 0, n - 1, 0, n - 1);
	}

	public static TreeNode buildTreePreIn(int[] preOrder, int[] inOrder, int pl, int pr, int il, int ir) {
		TreeNode root = new TreeNode(preOrder[pl]);
		int index = linearSearch(inOrder, root.val);
		int leftNodesCount = index - il;
		int rightNodesCount = ir - index;
		if (leftNodesCount != 0) {
			root.left = buildTreePreIn(preOrder, inOrder, pl + 1, pl + leftNodesCount, il, index - 1);
		}
		if (rightNodesCount != 0) {
			root.right = buildTreePreIn(preOrder, inOrder, pl + leftNodesCount + 1, pr, index + 1, ir);
		}
		return root;
	}

	private static int linearSearch(int[] inOrder, int data) {
		int n = inOrder.length;
		for (int i = 0; i < n; i++) {
			if (inOrder[i] == data) {
				return i;
			}
		}
		return -1;
	}

	public TreeNode buildTreeInPost(int[] inOrder, int[] postOrder) {
		int n = inOrder.length;
		return buildTreeInPost(inOrder, postOrder, 0, n - 1, 0, n - 1);
	}

	private TreeNode buildTreeInPost(int[] inOrder, int[] postOrder, int il, int ir, int pl, int pr) {
		TreeNode root = new TreeNode(postOrder[pr]);
		int index = linearSearch(inOrder, root.val);
		int leftNodesCount = index - il;
		int rightNodesCount = ir - index;
		if (leftNodesCount != 0) {
			root.left = buildTreeInPost(inOrder, postOrder, il, index - 1, pl, pl + leftNodesCount - 1);
		}
		if (rightNodesCount != 0) {
			root.right = buildTreeInPost(inOrder, postOrder, index + 1, ir, pr - rightNodesCount, pr - 1);
		}
		return root;
	}

}
