package com.example.tavaszidolgozat;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonWifi, buttonWIfiInfo, buttonAdapterView;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        if (wifiManager.isWifiEnabled())
        {
            buttonWIfiInfo.setEnabled(true);
        }

        buttonWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wifiIntent = new Intent(MainActivity.this, WifiActivity.class);
                startActivity(wifiIntent);
                finish();
                //overridePendingTransition();
            }
        });

        buttonWIfiInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wifiInfo = new Intent(MainActivity.this, WifiInfoActivity.class);
                startActivity(wifiInfo);
                finish();
                //overridePendingTransition();
            }
        });

        buttonAdapterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adapterViewIntent = new Intent(MainActivity.this, QRCodeActivity.class);
                startActivity(adapterViewIntent);
                finish();
                //overridePendingTransition();
            }
        });
    }

    public void init()
    {
        buttonWifi = (Button) findViewById(R.id.buttonWifi);
        buttonWIfiInfo = (Button) findViewById(R.id.buttonWifiInfo);
        buttonAdapterView = (Button) findViewById(R.id.buttonAdapterView);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    }
}
