package com.example.practico_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class AirplaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
        if (isAirplaneModeOn) {
            Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:2664553747"));
            dialIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(dialIntent);
        }
    }
}
