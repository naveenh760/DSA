package datastructures.queue;

public interface IQueue {

	public void enqueue(int data);

	public int dequeue();

	public boolean isEmpty();

	public int front();

}
