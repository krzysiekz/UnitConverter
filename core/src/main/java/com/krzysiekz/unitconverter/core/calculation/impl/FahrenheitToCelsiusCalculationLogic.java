package com.krzysiekz.unitconverter.core.calculation.impl;

import com.krzysiekz.unitconverter.core.calculation.CalculationLogic;

public class FahrenheitToCelsiusCalculationLogic implements CalculationLogic {
    @Override
    public Double calculate(Double inputNumber) {
        return (inputNumber - 32) * 5.0 / 9.0;
    }
}
