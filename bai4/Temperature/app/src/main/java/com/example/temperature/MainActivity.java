package com.example.temperature;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText temperatureInput;
    Button buttonCtoF, buttonFtoC;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureInput = findViewById(R.id.editTextTemperature);
        buttonCtoF = findViewById(R.id.buttonCtoF);
        buttonFtoC = findViewById(R.id.buttonFtoC);
        result = findViewById(R.id.textViewResult);

        buttonCtoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertTemperature(true);
            }
        });

        buttonFtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertTemperature(false);
            }
        });
    }

    private void convertTemperature(boolean cToF) {
        String input = temperatureInput.getText().toString().trim();
        if (input.isEmpty()) {
            result.setText("Vui lòng nhập nhiệt độ!");
            return;
        }

        try {
            double temp = Double.parseDouble(input);
            double converted;
            String unit;

            if (cToF) {
                converted = (temp * 9 / 5) + 32;
                unit = "°F";
            } else {
                converted = (temp - 32) * 5 / 9;
                unit = "°C";
            }

            result.setText(String.format("Kết quả: %.2f %s", converted, unit));

        } catch (NumberFormatException e) {
            result.setText("Sai định dạng! Hãy nhập số.");
        }
    }
}
