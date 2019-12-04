// IAidlInterface.aidl
package com.test.aidlServer;

// Declare any non-default types here with import statements

interface IAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    String getString(String a);
}
