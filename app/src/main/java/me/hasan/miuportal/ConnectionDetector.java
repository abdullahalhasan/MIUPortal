package me.hasan.miuportal;

import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;

/**
 * Created by hasan on 2/20/17.
 */

public class ConnectionDetector {
    private Context context;
    private Home home = new Home();
    public ConnectionDetector(Context context) {
        this.context = context;
    }



    public boolean isConnected() {

        ConnectivityManager connectivity = (ConnectivityManager)
                context.getSystemService(Service.CONNECTIVITY_SERVICE);

        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }

        return false;
    }

    public void connection() {
        if (isConnected() == false) {
            final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
            dialogBuilder.setTitle("Internet")
                    .setMessage("No Internet Connection Available! Turn On Data First!")
                    .setCancelable(false).setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    home.onBackPressed();
                }
            }).show();

        }
    }


}
