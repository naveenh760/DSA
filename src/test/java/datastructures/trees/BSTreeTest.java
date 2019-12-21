package datastructures.trees;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BSTreeTest {


	@Test
	void testInsert() {
		Integer[] expected = {1,3, 4};
		BSTree tree = new BSTree();
		tree.insert(3);
		tree.insert(4);
		tree.insert(1);
		assertArrayEquals(expected, tree.getContentsInOrder());
	}
	
	@Test
	void testFind() {
		BSTree tree = new BSTree();
		tree.insert(3);
		tree.insert(4);
		tree.insert(1);
		assertNotNull(tree.find(3));
		assertNull(tree.find(5));
	}
	
	@Test
	void testFindMin() {
		BSTree tree = new BSTree();
		tree.insert(3);
		tree.insert(4);
		tree.insert(1);
		assertEquals(1, tree.findMinElement());
	}
	
	@Test
	void testFindMinRec() {
		BSTree tree = new BSTree();
		tree.insert(3);
		tree.insert(4);
		tree.insert(1);
		assertEquals(1, tree.findMinRecElement());
	}
	
	@Test
	void testFindMax() {
		BSTree tree = new BSTree();
		tree.insert(3);
		tree.insert(4);
		tree.insert(1);
		assertEquals(4, tree.findMaxElement());
	}
	
	@Test
	void testFindRec() {
		BSTree tree = new BSTree();
		tree.insert(3);
		tree.insert(4);
		tree.insert(1);
		assertNotNull(tree.findRecElement(3));
		assertNull(tree.findRecElement(5));
	}

}
