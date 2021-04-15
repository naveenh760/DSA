package datastructures.trees;

public class TreeProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int height(TreeNode root) {
		if(root == null) {
			return -1;
		}
		return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
	}
	
	public boolean isBalancedNaive(TreeNode root) {
		if(root == null){
            return true;
        }
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		return Math.abs(leftHeight - rightHeight) <= 1 && isBalancedNaive(root.left) && isBalancedNaive(root.right);
	}
	
	
	public TreeBalanced isBalanced(TreeNode root) {
		if(root == null) {
			return new TreeBalanced(-1, true);
		}
		TreeBalanced leftBalanced = isBalanced(root.left);
		if(!leftBalanced.isBalanced) {
			return new TreeBalanced(-1, false);
		}
		TreeBalanced rightBalanced = isBalanced(root.right);
		if(!rightBalanced.isBalanced) {
			return new TreeBalanced(-1, false);
		}
		boolean curBalanced = Math.abs(leftBalanced.height - rightBalanced.height) <= 1;
		return new TreeBalanced(1 + Math.max(leftBalanced.height, rightBalanced.height), curBalanced && leftBalanced.isBalanced && rightBalanced.isBalanced);
	}
	
	
	public TreeDiameter getDiameter(TreeNode root) {
		if(root == null) {
			return new TreeDiameter(-1, 0);
		}
		
		TreeDiameter left = getDiameter(root.left);
		TreeDiameter right = getDiameter(root.right);
		int curHeight = 1 + Math.max(left.height, right.height);
		int curDiameter = Math.max(2 + left.height + right.height, Math.max(left.diameter, right.diameter));
		return new TreeDiameter(curHeight, curDiameter);
	}


}

class TreeBalanced{
	int height;
	boolean isBalanced;
	
	public TreeBalanced(int height, boolean isBalanced) {
		this.height = height;
		this.isBalanced = isBalanced;
	}	
}


class TreeDiameter{
	int height;
	int diameter;
	public TreeDiameter(int height, int diameter) {
		super();
		this.height = height;
		this.diameter = diameter;
	}
	
}
