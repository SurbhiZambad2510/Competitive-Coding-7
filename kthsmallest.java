//time complexity : o(log N)
//space complexity : O(1)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int len = m*n;
        if(matrix == null || len == 0)
            return 0;
        
        int low= matrix[0][0];
        int high = matrix[n-1][m-1];
        while(low<high)
        {
            int mid = low + (high - low)/2;
            int counter = count(matrix,mid);
            if(counter<k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
    private int count(int[][]matrix,int mid)
    {
        int n = matrix.length;
        int m = matrix[0].length-1;
        int countno = 0;
        for(int i =0;i<n;i++)
        {
           while(m>=0 && matrix[i][m]>mid) m--;
            countno+= m+1;
        }
        return countno;
    }
}