package MatrixThreads;

import matrix.IMatrix;
import matrix.Matrix;

public class MatrixThread extends Thread {

    private int sRow, rows;
    private IMatrix a, b, result;

    //a - macierz lewa
    //b - macierz prawa
    //result - macierz wynikowa mnozenia a*b
    //sRow - rzad startowy
    //rows - ilosc rzadow ktorymi zajmuje sie dany watek
    public MatrixThread(IMatrix a, IMatrix b, IMatrix result, int sRow, int rows){
        this.a = a;
        this.b = b;
        this.result = result;
        this.sRow = sRow;
        this.rows = rows;
    }

    @Override
    public void run(){
        for(int y = sRow; y < sRow + rows; ++y){
            for(int x = 0; x < b.columnCount(); ++x){
                result.getData()[y][x]=0;
                for(int i = 0; i < a.columnCount(); ++i){
                    result.getData()[y][x] += a.getData()[y][i] * b.getData()[i][x];
                }
            }
        }
    }
}
