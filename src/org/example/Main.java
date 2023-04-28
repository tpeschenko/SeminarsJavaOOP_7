package org.example;

import org.example.Controller.Controller;
import org.example.Model.Exeptions.DivisionByZeroException;
import org.example.Model.Exeptions.CalculateFormatException;

public class Main {
    public static void main(String[] args) throws DivisionByZeroException, CalculateFormatException {
        new Controller();
    }
}