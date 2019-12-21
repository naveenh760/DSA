package datastructures.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueLLTest {

	@Test
	void testEnqueue() {
		QueueLL q = new QueueLL();
		q.enqueue(3);
		q.enqueue(4);
		assertEquals(3, q.front());
	}

	@Test
	void testDequeue() {
		QueueLL q = new QueueLL();
		q.enqueue(3);
		q.enqueue(4);
		q.dequeue();
		assertEquals(4, q.dequeue());
	}

	@Test
	void testIsEmpty() {
		QueueLL q = new QueueLL();
		q.enqueue(3);
		q.dequeue();
		assertTrue(q.isEmpty());
		q.enqueue(4);
		assertFalse(q.isEmpty());
	}

}
