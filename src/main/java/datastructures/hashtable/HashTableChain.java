package datastructures.hashtable;

import java.util.LinkedList;

public class HashTableChain implements HashTable{

	int capacity;
	LinkedList<Integer>[] table;
	
	@SuppressWarnings("unchecked")
	HashTableChain(int capacity){
		this.capacity = capacity;
		table= new LinkedList[capacity];
		for(int i = 0; i < table.length; i++) {
			table[i] = new LinkedList<Integer>();
		} 
	}
	
	@Override
	public int hash(int key) {
		return key % capacity;
	}
	
	@Override
	public boolean contains(int key) {
		int index = hash(key);
		for(int element: table[index]) {
			if(element == key) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void add(int key) {
		int index = hash(key);
		table[index].add(key);
	}
	
	@Override
	public void remove(int key) {
		int index = hash(key);
		if(table[index].contains(key)) {
			table[index].remove((Integer) key);
		}
	}
}
