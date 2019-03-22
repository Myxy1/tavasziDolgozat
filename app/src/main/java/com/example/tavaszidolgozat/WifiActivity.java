package com.example.tavaszidolgozat;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class WifiActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.action_wifiOn:
                        Toast.makeText(WifiActivity.this, "Wifi bekapcsolva", Toast.LENGTH_SHORT).show();
                        wifiManager.setWifiEnabled(true);
                        break;

                    case R.id.action_wifiOff:
                        Toast.makeText(WifiActivity.this, "Wifi kikapcsolva", Toast.LENGTH_SHORT).show();
                        wifiManager.setWifiEnabled(false);
                        break;

                    case R.id.action_back:
                        Intent visszaIntent = new Intent(WifiActivity.this, MainActivity.class);
                        startActivity(visszaIntent);
                        finish();
                }
                return true;
            }
        });
    }
}
