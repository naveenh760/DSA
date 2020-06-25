package datastructures.queue;

public class QueueDemo {

	public static void main(String[] args) {
		QueueAr q = new QueueAr(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println(q.dequeue());
		

	}

}
