class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n<=1){
            return intervals;
        }
         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> merged = new ArrayList<>();

        merged.add(intervals[0]);
        int[] lastInterval = merged.get(0);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= lastInterval[1]) {
            
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            } else {
            
                merged.add(intervals[i]);
                lastInterval = intervals[i];
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}