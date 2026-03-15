class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        backTrack(board, 0);

        return res;
    }
    public void backTrack(char[][] board, int row){
        if(row == board.length){
            res.add(construct(board));
            return;
        }
        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                backTrack(board, row + 1);
                board[row][col] = '.';
            }
        }
    }
    public boolean isSafe(char[][] board, int row, int col){
        int n = board.length;

        for(int i =0; i < row; i++){
            if(board[i][col] == 'Q') return false;
        }
        for(int i = row - 1, j = col - 1; i>= 0 && j >= 0; i--,j--){
            if(board[i][j] == 'Q') return false;
        }
        for(int i = row - 1, j = col + 1; i >=0 && j<n; i--,j++){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
    public List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();

        for(int i= 0; i < board.length; i++){
            list.add(new String(board[i]));
        }
        return list;
    }
}