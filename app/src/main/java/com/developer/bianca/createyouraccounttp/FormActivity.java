package com.developer.bianca.createyouraccounttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.developer.bianca.createyouraccounttp.models.RegisterCard;
import com.developer.bianca.createyouraccounttp.utils.Constants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FormActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference registersRef;

    EditText nameField;
    EditText passwordField;
    EditText emailField;
    EditText phoneField;
    EditText celField;
    EditText cpfField;
    EditText cityField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        database = FirebaseDatabase.getInstance();
        registersRef = database.getReference(Constants.ACTIVE_REGISTERS_ENDPOINT);

        nameField = findViewById(R.id.name_edit_text);
        passwordField = findViewById(R.id.password_edit_text);
        emailField = findViewById(R.id.email_edit_text);
        phoneField = findViewById(R.id.phone_edit_text);
        celField = findViewById(R.id.cel_edit_text);
        cpfField = findViewById(R.id.cpf_edit_text);
        cityField = findViewById(R.id.city_edit_text);

        validateForm();
    }

    public void saveContact(View view){

        String name = nameField.getText().toString();
        String password = passwordField.getText().toString();
        String email = emailField.getText().toString();
        String phone = phoneField.getText().toString();
        String cel = celField.getText().toString();
        String cpf = cpfField.getText().toString();
        String city = cityField.getText().toString();

        final RegisterCard registerCard = new RegisterCard(name, password, email, phone, cel, cpf, city);

        registersRef.push().setValue(registerCard);

        registersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    Toast.makeText(getApplicationContext(), "Contato gravado com sucesso!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Erro ao gravar contato. Tente novamente.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        finish();
    }

    //FIXME:
    public void validateForm(){
        if(nameField.getText().toString().trim().equals("")){
            nameField.requestFocus();
            nameField.setError("Campo obrigatório");
        }
        if(passwordField.getText().toString().trim().equals("")){
            passwordField.requestFocus();
            passwordField.setError("Campo obrigatório");
        }
        if(emailField.getText().toString().trim().equals("")){
            emailField.requestFocus();
            emailField.setError("Campo obrigatório");
        }
        if(phoneField.getText().toString().trim().equals("")){
            phoneField.requestFocus();
            phoneField.setError("Campo obrigatório");
        }
        if(celField.getText().toString().trim().equals("")){
            celField.requestFocus();
            celField.setError("Campo obrigatório");
        }
        if(cpfField.getText().toString().trim().equals("")){
            cpfField.requestFocus();
            cpfField.setError("Campo obrigatório");
        }
        if(cityField.getText().toString().trim().equals("")){
            cityField.requestFocus();
            cityField.setError("Campo obrigatório");
        }
    }

    public void clearForm(View view) {
        nameField.getText().clear();
        passwordField.getText().clear();
        emailField.getText().clear();
        phoneField.getText().clear();
        celField.getText().clear();
        cpfField.getText().clear();
        cityField.getText().clear();
        validateForm();
    }
}
