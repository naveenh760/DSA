package solvingmethods.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FracKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double maxKnapsack(int capacity, Item arr[]) {
		Arrays.sort(arr, new ItemSort());
		double res = 0;
		int curCapacity = capacity;
		for(Item item: arr) {
			if(item.weight <= curCapacity) {
				res+= item.value;
				curCapacity = curCapacity - item.weight;
			}
			else {
				res+= curCapacity * (item.value /(double)item.weight);
				break;
			}
		}
		return res;
	}

}


class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class ItemSort implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		//Sort the ratios in descending order
		double ratio1 = o1.value / (double)o1.weight ;
		double ratio2 = o2.value / (double)o2.weight ;
		
		if(ratio2 > ratio1){
		    return 1;
		}
		else if(ratio2 == ratio1){
		    return 0;
		}
		else{
		    return -1;
		}
	}
	
}
