package datastructures.hashtable;

public interface HashTable {
	
	int hash(int key);
	boolean contains(int key);
	void add(int key);
	void remove(int key);

}
