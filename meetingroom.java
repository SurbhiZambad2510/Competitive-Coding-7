//Time Complexity :O(N)
//Space Complexity : O(N)

class Solution {
    public int minMeetingRooms(int[][] intervals) {
       if(intervals == null || intervals.length == 0)
           return 0;
        
        Arrays.sort(intervals,(a,b) ->a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++)
        {
          int peeker = pq.peek();
            if(intervals[i][0]>=peeker)
            {
                pq.remove();
                pq.add(intervals[i][1]);
            }
            else
            {
                pq.add(intervals[i][1]);
            }
        }
        return pq.size();
    }
}