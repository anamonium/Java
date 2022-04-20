package integrals.Exception;

public class IntervalException extends Exception{
    public IntervalException(){
        super("Koniec przedzialu musi byc wiekszy od poczatku");
    }
}
