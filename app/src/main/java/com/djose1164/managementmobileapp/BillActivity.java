package com.djose1164.managementmobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class BillActivity extends AppCompatActivity {
    boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
    }

    private void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onRadioButtonClicked(View view) {
        final int paid = R.id.radioBtn_paid;
        final int pendent = R.id.radioBtn_pendient;
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case paid:
                if (checked)
                    this.status = true;
                break;
            case pendent:
                if (checked)
                    this.status = false;
        }
    }

    public void saveBillToDB(View v) {
        final FirebaseFirestore db = FirebaseFirestore.getInstance();

        EditText soldTo = findViewById(R.id.input_soldTo);
        EditText address = findViewById(R.id.input_address);
        EditText phone = findViewById(R.id.input_phone);
        EditText quantity = findViewById(R.id.input_quantity);
        EditText description = findViewById(R.id.input_description);

        final String TAG = "error?";
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("name", soldTo.getText().toString());
        user.put("address", address.getText().toString());
        user.put("status", status ? "paid" : "pendent");
        user.put("phone", phone.getText().toString());
        user.put("quantity", quantity.getText().toString());
        user.put("description", description.getText().toString());

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        toastMsg(getResources().getString(R.string.added_success));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }
}