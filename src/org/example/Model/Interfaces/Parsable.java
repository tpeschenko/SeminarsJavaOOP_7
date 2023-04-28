package org.example.Model.Interfaces;

import org.example.Model.Exeptions.CalculateFormatException;

public interface Parsable {
    Parsable parse(String string) throws CalculateFormatException;
}
