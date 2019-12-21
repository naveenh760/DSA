package datastructures.queue;

import java.util.LinkedList;

public class QueueLL {
  private LinkedList<Integer> list = new LinkedList<Integer>();
  
  public void enqueue(int data) {
	  list.addLast(data);
  }
  
  public int dequeue() {
	  return list.removeFirst();
  }
	
  public boolean isEmpty() {
	  return list.isEmpty();
  }
  
  public int front() {
	  return list.getFirst();
  }
}
