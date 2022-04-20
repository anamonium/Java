package integrals;

import functions.Function;

public abstract class IntegralAlgorithm {
    protected double a;
    protected double b;
    protected int n;
    protected double sum;
    protected double exact;
    protected double error;
    protected Function function;

    public double getIntegral(){
        return sum;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public abstract void calculateIntegral();

   public abstract void calculateExactIntegral();

   public double getExact(){
       return exact;
   }

   public abstract void calculateError();

   public double getError(){ return error;}



}
