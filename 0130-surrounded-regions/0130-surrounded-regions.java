class Solution {

    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public boolean isValid(int row, int col, int n, int m){

        if(row>=0 && row < n && col >= 0 && col < m) return true;
        return false;
    }
    int rowDirection[] = {1,-1,0,0};
    int colDirection[] = {0,0,1,-1};

    public void bfs(char[][] board, int startRow, int startCol, int n, int m) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startRow, startCol));

        board[startRow][startCol] = '#';

        while (!q.isEmpty()) {

            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;

            for (int i = 0; i < 4; i++) {

                int newRow = r + rowDirection[i];
                int newCol = c + colDirection[i];

                if (isValid(newRow, newCol, n, m) &&
                    board[newRow][newCol] == 'O') {

                    board[newRow][newCol] = '#';
                    q.add(new Pair(newRow, newCol));
                }
            }
        }

    }
    public void solve(char[][] board) {

        if(board == null || board.length == 0) return;
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {

            if (board[i][0] == 'O')
                bfs(board, i, 0, n, m);

            if (board[i][m - 1] == 'O')
                bfs(board, i, m - 1, n, m);
        }
        for (int j = 0; j < m; j++) {

            if (board[0][j] == 'O')
                bfs(board, 0, j, n, m);

            if (board[n - 1][j] == 'O')
                bfs(board, n - 1, j, n, m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

}