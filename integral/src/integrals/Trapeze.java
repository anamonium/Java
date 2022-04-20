package integrals;


public class Trapeze extends IntegralAlgorithm{

    public Trapeze(){
        this.sum = 0;
        this.exact = 0;
    }

    @Override
    public void calculateIntegral(){
        double krok,p;

        krok=Math.abs(b-a)/n;
        sum = 0;
        for(p=(a+krok);p<b;p+=krok)
        {
            sum+=function.getValue(p);
        }
        sum+=0.5*function.getValue(a)+0.5*function.getValue(b);
        sum*=krok;
    }

    public void calculateExactIntegral(){
        this.exact= function.getExactIntegralValue(b) - function.getExactIntegralValue(a);
    }

    public void calculateError(){
        error = Math.abs(sum - exact);
    }
}
