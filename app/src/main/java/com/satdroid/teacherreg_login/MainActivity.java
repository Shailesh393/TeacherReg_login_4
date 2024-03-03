package com.satdroid.teacherreg_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btnregister;

  private  Spinner MCA,civil,cs,electrical,electronics,IT,mechanical;
  private  CheckBox MCAcb,civilcb,cscb,electricalcb,electronicscb,ITcb,mechanicalcb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxinit();
        spinnerView();
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String MCA_tv="",Civil_tv="";
                if(MCAcb.isChecked())
                {
                    MCA_tv=MCAcb.getText().toString()+" "+MCA.getSelectedItem().toString();
                }
                if(civilcb.isChecked())
                {
                    Civil_tv=civilcb.getText().toString()+" "+civil.getSelectedItem().toString();
                }
                Intent RegToDash=new Intent(MainActivity.this,TeacherDashboard.class);
                RegToDash.putExtra("MCA",MCA_tv);
                RegToDash.putExtra("Civil",Civil_tv);
                startActivity(RegToDash);
            }
        });
    }

    private void checkBoxinit(){
        btnregister=findViewById(R.id.reg_btn);
        MCAcb=findViewById(R.id.MCA_CheckBox);
        civilcb=findViewById(R.id.Civil_CheckBox);
        cscb=findViewById(R.id.Computer_Science_CheckBox);
        electricalcb=findViewById(R.id.Electrical_CheckBox);
        electronicscb=findViewById(R.id.Electronics_CheckBox);
        ITcb=findViewById(R.id.IT_CheckBox);
        mechanicalcb=findViewById(R.id.Mechanical_CheckBox);

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