package com.example.formularz;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Patterns;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private  EditText surname;
    private  EditText mail;
    private  EditText n_tele;
    private  EditText haslo;
    private  EditText p_haslo;
    private Button button_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        button_c=findViewById(R.id.button);
        surname=findViewById(R.id.surname);
        mail=findViewById(R.id.mail);
        n_tele=findViewById(R.id.n_tele);
        haslo=findViewById(R.id.haslo);
        p_haslo=findViewById(R.id.p_haslo);
        
        button_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name_input=name.getText().toString().trim();
                String surname_input=surname.getText().toString().trim();
                String mail_input=mail.getText().toString().trim();
                String n_tele_input=n_tele.getText().toString().trim();
                String haslo_input=haslo.getText().toString().trim();
                String p_haslo_input=p_haslo.getText().toString().trim();



                if(name_input.isEmpty()){
                    Toast.makeText(MainActivity.this,"musisz wypełnić pole imie",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(surname_input.isEmpty()){
                    Toast.makeText(MainActivity.this,"musisz wypełnić pole nazwisko",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mail_input.isEmpty()){
                    Toast.makeText(MainActivity.this,"musisz wypełnić pole E-mail",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(n_tele_input.isEmpty()){
                    Toast.makeText(MainActivity.this,"musisz wypełnić pole telefon",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(haslo_input.isEmpty()){
                    Toast.makeText(MainActivity.this,"musisz wypełnić pole haslo",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(p_haslo_input.isEmpty()){
                    Toast.makeText(MainActivity.this,"musisz wypełnić pole powtorz haslo",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(n_tele_input.length()!=9){
                    Toast.makeText(MainActivity.this,"Pole numer telefonu musi posiadać 9 cyfr",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(mail_input).matches()) {
                    Toast.makeText(MainActivity.this, "Wprowadź poprawny adres e-mail", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(haslo_input.length()<6){
                    Toast.makeText(MainActivity.this,"Pole hasło musi posiadać co najmniej 6 znaków",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!p_haslo_input.equals(haslo_input)){
                    Toast.makeText(MainActivity.this,"Hasło musi się powtarzać",Toast.LENGTH_SHORT).show();
                    return;
                }


                Toast.makeText(MainActivity.this, "Formularz został wysłany!", Toast.LENGTH_SHORT).show();
                button_c.setText("zatwierdzone");

                Log.d("imie:",name_input);
                Log.d("nazwsisko:",surname_input);
                Log.d("mail:",mail_input);
                Log.d("numer telefonu:",n_tele_input);
                Log.d("Hało:",haslo_input);
                Log.d("P. hasło:",p_haslo_input);
            }
        });
    }
}
