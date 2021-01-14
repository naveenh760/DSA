package algo.sorting;

import java.util.Arrays;

import utilities.Student;

public class CountingSortObjects {

	public static void main(String[] args) {
		sortStudents();

	}
	
	public static void sortStudents() {
		int n = 5;
		Student[] students = new Student[n];
		
		students[0] = new Student("C", 90);
		students[1] = new Student("A", 92);
		students[2] = new Student("B", 90);
		students[3] = new Student("E", 92);
		students[4] = new Student("D", 95);
		Arrays.sort(students);
		countingSort(students, 100);
	//	countingSortDesc(students, 100);
		Arrays.stream(students).forEach(student -> System.out.println(student.name + " " + student.marks));
	}
	
	
	static void countingSort(Student arr[], int range) {
		int n = arr.length;
		int[] count= new int[range + 1];
		Arrays.fill(count, 0);
		for(int i = 0; i < n; i++) {
			count[arr[i].marks]++;
		}
		for(int i = 1; i < range + 1; i++) {
			count[i] = count[i - 1] + count[i];
		}
		
		Student[] output = new Student[n];
		for(int i = n - 1; i >= 0; i--) {
			output[count[arr[i].marks] - 1] = arr[i];
			count[arr[i].marks]--;
		}
		for(int i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}
	
	
	static void countingSortDesc(Student arr[], int range) {
		int n = arr.length;
		int[] count= new int[range + 1];
		int countArrLen = count.length;
		Arrays.fill(count, 0);
		for(int i = 0; i < n; i++) {
			count[arr[i].marks]++;
		}
		for(int i = countArrLen - 2; i >= 0; i--) {
			count[i] = count[i + 1] + count[i];
		}
		
		Student[] output = new Student[n];
		for(int i = n - 1; i >= 0; i--) {
			output[count[arr[i].marks] - 1] = arr[i];
			count[arr[i].marks]--;
		}
		for(int i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}
	
	

}
