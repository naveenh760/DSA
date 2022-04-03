package solvingmethods.greedy;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return (lastPos == 0) ? true : false;
    }

    boolean canJump(int[] arr, int index){
        int n = arr.length;
        if(index >= n){
            return false;
        }
        if(index == n - 1){
            return true;
        }
        int maxJumps = arr[index];
        boolean canJump = false;
        for(int i = 1; i <= maxJumps; i++){
            canJump = canJump || canJump(arr, index + i);
        }
        return canJump;
    }


}
