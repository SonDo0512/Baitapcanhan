package com.example.project_cal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edta, edtb, edtc;
    Button btncong, btntru, btnnhan, btnchia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        edtc = findViewById(R.id.edtc);
        btncong = findViewById(R.id.btncong);
        btntru = findViewById(R.id.btntru);
        btnnhan = findViewById(R.id.btnnhan);
        btnchia = findViewById(R.id.btnchia);

        btncong.setOnClickListener(view -> calculate('+'));
        btntru.setOnClickListener(view -> calculate('-'));
        btnnhan.setOnClickListener(view -> calculate('*'));
        btnchia.setOnClickListener(view -> calculate('/'));
    }

    private void calculate(char operator) {
        try {
            double a = Double.parseDouble(edta.getText().toString());
            double b = Double.parseDouble(edtb.getText().toString());
            double result = 0;

            switch (operator) {
                case '+': result = a + b; break;
                case '-': result = a - b; break;
                case '*': result = a * b; break;
                case '/':
                    if (b == 0) {
                        edtc.setText("Lỗi chia 0");
                        return;
                    }
                    result = a / b;
                    break;
            }

            edtc.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            edtc.setText("Lỗi nhập dữ liệu");
        }
    }
}
