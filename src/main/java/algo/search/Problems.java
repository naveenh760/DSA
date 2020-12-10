package algo.search;

public class Problems {

	public static void main(String[] args) {
		System.out.println(athMagical1(807414236, 3788, 38141));

	}

	long floorSqrt(long x) {
		long low = 0;
		long high = x;
		if (x == 0) {
			return 0;
		}
		if (x == 1) {
			return 1;
		}
		while (low <= high) {
			long mid = low + (high - low) / 2;
			if (x / mid == mid) {
				return mid;
			} else if (x / mid < mid) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return high;
	}

	public int peakElement(int[] arr) {
		int peakPos = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if ((i == 0 || arr[i - 1] <= arr[i]) && (i == n - 1 || arr[i + 1] <= arr[i])) {
				peakPos = i;
				break;
			}
		}
		return peakPos;
	}
	
	public int peakElement1(int[] arr) {
		int peakPos = 0;
		int n = arr.length;
		int beg = 0;
		int end = n - 1;
		while( beg <= end) {
			int mid = beg + (end - beg) / 2;
			if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid])) {
				peakPos = mid;
				break;
			}
			else if(mid > 0 && arr[mid] < arr[mid - 1]) {
				end = mid - 1;
			}
			else{
				beg = mid + 1;
			}
		}
		return peakPos;
	}
	
	public int singleSorted(int[] A) {
        int n = A.length;
        int start = 0;
        int end = n - 1;
        int ans = -1;
        if(n == 1){
            return A[0];
        }
        if(A[0] != A[1]){
            return A[0];
        }
        if(A[n - 1] != A[n - 2]){
            return A[n - 1];
        }
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if((A[mid] != A[mid - 1]) && (A[mid] != A[mid + 1])){
                return A[mid];
            }
            else if((A[mid] == A[mid+1] && mid % 2 == 0 ) || (A[mid] == A[mid -1] && (mid -1) % 2 == 0) ){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return ans;
    }
	
	
	public int searchInsert(int[] A, int B) {
        int n = A.length;
        int ans = n;
        int start = 0;
        int end = n - 1;
        while( start <= end){
            int mid = start + (end - start)/2;
            if(A[mid] < B){
                start = mid + 1;
            }
            else if(A[mid] >= B){
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
	
	public int searchMatrix(int[][] A, int B) {
        int R = A.length;
        int C = A[0].length;
        int startC, endC;
        int curR = 0;
        while(curR < R){
            startC = 0;
            endC = C - 1;
            while(startC <= endC){
                int midC = startC + (endC - startC) / 2;
                if(B == A[curR][midC]){
                    return 1;
                }
                else if(B > A[curR][midC]){
                    if(B > A[curR][C-1]){
                        curR++;
                        break;
                    }
                    else{
                        startC = midC + 1;
                    }
                }
                else if(B < A[curR][midC]){
                    endC = midC - 1;
                }
                    
            }
            
            if(startC > endC){
                return 0;
            }
        }
        return 0;
    }
	
	public int searchMatrix1(int[][] A, int B) {
		int R = A.length;
		int C = A[0].length;
		int start = 0;
		int end = R*C - 1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			int r = mid / C;
			int c = mid % C;
			if(A[r][c] == B) {
				return 1;
			}
			else if(A[r][c] < B) {
				start = mid + 1;
			}
			else {
				end = mid -1;
			}
			
		}
		return 0;
	}
	
	
	public int athMagical(int A, int B, int C) {
        int mod = (int) (Math.pow(10,9)) + 7;
        int num = 2;
        int count = 0;
        while(true){
            if((num % B == 0) || (num % C == 0)){
                count++;
                if(count == A){
                    break;
                }
            }
            num++;
        }
        return num % mod;
    }
	
		
	public static int athMagical1(int A, int B, int C) {
		long ans = 0;
        int mod = (int) (Math.pow(10,9)) + 7;
        long low = 1L;
        long high = (long)A * (long)Math.max(B, C);
        long lcm = (B * C) / gcd(B,C);
        while(low <= high) {
        	long mid =  (low + (high - low) / 2);
        	long count = (mid / B) + (mid / C) - (mid / lcm);
        	if(count >= A) {
        		ans = mid;
        		high = mid - 1;
        	}
        	else {
        		low = mid + 1;
        	}
        }
        return (int) (ans % mod);
    }
	
		
	static int gcd(int A, int B) {
		if(A == 0) {
			return B;
		}
		return gcd(B % A, A);
	}

}
