package org.example.Model.Classes;

import org.example.Model.Exeptions.CalculateFormatException;
import org.example.Model.Interfaces.Parsable;

public class Complex extends Real {
    protected double imaginary;

    public Complex() {
        super();
    }

    public Complex(double real, double imaginary) {
        super(real);
        this.imaginary = imaginary;
    }

    public Complex(double real) {
        this(real, 0);
    }

    public Complex(Complex complex) {
        this(complex.real, complex.imaginary);
    }



    public static Complex parseComplex(String str) throws CalculateFormatException {
        if (str.length() == 0) {
            throw new java.lang.NumberFormatException("Incorrect format number");
        }
        String part1 , part2;
        str = str.replace(" ", "");
        int pos = Math.max(str.lastIndexOf('+'), str.lastIndexOf('-'));
        if(pos > 0) {
           part1 = str.substring(0, pos);
           part2 = str.substring(pos, str.length());
        } else {
            part1 = str.substring(0, str.length());
            part2 = "0.0";
        }
        if (part1.contains("i")) {
            String temp = part1;
            part1 = part2;
            part2 = temp;
        }
        pos = part2.indexOf("i");
        String rp = "";
        if (pos == 0 || pos == 1 && !Character.isDigit(part2.charAt(0))) {
            rp = "1.0";
        }
        if (!part2.equals("0.0") && !part2.contains("i")){
            throw new CalculateFormatException("Incorrect format number");
        }

        part2 = part2.replace("i",rp);
        return new Complex(((Real) Real.parseReal(part1)).real, ((Real)Real.parseReal(part2)).real);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        final boolean needBrackets = (real !=0 && imaginary !=0 || real< 0 || imaginary < 0);
        if (needBrackets) s.append("(");
        if (real!=0) {
            s.append(decimalFormat.format(real));
            if (imaginary > 0) s.append(" + ");
        }
        double img = Math.abs(imaginary);
        if(imaginary < 0) s.append(" -" + ((real != 0)? " ":""));
        if(img !=1 && ( real ==0 || img != 0)) s.append(decimalFormat.format(img));
        if (imaginary != 0)  s.append("i");
        if (needBrackets) s.append(")");
        return s.toString();
    }

    @Override
    public Parsable parse(String str) throws CalculateFormatException {
        return parseComplex(str);
    }
}
