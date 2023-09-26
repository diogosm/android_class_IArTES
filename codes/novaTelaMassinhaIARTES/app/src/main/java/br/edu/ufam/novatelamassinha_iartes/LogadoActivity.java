package br.edu.ufam.novatelamassinha_iartes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class LogadoActivity extends AppCompatActivity {

    private TextView logadoTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logado);

        logadoTextView = (TextView)  findViewById(R.id.textoLogado);
        logadoTextView.setText("Ola usuario logado");
    }
}