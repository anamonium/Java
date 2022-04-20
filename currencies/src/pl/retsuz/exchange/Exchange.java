package pl.retsuz.exchange;

import pl.retsuz.currency.ICurrency;

public class Exchange implements IExchange{
    public double exchange(ICurrency src, ICurrency tgt, double amt){
        double temp = 0.0;
        //temp = src.getFactor()*amt/tgt.getFactor();
        temp = src.getRate()*amt/tgt.getRate();
        return temp;

    }
    //Oblicza otrzymaną ilość środka pieniężnego po podaniu wartości źródłowej,
    //waluty źródłowej oraz waluty docelowej
}
    //Utworzyć klasę Exchange w paczce exchange, implementującą interfejs IExchange
