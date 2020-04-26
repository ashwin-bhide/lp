class Solution {
    public class CountComparator implements Comparator<Map.Entry<Integer,Integer>>{
        public int compare(Map.Entry<Integer,Integer> e1,Map.Entry<Integer,Integer> e2){
            int v1 = e1.getValue();
            int v2 = e2.getValue();
            return v1-v2;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==0)
            return new int[k];
        
        Map<Integer,Integer> hm = new HashMap();
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(new CountComparator());
        
        for(int n:nums){
            hm.put(n,hm.getOrDefault(n,0)+1);
        }
        
       for(Map.Entry<Integer,Integer> e:hm.entrySet()){
           minHeap.add(e);
           if(minHeap.size()>k)
               minHeap.poll();
       }
       
       int[] res = new int[k];
       int i=0;
       while(!minHeap.isEmpty())
           res[i++] = minHeap.poll().getKey();
        
        return res;
        
    }
}
