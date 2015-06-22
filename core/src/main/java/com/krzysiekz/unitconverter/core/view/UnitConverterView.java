package com.krzysiekz.unitconverter.core.view;


public interface UnitConverterView {
    Double getInputNumber();

    String getFromUnit();

    String getToUnit();

    void showResult(double result);

    void showConversionNotSupported();
}
