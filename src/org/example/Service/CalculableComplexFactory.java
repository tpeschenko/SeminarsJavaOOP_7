package org.example.Service;

import org.example.Model.Classes.CalculatorComplex;
import org.example.Model.Interfaces.Calculable;
import org.example.Model.Classes.Complex;
import org.example.Model.Exeptions.CalculateFormatException;

public class CalculableComplexFactory extends  CalculableRealFactory {
    private CalculatorComplex calc;

    public CalculableComplexFactory() {
        this.calc = (CalculatorComplex) createCalculator();
    }

    @Override
    public Calculable createCalculator() {
        calc = new CalculatorComplex();
        return calc;
    }

    @Override
    public Complex createNumber(String str) throws CalculateFormatException {
        return Complex.parseComplex(str);
    }

    @Override
    public Calculable getCalculator() {
        return this.calc;
    }

}
