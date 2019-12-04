package com.test.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.test.aidlServer.IAidlInterface;

public class AidlService extends Service {
    public AidlService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("AidlService","onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("AidlService","onBind");
        return stub;
    }

    IAidlInterface.Stub stub = new IAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getString(String a) throws RemoteException {
            Log.e("AidlService","client send : " + a);
            return "hello this is server";
        }
    };
}
