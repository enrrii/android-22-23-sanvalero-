package com.example.mvc_netflix_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvc_netflix_1.controller.StudentController;
import com.example.mvc_netflix_1.model.StudentWS;
import com.example.mvc_netflix_1.model.pojo.Student;

public class MainActivity extends AppCompatActivity {
    private StudentController controller;
    private static MainActivity view;
    private StudentWS model;
    private EditText edtUser;
    private EditText edtSurname;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        //CARGA VIEW
        view = this;
        //CARGA MODEL

        //MODEL + VIEW
        controller = new StudentController(model,view);
        // CASO DE USO -> OBTENER ESTUDIANTE
        controller.getStudent();


    }


    public void printStudentDetails(Student student){
        Log.d("MainActivity - NAME", student.getName());
        Log.d("MainActivity - NAME", student.getSurname());
    }
    public void printStudentDetailsOnScreen(Student student){
        edtUser.setText(student.getName());
        edtSurname.setText(student.getSurname());
        Toast.makeText(view.getInstance(),
                "Usuario y Password correctas...",
                Toast.LENGTH_SHORT).show();
    }

    private void initComponents(){
        edtUser = (EditText) findViewById(R.id.edt1);
        edtSurname= (EditText) findViewById(R.id.edt2);
        btnLogin = (Button) findViewById(R.id.btn1);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString();
                String password = edtSurname.getText().toString();
                Student user1 = new Student();
                user1.setSurname(password);
                user1.setName(user);
                controller.updateStudent(user1);
            }
        });
    }

    public static MainActivity getInstance(){
        if(view == null){
            return new MainActivity();
        }else{
            return view;
        }
    }

}