package com.krzysiekz.unitconverter.core.calculation.impl;


import com.krzysiekz.unitconverter.core.calculation.CalculationLogic;

public class InchToCmCalculationLogic implements CalculationLogic {
    @Override
    public Double calculate(Double inputNumber) {
        return inputNumber * 2.54;
    }
}
