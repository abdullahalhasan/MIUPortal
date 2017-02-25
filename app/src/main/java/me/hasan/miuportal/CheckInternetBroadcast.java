package me.hasan.miuportal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.net.ConnectivityManager.TYPE_WIFI;

/**
 * Created by hasan on 2/24/17.
 */

public class CheckInternetBroadcast extends BroadcastReceiver {
    View view;
    @Override
    public void onReceive(Context context, Intent intent) {

        int[] type = { ConnectivityManager.TYPE_MOBILE,ConnectivityManager.TYPE_WIFI };
        if (isNetworkAvailable(context,type)==false) {
           Toast.makeText(context, "No Internet Connection", Toast.LENGTH_LONG).show();
        } else {
            return;
        }

    }

    private boolean isNetworkAvailable(Context context, int[] typeNetworks) {
        try {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            for (int typeNetwork : typeNetworks) {
                NetworkInfo networkInfo = manager.getNetworkInfo(typeNetwork);
                if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    
}
