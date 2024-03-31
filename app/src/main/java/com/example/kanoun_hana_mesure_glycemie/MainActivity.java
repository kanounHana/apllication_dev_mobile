package com.example.kanoun_hana_mesure_glycemie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView  tvAge,tvReponse;
    private EditText etValeur;
    private SeekBar sbAge;
    private RadioButton rbIsFasting,rbIsNotFasting;
    private Button btnCosulter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("information","on progress change"+progress);
                tvAge.setText("votre age: "+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btnCosulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
            }
        });

    }
    public void calculer(){
        Log.i("information","on click sur le bouton btnConsulter");
        int age;
        float valeur;
        boolean verifAge=false,verifValeur=false;
        if(sbAge.getProgress()!=0)
            verifAge=true;
        else Toast.makeText(MainActivity.this, "veuillez saisir votre age", Toast.LENGTH_SHORT).show();
        if(etValeur.getText().toString().isEmpty())
            Toast.makeText(MainActivity.this, "vauillez saisir votre valeur mesurée", Toast.LENGTH_LONG).show();
        else verifValeur=true;
        if(verifAge && verifValeur){
            age= sbAge.getProgress();
            valeur= Float.valueOf(etValeur.getText().toString());
            if(rbIsFasting.isChecked()){//oui
                if(age>=13) {
                    if (valeur < 5.0)
                        tvReponse.setText("niveau de glycemie est trop bas");
                    else if (valeur<=7.2)
                        tvReponse.setText("niveau de glycemie est normal");
                    else tvReponse.setText("niveau de glycemie est trop élevé");
                } else if (age>=6) {
                    if (valeur < 5.0)
                        tvReponse.setText("niveau de glycemie est trop bas");
                    else if (valeur<=10.0)
                        tvReponse.setText("niveau de glycemie est normal");
                    else tvReponse.setText("niveau de glycemie est trop élevé");
                }else if (age<6) {
                    if (valeur < 5.5)
                        tvReponse.setText("niveau de glycemie est trop bas");
                    else if (valeur<=10.0)
                        tvReponse.setText("niveau de glycemie est normal");
                    else tvReponse.setText("niveau de glycemie est trop élevé");
                }
            }else{//non
                if (valeur >10.5)
                    tvReponse.setText("niveau de glycemie est trop élevé");
                else
                    tvReponse.setText("niveau de glycemie est normal");
                }
            }
        }
    private void init(){
        tvAge= findViewById(R.id.tv_age);
        tvReponse=findViewById(R.id.tvReponse);
        sbAge=findViewById(R.id.sbAge);
        etValeur=findViewById(R.id.etValeur);
        rbIsFasting=findViewById(R.id.rbtOui);
        rbIsNotFasting=findViewById(R.id.rbtNon);
        btnCosulter=findViewById(R.id.btnConsulter);
    }
}