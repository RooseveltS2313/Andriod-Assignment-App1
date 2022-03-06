package com.example.bowwowdoggroomers;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText numberEditText;
    TextView displayTextView;
    CheckBox trimnailCheckBox, massageCheckBox, fleaBathCheckBox;
    final Double conversionFactor = 1.00;
    NumberFormat FNT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberEditText = findViewById(R.id.number_editText);
        displayTextView = findViewById(R.id.display_textView);
        trimnailCheckBox = findViewById(R.id.trimnail_checkBox);
        massageCheckBox = findViewById(R.id.massage_checkBox);
        fleaBathCheckBox = findViewById(R.id.fleabath_checkBox);
        displayTextView.setText("");

        FNT = NumberFormat.getCurrencyInstance();

    }

    public void handleReset(View v) {
        resetScreen();

    }
    public void handleCalculate(View v) {
        updateUI();
    }
    public void handleOrder(View v) {
        Toast.makeText(this, "Order Placed", Toast.LENGTH_SHORT).show();
        resetScreen();

    }
    public void handleChecked(View v) {
        if (v.getId() == R.id.trimnail_checkBox) {

        } else if (v.getId() == R.id.massage_checkBox) {

        } else {
            //Flea bath selected
        }
        updateUI();

    }

    public void updateUI() {
        String result = "";
        Double cost = 0.0;

        if (trimnailCheckBox.isChecked()) {
            cost += 5.00;
        }
        if (massageCheckBox.isChecked()) {
            cost += 20.00;
        }
        if (fleaBathCheckBox.isChecked()) {
            cost += 10.00;
        }

        try {
            Double num = Double.parseDouble(numberEditText.getText().toString());
            if (num < 30){
                cost += 35.00;
            } else if (num < 50) {
                cost += 45.00;
            } else {
                cost += 55.00;
            }
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Illegal Number", Toast.LENGTH_SHORT).show();
        }
        cost = cost * conversionFactor;
        result = FNT.format(cost);
            //result = cost.toString();
        displayTextView.setText(result);
    }


    public void resetScreen() {
        numberEditText.setText("");
        displayTextView.setText("");
        trimnailCheckBox.setChecked(false);
        massageCheckBox.setChecked(false);
        fleaBathCheckBox.setChecked(false);
    }

}
