package com.example.practico_1;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private AirplaneModeReceiver ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        ba = new AirplaneModeReceiver();
    }

    @Override
    protected void onStart() {
        super.onStart();

        registerReceiver(ba, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        try { unregisterReceiver(ba); } catch (Exception ignored) {}
    }
}
