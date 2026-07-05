class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    int[] rowDirection = {1,-1,0,0};
    int[] colDirection = {0,0,1,-1};

    boolean isValid(int r, int c, int n, int m){
        return r >= 0 && r < n && c >= 0 && c < m;
    }
     
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        if(n==1 && m==1) return 0;

        int[][] ans = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j< m; j++){
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);

        pq.add(new Pair(0, 0, 0));
        ans[0][0] = 0;
        
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.dist;

            if(curr.row == n - 1 && curr.col == m - 1) return node;

            for(int i = 0; i < 4; i++){
                int newRow = curr.row + rowDirection[i];
                int newCol = curr.col + colDirection[i];

                if(isValid(newRow, newCol, n, m)){
                    int minEffort = Math.max(node, Math.abs(heights[curr.row][curr.col] - heights[newRow][newCol]));
                    if(minEffort <ans[newRow][newCol]){
                        ans[newRow][newCol]=minEffort;
                        pq.add(new Pair(newRow,newCol,minEffort));
                    }
                }
            }
        }
        return 0;
        
    }
}