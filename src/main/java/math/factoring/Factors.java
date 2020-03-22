package math.factoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Factors {

 public static ArrayList<Integer> getFactors1(int A){
	 ArrayList<Integer> factors = new ArrayList<Integer>();
	 for(int i=1 ; i <= A; i++) {
		 if(A % i == 0) {
			 factors.add(i);
		 }
	 }
	 return factors;
 }
 
 public static ArrayList<Integer> getFactors2(int A){
	 ArrayList<Integer> factors = new ArrayList<Integer>();
	 for(int i =1 ; i<= Math.sqrt(A); i++) {
		 if(A % i == 0) {
			 factors.add(i);
			 if(i != Math.sqrt(A)) {
				 factors.add(A / i);
			 }
		 }	 
	 }
	 Collections.sort(factors);
	 return factors;
 }
 
 public static boolean isPrime(int n) {
	 if(n <= 1) {
		 return false;
	 }
	 for(int i = 2; i*i <= n; i++) {
		 if(n % i == 0) {
			 return false;
		 }
	 }
	 return true;
 }
 
 
 public static ArrayList<Integer> sieveOfErat(int n){
	 boolean[] primes = new boolean[n + 1];
	 ArrayList<Integer> result = new ArrayList<Integer>();
	 Arrays.fill(primes, true);
	 
	 for(int p = 2; p*p <= n ; p++) {
		 for(int i = p * p; i <= n; i+=p) {
			 primes[i] = false;
		 }
	 }
	 
	 for(int i = 2; i <=n ; i++) {
		 if(primes[i] == true) {
			 result.add(i);
		 }
	 }
	 
	 return result;
 }
 
 public static int exactly3Divisors(int N)
 {
     ArrayList<Integer> primes = sieveOfErat((int)Math.sqrt(N));
     return primes.size();
 }
 
 
 public static void main(String[] args) {
	 //System.out.println(Factors.getFactors2(85416));
	/* ArrayList<Integer> results = sieveOfErat(50);
	 for(int result: results) {
		 System.out.print(result + " ");
	 } */
	 System.out.println(exactly3Divisors(30));
 }
	
}
