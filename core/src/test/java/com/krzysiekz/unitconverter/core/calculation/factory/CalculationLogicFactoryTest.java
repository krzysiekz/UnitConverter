package com.krzysiekz.unitconverter.core.calculation.factory;

import com.krzysiekz.unitconverter.core.calculation.CalculationLogic;
import com.krzysiekz.unitconverter.core.calculation.impl.FahrenheitToCelsiusCalculationLogic;
import com.krzysiekz.unitconverter.core.calculation.impl.InchToCmCalculationLogic;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculationLogicFactoryTest {

    @Test
    public void shouldReturnProperClassForInchesAndCm() {
        //when
        CalculationLogic calculationLogic = CalculationLogicFactory.getCalculationLogic("in", "cm");
        //then
        assertThat(calculationLogic).isInstanceOf(InchToCmCalculationLogic.class);
    }

    @Test
    public void shouldReturnProperClassForFahrenheitAndCelsius() {
        //when
        CalculationLogic calculationLogic = CalculationLogicFactory.getCalculationLogic("F", "C");
        //then
        assertThat(calculationLogic).isInstanceOf(FahrenheitToCelsiusCalculationLogic.class);
    }

    @Test
    public void shouldReturnNullIfCalculationLogicNotAvailable() {
        //when
        CalculationLogic calculationLogic = CalculationLogicFactory.getCalculationLogic("A", "B");
        //then
        assertThat(calculationLogic).isNull();
    }
}