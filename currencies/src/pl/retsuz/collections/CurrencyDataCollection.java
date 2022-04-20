package pl.retsuz.collections;

import pl.retsuz.currency.Currency;
import pl.retsuz.currency.ICurrency;
import java.util.List;
import java.util.ArrayList;


public class CurrencyDataCollection implements IDataCollection{

       protected Currency currencyy;
       protected List<ICurrency> lista;

    public String ToString(){
//        String calosc = currencyy.getName()+" "+ currencyy.getCode()+" "+ currencyy.getFactor()+" "+ currencyy.getRate()+"\n";
//        return calosc;
        String temp = "";
        for(ICurrency i : lista) {
            temp = temp + i.getName() + " " + i .getCode() + " " + i.getFactor() + " " + i.getRate() + "\n";
        }

        return temp;
    }
    //Zwraca ciąg znaków, reprezentujący wszystkie obiekty Currency komponowane w klasie

    public List<ICurrency> getCurrencyList(){
        return lista;
    }
    //Zwraca referencję do listy obiektów Currency w klasie

    public ICurrency getCurrencyByCode(ICurrency currency){

        for( ICurrency temp : lista) {
            if(currency.getCode().equals(temp.getCode())) //moze byc currency.equals(temp)
                return temp;
        }
        return null;
    }
    //Zwraca pełen obiekt Currency z listy po podaniu obiektu Currency, z ustawionym kodem waluty

    public CurrencyDataCollection() {
        lista = new ArrayList<>();
    }
}
