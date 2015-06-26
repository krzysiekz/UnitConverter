package com.krzysiekz.unitconverter.app;

import android.widget.EditText;
import android.widget.TextView;
import com.krzysiekz.unitconverter.core.UnitConverter;
import com.krzysiekz.unitconverter.core.view.UnitConverterView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    @Test
    public void shouldExists() {
        assertThat(mainActivity).isNotNull();
    }

    @Test
    public void shouldCreateUnitConverter() {
        //when
        //then
        assertThat(mainActivity.getUnitConverter()).isNotNull();
        assertThat(mainActivity).isInstanceOf(UnitConverterView.class);
    }

    @Test
    public void shouldCallConvertMethodWhenButtonIsClicked() {
        //given
        UnitConverter unitConverter = mock(UnitConverter.class);
        //when
        mainActivity.setUnitConverter(unitConverter);
        mainActivity.findViewById(R.id.convert_button).performClick();
        //then
        verify(unitConverter).convert();
    }

    @Test
    public void shouldReturnProperInputNumber() {
        //given
        EditText textInput = (EditText) mainActivity.findViewById(R.id.input_number);
        //when
        textInput.setText("20");
        Double inputNumber = mainActivity.getInputNumber();
        //then
        assertThat(inputNumber).isEqualTo(20);
    }

    @Test
    public void shouldReturnProperFromUnit() {
        //given
        EditText textInput = (EditText) mainActivity.findViewById(R.id.from_unit);
        //when
        textInput.setText("in");
        String fromUnit = mainActivity.getFromUnit();
        //then
        assertThat(fromUnit).isEqualTo("in");
    }

    @Test
    public void shouldReturnProperToUnit() {
        //given
        EditText textInput = (EditText) mainActivity.findViewById(R.id.to_unit);
        //when
        textInput.setText("cm");
        String fromUnit = mainActivity.getToUnit();
        //then
        assertThat(fromUnit).isEqualTo("cm");
    }
}