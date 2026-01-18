class Solution {
    static int ans = 1;
    public int largestMagicSquare(int[][] arr) {

        ans = 1;
        int rowCount = arr.length;
        int colCount = arr[0].length;

        for(int i=0; i<rowCount; i++){
            for(int j=0; j<colCount; j++){
                //After every pass, the maximum size of a square decreases
                int remainingSquareSize = Math.min(rowCount-i,colCount-j);
                for(int k=2; k<=remainingSquareSize; k++){
                    if(isMagicSquare(arr,i,j,k)) {ans=Math.max(ans,k);}
                }
            }
        }
        return ans;
    }
    static boolean isMagicSquare(int arr[][], int row, int col, int squareSize){

        int firstRowSum = 0;
        //Pre-Calculate the firstRowSum which must be the same as sum of any row, sum of any column
        for(int i=row; i<row+squareSize; i++) firstRowSum += arr[i][col];

        // checking row sums
        for(int i=row; i<row+squareSize; i++){
            int sum = 0;
            for(int j=col; j<col+squareSize; j++){
                sum += arr[i][j];
            }

            if(sum!=firstRowSum) return false ;
        }

        // checking col

        for(int j=col; j<col+squareSize; j++){
            int sum = 0;
            for(int i=row; i<row+squareSize; i++){
                sum += arr[i][j];
            }

            if(sum!=firstRowSum) return false;
        }

        // checking diagonal
        int i1 = row;
        int j1 = col;

        int i2 = row;
        int j2 = col+squareSize-1;


        int d1=0;
        int d2=0;
        while(i1<row+squareSize){
            d1 = d1+arr[i1][j1];
            d2 = d2+arr[i2][j2];

            i1 = i1+1;
            j1 = j1+1;

            i2 = i2+1;
            j2 = j2-1;
        }

        if(d1!=firstRowSum || d2!=firstRowSum) return false;
        return true;
    }
}