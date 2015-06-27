package com.krzysiekz.unitconverter.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.krzysiekz.unitconverter.core.UnitConverter;
import com.krzysiekz.unitconverter.core.view.UnitConverterView;

public class MainActivity extends Activity implements UnitConverterView {

    private Button button;
    private EditText textInput;
    private EditText fromUnit;
    private EditText toUnit;
    private TextView resultText;

    private UnitConverter unitConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unitConverter = new UnitConverter(this);

        setUp();

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                unitConverter.convert();
            }
        });
    }

    private void setUp() {
        button = (Button) findViewById(R.id.convert_button);
        textInput = (EditText) findViewById(R.id.input_number);
        fromUnit = (EditText) findViewById(R.id.from_unit);
        toUnit = (EditText) findViewById(R.id.to_unit);
        resultText = (TextView) findViewById(R.id.result_text);
    }

    void setUnitConverter(UnitConverter unitConverter) {
        this.unitConverter = unitConverter;
    }

    UnitConverter getUnitConverter() {
        return unitConverter;
    }
    @Override
    public Double getInputNumber() {
        return Double.parseDouble(textInput.getText().toString());
    }
    @Override
    public String getFromUnit() {
        return fromUnit.getText().toString();
    }
    @Override
    public String getToUnit() {
        return toUnit.getText().toString();
    }
    @Override
    public void showResult(double result) {
        String formattedResult = String.format( "%.2f", result );
        resultText.setText(formattedResult);
    }

    @Override
    public void showConversionNotSupported() {
        resultText.setText(R.string.conversion_not_supported);
    }
}
