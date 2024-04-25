# Matrix Multiplication

This Java program performs matrix multiplication using multi-threading. It prompts the user to input the dimensions of two matrices, generates random numbers to fill them, computes the multiplication concurrently, and displays the result.

## Usage

1. Compile the Java file:
javac MatrixMultiplication.java


2. Run the compiled program:
java MatrixMultiplication


3. Follow the prompts to input the dimensions of matrices.

## How It Works

1. **Input**: The program prompts the user to input the number of rows and columns for two matrices, A and B.

2. **Matrix Creation**: It creates matrices A, B, and C based on the input dimensions.

3. **Matrix Filling**: Random numbers between 1 and 10 are generated to fill matrices A and B.

4. **Matrix Multiplication**: Each cell of the resulting matrix C is computed concurrently using multi-threading.

5. **Thread Handling**: The program uses a monitor class (`myMonitor`) to synchronize threads and ensure correct computation order.

6. **Output**: Finally, it displays matrices A, B, and the resulting matrix C.

## Example

Suppose we input the following dimensions:

Matrix A:
3 (rows) x 2 (columns)

Matrix B:
2 (rows) x 4 (columns)

The program will then display the filled matrices A and B, compute the matrix multiplication, and display the resulting matrix C.
