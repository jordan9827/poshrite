package com.poshrite.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;

import com.poshrite.R;
import com.poshrite.constants.Constants;

public class Splash extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST_CODE = 121;
    private static int SPLASH_TIME_OUT = 5000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);



        if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {


            try {
                Log.e(Constants.TAG_LOGCAT, " requesting permission NOW");
//                requestPermissions(new String[]{
//                                android.Manifest.permission.ACCESS_FINE_LOCATION,
//                                android.Manifest.permission.ACCESS_COARSE_LOCATION,
//                                android.Manifest.permission.GET_ACCOUNTS,
//                                android.Manifest.permission.WAKE_LOCK,
//                                android.Manifest.permission.READ_EXTERNAL_STORAGE,
//                                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                                android.Manifest.permission.READ_PHONE_STATE,
//                                android.Manifest.permission.ACCESS_NETWORK_STATE,
//                                android.Manifest.permission.CAMERA,
//                                android.Manifest.permission.SYSTEM_ALERT_WINDOW,
//                                android.Manifest.permission.ACCESS_WIFI_STATE,
//
//                                android.Manifest.permission.UPDATE_DEVICE_STATS,
//
//                                android.Manifest.permission.CHANGE_WIFI_STATE,
//
//
//                        },
//                        PERMISSIONS_REQUEST_CODE);
                loadSplash();
            } catch (NoSuchMethodError e) {
                Log.e(Constants.TAG_LOGCAT, "some exception while requesting permission");
            }

        } else {
            //Below Marsh Mallow condition
            loadSplash();
        }

    }



    private void loadSplash() {

        if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent intentToWelcomeScreen = new Intent(Splash.this, SignUp.class);
                    startActivity(intentToWelcomeScreen);
                    finish();
                    overridePendingTransition(R.anim.slide_for_in, R.anim.slide_for_out);
                }


            }, SPLASH_TIME_OUT);
        } else {

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent intentToWelcomeScreen = new Intent(Splash.this, SignUp.class);
                    startActivity(intentToWelcomeScreen);
                    finish();
                    overridePendingTransition(R.anim.slide_for_in, R.anim.slide_for_out);

                }


            }, SPLASH_TIME_OUT);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            Log.e(Constants.TAG_LOGCAT, "onRequestPermissionsResult");
            Log.e(Constants.TAG_LOGCAT, "FOR PERMISSION_DENIED" + PackageManager.PERMISSION_DENIED);
            Log.e(Constants.TAG_LOGCAT, "FOR PERMISSION_GRANTED" + PackageManager.PERMISSION_GRANTED);

            for (int i = 0; i < permissions.length; i++) {
                String requestedPermission = permissions[i];
                int statusOfPermission = grantResults[i];
                Log.e(Constants.TAG_LOGCAT, "PEMISSION PASSED NAME == > " + requestedPermission);
                Log.e(Constants.TAG_LOGCAT, "PEMISSION PASSED STATUS  == > " + statusOfPermission);
            }
            loadSplash();
        }
    }

}
