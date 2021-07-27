package com.djose1164.managementmobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }
    private void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
    public void btn_newBill(View view) {
        Intent intent = new Intent(this, BillActivity.class);
        startActivity(intent);
    }

    public void btn_showBills(View view) {
        this.toastMsg("Viendo facturas");
    }
}
