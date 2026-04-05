class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rowIdx = searchPotentialRow(matrix, target);

        if (rowIdx != -1) {
            return binarySearchOverRow(rowIdx, matrix, target);
        }

        return false;
    }

    // Step 1: Find possible row
    private int searchPotentialRow(int[][] matrix, int target) {

        int low = 0;
        int high = matrix.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (matrix[mid][0] <= target &&
                matrix[mid][matrix[0].length - 1] >= target) {
                return mid;
            }
            else if (matrix[mid][0] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // Step 2: Binary search inside that row
    private boolean binarySearchOverRow(int rowIdx, int[][] matrix, int target) {

        int low = 0;
        int high = matrix[rowIdx].length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (matrix[rowIdx][mid] == target) {
                return true;
            }
            else if (matrix[rowIdx][mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return false;
    }
}