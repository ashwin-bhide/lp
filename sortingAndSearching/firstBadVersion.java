/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n==0)
            return -1;
        int left = 1, right = n;
        while(left<right){
            int mid = left + (right-left)/2;
            if(!isBadVersion(mid))
                left = mid+1;
            else
                right = mid;
        }
        return (isBadVersion(left))?left:-1;
    }
}