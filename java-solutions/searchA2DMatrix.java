class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1, row = -1, mid = -1;
        while (l <= r)
        {
            mid = ((r - l) / 2) + l;
            System.out.println(matrix[mid][0]);
            if(matrix[mid][0] == target)
                return true;
            if(matrix[mid][0] <= target && matrix[mid][matrix[0].length-1] >= target)
            {
                break;
            }
            if(matrix[mid][0] < target)
            {
                if(mid < matrix.length - 1)
                    l = mid + 1;
                else
                    break;
            }
            if(matrix[mid][0] > target)
            {
                r = mid - 1;
            }
        }
        row = mid;
        System.out.println("row: " + row);


        l = 0;
        r = matrix[row].length - 1;
        while (l <= r)
        {
            mid = ((r - l) / 2) + l;
            System.out.println(matrix[row][mid]);
            if(matrix[row][mid] == target)
                return true;
            if(matrix[row][mid] < target)
            {
                if(mid < matrix[row].length - 1)
                    l = mid + 1;
                else
                    break;
            }
            if(matrix[row][mid] > target)
            {
                r = mid - 1;
            }
        }

        return false;
    }
}
