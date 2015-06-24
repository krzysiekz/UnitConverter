package com.krzysiekz.unitconverter.core.calculation.factory;


import com.krzysiekz.unitconverter.core.calculation.CalculationLogic;
import com.krzysiekz.unitconverter.core.calculation.impl.FahrenheitToCelsiusCalculationLogic;
import com.krzysiekz.unitconverter.core.calculation.impl.InchToCmCalculationLogic;

public class CalculationLogicFactory {

    public static CalculationLogic getCalculationLogic(String unitFrom, String unitTo) {
        if (unitFrom.equals("in") && unitTo.equals("cm")) {
            return new InchToCmCalculationLogic();
        } else if (unitFrom.equals("F") && unitTo.equals("C")) {
            return new FahrenheitToCelsiusCalculationLogic();
        }
        return null;
    }
}
