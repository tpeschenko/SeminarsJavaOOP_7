package org.example.Model.Interfaces;

import org.example.Model.Classes.Real;
import org.example.Model.Exeptions.DivisionByZeroException;

public interface Calculable<T extends Real> {
    Parsable summ(T number);
    Parsable mult(T number);
    Parsable subt(T number);
    Parsable div(T number) throws DivisionByZeroException;
    Parsable rev() throws DivisionByZeroException;
    Parsable minus();

    Parsable getResult();

//    Parsable getNumber();
}
