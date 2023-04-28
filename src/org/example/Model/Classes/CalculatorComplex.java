package org.example.Model.Classes;

import org.example.Model.Exeptions.DivisionByZeroException;
import org.example.Model.Interfaces.Parsable;

public class CalculatorComplex extends CalculatorReal{
    private Complex result;

    public CalculatorComplex() {
        super();
        this.result = new Complex();
    }

    @Override
    public Parsable summ(Real complex) {
        this.result.real += complex.real;
        result.imaginary += ((Complex) complex).imaginary;
        return this.result;
    }

    @Override
    public Parsable subt(Real complex) {
        result.real -= complex.real;
        result.imaginary -= ((Complex) complex).imaginary;
        return this.result;
    }

    @Override
    public Parsable mult(Real complex) {
        double c =  ((Complex)complex).imaginary;
        double r = this.result.real * complex.real - this.result.imaginary * c;
        double i = this.result.imaginary * complex.real + c * this.result.real;
        this.result.real = r;
        this.result.imaginary = i;
        return this.result;
    }

    @Override
    public Parsable div(Real complex) throws DivisionByZeroException {
        double c =  ((Complex)complex).imaginary;
        double zn = complex.real * complex.real + c * c;
        if (zn == 0) {
            throw new DivisionByZeroException("Division by zero");
        } else {
            double ch1 = result.real * complex.real + result.imaginary * c;
            double ch2 = result.imaginary * complex.real - c * result.real;
            result.real = ch1 / zn;
            result.imaginary = ch2 / zn;
        }
        return this.result;
    }

    public Parsable rev() throws DivisionByZeroException {
        double zn = result.real * result.real + result.imaginary * result.imaginary;
        if (zn == 0) {
            throw new DivisionByZeroException("Division by zero");
        } else {
            result.real = result.real / zn;
            result.imaginary = - result.imaginary / zn;
        }
        return this.result;
    }

    public Parsable minus() {
        result.real = -result.real;
        result.imaginary = -result.imaginary;
        return this.result;
    }

    @Override
    public Parsable set(Parsable number) {
        this.result.real = ((Complex)number).real;
        this.result.imaginary = ((Complex)number).imaginary;
        return this.result;
    }
}
