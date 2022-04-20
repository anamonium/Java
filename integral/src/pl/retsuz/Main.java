package pl.retsuz;

import functions.Function;
import functions.examples.builder.ExampleBuilder;
import functions.examples.cosineexample.CosineExampleBuilder;
import integrals.IntegralAlgorithm;
import integrals.MonteCarlo;
import integrals.Trapeze;
import View.IntegralView;
import View.IntegralConsoleView;

public class Main {

    protected static ExampleBuilder functionBuilder;
    protected static Function givenExample;
    protected static IntegralAlgorithm algorithm;
    static IntegralView view;

    public static void main(String[] args) {

        functionBuilder = new CosineExampleBuilder();
        givenExample = functionBuilder.build();
        algorithm = new Trapeze();
        view = new IntegralConsoleView();
        algorithm.setFunction(givenExample);

        view.Init(algorithm);
        view.View();


    }
}
