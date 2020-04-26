class Solution {
    public void sortColors(int[] nums) {
        if(nums.length==0)
            return;
        //using 2 passes
        int pivotValue = 1;
        int low = 0, high = nums.length-1;
        //forward pass - puts all elements smaller to pivotValue at the front of the array
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivotValue){
                swap(nums,i,low);
                low++;
            }
        }
        //backward pass - puts all elements greater than pivotValue at the back of the array
        //low is currently pointing to the next index of the last element less than pivotValue
        //so we end our backward pass at that index
        for(int i=nums.length-1;i>=low;i--){
            if(nums[i]>pivotValue){
                swap(nums,i,high);
                high--;
            }
        }
        
    }
    private void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
