package datastructures.arrays;

import java.util.ArrayList;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		int n = intervals.size();
		if (n == 0) {
			intervals.add(newInterval);
			return intervals;
		}
		int insertPos = 0;
		int overlapI = -1;
		int overlapJ = -1;
		for (int i = 0; i < n; i++) {
			Interval curInterval = intervals.get(i);
			int maxStart = Math.max(curInterval.start, newInterval.start);
			int minEnd = Math.min(curInterval.end, newInterval.end);
			if (maxStart > minEnd) {
				if (newInterval.start > curInterval.start) {
					insertPos = i + 1;
				}
			} else {
				if (overlapI == -1) {
					overlapI = i;
				}
				overlapJ = i;
			}
		}

		if (overlapI == -1) {
			intervals.add(insertPos, newInterval);
			return intervals;

		} else {
			int mStart = Math.min(intervals.get(overlapI).start, newInterval.start);
			int mEnd = Math.max(intervals.get(overlapJ).end, newInterval.end);
			Interval merged = new Interval(mStart, mEnd);
			intervals.subList(overlapI, overlapJ + 1).clear();
			int newSize = intervals.size();
			if (newSize == 0) {
				intervals.add(merged);
			} else {
				intervals.add(overlapI, merged);
			}
		}

		return intervals;

	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
