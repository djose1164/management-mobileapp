package com.djose1164.managementmobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ToastMsg toastMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        this.textView = findViewById(R.id.textView);
    }

    public void btn_newBill(View view) {
        Toast toast = Toast.makeText(this, "Holaa", Toast.LENGTH_LONG);
        toast.show();
    }

    public void btn_showBills(View view) {
        toastMsg.showMsg(this, "Mostrando facturas");
    }
}
