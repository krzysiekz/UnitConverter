package com.krzysiekz.unitconverter.core;

import com.krzysiekz.unitconverter.core.view.UnitConverterView;

public class UnitConverter {
    private UnitConverterView view;

    public UnitConverter(UnitConverterView view) {
        this.view = view;
    }
    public void convert() {
        double inputNumber = view.getInputNumber();
        if (view.getFromUnit().equals("in") && view.getToUnit().equals("cm")) {
            view.showResult(inputNumber * 2.54);
        } else {
            view.showConversionNotSupported();
        }
    }
}
