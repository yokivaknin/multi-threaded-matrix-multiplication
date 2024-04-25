class Worker implements Runnable {

    private int[][] A;
    private int[][] B;
    private int ARow;
    private int BColumns;
    private int[][] C;
    private myMonitor monitor;
    private int threadNum;

    public Worker(int[][] A, int[][] B,int[][] C, int ARow, int BColumns, myMonitor monitor, int threadNum) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.ARow = ARow;
        this.BColumns = BColumns;
        this.monitor = monitor;
        this.threadNum = threadNum;
    }

    @Override
    public void run() {

        //Calculating dot product
        int sum = 0;
        for (int k = 0; k < A[0].length; k++) {
            sum += A[ARow][k] * B[k][BColumns];
        }

        C[ARow][BColumns] = sum;

        //Printing the results each thread in its order
        monitor.waitForMyTurn(threadNum);

        System.out.println("Thread " + threadNum + " calculated C[" + ARow + "][" + BColumns + "] = "+ sum);

        monitor.imDone();
    }
}