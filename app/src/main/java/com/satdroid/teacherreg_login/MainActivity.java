package com.satdroid.teacherreg_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btnregister;
    Spinner MCA,civil,cs,electrical,electronics,IT,mechanical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnregister=findViewById(R.id.reg_btn);

        spinnerView();

    }

   private void spinnerView()
    {
        MCA=findViewById(R.id.MCA_sem);
        civil=findViewById(R.id.Civil_sem);
        cs=findViewById(R.id.Computer_Science_sem);
        electrical=findViewById(R.id.Electrical_sem);
        electronics=findViewById(R.id.Electronics_sem);
        IT=findViewById(R.id.IT_sem);
        mechanical=findViewById(R.id.Mechanical_sem);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.Semester, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        MCA.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapterCivil=ArrayAdapter.createFromResource(this, R.array.Semester, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        civil.setAdapter(adapterCivil);

        ArrayAdapter<CharSequence> adapterCs=ArrayAdapter.createFromResource(this, R.array.Semester, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        cs.setAdapter(adapterCs);

        ArrayAdapter<CharSequence> adapterElectrical=ArrayAdapter.createFromResource(this, R.array.Semester, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        electrical.setAdapter(adapterElectrical);

        ArrayAdapter<CharSequence> adapterElectronics=ArrayAdapter.createFromResource(this, R.array.Semester, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        electronics.setAdapter(adapterElectronics);

        ArrayAdapter<CharSequence> adapterIT=ArrayAdapter.createFromResource(this, R.array.Semester, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        IT.setAdapter(adapterIT);

        ArrayAdapter<CharSequence> adapterMechanical=ArrayAdapter.createFromResource(this, R.array.Semester, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        mechanical.setAdapter(adapterMechanical);
    }
}