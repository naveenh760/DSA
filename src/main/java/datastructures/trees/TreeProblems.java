package datastructures.trees;

public class TreeProblems {

	public TreeNode prev = null;
	
	TreeNode bToDLL(TreeNode root)
    {
	  if(root == null){
	      return root;
	  }
	  TreeNode head = bToDLL(root.getLeft());
	  
	  if(prev == null){
	      head = root;
	  }
	  else{
	      prev.setRight(root);
	      root.setLeft(prev);
	  }
	  prev = root;
	  
	  bToDLL(root.getRight());
	  return head;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
