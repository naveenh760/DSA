package math.basic;

public class BasicProbs {

	public static void main(String[] args) {
	//	quadraticRoots(2, 8, 8);
		System.out.println(nthFibo1(3));
		
	}
	
	public static int factorial(int n) {
		if(n < 0) {
			return -1;
		}
		else if(n == 0) {
			return 1;
		}
		else {
			return n* factorial(n-1);
		}
		
	}
	
	public static int nthFibo(int n) {
		if(n <= 0) {
			return 0;
		}
		else if(n == 1) {
			return 1;
		}
		else {
			return nthFibo(n - 1) + nthFibo(n - 2);
		}
		
	}
	
	
	public static int nthFibo1(int n) {
		if( n <= 1) {
			return n;
		}
		int b = 0;
		int a = 1;
		int sum = 0;
		for(int i = 2; i <= n; i++) {
			sum = a + b;
			b = a;
			a = sum;
		}
		return sum;
	}
	
	public static boolean isArmStrong(int n) {
		int sum = 0;
		int temp = n;
		while( temp > 0 ) {
			int digit = temp % 10;
			sum += Math.pow(digit,3);
			temp = temp / 10;
		}
		if(sum == n) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int mod(int a,int b) {
		int dividend = a / b;
		int reminder = a - (b * dividend);
		return reminder;
	}
	
	public static int divide(int a ,int b) {
		int count = 0;
		int sum = b;
		while(sum <= a) {
			count++;
			sum += b;
		}
		return count;
	}
	
	public static void quadraticRoots(int a,int b,int c)
    {
        int desc = (int)Math.pow(b,2) - 4*a*c;
        if(desc < 0){
            System.out.print("Imaginary");
        }
        else if(desc == 0){
            double root = Math.floor(-b / (2.0 * a));
            System.out.print((int)root +" " + (int)root);
        }
        else{
            double root = Math.floor((- b + Math.sqrt(desc)) / (2.0*a));
            System.out.print((int)root);
        }
    }
	
	 public double termOfGP(int A,int B,int N)
	    {
		 	double r = B / (double) A;
		    return A * Math.pow(r, N -1);	
		  
	        
	    }

	 
}
