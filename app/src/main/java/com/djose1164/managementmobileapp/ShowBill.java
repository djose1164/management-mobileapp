package com.djose1164.managementmobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.djose1164.managementmobileapp.Client;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ShowBill extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText name;
    private String searchBy;
    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill);
        Spinner spinner = findViewById(R.id.spinner);

        // Setting the spinner.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.typeof_search, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        this.name = findViewById(R.id.input_searchBy);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        this.searchBy = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Stuff.
    }

    public void getDataFromDB(View view) {
        TextView name = findViewById(R.id.input_searchBy);
        TextView phone = findViewById(R.id.txtViewPhone);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference usersRef = db.collection("users");
        //Map<String, Objects> mUsers = new HashMap<>();

        Query query = usersRef.whereEqualTo(searchBy, this.name.getText().toString());
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        client = document.toObject(Client.class);

                    }
                } else {
                    Toast.makeText(this, "No se pudo cargar los datos",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showInfo() {

    }
}