package solvingmethods.greedy;

import java.util.Arrays;

public class ActivitySelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int maxActivities(int start[] , int end[]) {
		int n = start.length;
		Activity[] activities = new Activity[n];
		for(int i = 0 ; i < n; i++) {
			activities[i] = new Activity(start[i], end[i]);
		}
		Arrays.sort(activities);
		int maxCount = 1;
		int lastPerformed = 0;
		for(int i = 1; i < n; i++) {
			if(activities[i].start >= activities[lastPerformed].end) {
				maxCount++;
				lastPerformed = i;
			}
		}
		return maxCount;
	}

}


class Activity implements Comparable<Activity>{
	int start;
	int end;
	public Activity(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Activity o) {
		return this.end - o.end;
	}
	
}
