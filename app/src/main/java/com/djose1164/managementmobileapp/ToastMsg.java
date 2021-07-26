package com.djose1164.managementmobileapp;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class ToastMsg {
    public void showMsg(Context context, String msg) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        toast.show();
    }
}
