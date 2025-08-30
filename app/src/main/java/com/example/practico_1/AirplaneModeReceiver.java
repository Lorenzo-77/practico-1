package com.example.practico_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    private static final String TAG = "AirplaneModeReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) return;

        String action = intent.getAction();
        Log.d(TAG, "onReceive action=" + action);

        if (!Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(action) &&
                !"android.intent.action.AIRPLANE_MODE".equals(action)) {
            return;
        }

        boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
        Log.d(TAG, "Airplane mode = " + isAirplaneModeOn);
        Toast.makeText(context, isAirplaneModeOn ? "Modo Avión ACTIVADO" : "Modo Avión DESACTIVADO", Toast.LENGTH_SHORT).show();

        if (isAirplaneModeOn) {

            Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:2664553747"));
            dialIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                context.startActivity(dialIntent);
            } catch (Exception e) {
                Log.e(TAG, "Error al abrir dialer: " + e.getMessage(), e);
                Toast.makeText(context, "No se pudo abrir el marcador", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
