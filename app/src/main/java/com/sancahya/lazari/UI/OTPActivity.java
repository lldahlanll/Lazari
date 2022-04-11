package com.sancahya.lazari.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sancahya.lazari.MainActivity;
import com.sancahya.lazari.databinding.ActivityMainBinding;
import com.sancahya.lazari.databinding.ActivityOtpactivityBinding;

public class OTPActivity extends AppCompatActivity {
    private ActivityOtpactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OTPActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}