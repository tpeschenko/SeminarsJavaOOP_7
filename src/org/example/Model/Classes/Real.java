package org.example.Model.Classes;

import org.example.Model.Exeptions.CalculateFormatException;
import org.example.Model.Interfaces.Parsable;

import java.text.DecimalFormat;
public class Real implements Parsable {
    protected double real;
    protected final static DecimalFormat decimalFormat;

    static {
        decimalFormat = new DecimalFormat("#.#####");
    }

    public Real() {
        this.real = 0;
    }

    public Real(double real) {
        this.real = real;
    }

    public Real(Real real) {
        this.real = real.real;
    }

    @Override
    public String toString() {
        return "" + decimalFormat.format(real);
    }

    public static Real parseReal(String str) {
        if (str == null || str == ""){
            return null;
        }
        str = str.replace(" ", "");

        if (!str.contains(".")) {
            str += ".0";
        }
        return new Real(Double.parseDouble(str));
    }

    @Override
    public Parsable parse(String str) throws CalculateFormatException {
        return parseReal(str);
    }

//    @Override
//    public Parsable clear() {
//        this.real = 0;
//        return this;
//    }
//
//    @Override
//    public Parsable set(Real number) {
//        this.real = number.real;
//        return this;
//    }
}
