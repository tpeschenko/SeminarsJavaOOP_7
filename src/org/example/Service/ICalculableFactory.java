package org.example.Service;

import org.example.Model.Interfaces.Calculable;
import org.example.Model.Exeptions.CalculateFormatException;
import org.example.Model.Classes.Real;

public interface ICalculableFactory<T extends Real, Complex> {
    Calculable createCalculator();
    T createNumber(String str) throws CalculateFormatException;
    Calculable getCalculator();
}