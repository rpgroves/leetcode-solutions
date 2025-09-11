class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Boolean>[] xMap = (HashMap<Integer, Boolean>[]) new HashMap[board.length];
        HashMap<Integer, Boolean>[] yMap = (HashMap<Integer, Boolean>[]) new HashMap[board[0].length];

        for(int x = 0; x < board.length; x++)
        {
            if(xMap[x] == null)
                xMap[x] = new HashMap<>();
            for(int y = 0; y < board[0].length; y++)
            {
                if(board[x][x] == '.')
                    continue;

                if(yMap[y] == null)
                    yMap[y] = new HashMap<>();
                int val = board[x][y] - '0';
                
                if(xMap[x].get(val) == null)
                    xMap[x].put(val, true);
                else
                    return false;
                
                if(yMap[y].get(val) == null)
                    yMap[y].put(val, true);
                else
                    return false;
            }
        }

        return true;
    }
}
