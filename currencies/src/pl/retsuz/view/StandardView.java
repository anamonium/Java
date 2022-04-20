package pl.retsuz.view;

import pl.retsuz.collections.IDataCollection;
import pl.retsuz.currency.ICurrency;
import pl.retsuz.exchange.IExchange;
import java.util.Scanner;

import static java.lang.System.exit;

public class StandardView implements ICurrencyView{

    private IExchange exCha;
    private IDataCollection colleci;
    private Scanner sc;

    public void setExchange(IExchange exchange){
        exCha = exchange;
    }

    public void setDataCollection(IDataCollection collection) {
        colleci = collection;
    }

    public void ViewAll(IDataCollection coll) {
        System.out.println(colleci.ToString());
    }

    public StandardView() {
        this.sc = new Scanner(System.in);
    }

    public ICurrency StringToCurrency(String code) {
        for (ICurrency i : colleci.getCurrencyList()) {
            if (i.getCode().equals(code))
                return i;
        }

        return null;
    }

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


    public ICurrency ChooseCurrency(String label){
        String line;

        System.out.println(label);
        line = sc.nextLine();
        if(StringToCurrency(line) == null) {
            System.err.println("\nNieprawidlowy kod waluty");
            return ChooseCurrency(label);
        }
        else
            return StringToCurrency(line);
    }

    public void exchange() {
        double amount;
        ICurrency from = ChooseCurrency("\nPodaj kod waluty z ktorej wymieniasz: ");
        ICurrency to = ChooseCurrency("\nPodaj kod waluty do ktorej wymieniasz: ");

        amount = parseWithMessage("Ilosc pieniedzy:");

        if (amount < 0.0) {
            System.err.println("Ilosc musi byc dodatnia\n");
            exchange();
        }

        double afterExchange = exCha.exchange(from, to, amount);

        System.out.println("\nPo wymianie: " + afterExchange + " " + to.getCode() + "\n");

    }

    public void menu() {
        System.out.println("Co chcesz zrobic? ");
        System.out.println("1 - pokaz waluty");
        System.out.println("2 - wymien pieniadze");
        System.out.println("3 - zakonczyc program");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            ViewAll(colleci);
        }
        else if (choice.equals("2")) {
            exchange();
        }
        else if(choice.equals("3")) {
            System.out.println("Do widzenia!");
            exit(0);
        }
        else {
            System.err.println("Nieprawidlowy wybor\n");
            menu();
        }

        menu();
    }

}
