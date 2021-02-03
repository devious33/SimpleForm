package com.example.simpleform;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {
    int year, month, day;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner.setPrompt("Gender");


    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        EditText etDOB = findViewById(R.id.etDOB);
        TextView txtAge = findViewById(R.id.txtAge);
        txtAge.setText("");
        Calendar cal = Calendar.getInstance();
        cal.set(i,i1,i2);
        SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd");
        etDOB.setText(tf.format(cal.getTime()));
        etDOB.setClickable(false);
        cal = Calendar.getInstance();
        txtAge.setText(""+(cal.get(Calendar.YEAR) - i));

    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.etDOB:
                new DatePickerDialog(this,this,year,month,day).show();

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}