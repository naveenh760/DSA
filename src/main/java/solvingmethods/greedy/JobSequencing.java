package solvingmethods.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	void printJobSecheduling(Job arr[]) {
		int n = arr.length;
		int noOfJobs = 0;
		int maxProfit = 0;
		Arrays.sort(arr, new JobSort());
		int[] sequence = new int[n];  //jth position will contain index of job starting at j
		Arrays.fill(sequence, -1);
		for(int i = 0; i < n; i++) {
			//identify last possible slot for ith job
			for(int j = Math.min(arr[i].deadline,n) - 1; j >= 0 ; j--) {
				if(sequence[j] == -1) {
					sequence[j] = i;
					noOfJobs++;
					maxProfit += arr[i].profit;
					break;
				}
			}
		}
	System.out.println(noOfJobs + " "+ maxProfit);	
		
	}

}

class Job{
	char id;
	int deadline;
	int profit;
	public Job(char id, int deadline, int profit) {
		this.deadline = id;
		this.deadline = deadline;
		this.profit = profit;
	}
}

class JobSort implements Comparator<Job>{

	@Override
	public int compare(Job o1, Job o2) {
		return o2.profit - o1.profit;
	}
	
}
