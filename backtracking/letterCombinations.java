class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if(digits.length()==0)
            return result;
        
        String[] phoneDigits = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        
        letterCombinationsHelper(digits,phoneDigits,result,"",0);
        return result;
    }
    private void letterCombinationsHelper(String digits,String[] phoneDigits,List<String> result,String inProgress,int index){
        //base condition
        if(inProgress.length()==digits.length()){
            result.add(inProgress);
            return;
        }
        
        int len = inProgress.length();
        int phoneDigitsIndex = digits.charAt(len-1) - '0';
        String letters = phoneDigits[phoneDigitsIndex];
        for(int i=index;i<letters.length();i++){
            inProgress += letters.charAt(i); //choose
            letterCombinationsHelper(digits,phoneDigits,result,inProgress,index+1);  //explore
            inProgress.substring(0,len); //unchoose
        }
        
    }
}
