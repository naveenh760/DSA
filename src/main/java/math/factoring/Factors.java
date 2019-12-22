package math.factoring;

import java.util.ArrayList;
import java.util.Collections;

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
 
 public static void main(String[] args) {
	 System.out.println(Factors.getFactors2(85416));
 }
	
}
