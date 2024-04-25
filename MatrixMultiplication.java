import java.util.Random;
import  java.util.Scanner;
public class MatrixMultiplication {

    public static void main(String[] args) throws InterruptedException {

        //Reading input.
        Scanner scan = new Scanner(System.in);

        boolean gotCorrectInput = false;
        int ANumOfRows = 0;
        int ANumOfColumns_BNumOfRows = 0;
        int BNumOfColumns = 0;

        while (!gotCorrectInput){
            try {
                System.out.println("insert the number of rows in A : ");
                ANumOfRows = scan.nextInt();
                System.out.println("insert the number of columns in A (which is the number of rows in B): ");
                ANumOfColumns_BNumOfRows = scan.nextInt();
                System.out.println("insert the number of columns in B : ");
                BNumOfColumns = scan.nextInt();

                if(ANumOfRows>0 && ANumOfColumns_BNumOfRows>0 && BNumOfColumns>0)
                    gotCorrectInput = true;
                else
                    System.out.println("Incorrect input try again. \n");

            }catch (Exception e){
                System.out.println("Incorrect input try again. \n");
                scan.nextLine();
            }
        }

        //Creating matrix's
        int[][] A = new int[ANumOfRows][ANumOfColumns_BNumOfRows];
        int[][] B = new int[ANumOfColumns_BNumOfRows][BNumOfColumns];
        int[][] C = new int[ANumOfRows][BNumOfColumns];

        //Inserting random numbers into the Matrix(0 - 10)
        fillMatrix(ANumOfRows,ANumOfColumns_BNumOfRows,A);
        fillMatrix(ANumOfColumns_BNumOfRows,BNumOfColumns,B);

        //printing A & B matrix
        System.out.println("Matrix A: \n");
        printMatrix(A);

        System.out.println("Matrix B: \n");
        printMatrix(B);

        //computing vector dot products (each one with a thread).
        myMonitor monitor = new myMonitor();

        for (int k = 0; k < ANumOfRows * BNumOfColumns; k++) {
            int CRow = k / BNumOfColumns;
            int CColumn = k % BNumOfColumns;
            Thread t = new Thread(new Worker(A, B,C, CRow, CColumn,monitor,k));
            t.start();
            t.join();
        }

        System.out.println("\nResult matrix multiplication is: \n");
        printMatrix(C);
    }

    public  static  void fillMatrix (int MNumOfRows, int MNumOfColumns, int [][] M){

        Random rand = new Random();

        for (int i = 0; i < MNumOfRows; i++) {
            for (int j = 0; j < MNumOfColumns; j++) {
                M[i][j] = rand.nextInt(10) + 1;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        int numOfRows = matrix.length;
        int numOfColumns = matrix[0].length;

        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
}