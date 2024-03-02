package com.satdroid.teacherreg_login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class TeacherDashboard extends AppCompatActivity {


    String MCAtxt,Civiltxt;
    GridView gridViewCourse;

    TextView courseName;
    FloatingActionButton floatingActionButton;
  private  CheckBox MCAcb,civilcb,cscb,electricalcb,electronicscb,ITcb,mechanicalcb;
  private  Spinner MCA,civil,cs,electrical,electronics,IT,mechanical;

    ArrayList<CourseModal> courseList=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);

        gridViewCourse=findViewById(R.id.gridView_courses);
        courseName=findViewById(R.id.CourseTV);
        floatingActionButton=findViewById(R.id.floating_btn_newCourse);

        Intent intent=getIntent();
        MCAtxt=intent.getStringExtra("MCA");
        Civiltxt=intent.getStringExtra("Civil");

        courseName.setText("Courses");
//        ArrayList<CourseModal> courseList=new ArrayList<>();
        if(!MCAtxt.isEmpty())
        {
            courseList.add(new CourseModal(MCAtxt));
        }
        if(!Civiltxt.isEmpty())
        {
            courseList.add(new CourseModal(Civiltxt));
        }

        CourseAdapter adapter=new CourseAdapter(this,courseList);
        gridViewCourse.setAdapter(adapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = getLayoutInflater();
                View alertLayout=inflater.inflate(R.layout.new_course_add_design,null);

                MCAcb=alertLayout.findViewById(R.id.MCA_CheckBoxf);
                civilcb=alertLayout.findViewById(R.id.Civil_CheckBoxf);

                MCA=alertLayout.findViewById(R.id.MCA_semf);
                civil=alertLayout.findViewById(R.id.Civil_semf);

                ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(TeacherDashboard.this, R.array.Semester, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                MCA.setAdapter(adapter);

                ArrayAdapter<CharSequence> adapterCivil=ArrayAdapter.createFromResource(TeacherDashboard.this, R.array.Semester, android.R.layout.simple_spinner_item);
                adapterCivil.setDropDownViewResource(android.R.layout.simple_spinner_item);
                civil.setAdapter(adapterCivil);

                AlertDialog.Builder alertDialog=new AlertDialog.Builder(TeacherDashboard.this);
                alertDialog.setView(alertLayout);
                alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String MCA_tv="",Civil_tv="";
                        if(MCAcb.isChecked())
                        {
                            MCA_tv=MCAcb.getText().toString()+" "+MCA.getSelectedItem().toString();
                            courseList.add(new CourseModal(MCA_tv));

                        }
                        if(civilcb.isChecked())
                        {
                            Civil_tv=civilcb.getText().toString()+" "+civil.getSelectedItem().toString();
                            courseList.add(new CourseModal(Civil_tv));
                        }
                        CourseAdapter adapterN=new CourseAdapter(TeacherDashboard.this,courseList);
                        gridViewCourse.setAdapter(adapterN);
                        Toast.makeText(TeacherDashboard.this,"Course Added",Toast.LENGTH_SHORT).show();

                    }
                });
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog1=alertDialog.create();

                alertDialog1.show();

            }
        });

        gridViewCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String courseModal=courseList.get(position).getCourse();
//                courseName.setText(courseModal);
                Intent inext=new Intent(TeacherDashboard.this,CourseActivity.class);
                inext.putExtra("course_name",courseList.get(position).getCourse());
                startActivity(inext);
            }
        });
    }
}