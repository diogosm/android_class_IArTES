package br.edu.ufam.novatelamassinha_iartes;

import static android.widget.Toast.*;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button)  findViewById(R.id.button);

        //verifica se login e senha ja estavam salvos
        confereLoginSenha();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaLoginSenha();
            }
        });
    }

    private void confereLoginSenha() {
        SharedPreferences sharedPreferences = getSharedPreferences(
                "dados_login",
                Activity.MODE_PRIVATE
        );

        String loginStr = sharedPreferences.getString("login", "");
        String senhaStr = sharedPreferences.getString("senha", "");

        Log.i("Debug", "Login e senha ja salvos: "+ loginStr +
                " " + senhaStr);
        if(loginStr.equals("admin") && senhaStr.equals("admin")){
            Intent intent = new Intent(MainActivity.this,
                    LogadoActivity.class);
            startActivity(intent);
            finish();
        }else{
            Toast toast = Toast.makeText(this,
                    "Senha/Login nunca validadods",
                    LENGTH_SHORT);
            toast.show();
        }
    }

    private void verificaLoginSenha(){
        EditText login, senha;
        SharedPreferences sharedPreferences = getSharedPreferences(
                "dados_login",
                Activity.MODE_PRIVATE
        );

        String loginStr = "admin";
        String senhaStr = "admin";

        //verifico se senha e login batem
        login = (EditText)  findViewById(R.id.login);
        senha = (EditText)  findViewById(R.id.password);
        if(login.getText().toString().equals(
                loginStr
        ) && senha.getText().toString().equals(
                senhaStr
        )){
            //login validado, entao salvo no XML
            SharedPreferences.Editor edit =
                    sharedPreferences.edit();
            edit.putString("login", login.getText().toString());
            edit.putString("senha", senha.getText().toString());
            edit.commit();

            Log.i("debug", "Login validado");
            Toast toast = Toast.makeText(this,
                    "login validada",
                    LENGTH_SHORT);
            toast.show();
        }else{
            Toast toast = makeText(this,
                    "Login/senha invalidos",
                    LENGTH_LONG);
            toast.show();
        }
    }
}