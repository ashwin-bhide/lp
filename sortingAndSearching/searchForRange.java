class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1; res[1] = -1;
        if(nums.length==0)
            return res;
        
        int left = 0, right = nums.length-1;
        int index = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(target == nums[mid]){
                index = mid;
                break;   
            }
            else if(target<nums[mid])
                right = mid-1;
            else
                left = mid+1;
        }
        if(index!=-1){
            int low = index,high = index;
            while(low>=0 && nums[low]==target)
                low--;
            while(high<nums.length && nums[high]==target)
                high++;
            res[0] = low+1; res[1] = high-1;
        }
        return res;
    }
}
