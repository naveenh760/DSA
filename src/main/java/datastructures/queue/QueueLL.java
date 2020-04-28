package datastructures.queue;

import java.util.LinkedList;

public class QueueLL implements IQueue{
  private LinkedList<Integer> list = new LinkedList<Integer>();
  
  @Override
  public void enqueue(int data) {
	  list.addLast(data);
  }
  
  @Override
  public int dequeue() {
	  return list.removeFirst();
  }
	
  @Override
  public boolean isEmpty() {
	  return list.isEmpty();
  }
  
  @Override
  public int front() {
	  return list.getFirst();
  }
}
