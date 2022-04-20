package Multiply;

import MatrixThreads.MatrixThread;
import matrix.IMatrix;
import matrix.Matrix;

public class MultiplyMatrix {

    MatrixThread [] threads;

    public int calculateAvailableThreads(){return Runtime.getRuntime().availableProcessors();}

    public IMatrix multiply(IMatrix a, IMatrix b){

        int threadsAvalaible = calculateAvailableThreads();

        IMatrix result = new Matrix(a.rowCount(), b.columnCount());

        threads = new MatrixThread[threadsAvalaible-1];

        int startRow = 0;
        int rowsForThread = b.rowCount() / threadsAvalaible;

        //kazdy watek zaczyna wykonywac przypisane mu wiersze
        for (int i = 0; i < threads.length; ++i){
            threads[i] = new MatrixThread(a,b,result,startRow,rowsForThread );
            threads[i].start();
            startRow += rowsForThread;
        }

        //ostatni watek dostaje rowsForThread + reszta z dzielenia (zostalyby nieobsluzone wiersze jezeli nie zostaloby to zabezpieczone)
        new MatrixThread(a,b,result,startRow,rowsForThread+a.rowCount() % rowsForThread).run();
        return result;
    }
}
