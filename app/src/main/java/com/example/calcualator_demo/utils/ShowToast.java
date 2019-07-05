package com.example.calcualator_demo.utils;

import android.content.Context;
import android.widget.Toast;

public class ShowToast {
    public  static  void showToast(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
