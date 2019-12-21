package datastructures.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackLLTest {

	@Test
	void testPush() {
		StackLL stack = new StackLL();
		stack.push(3);
		stack.push(4);
		assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());		
	}

	@Test
	void testPop() {
		StackLL stack = new StackLL();
		stack.push(3);
		stack.pop();
		assertTrue(stack.isEmpty());
	}

	@Test
	void testTop() {
		StackLL stack = new StackLL();
		stack.push(3);
		int top = stack.top();
		assertEquals(3, top);
	}

	@Test
	void testIsEmpty() {
		StackLL stack = new StackLL();
		assertTrue(stack.isEmpty());
	}

}
