class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if(nums.length==0)
            return result;
        
        permuteHelper(result,nums,new ArrayDeque<Integer>(),0);
        return result;
    }
    private void permuteHelper(List<List<Integer>> result, int[] nums,ArrayDeque<Integer> inProgress,int index){
        //base condition
        if(index==nums.length){
            result.add(new ArrayList(inProgress));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            //constraint
            if(!inProgress.contains(nums[i])){
                //choose
                inProgress.add(nums[i]);
                //explore
                permuteHelper(result,nums,inProgress,index+1);
                //unchoose
                inProgress.removeLast();   
            }
        }
    }
}
