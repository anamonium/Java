package View;

import integrals.Exception.IntervalException;
import integrals.Exception.InputException;
import integrals.IntegralAlgorithm;

import java.util.Scanner;


public class IntegralConsoleView implements IntegralView {

    private IntegralAlgorithm solver;
    private Scanner sc;

    protected double parseWithMessage(String message){
        System.out.println(message);
        String line;
        double res;

        try{
            line = sc.nextLine();
            res = Double.parseDouble(line);
        } catch (Exception es){
            System.err.println("Wprowadzono nieprawidlowe dane");
            res = parseWithMessage(message);
        }
        return res;
    }

    protected int parseWithMessageInt(String message){
        System.out.println(message);
        String line;
        int res;

        try{
            line = sc.nextLine();
            res = Integer.parseInt(line);
        } catch (Exception es){
            System.err.println("Wprowadzono nieprawidlowe dane");
            res = parseWithMessageInt(message);
        }
        return res;
    }

    protected void parseFactors(){
        double a, b;
        int n;
        a = parseWithMessage("Wprowadz poczatek przedzialu a: ");
        b = parseWithMessage("Wprowadz koniec przedzialu b: ");
        n = parseWithMessageInt("Wprowadz ilosc podprzedzialow n: ");

        if(a>b){
            try{
                throw new IntervalException();
            }catch (IntervalException e){
                System.err.println(e.getMessage());
                parseFactors();
            }
        }
        else if(n<1){
            try{
                throw new InputException();
            } catch (InputException e){
                System.err.println(e.getMessage());
                parseFactors();
            }
        }

        this.solver.setA(a);
        this.solver.setB(b);
        this.solver.setN(n);
    }

    protected void displaySolutions(double method, double exact, double error){
        String label = "Rozwiazanie: \n" + "Obliczenie: " + method + "\nDokladne: " + exact + "\nBlad: " + error + "\n";

        System.out.println(label);
    }

    protected void getSolution(){
        solver.calculateIntegral();
        solver.calculateExactIntegral();
        solver.calculateError();
        displaySolutions(solver.getIntegral(), solver.getExact(), solver.getError());
    }


    public void View(){
        while (true){
            parseFactors();
            getSolution();
        }
    }


    public void Init(IntegralAlgorithm solver){
        this.solver = solver;
        this.sc = new Scanner(System.in);
    }
}

