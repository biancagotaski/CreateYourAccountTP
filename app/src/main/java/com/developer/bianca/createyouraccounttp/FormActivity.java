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

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference registersRef = database.getReference(Constants.ACTIVE_REGISTERS_ENDPOINT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    public void saveContact(View view){
        EditText nameField = findViewById(R.id.name_edit_text);
        EditText passwordField = findViewById(R.id.password_edit_text);
        EditText emailField = findViewById(R.id.email_edit_text);
        EditText phoneField = findViewById(R.id.phone_edit_text);
        EditText celField = findViewById(R.id.cel_edit_text);
        EditText cpfField = findViewById(R.id.cpf_edit_text);
        EditText cityField = findViewById(R.id.city_edit_text);

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
}
