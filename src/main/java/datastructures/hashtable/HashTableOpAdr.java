package datastructures.hashtable;

public class HashTableOpAdr implements HashTable {
	
	int[] table;
	int capacity;
	int size;
	
	public HashTableOpAdr(int capacity) {
		this.capacity = capacity;
		size = 0;
		table = new int[capacity];
		for(int i=0 ; i < table.length; i++) {
			table[i] = -1;
		}
	}
	
    public HashTableOpAdr() {
		this(10);
	}
	

	@Override
	public int hash(int key) {
		return key % capacity;
	}

	@Override
	public boolean contains(int key) {
		if(size == 0) {
			return false;
		}
		int index = hash(key);
		int j = index;
		while(table[index] != -1) {
			if(table[index] == key) {
				return true;
			}
			index = (index + 1) % capacity;
			if(index == j) {
				break;
			}
		}
		return false;
	}

	@Override
	public void add(int key) {
		if(size >= capacity) {
			return;
		}
		int index = hash(key);
		while(table[index] != -1 && table[index] != -2 && table[index] != key) {
			index  = (index + 1) % capacity;
		}
		table[index] = key;
		size++;

	}

	@Override
	public void remove(int key) {
		int index = hash(key);
		int j = index;
		while(table[index] != -1) {
			if(table[index] == key) {
				table[index] = -2;
				size--;
				break;
			}
			index = (index + 1) % capacity;
			if(index == j) {
				break;
			}
		}
		

	}

}
