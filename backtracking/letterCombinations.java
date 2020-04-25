//can be modified to use StringBuilder() to spped up the string manipulations as it is a mutable class and string is immutable
//sb.setLength(chosen.length()-1); is used to get substring upto the chosen index 
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
        if(index==digits.length()){
            result.add(inProgress);
            return;
        } else{
            int phoneDigitsIndex = digits.charAt(index) - '0';
            String letters = phoneDigits[phoneDigitsIndex];
            for(int i=0;i<letters.length();i++){
                inProgress += letters.charAt(i); //choose
                letterCombinationsHelper(digits,phoneDigits,result,inProgress,index+1);  //explore
                inProgress = inProgress.substring(0,index); //unchoose
            }      
        }
        
    }
}
