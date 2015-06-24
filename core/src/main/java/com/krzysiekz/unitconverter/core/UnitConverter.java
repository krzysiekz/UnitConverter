package com.krzysiekz.unitconverter.core;

import com.krzysiekz.unitconverter.core.calculation.CalculationLogic;
import com.krzysiekz.unitconverter.core.calculation.factory.CalculationLogicFactory;
import com.krzysiekz.unitconverter.core.view.UnitConverterView;

public class UnitConverter {
    private UnitConverterView view;

    public UnitConverter(UnitConverterView view) {
        this.view = view;
    }
    public void convert() {
        double inputNumber = view.getInputNumber();
        CalculationLogic calculationLogic = CalculationLogicFactory.getCalculationLogic(view.getFromUnit(), view.getToUnit());
        if(calculationLogic != null) {
            view.showResult(calculationLogic.calculate(inputNumber));
        } else {
            view.showConversionNotSupported();
        }
    }
}
