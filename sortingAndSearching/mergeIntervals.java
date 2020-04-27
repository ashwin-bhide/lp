class Solution {
    public class StartComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return a[0] - b[0];
        }
    }
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList();
        if(intervals.length==0)
            return result.toArray(new int[result.size()][]);
        
        List<int[]> intervalsList = new ArrayList();
        intervalsList = Arrays.asList(intervals);
        
        Collections.sort(intervalsList,new StartComparator());
        
        result.add(intervalsList.get(0));
        for(int i=1;i<intervalsList.size();i++){
            if(result.getLast()[1] >= intervalsList.get(i)[0])
                result.getLast()[1] = Math.max(result.getLast()[1],intervalsList.get(i)[1]);
            else
                result.add(intervalsList.get(i));
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
