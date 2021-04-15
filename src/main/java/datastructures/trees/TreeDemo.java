package datastructures.trees;

import datastructures.trees.bst.BSTree;

public class TreeDemo {

	public static void main(String[] args) {
	//	BSTreeExample();
		BSTreeExample1();
		
	}
	
	
	public static void TreeExample() {
		
	}
	
	public static void BSTreeExample() {
		BSTree tree = new BSTree();
		tree.insert(3);
		tree.insert(4);
		tree.insert(1);
	}
	
	public static void BSTreeExample1() {
		BSTree tree = new BSTree();
		tree.insertIter(3);
		tree.insertIter(4);
		tree.insertIter(1);
	}

}
