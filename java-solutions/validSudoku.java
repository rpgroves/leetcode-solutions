class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Boolean>[] xMap = (HashMap<Integer, Boolean>[]) new HashMap[board.length];
        HashMap<Integer, Boolean>[] yMap = (HashMap<Integer, Boolean>[]) new HashMap[board[0].length];
        HashMap<Integer, Boolean>[][] squareMap = (HashMap<Integer, Boolean>[][]) new HashMap[board.length][board[0].length];


        for (int i = 0; i < board.length; i++) {
            xMap[i] = new HashMap<>();
        }
        for (int j = 0; j < board[0].length; j++) {
            yMap[j] = new HashMap<>();
        }
        for(int x = 0; x < squareMap.length; x++)
        {
            for(int y = 0; y < squareMap[0].length; y++)
            {
                squareMap[x][y] = new HashMap<>();
            }
        }

        for(int x = 0; x < board.length; x++)
        {
            for(int y = 0; y < board[0].length; y++)
            {
                if(board[x][y] == '.')
                    continue;

                int val = board[x][y] - '0';
                
                if(xMap[x].get(val) == null)
                    xMap[x].put(val, true);
                else
                    return false;
                
                if(yMap[y].get(val) == null)
                    yMap[y].put(val, true);
                else
                    return false;

                if(squareMap[x/3][y/3].get(val) == null)
                    squareMap[x/3][y/3].put(val, true);
                else
                    return false;
            }
        }

        return true;
    }
}
