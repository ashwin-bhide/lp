class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if(nums.length==0)
            return result;
        
        subsetsHelper(result,nums,new LinkedList<Integer>(),0);
        return result;
    }
    private void subsetsHelper(List<List<Integer>> result,int[] nums,LinkedList<Integer> inProgress,int index){
        //base case
        if(index>nums.length){
            return;
        }
        
        result.add(new LinkedList(inProgress));
        
        for(int i=index;i<nums.length;i++){
            //choose
            inProgress.add(nums[i]);
            //explore
            subsetsHelper(result,nums,inProgress,i+1);
            //unchoose
            inProgress.removeLast();
        }
    }
}
