class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==0)
            return -1;
        
        if(nums.length==1)
            return 0;
        
        int left = 0, right = nums.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]>nums[mid+1]) //descending slope, peak is on left
                right = mid; 
            else                    //ascending slope, peak on right
                left = mid+1;
        }
        //left==right, only 1 element left in search space
        return left; //index of peak element
    }
}
