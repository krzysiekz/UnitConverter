package com.krzysiekz.unitconverter.core;

import com.krzysiekz.unitconverter.core.view.UnitConverterView;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class UnitConverterTest {

    private UnitConverterView view;
    private UnitConverter converter;

    @Before
    public void setUp() throws Exception {
        //given
        view = mock(UnitConverterView.class);
        converter = new UnitConverter(view);
    }

    @Test
    public void shouldConvertFromInchesToCm() {
        //when
        when(view.getInputNumber()).thenReturn(1.0);
        when(view.getFromUnit()).thenReturn("in");
        when(view.getToUnit()).thenReturn("cm");
        converter.convert();
        //then
        verify(view).showResult(2.54);
    }

    @Test
    public void shouldShowConversionNotSupported() {
        //when
        when(view.getInputNumber()).thenReturn(2.0);
        when(view.getFromUnit()).thenReturn("A");
        when(view.getToUnit()).thenReturn("B");
        converter.convert();
        //then
        verify(view).showConversionNotSupported();
    }

    @Test
    public void shouldConvertFromFahrenheitToCelsius() {
        //when
        when(view.getInputNumber()).thenReturn(-4.0);
        when(view.getFromUnit()).thenReturn("F");
        when(view.getToUnit()).thenReturn("C");
        converter.convert();
        //then
        verify(view).showResult(-20);
    }
}