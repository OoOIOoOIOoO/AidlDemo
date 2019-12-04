package com.test.aidlClient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.test.aidlServer.IAidlInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindServerService();
    }

    private void bindServerService(){
        Log.e("MainActivity", "bindService");
        Intent intent = new Intent();
        intent.setPackage("com.test.aidlServer");
        intent.setAction("com.aidl.server.a");
        bindService(intent,connection, Context.BIND_AUTO_CREATE);
    }

    private IAidlInterface anInterface;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("MainActivity", "onServiceConnected");
            anInterface = IAidlInterface.Stub.asInterface(service);
            try {
                String result = anInterface.getString("hello I am client");
                Log.e("MainActivity", "server result : " + result);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("MainActivity", "onServiceDisconnected");
        }
    };
}
