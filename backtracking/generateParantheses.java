class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        if(n==0)
            return result;
        generateParenthesisHelper(result,"",0,0,n);
        return result;
        
    }
    private void generateParenthesisHelper(List<String> result,String inProgress,int oc,int cc,int n){
        //base condition
        if(inProgress.length()==2*n){
            result.add(inProgress);
            return;
        } 
        //constraint 1, and maintain order of operation
        if(oc<n){
            generateParenthesisHelper(result,inProgress+'(',oc+1,cc,n);
        }
        //constraint 2, if close count is less than open count, only then go ahead and add ')' bracket
        if(cc<oc){
            generateParenthesisHelper(result,inProgress+')',oc,cc+1,n);
        }
    }
}
