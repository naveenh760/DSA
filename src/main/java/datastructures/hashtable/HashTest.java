package datastructures.hashtable;

public class HashTest {

	public static void main(String[] args) {
		HashTable table = new HashTableOpAdr(10);
		table.add(5);
		table.add(6);
		table.remove(6);
		table.add(15);
		System.out.println(table.contains(6));
		System.out.println(table.contains(5));
		System.out.println(table.contains(15));

	}

}
