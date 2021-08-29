package com.laila.udemy.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView percentageTextView, tipValueTextView, totalValueTextView;
    private EditText billAmountEditText;
    double tipValue, percent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setIds();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                percent = progress;
                percentageTextView.setText(percent + "%");
                calculateTip();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {



            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void setIds() {

        this.seekBar = findViewById(R.id.seekBar);
        this.percentageTextView = findViewById(R.id.percentage_TextView);
        this.tipValueTextView = findViewById(R.id.tip_value_textView);
        this.totalValueTextView = findViewById(R.id.total_value_textView);
        this.billAmountEditText = findViewById(R.id.bill_amount_input);

    }

    public void calculateTip() {

        String billValue = billAmountEditText.getText().toString();

        // If bill amount if not empty
        if (billValue.equals("") || billValue == null) {

            Toast.makeText(getApplicationContext(), "Bill amount cannot be empty ", Toast.LENGTH_LONG).show();

        } else {

            // Convert string to double
            double billValueNumber = Double.parseDouble(billValue);

            // Calculate tip
            double tip = billValueNumber * (percent / 100);
            double totalTip = Math.round(tip * 100);
            totalTip /= 100;

            //Show total tip
            tipValueTextView.setText(" $ " + totalTip);

            // Calculate total amount
            double totalAmount = billValueNumber + totalTip;
            double totalAmountRounded = Math.round(totalAmount * 100);
            totalAmountRounded /= 100;

            // Show total amount
            totalValueTextView.setText(" $ " + totalAmountRounded);

        }

    }
}