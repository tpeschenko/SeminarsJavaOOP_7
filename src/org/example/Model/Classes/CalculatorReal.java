package org.example.Model.Classes;

import org.example.Model.Exeptions.DivisionByZeroException;
import org.example.Model.Interfaces.Calculable;
import org.example.Model.Interfaces.Changeable;
import org.example.Model.Interfaces.Parsable;

public class CalculatorReal implements Calculable, Changeable {
     private Real result;

     public CalculatorReal() {
          this.result = new Real();
     }

     @Override
     public Parsable summ(Real number) {
          result.real += number.real;
          return this.result;
     }

     @Override
     public Parsable mult(Real number) {
          result.real *= number.real;
          return this.result;
     }

     @Override
     public Parsable subt(Real number) {
          result.real -= number.real;
          return this.result;
     }

     @Override
     public Parsable div(Real number) throws DivisionByZeroException {
          if (number.real == 0){
               throw new DivisionByZeroException("Division by zero");
          } else {
               result.real = result.real / number.real;
          }
          return this.result;
     }

     @Override
     public Parsable rev() throws DivisionByZeroException {
          if (result.real == 0){
               throw new DivisionByZeroException("Division by zero");
          } else {
               result.real =  1 / result.real;
          }
          return this.result;
     }

     @Override
     public Parsable minus() {
          result.real = -result.real;
          return this.result;
     }

     @Override
     public Parsable getResult() {
          return this.result;
     }

     @Override
     public Parsable set(Parsable number) {
          this.result = (Real) number;
          return this.result;
     }
}
