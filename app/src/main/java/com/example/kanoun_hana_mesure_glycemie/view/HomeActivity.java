package com.example.kanoun_hana_mesure_glycemie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kanoun_hana_mesure_glycemie.R;
import com.example.kanoun_hana_mesure_glycemie.controller.HomeController;

public class HomeActivity extends AppCompatActivity {
    private Button btnConsultation;
    private EditText etUserEmail,etUserPassword;
    private HomeController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        etUserEmail.setText(controller.getUserEmail());

        btnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("information","button cliqué");
                String email,password;
                boolean verifEmail=false, verifPassword=false;
                if(!etUserEmail.getText().toString().isEmpty())
                    verifEmail=true;
                else Toast.makeText(HomeActivity.this,"veuillez saisir votre email!",Toast.LENGTH_SHORT);
                if(!etUserPassword.getText().toString().isEmpty())
                    if(etUserPassword.getText().toString().equals(controller.getUserPassword()))
                        verifPassword=true;
                    else Toast.makeText(HomeActivity.this,"mot de passe incorrect!",Toast.LENGTH_SHORT);
                else Toast.makeText(HomeActivity.this,"veuillez saisir votre mot de passe!",Toast.LENGTH_SHORT);
                if (verifEmail&&verifPassword){
                    email =etUserEmail.getText().toString();
                    password=etUserPassword.getText().toString();
                    controller.createUser(email,password,getApplicationContext());
                    Intent intent= new Intent(HomeActivity.this,MainActivity.class);
                    //Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    private void init(){
        btnConsultation=findViewById(R.id.btnConsultation);
        etUserEmail=findViewById(R.id.etUserEmail);
        etUserPassword=findViewById(R.id.etUserPassword);
        controller=HomeController.getInstance(this);
    }
}