package org.example.View;

import org.example.Model.Interfaces.Calculable;
import org.example.Model.Classes.Real;
import org.example.Model.Interfaces.Changeable;
import org.example.Model.Interfaces.Parsable;
import org.example.Service.CalculableComplexFactory;
import org.example.Service.CalculableRealFactory;
import org.example.Service.ICalculableFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserMenu {
    ICalculableFactory calcFactory;
    Calculable calc;
    Parsable result;
    Real operand;
    UserInOutOperations uo;

    static UIinteractable ui;
    static String session;
    static List<String> binaryOperations;
    static ArrayList<String> unaryOperations;
    static ArrayList<String> allOperations;

    static {
        ui = new UIConsole();
        binaryOperations = new ArrayList<>(Arrays.asList(
                new String[] {"+", "-", "*", "/"}));
        unaryOperations = new ArrayList<>(Arrays.asList(
                new String[] {"+/-", "1/x", "^2", "/", "c", "C", "q", "Q"}));
        allOperations = new ArrayList<>();
        allOperations.addAll(binaryOperations);
        allOperations.addAll(unaryOperations);
    }

    public UserMenu(UIinteractable uIinteractable)
    {
        ui = uIinteractable;
    }

    public void startMenu() {
        while (true) {
            ui.output("\n\nCalculator\n1. Real numbers" +
                            "\n2. Complex numbers\n0. quit\n\nEnter your choice: ");
            switch (ui.input()) {
                case "1":
                    calcFactory =  new CalculableRealFactory();
//                    calc = calcFactory.createCalculator();
                    startCalculation("Real");
                    break;
                case "2": calcFactory = new CalculableComplexFactory();
//                    calc = calcFactory.createCalculator();
                    startCalculation("Complex");
                    break;
                case "0": return;
            }
        }
    }

    public void startCalculation(String session) {
        this.session = session;
        calc = calcFactory.createCalculator();
        uo = new UserInOutOperations(calcFactory, calc, ui, session);
        Calculation();
    }

    public void Calculation() {
        uo.showTitle();
        initCalculation();

        String operation;
        while (true) {
            operation = uo.inputOperation(allOperations);

            if (binaryOperations.contains(operation)) {
                operand = (Real) uo.inputOperand();
            } else if (unaryOperations.contains(operation)) {
                operand = (Real) result;
            }

            switch (operation){
                case "+": result = calc.summ(operand); break;
                case "+/-": result = calc.minus(); break;
                case "-": result = calc.subt(operand); break;
                case "^2":
                case "*":  result = calc.mult(operand); break;
                case "1/x": case "/":
                    try {
                        if (operation.equals("/")) result = calc.div(operand);
                        else result = calc.rev();
                    } catch (Exception e) {
                        uo.clearResult(result.toString());
                        uo.exceptionOperation(e.getMessage()
                                , "The calculation was canceled"
                                , "> " + result.toString());
                        continue;
                    } break;
                case "q", "Q": return;
                case "c", "C": initCalculation();
                default: continue;
            }
            uo.clearResult("");
            uo.storeResult(result.toString(),"> ");
        }
    }

    public void initCalculation(){
        uo.clearResult("> ");
        var cl = uo.inputOperand();
        result = ((Changeable)calc).set(cl);
    }
}
