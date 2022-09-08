public class matrixMult {
    public static void main(String[] args) {
        int a[][] = {{1,2},{3,4}};
        int b[][] = {{5,6,7},{8,9,10}};
        int c[][] = new int[a.length][b[0].length];

        //iterating first matrix rows
        for(int row = 0;row<a.length;row++)
        {
            //iterating second matrix cols
            for (int col2 = 0;col2 < b[0].length; col2++){
            // mxn MxN n=M
                int multVal = 0;
                //iterating col of 1st matrix row of 2nd matrix
                for (int col = 0; col < a[0].length; col++)
                        multVal += a[row][col] * b[col][col2];
                c[row][col2] = multVal;
            }
        }
        //print
        for (int[] row : c) {
            for (int item : row) 
                System.out.print(item+" ");
            System.out.println();
        }
    }
}
