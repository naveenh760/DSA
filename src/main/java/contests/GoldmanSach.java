package contests;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GoldmanSach {

	public static int noOfWaysToDrawTheGame(int totalScore) {
		int count = 0;
		for(int x = 0; x <= totalScore / 2; x++) {
			for(int y = 0; y <= totalScore / 4; y++) {
				for(int z = 0; z <= totalScore / 6; z++) {
					if( 2*x + 4*y + 6*z == totalScore) {
						count++;
						System.out.print(x);
						System.out.print(y);
						System.out.print(z);
						System.out.println();
					}
				}
			}
		}
		return count;
	}
	
	
	public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
		Stack<String> stack = new Stack<String>();
		List<String> outputArray = new ArrayList<String>();
		inputArray.add("1");
		for(int i = 0 ; i< inputArray.size(); i++) {
			if(stack.isEmpty()) {
				stack.push(inputArray.get(i));
			}
			else {
				if(stack.peek().equals(inputArray.get(i))) {
					stack.push(inputArray.get(i));
				}
				else {
					int count = stack.size();
					if(count >= burstLength) {
						stack.clear();
					}
					else {
						while(!stack.isEmpty()) {
							outputArray.add(stack.pop());
						}
					}
					stack.push(inputArray.get(i));
				}
			}
		}
		
		return outputArray;
		

    }

	
}
