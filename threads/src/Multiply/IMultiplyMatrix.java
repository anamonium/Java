package Multiply;

import matrix.IMatrix;
import matrix.Matrix;

public interface IMultiplyMatrix extends Runnable{
    public IMatrix multiply(IMatrix a, IMatrix b);
    int calculateAvailableThreads();
}
