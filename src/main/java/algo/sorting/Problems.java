package algo.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Problems {

	public static void main(String[] args) {
		int a[] = {1, 6,7,7,9,13};
		int b[] = {2 , 4, 4, 6,15,17,19};
		Integer[] result = intersectionOfSortedArrays1(a, b);
		System.out.println(Arrays.toString(result));

	}

	public static Integer[] interectionOfSortedArrays(int a[], int b[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int m = a.length;
		int n = b.length;
		
		for(int i = 0 ; i < m; i++) {
			if( i > 0 && a[i] == a[i - 1]) {
				continue;
			}
			
			for(int j = 0; j < n; j++) {
				if(a[i] == b[j]) {
					list.add(a[i]);
					break;
				}
			}
		}
		return list.toArray(new Integer[0]);
	}
	
	public static Integer[] intersectionOfSortedArrays1(int a[], int b[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int m = a.length;
		int n = b.length;
		int i = 0, j = 0;
		
		while(i < m && j < n) {
			if( i > 0 && a[i] == a[i - 1]) {
				i++;
				continue;
			}
			if(a[i] < b[j]) {
				i++;
			}
			else if(a[i] > b[j]) {
				j++;
			}
			else {
				list.add(a[i]);
				i++;
				j++;
			}
		}
		return list.toArray(new Integer[0]);
	}
	
	
	public static Integer[] unionOfSortedArrays(int a[], int b[]) {
		int m = a.length;
		int n = b.length;
		int i = 0, j = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while( i < m && j < n) {
			if(i != 0 && a[i] == a[i - 1]) {
				i++;
				continue;
			}
			
			if( j!= 0 && b[j] == b[j - 1]) {
				j++;
				continue;
			}
			
			if(a[i] < b[j]) {
				list.add(a[i]);
				i++;
			}
			else if( a[i] > b[j]) {
				list.add(b[j]);
				j++;
			}
			else {
				list.add(a[i]);
				i++;
				j++;
			}
		}
		
		while(i < m) {
			if( i == 0 || a[i] != a[ i - 1]) {
				list.add(a[i]);
				i++;
			}
		}
		
		while( j < n) {
			if( j == 0 || b[j] != b[j - 1]) {
				list.add(b[j]);
				j++;
			}
		}
		return list.toArray(new Integer[0]);
	}
	
}
