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
	
	
	public ArrayList<ArrayList<Integer>> levelOrderLineByLineList() {
		if (root == null) {
			return null;
		}
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ans.add(new ArrayList<Integer>());
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		que.add(null);
		while (que.size() > 1) {
			TreeNode current = que.poll();
			if (current == null) {
				ans.add(new ArrayList<Integer>());
				que.add(null);
				continue;
			}
			ans.get(ans.size() - 1).add(current.getData());
			if (current.getLeft() != null) {
				que.add(current.getLeft());
			}
			if (current.getRight() != null) {
				que.add(current.getRight());
			}
		}
		return ans;
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

	
	public void printNodesKDist(TreeNode root, int k) {
		if(root == null) {
			return;
		}
		if(k == 0) {
			System.out.print(root.getData() + "");
		}
		else {
			printNodesKDist(root.getLeft(), k - 1);
			printNodesKDist(root.getRight(), k - 1);
		}
	}
	
	
	public void leftView() {
		if (root == null) {
			return;
		}
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		while (!que.isEmpty()) {
			int count = que.size();
			for (int i = 0; i < count; i++) {
				TreeNode current = que.poll();
				if(i == 0) {
					System.out.print(current.getData() + " ");
				}
				if (current.getLeft() != null) {
					que.add(current.getLeft());
				}
				if (current.getRight() != null) {
					que.add(current.getRight());
				}
			}
		}
	}
	
	public void leftView1(TreeNode root, int level, Integer maxLevel) {    // Not working need to debug
		if(root == null) {
			return;
		}
		if( maxLevel < level) {
			System.out.print(root.getData() + " ");
			maxLevel = level;
		}
		leftView1(root.getLeft(), level + 1, maxLevel);
		leftView1(root.getRight(), level + 1, maxLevel);
			
	}
	
	public void leftView1() {
		leftView1(root, 1, 0);
	}
	
	
	public boolean isSumProperty(TreeNode root)
    {
        if(root == null) {
        	return true;
        }
        if(root.getLeft() == null && root.getRight() == null) {
        	return true;
        }
        int sum = 0;
        if(root.getLeft() != null) {
        	sum+= root.getLeft().getData();
        }
        if(root.getRight() != null) {
        	sum += root.getRight().getData();
        }
        
        if(root.getData() == sum) {
        	return isSumProperty(root.getLeft()) && isSumProperty(root.getRight());
        }
        return false;
    }
	
	
	public boolean isBalancedNaive(TreeNode root) {
		if(root == null) {
			return true;
		}
		int lh = height(root.getLeft());
		int rh = height(root.getRight());
		
		if(Math.abs(lh - rh) <= 1) {
			return isBalancedNaive(root.getLeft()) && isBalancedNaive(root.getRight());
		}
		return false;
	}
	
	public int isBalanced(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int lh = isBalanced(root.getLeft());
		if(lh == -1) {
			return -1;
		}
		int rh = isBalanced(root.getRight());
		if(rh == -1) {
			return -1;
		}
		if(Math.abs(lh - rh) > 1) {
			return -1;
		}
		else {
			return 1 + Math.max(lh, rh);
		}
	}
	
	
	public boolean isBalanced() {
		if(isBalanced(root) == -1) {
			return false;
		}
		return true;
	}
	
	public int maxWidth() {
		if (root == null) {
			return 0;
		}
		int maxWidth = 0;
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		while (!que.isEmpty()) {
			int count = que.size();
			maxWidth = Math.max(count, maxWidth);
			for (int i = 0; i < count; i++) {
				TreeNode current = que.poll();
				if (current.getLeft() != null) {
					que.add(current.getLeft());
				}
				if (current.getRight() != null) {
					que.add(current.getRight());
				}
			}
		}
		return maxWidth;
	}
}
