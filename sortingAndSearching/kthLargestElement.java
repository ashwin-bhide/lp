class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length==0)
            return -1;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        
        for(int n:nums){
            minHeap.add(n);
            if(minHeap.size()>k)
                minHeap.poll();
        }
        return minHeap.peek();
    }
}
