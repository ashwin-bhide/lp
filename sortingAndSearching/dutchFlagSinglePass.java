class Solution {
    public void sortColors(int[] nums) {
        if(nums.length==0)
            return;
        //using 1 pass
        int low = 0, curr = 0, high = nums.length-1;
        int pivotValue = 1;
        while(curr<=high){
            if(nums[curr]<pivotValue){
                swap(nums,low,curr);
                low++; curr++;
            } else if(nums[curr]>pivotValue){
                swap(nums,high,curr);
                high--;
            } else{
                curr++;
            }
        }
        
    }
    private void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
