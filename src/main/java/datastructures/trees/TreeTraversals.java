package datastructures.trees;

import java.util.*;

public class TreeTraversals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void preorder(TreeNode root, ArrayList<Integer> result) {
		if (root != null) {
			result.add(root.val);
			preorder(root.getLeft(), result);
			preorder(root.getRight(), result);
		}
	}
	
	 public ArrayList<Integer> preorderIter(TreeNode A) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        TreeNode root = A;
	        while(!stack.isEmpty() || root != null){
	            if(root != null){
	                result.add(root.val);
	                stack.push(root);
	                root = root.left;
	            }
	            else{
	                TreeNode top = stack.peek();
	                root = top.right;
	                stack.pop();
	            }
	        }
	        return result;
	    }

	public static void postorder(TreeNode root, ArrayList<Integer> result ) {
		if (root != null) {
			postorder(root.getLeft(),result);
			postorder(root.getRight(),result);
			result.add(root.val);

		}
	}

	public static void inorder(TreeNode root, ArrayList<Integer> result) {
		if (root != null) {
			inorder(root.left, result);
			result.add(root.val);
			inorder(root.right, result);
		}
	}
	
	
	public ArrayList<Integer> inorderTraversal(TreeNode A) {
        TreeNode root = A;
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || root != null)
        {
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                result.add(stack.peek().val);
                root = stack.peek().right;
                stack.pop();
            }
        }
        return result;
    }

	public void levelOrder(TreeNode root) {
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

	public void levelOrderLineByLine(TreeNode root) {
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

	public ArrayList<ArrayList<Integer>> levelOrderLineByLineList(TreeNode root) {
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

	public ArrayList<ArrayList<Integer>> levelOrderZigZag(TreeNode root) {
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
				if (ans.size() % 2 == 0) {
					Collections.reverse(ans.get(ans.size() - 1));
				}
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

	public void levelOrderZigZag1(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				TreeNode current = stack1.peek();
				System.out.print(current.val + " ");
				if (current.left != null) {
					stack2.push(current.left);
				}
				if (current.right != null) {
					stack2.push(current.right);
				}
			}
			while (!stack2.isEmpty()) {
				TreeNode current = stack2.peek();
				System.out.print(current.val + " ");
				if (current.right != null) {
					stack1.push(current.right);
				}
				if (current.left != null) {
					stack1.push(current.left);
				}

			}

		}
	}

	public void levelOrderLineByLine1(TreeNode root) {
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

	public ArrayList<ArrayList<Integer>> levelOrderToList(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		while(!que.isEmpty()){
			int cnt = que.size();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			result.add(arr);
			for(int i = 0; i < cnt; i++){
				TreeNode current = que.poll();
				arr.add(current.val);
				if(current.left != null){
					que.add(current.left);
				}
				if(current.right != null){
					que.add(current.right);
				}
			}
		}
		return result;
	}

	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, ArrayList<Integer>> levelMap = new HashMap<Integer, ArrayList<Integer>>();
		buildlevelMap(root, 0, levelMap);
		int minLevel = Integer.MAX_VALUE;
		int maxLevel = Integer.MIN_VALUE;
		for (int num : levelMap.keySet()) {
			minLevel = Math.min(minLevel, num);
			maxLevel = Math.max(maxLevel, num);
		}
		for (int i = minLevel; i <= maxLevel; i++) {
			ans.add(levelMap.get(i));
		}

		return ans;
	}

	private void buildlevelMap1(TreeNode root, int level, HashMap<Integer, ArrayList<Integer>> levelMap) {
		if (root == null) {
			return;
		}
		if (levelMap.containsKey(level)) {
			levelMap.get(level).add(root.val);
		} else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(root.val);
			levelMap.put(level, list);
		}
		buildlevelMap1(root.left, level - 1, levelMap);
		buildlevelMap1(root.right, level + 1, levelMap);

	}

	private void buildlevelMap(TreeNode root, int level, HashMap<Integer, ArrayList<Integer>> levelMap) {
		if (root == null) {
			return;
		}
		Queue<Pair> que = new LinkedList<Pair>();
		que.add(new Pair(root, 0));
		while (!que.isEmpty()) {
			Pair current = que.poll();
			int currentLevel = current.level;
			addToMap(current, levelMap);
			if (current.node.left != null) {
				que.add(new Pair(current.node.left, currentLevel - 1));
			}
			if (current.node.right != null) {
				que.add(new Pair(current.node.right, currentLevel + 1));
			}
		}
	}

	private void addToMap(Pair current, HashMap<Integer, ArrayList<Integer>> levelMap) {
		int currentLevel = current.level;
		if (levelMap.containsKey(currentLevel)) {
			levelMap.get(currentLevel).add(current.node.val);
		} else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(current.node.val);
			levelMap.put(currentLevel, list);
		}

	}
	
	
	public ArrayList<Integer> topView(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		TreeMap<Integer, TreeNode> levelMap = new TreeMap<Integer, TreeNode>();
		buildTopViewMap(root, levelMap);
		for (int level:levelMap.keySet()) {
			ans.add(levelMap.get(level).val);
		}

		return ans;
	}
	
	private void buildTopViewMap(TreeNode root, TreeMap<Integer, TreeNode> levelMap) {
		if (root == null) {
			return;
		}
		Queue<Pair> que = new LinkedList<Pair>();
		que.add(new Pair(root, 0));
		while (!que.isEmpty()) {
			Pair current = que.poll();
			int currentLevel = current.level;
			if(!levelMap.containsKey(currentLevel)) {
				levelMap.put(currentLevel, current.node);
			}
			if (current.node.left != null) {
				que.add(new Pair(current.node.left, currentLevel - 1));
			}
			if (current.node.right != null) {
				que.add(new Pair(current.node.right, currentLevel + 1));
			}
		}
	}

	
	
	
	}

class Pair {
	TreeNode node;
	int level;

	public Pair(TreeNode node, int level) {
		this.node = node;
		this.level = level;
	}
}
