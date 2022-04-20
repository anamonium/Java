package View;

import Multiply.MultiplyMatrix;
import matrix.IMatrix;
import matrix.generators.DefaultGenerator;

import java.util.Date;
import java.util.Scanner;

public class View {
    private Scanner sc = new Scanner(System.in);

    protected int parseWithMessageInt(String message) {
        System.out.println(message);
        String line;
        int res;

        try {
            line = sc.nextLine();
            res = Integer.parseUnsignedInt(line);
        } catch (Exception ex) {
            System.err.println("Wprowadzono niepoprawne dane");
            res = parseWithMessageInt(message);
        }

        return res;
    }

    protected void calculate(){
        IMatrix a;
        IMatrix b;
        IMatrix c;
        IMatrix d;
        int mA = parseWithMessageInt("Podaj liczbe wierszy macierzy A");
        int nA = parseWithMessageInt("Podaj liczbe kolumn macierzy A");
        int mB = parseWithMessageInt("Podaj liczbe wierszy macierzy B");
        int nB = parseWithMessageInt("Podaj liczbe kolumn macierzy B");

        //warunek jezeli macierz A ma tyle samo kolumn co macierz B wierszy to mozna te macierze pomnozyc
        if(checkInput(nA, mB)){
            System.out.println("Generuję macierze...");
            a= DefaultGenerator.generateRandomMatrix(mA,nA,0,3);
            b= DefaultGenerator.generateRandomMatrix(mB,nB,0,3);
            System.out.println("Mnożę macierze klasycznie...");
            Date start = new Date();
            c=IMatrix.multiply(a,b);
            Date end = new Date();
            System.out.println("Czas mnożenia w milisekundach: " + (end.getTime() - start.getTime()));

            System.out.println("Mnożę macierze przy uzyciu watkow...");
            MultiplyMatrix test = new MultiplyMatrix();
            Date start1 = new Date();
            d = test.multiply(a,b);
            Date end1 = new Date();
            System.out.println("Czas mnożenia w milisekundach: " + (end1.getTime() - start1.getTime()));
        }
        else{
            System.out.println("Niepoprawne wymiary macierzy");
        }
    }

    protected boolean checkInput(int b, int c){
        if (b == c)
            return true;
        else
            return false;
    }
    public void menu(){
        int choice;

            System.out.println("1 - mnozenie macierzy\n2 - wyjscie z programu");

            choice = parseWithMessageInt("");

            if (choice == 1) {
                calculate();
                menu();
            }
            else if (choice == 2)
                System.exit(0);
            else {
                System.out.println("Niepoprawny wybor");
                menu();
            }

    }
}
