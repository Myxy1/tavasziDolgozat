package com.example.tavaszidolgozat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.text.format.Formatter;
import android.widget.Toast;

public class WifiInfoActivity extends AppCompatActivity {

    private Button buttonIp, buttonBack;
    private TextView textViewIp;
    private WifiInfo wifiInfo;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_info);

        init();
        buttonIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ip = wifiInfo.getIpAddress();
                String converted_ip = Formatter.formatIpAddress(ip);
                textViewIp.setText("IP ADDRESS:" + converted_ip);

                SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("ip",converted_ip);
                editor.apply();
                Toast.makeText(WifiInfoActivity.this, "IP elmentve!", Toast.LENGTH_SHORT).show();
            }
        });


        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visszaMenubeIntent = new Intent(WifiInfoActivity.this,MainActivity.class);
                startActivity(visszaMenubeIntent);
                finish();
            }
        });

    }

    public void init()
    {
        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonIp = (Button) findViewById(R.id.buttonWifiIP);
        textViewIp = (TextView) findViewById(R.id.textViewIp);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiInfo = wifiManager.getConnectionInfo();
    }
}
